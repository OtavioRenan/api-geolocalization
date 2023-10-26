package br.com.geolocalization.application.domain;

import br.com.geolocalization.application.domain.dtos.DistanceMatrixDTO;
import br.com.geolocalization.application.external.distancematrix.entitys.RowEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceMatrix {
    List<String> destinationAddresses;

    List<String> originAddresses;

    List<Row> rows;

    String status;

    public DistanceMatrix(List<String> destinationAddresses, List<String> originAddresses, List<Row> rows, String status) {
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
        this.rows = rows;
        this.status = status;
    }

    public DistanceMatrixDTO toDistanceMatrixDTO() {
        return new DistanceMatrixDTO(destinationAddresses, originAddresses, rows.stream().map(Row::toRowDTO).collect(Collectors.toList()), status);
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

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}