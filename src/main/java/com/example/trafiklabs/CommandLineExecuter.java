package com.example.trafiklabs;

import com.example.trafiklabs.model.LineInformation;
import com.example.trafiklabs.service.LineInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Profile("!test")
@Component
public class CommandLineExecuter implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineExecuter.class);
    private final LineInformationService lineInformationService;

    public static final String NEW_LINE = System.lineSeparator();

    public CommandLineExecuter(LineInformationService lineInformationService) {
        this.lineInformationService = lineInformationService;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Application started.");
        try {
            List<LineInformation> lineInformationList = lineInformationService.fetchBusLinesWithTheMostStops(10);
            if (lineInformationList.isEmpty()) {
                System.out.println("Found no bus line information!");
            } else {
                StringBuilder topBusLinesOutput = new StringBuilder();
                int lineCount = lineInformationList.size();
                topBusLinesOutput.append(String.format("Top %d bus lines with the most stops in Stockholm:%n", lineCount));
                int index = 1;
                for (LineInformation lineInformation : lineInformationList) {
                    topBusLinesOutput.append(String.format("%d: %s%n", index++, lineInformation.getLineName()));
                }
                topBusLinesOutput.append(NEW_LINE);
                LineInformation lineWithMostStops = lineInformationList.get(0);
                topBusLinesOutput.append(String.format("Bus stops for line '%s' listed below:%n", lineWithMostStops.getLineName()));

                for (String stopPoint : lineWithMostStops.getStopPoints()) {
                    topBusLinesOutput.append(String.format("%s%n", stopPoint));
                }
                System.out.println(topBusLinesOutput);
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong when fetching bus line information. " + e.getMessage());
        }
        LOGGER.info("Application finished.");
    }
}
