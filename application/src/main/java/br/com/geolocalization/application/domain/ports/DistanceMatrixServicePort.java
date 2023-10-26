package br.com.geolocalization.application.domain.ports;

import br.com.geolocalization.application.domain.dtos.DistanceMatrixDTO;
import br.com.geolocalization.application.domain.dtos.inputs.DistanceMatrixInput;

import java.util.List;

public interface DistanceMatrixServicePort {
    DistanceMatrixDTO calculateDistance(DistanceMatrixInput input);
}