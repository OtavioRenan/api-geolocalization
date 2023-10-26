package br.com.geolocalization.application.domain.dtos;

import java.util.ArrayList;
import java.util.List;

public class DistanceMatrixDTO {
    List<String> destinationAddresses;

    List<String> originAddresses;

    List<RowDTO> rows;

    String status;

    public DistanceMatrixDTO(List<String> destinationAddresses, List<String> originAddresses, List<RowDTO> rows, String status) {
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
        this.rows = rows;
        this.status = status;
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

    public List<RowDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowDTO> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}