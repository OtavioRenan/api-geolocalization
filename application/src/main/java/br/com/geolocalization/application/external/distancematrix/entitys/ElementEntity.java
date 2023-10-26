package br.com.geolocalization.application.external.distancematrix.entitys;

import br.com.geolocalization.application.domain.Element;

public class ElementEntity {
    private DistanceEntity distance;

    private DurationEntity duration;

    private String status;

    public Element toElement() {
        return new Element(distance.toDistance(), duration.toDuration(), status);
    }

    public DistanceEntity getDistance() {
        return distance;
    }

    public void setDistance(DistanceEntity distance) {
        this.distance = distance;
    }

    public DurationEntity getDuration() {
        return duration;
    }

    public void setDuration(DurationEntity duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}