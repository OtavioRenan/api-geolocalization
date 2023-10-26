package br.com.geolocalization.application.external.distancematrix.entitys;

import br.com.geolocalization.application.domain.Duration;

public class DurationEntity {
    private String text;

    private String value;

    public Duration toDuration() {
        return new Duration(text, value);
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
