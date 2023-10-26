package br.com.geolocalization.application.domain.dtos.inputs;

import java.util.List;

public class DistanceMatrixInput {
    List<String> origins;

    List<String> destinations;

    public List<String> getOrigins() {
        return origins;
    }

    public void setOrigins(List<String> origins) {
        this.origins = origins;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }
}
