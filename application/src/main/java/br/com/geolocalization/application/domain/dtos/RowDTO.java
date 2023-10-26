package br.com.geolocalization.application.domain.dtos;

import java.util.List;

public class RowDTO {
    List<ElementDTO> elements;

    public RowDTO(List<ElementDTO> elements) {
        this.elements = elements;
    }

    public List<ElementDTO> getElements() {
        return elements;
    }

    public void setElements(List<ElementDTO> elements) {
        this.elements = elements;
    }
}