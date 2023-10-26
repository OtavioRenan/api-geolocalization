package br.com.geolocalization.application.domain;

import br.com.geolocalization.application.domain.dtos.ElementDTO;

public class Element {
    private Distance distance;

    private Duration duration;

    private String status;

    public Element(Distance distance, Duration duration, String status) {
        this.distance = distance;
        this.duration = duration;
        this.status = status;
    }

    public ElementDTO toElementDTO() {
        return new ElementDTO(distance.toDistanceDTO(), duration.toDurationDTO(), status);
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
