package com.example.trafiklabs.model.trafiklab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopPointNumber",
        "StopPointName",
        "StopAreaNumber",
        "LocationNorthingCoordinate",
        "LocationEastingCoordinate",
        "ZoneShortName",
        "StopAreaTypeCode",
        "LastModifiedUtcDateTime",
        "ExistsFromDate"
})
public class StopPoint {

    @JsonProperty("StopPointNumber")
    private Integer stopPointNumber;
    @JsonProperty("StopPointName")
    private String stopPointName;
    @JsonProperty("StopAreaNumber")
    private Integer stopAreaNumber;
    @JsonProperty("LocationNorthingCoordinate")
    private String locationNorthingCoordinate;
    @JsonProperty("LocationEastingCoordinate")
    private String locationEastingCoordinate;
    @JsonProperty("ZoneShortName")
    private String zoneShortName;
    @JsonProperty("StopAreaTypeCode")
    private String stopAreaTypeCode;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    @JsonProperty("StopPointNumber")
    public Integer getStopPointNumber() {
        return stopPointNumber;
    }

    @JsonProperty("StopPointNumber")
    public void setStopPointNumber(Integer stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    @JsonProperty("StopPointName")
    public String getStopPointName() {
        return stopPointName;
    }

    @JsonProperty("StopPointName")
    public void setStopPointName(String stopPointName) {
        this.stopPointName = stopPointName;
    }

    @JsonProperty("StopAreaNumber")
    public Integer getStopAreaNumber() {
        return stopAreaNumber;
    }

    @JsonProperty("StopAreaNumber")
    public void setStopAreaNumber(Integer stopAreaNumber) {
        this.stopAreaNumber = stopAreaNumber;
    }

    @JsonProperty("LocationNorthingCoordinate")
    public String getLocationNorthingCoordinate() {
        return locationNorthingCoordinate;
    }

    @JsonProperty("LocationNorthingCoordinate")
    public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
        this.locationNorthingCoordinate = locationNorthingCoordinate;
    }

    @JsonProperty("LocationEastingCoordinate")
    public String getLocationEastingCoordinate() {
        return locationEastingCoordinate;
    }

    @JsonProperty("LocationEastingCoordinate")
    public void setLocationEastingCoordinate(String locationEastingCoordinate) {
        this.locationEastingCoordinate = locationEastingCoordinate;
    }

    @JsonProperty("ZoneShortName")
    public String getZoneShortName() {
        return zoneShortName;
    }

    @JsonProperty("ZoneShortName")
    public void setZoneShortName(String zoneShortName) {
        this.zoneShortName = zoneShortName;
    }

    @JsonProperty("StopAreaTypeCode")
    public String getStopAreaTypeCode() {
        return stopAreaTypeCode;
    }

    @JsonProperty("StopAreaTypeCode")
    public void setStopAreaTypeCode(String stopAreaTypeCode) {
        this.stopAreaTypeCode = stopAreaTypeCode;
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
