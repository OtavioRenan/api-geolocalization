package br.com.geolocalization.application.external.distancematrix.entitys;

import br.com.geolocalization.application.domain.DistanceMatrix;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceMatrixEntity {
    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses;

    @JsonProperty("origin_addresses")
    private List<String> originAddresses;

    private List<RowEntity> rows = new ArrayList<>();

    private String status;

    public DistanceMatrix toDistanceMatrix() {
        return new DistanceMatrix(destinationAddresses,
                originAddresses, rows.stream().map(RowEntity::toRow).collect(Collectors.toList()), status);
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<RowEntity> getRows() {
        return rows;
    }

    public void setRows(List<RowEntity> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}