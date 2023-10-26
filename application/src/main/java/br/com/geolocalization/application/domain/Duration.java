package br.com.geolocalization.application.domain;

import br.com.geolocalization.application.domain.dtos.DurationDTO;

public class Duration {
    private String text;

    private String value;

    public Duration(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public DurationDTO toDurationDTO() {
        return new DurationDTO(getText(), getValue());
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
