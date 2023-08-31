package com.example.trafiklabs.model;

import com.example.trafiklabs.model.trafiklab.Line;
import com.example.trafiklabs.model.trafiklab.StopPoint;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * POJO holding the necessary information about a bus line and its
 * stop points
 */
public class LineInformation {
    private String lineName;
    private Set<String> stopPoints;

    public LineInformation() {}

    public LineInformation(Line line) {
        this.lineName = line.getLineDesignation();
        stopPoints = new HashSet<>();
    }

    public String getLineName() {
        return lineName;
    }

    public Set<String> getStopPoints() {
        return stopPoints;
    }

    public void addStopPoint(StopPoint stopPoint) {
        stopPoints.add(stopPoint.getStopPointName());
    }

    @JsonIgnore
    public int getStopPointCount() {
        return stopPoints.size();
    }
}
