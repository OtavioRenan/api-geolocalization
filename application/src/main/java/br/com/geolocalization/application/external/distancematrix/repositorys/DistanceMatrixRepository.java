package br.com.geolocalization.application.external.distancematrix.repositorys;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.geolocalization.application.domain.DistanceMatrix;
import br.com.geolocalization.application.domain.exceptions.DefaultException;
import br.com.geolocalization.application.external.distancematrix.entitys.DistanceMatrixEntity;
import br.com.geolocalization.application.external.distancematrix.interfaces.DistanceMatrixRepositoryPort;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class DistanceMatrixRepository implements DistanceMatrixRepositoryPort {
    @Value("${google.api.distance.matrix.key}")
    private String key;

    private static final Logger LOGGER = Logger.getLogger(DistanceMatrixRepository.class.getName());

    private  static final String URL = "https://maps.googleapis.com/maps/api/distancematrix/json?";

    @Override
    public DistanceMatrix calculateDistance(List<String> origins, List<String> destinations) {
        return getDistance(origins, destinations);
    }

    public DistanceMatrix getDistance(List<String> origins, List<String> destinations) {
        String url = factoryParams("origins=", origins) + factoryParams("&destinations=", destinations) + factoryKey();
        return getDistance(url).toDistanceMatrix();
    }

    private DistanceMatrixEntity getDistance(String params) {
        DistanceMatrixEntity distance = new DistanceMatrixEntity();

        try {
            URL url = new URL(URL + params);

            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.connect();

            if(request.getResponseCode() == 400) {
                defaultException();
            }

            distance = new ObjectMapper().readValue(request.getInputStream(), DistanceMatrixEntity.class);

            if(!distance.getStatus().equals("OK")) {
                defaultException();
            }

            request.disconnect();
        } catch (IOException e) {
            LOGGER.warning(e.getLocalizedMessage());
        }

        return distance;
    }

    private String factoryParams(String params, List<String> list) {
        StringBuilder sb = new StringBuilder(params);

        int size = list.size();

        AtomicInteger index = new AtomicInteger(1);

        list.forEach( s -> {
            if(size == index.get()) {
                sb.append(s);
            } else {
                sb.append(s).append("|");
                index.getAndIncrement();
            }
        });

        return sb.toString();
    }

    private String factoryKey() {
        return "&key=" + key;
    }

    private void defaultException() {
        throw new DefaultException("Request error on access API Distance Matrix.");
    }
}