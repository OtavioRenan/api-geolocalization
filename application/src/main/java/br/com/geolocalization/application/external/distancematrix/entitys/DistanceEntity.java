package br.com.geolocalization.application.external.distancematrix.entitys;

import br.com.geolocalization.application.domain.Distance;

public class DistanceEntity {

    private String text;

    private String value;

    public Distance toDistance() {
        return new Distance(text, value);
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