package br.com.geolocalization.application.domain.dtos;

public class ElementDTO {
    private DistanceDTO distance;

    private DurationDTO duration;

    private String status;

    public ElementDTO(DistanceDTO distance, DurationDTO duration, String status) {
        this.distance = distance;
        this.duration = duration;
        this.status = status;
    }

    public DistanceDTO getDistance() {
        return distance;
    }

    public void setDistance(DistanceDTO distance) {
        this.distance = distance;
    }

    public DurationDTO getDuration() {
        return duration;
    }

    public void setDuration(DurationDTO duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
