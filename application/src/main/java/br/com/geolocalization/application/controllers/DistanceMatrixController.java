package br.com.geolocalization.application.controllers;

import br.com.geolocalization.application.domain.dtos.DistanceMatrixDTO;
import br.com.geolocalization.application.domain.dtos.inputs.DistanceMatrixInput;
import br.com.geolocalization.application.domain.ports.DistanceMatrixServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distance-matrix")
public class DistanceMatrixController {
    @Autowired
    private DistanceMatrixServicePort service;

    @GetMapping("/")
    public DistanceMatrixDTO calculate(@RequestBody DistanceMatrixInput input) {
        return service.calculateDistance(input);
    }
}