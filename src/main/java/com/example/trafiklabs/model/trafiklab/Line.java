package com.example.trafiklabs.model.trafiklab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LineNumber",
        "LineDesignation",
        "DefaultTransportMode",
        "DefaultTransportModeCode",
        "LastModifiedUtcDateTime",
        "ExistsFromDate"
})
public class Line {

    @JsonProperty("LineNumber")
    private Integer lineNumber;
    @JsonProperty("LineDesignation")
    private String lineDesignation;
    @JsonProperty("DefaultTransportMode")
    private String defaultTransportMode;
    @JsonProperty("DefaultTransportModeCode")
    private String defaultTransportModeCode;
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

    @JsonProperty("LineDesignation")
    public String getLineDesignation() {
        return lineDesignation;
    }

    @JsonProperty("LineDesignation")
    public void setLineDesignation(String lineDesignation) {
        this.lineDesignation = lineDesignation;
    }

    @JsonProperty("DefaultTransportMode")
    public String getDefaultTransportMode() {
        return defaultTransportMode;
    }

    @JsonProperty("DefaultTransportMode")
    public void setDefaultTransportMode(String defaultTransportMode) {
        this.defaultTransportMode = defaultTransportMode;
    }

    @JsonProperty("DefaultTransportModeCode")
    public String getDefaultTransportModeCode() {
        return defaultTransportModeCode;
    }

    @JsonProperty("DefaultTransportModeCode")
    public void setDefaultTransportModeCode(String defaultTransportModeCode) {
        this.defaultTransportModeCode = defaultTransportModeCode;
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
