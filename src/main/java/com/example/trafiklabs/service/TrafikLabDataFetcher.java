package com.example.trafiklabs.service;

import com.example.trafiklabs.model.trafiklab.JourneyPattern;
import com.example.trafiklabs.model.trafiklab.Line;
import com.example.trafiklabs.model.trafiklab.Response;
import com.example.trafiklabs.model.trafiklab.StopPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class used for fetching data from the "TrafikLabs SL Stops and lines v.2.0 API".
 * Documentation can be found at:
 * <a href="https://www.trafiklab.se/api/trafiklab-apis/sl/stops-and-lines-2/">...</a>
 */
@Service
public class TrafikLabDataFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(LineInformationService.class);

    @Value("${app.key}")
    public String apiKey;
    
    public final WebClient webClient;

    public TrafikLabDataFetcher(WebClient webClient) {
        this.webClient = webClient;
    }

    public Map<Integer, Line> fetchBusses() throws IllegalStateException {
        LOG.info("Fetching bus lines...");
        Response<Line> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("model", ApiModelType.LINE.getModel())
                        .queryParam("key", apiKey)
                        .queryParam("DefaultTransportModeCode", "BUS")
                        .build())
                .header(HttpHeaders.ACCEPT_ENCODING, "gzip")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<Line>>() {
                })
                .block();


        if (response == null) {
            throw new IllegalStateException("No response when fetching bus lines.");
        }
        List<Line> allBuses = response.getResponseData().getResult();

        return allBuses.stream()
                .collect(Collectors.toMap(
                        Line::getLineNumber,
                        Function.identity(),
                        (line1, line2) -> line1
                ));
    }

    public Map<Integer, StopPoint> fetchStopPoints() throws IllegalStateException {
        LOG.info("Fetching stop points...");
        Response<StopPoint> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("model", ApiModelType.STOP_POINT.getModel())
                        .queryParam("key", apiKey)
                        .build())
                .header(HttpHeaders.ACCEPT_ENCODING, "gzip")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<StopPoint>>() {
                })
                .block();

        if (response == null) {
            throw new IllegalStateException("No response when fetching stop points.");
        }
        List<StopPoint> allStopPoints = response.getResponseData().getResult();

        return allStopPoints.stream()
                .filter(stopPoint -> "BUSTERM".equals(stopPoint.getStopAreaTypeCode()))
                .collect(Collectors.toMap(
                        StopPoint::getStopPointNumber,
                        Function.identity(),
                        (stopPoint1, stopPoint2) -> stopPoint1
                ));
    }

    public Map<Integer, List<JourneyPattern>> fetchJourneyPatterns() throws IllegalStateException {
        LOG.info("Fetching journey patterns...");
        Response<JourneyPattern> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("model", ApiModelType.JOURNEY_PATTERN.getModel())
                        .queryParam("key", apiKey)
                        .queryParam("DefaultTransportModeCode", "BUS")
                        .build())
                .header(HttpHeaders.ACCEPT_ENCODING, "gzip")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<JourneyPattern>>() {
                })
                .block();

        if (response == null) {
            throw new IllegalStateException("No response when fetching journey patterns.");
        }
        List<JourneyPattern> allJourneyPatterns = response.getResponseData().getResult();

        return allJourneyPatterns.stream()
                .collect(Collectors.groupingBy(JourneyPattern::getLineNumber));
    }
}
