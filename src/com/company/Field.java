package com.company;

public class Field {

    private Coordinates coordinate;
    private Figure figure;

    public Field(Coordinates coordinate, Figure figure) {
        this.coordinate = coordinate;
        this.figure = figure;
    }
    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

}
