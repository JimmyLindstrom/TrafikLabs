package com.example.trafiklabs.service;

import com.example.trafiklabs.model.LineInformation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LineInformationService {

    /**
     * Fetch the SL busses with the most stop points on their journey.
     * Return the provided limit amount of busses in the form of {@link LineInformation}
     * objects.
     * @param limit the amount of bus lines to return.
     */
    List<LineInformation> fetchBusLinesWithTheMostStops(int limit);
}
