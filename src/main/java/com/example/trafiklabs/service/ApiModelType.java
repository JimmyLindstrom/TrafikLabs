package com.example.trafiklabs.service;

public enum ApiModelType {
    STOP_POINT("stop"),
    LINE("line"),
    JOURNEY_PATTERN("jour");

    final String model;

    ApiModelType(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
