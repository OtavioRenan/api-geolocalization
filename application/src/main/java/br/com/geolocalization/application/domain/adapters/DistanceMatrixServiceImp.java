package br.com.geolocalization.application.domain.adapters;

import br.com.geolocalization.application.domain.dtos.DistanceMatrixDTO;
import br.com.geolocalization.application.domain.dtos.inputs.DistanceMatrixInput;
import br.com.geolocalization.application.domain.ports.DistanceMatrixServicePort;
import br.com.geolocalization.application.external.distancematrix.interfaces.DistanceMatrixRepositoryPort;
public class DistanceMatrixServiceImp implements DistanceMatrixServicePort {

    private final DistanceMatrixRepositoryPort repository;

    public DistanceMatrixServiceImp(DistanceMatrixRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public DistanceMatrixDTO calculateDistance(DistanceMatrixInput input) {
        return repository.calculateDistance(input.getOrigins(), input.getDestinations()).toDistanceMatrixDTO();
    }
}