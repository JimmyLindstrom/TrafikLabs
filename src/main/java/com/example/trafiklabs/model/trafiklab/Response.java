package com.example.trafiklabs.model.trafiklab;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StatusCode",
        "ExecutionTime",
        "ResponseData"
})
public class Response<T> {

    @JsonProperty("StatusCode")
    private Integer statusCode;
    @JsonProperty("ExecutionTime")
    private Integer executionTime;
    @JsonProperty("ResponseData")
    private ResponseData<T> responseData;

    @JsonProperty("StatusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("ExecutionTime")
    public Integer getExecutionTime() {
        return executionTime;
    }

    @JsonProperty("ExecutionTime")
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    @JsonProperty("ResponseData")
    public ResponseData<T> getResponseData() {
        return responseData;
    }

    @JsonProperty("ResponseData")
    public void setResponseData(ResponseData<T> responseData) {
        this.responseData = responseData;
    }

}
