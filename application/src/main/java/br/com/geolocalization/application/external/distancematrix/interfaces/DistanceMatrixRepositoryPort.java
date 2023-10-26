package br.com.geolocalization.application.external.distancematrix.interfaces;

import br.com.geolocalization.application.domain.DistanceMatrix;

import java.util.List;

public interface DistanceMatrixRepositoryPort {
    DistanceMatrix calculateDistance(List<String> origins, List<String> destinations);
}