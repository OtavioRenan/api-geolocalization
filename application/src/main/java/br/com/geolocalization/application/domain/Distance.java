package br.com.geolocalization.application.domain;

import br.com.geolocalization.application.domain.dtos.DistanceDTO;

public class Distance {
    private String text;

    private String value;

    public Distance(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public DistanceDTO toDistanceDTO() {
        return new DistanceDTO(getText(), getValue());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}