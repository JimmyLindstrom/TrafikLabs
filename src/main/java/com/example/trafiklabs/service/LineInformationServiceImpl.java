package com.example.trafiklabs.service;

import com.example.trafiklabs.model.LineInformation;
import com.example.trafiklabs.model.trafiklab.JourneyPattern;
import com.example.trafiklabs.model.trafiklab.Line;
import com.example.trafiklabs.model.trafiklab.StopPoint;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class LineInformationServiceImpl implements LineInformationService {

    public final TrafikLabDataFetcher trafikLabDataFetcher;

    public LineInformationServiceImpl(TrafikLabDataFetcher trafikLabDataFetcher) {
        this.trafikLabDataFetcher = trafikLabDataFetcher;
    }

    @Override
    public List<LineInformation> fetchBusLinesWithTheMostStops(int limit) {
        Map<Integer, Line> busMap = trafikLabDataFetcher.fetchBusses();
        Map<Integer, StopPoint> stopPointMap = trafikLabDataFetcher.fetchStopPoints();
        Map<Integer, List<JourneyPattern>> journeyPatternsByLineNumber = trafikLabDataFetcher.fetchJourneyPatterns();
        Map<Integer, List<JourneyPattern>> limitedJourneyPatternsByLineNumber = getLimitedResultsWithMostStops(journeyPatternsByLineNumber, limit);

        return createLineInformation(busMap, stopPointMap, limitedJourneyPatternsByLineNumber);
    }

    private Map<Integer, List<JourneyPattern>> getLimitedResultsWithMostStops(Map<Integer, List<JourneyPattern>> journeyPatternsByLineNumber, int limit) {
        Comparator<List<JourneyPattern>> listSize = Comparator.comparing(List::size);
        return journeyPatternsByLineNumber.values().stream()
                .sorted(listSize.reversed())
                .limit(limit)
                .collect(Collectors.toMap(
                        list -> list.get(0).getLineNumber(),
                        Function.identity()
                        )
                );
    }

    private List<LineInformation> createLineInformation(Map<Integer, Line> busMap,
                                                        Map<Integer, StopPoint> stopPointMap,
                                                        Map<Integer, List<JourneyPattern>> journeyPatternsByLineNumber) {
        Map<Integer, LineInformation> lineInformationMap = new HashMap<>();
        journeyPatternsByLineNumber.forEach((lineNumber, journeyPatterns) -> {
            if (!busMap.containsKey(lineNumber)) {
                throw new IllegalStateException("Could not find bus information for line number:" + lineNumber);
            }
            Line line = busMap.get(lineNumber);
            journeyPatterns.forEach(journeyPattern -> {
                Integer stopPointNumber = journeyPattern.getJourneyPatternPointNumber();
                if (!stopPointMap.containsKey(stopPointNumber)) {
                    throw new IllegalStateException("Could not find stop point information for stop point number:" + stopPointNumber);
                }
                StopPoint stopPoint = stopPointMap.get(stopPointNumber);
                lineInformationMap.computeIfAbsent(lineNumber, lineInformation -> new LineInformation(line)).addStopPoint(stopPoint);
            });
        });
        return lineInformationMap.values().stream()
                .sorted(Comparator.comparing(LineInformation::getStopPointCount).reversed())
                .collect(Collectors.toList());
    }
}
