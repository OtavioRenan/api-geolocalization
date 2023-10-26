package br.com.geolocalization.application.external.distancematrix.entitys;

import br.com.geolocalization.application.domain.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RowEntity {
    List<ElementEntity> elements = new ArrayList<>();

    public Row toRow() {
        return new Row(elements.stream().map(ElementEntity::toElement).collect(Collectors.toList()));
    }

    public List<ElementEntity> getElements() {
        return elements;
    }

    public void setElements(List<ElementEntity> elements) {
        this.elements = elements;
    }
}