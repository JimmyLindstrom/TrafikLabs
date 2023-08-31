package com.example.trafiklabs.model.trafiklab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A JourneyPatterns contains a links between a {@link Line}s
 * and a {@link StopPoint} on its route.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LineNumber",
        "DirectionCode",
        "JourneyPatternPointNumber",
        "LastModifiedUtcDateTime",
        "ExistsFromDate"
})
public class JourneyPattern {

    @JsonProperty("LineNumber")
    private Integer lineNumber;
    @JsonProperty("DirectionCode")
    private Integer directionCode;
    @JsonProperty("JourneyPatternPointNumber")
    private Integer journeyPatternPointNumber;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    @JsonProperty("LineNumber")
    public Integer getLineNumber() {
        return lineNumber;
    }

    @JsonProperty("LineNumber")
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @JsonProperty("DirectionCode")
    public Integer getDirectionCode() {
        return directionCode;
    }

    @JsonProperty("DirectionCode")
    public void setDirectionCode(Integer directionCode) {
        this.directionCode = directionCode;
    }

    @JsonProperty("JourneyPatternPointNumber")
    public Integer getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    @JsonProperty("JourneyPatternPointNumber")
    public void setJourneyPatternPointNumber(Integer journeyPatternPointNumber) {
        this.journeyPatternPointNumber = journeyPatternPointNumber;
    }

    @JsonProperty("LastModifiedUtcDateTime")
    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }

    @JsonProperty("LastModifiedUtcDateTime")
    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }

    @JsonProperty("ExistsFromDate")
    public String getExistsFromDate() {
        return existsFromDate;
    }

    @JsonProperty("ExistsFromDate")
    public void setExistsFromDate(String existsFromDate) {
        this.existsFromDate = existsFromDate;
    }
}