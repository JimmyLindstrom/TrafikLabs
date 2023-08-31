package com.example.trafiklabs.service;

import com.example.trafiklabs.model.LineInformation;
import com.example.trafiklabs.model.trafiklab.JourneyPattern;
import com.example.trafiklabs.model.trafiklab.Line;
import com.example.trafiklabs.model.trafiklab.StopPoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;;

@ActiveProfiles("test")
@SpringBootTest
class LineInformationServiceTest {

    @Autowired
    private LineInformationService lineInformationService;

    @MockBean
    private TrafikLabDataFetcher trafikLabDataFetcher;

    @Test
    void fetchBusLinesWithTheMostStops() {
        when(trafikLabDataFetcher.fetchBusses()).thenReturn(getMockedBuses());
        when(trafikLabDataFetcher.fetchStopPoints()).thenReturn(getMockedStopPoints());
        when(trafikLabDataFetcher.fetchJourneyPatterns()).thenReturn(getMockedJourneyPatterns());

        List<LineInformation> lineInformations = lineInformationService.fetchBusLinesWithTheMostStops(10);

        assertEquals(10, lineInformations.size());
        assertTrue(lineInformations.get(0).getStopPointCount() > lineInformations.get(1).getStopPointCount());
        assertEquals("20", lineInformations.get(0).getLineName());
    }

    private Map<Integer, Line> getMockedBuses() {
        Map<Integer, Line> busLines = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            Line line = new Line();
            line.setLineNumber(i);
            line.setLineDesignation(String.valueOf(i));
            busLines.put(i, line);
        }
        return busLines;
    }

    private Map<Integer, StopPoint> getMockedStopPoints() {
        Map<Integer, StopPoint> stopPoints = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
           StopPoint stopPoint = new StopPoint();
           stopPoint.setStopPointNumber(i);
           stopPoint.setStopPointName(String.valueOf(i));
           stopPoints.put(i, stopPoint);
        }
        return stopPoints;
    }

    private Map<Integer, List<JourneyPattern>> getMockedJourneyPatterns() {
        Map<Integer, List<JourneyPattern>> journeyPatterns = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            List<JourneyPattern> journeyPatternList = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                JourneyPattern journeyPattern = new JourneyPattern();
                journeyPattern.setLineNumber(i);
                journeyPattern.setJourneyPatternPointNumber(j);
                journeyPatternList.add(journeyPattern);
            }
            journeyPatterns.put(i, journeyPatternList);
        }
            return journeyPatterns;
    }
}