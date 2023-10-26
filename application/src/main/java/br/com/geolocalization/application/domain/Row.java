package br.com.geolocalization.application.domain;

import br.com.geolocalization.application.domain.dtos.RowDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Row {
    List<Element> elements;

    public Row(List<Element> elements) {
        this.elements = elements;
    }

    public RowDTO toRowDTO() {
        return new RowDTO(elements.stream().map(Element::toElementDTO).collect(Collectors.toList()));
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}