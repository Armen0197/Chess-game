package com.company;

import com.company.Enums.Color;
import com.company.Moves;

public abstract class Figure implements Moves {
    private Coordinates currentLocation;
    private Color color;
    private int x;
    private int y;

    public Figure(Coordinates currentLocation,Color color) {
        this.currentLocation = currentLocation;
        this.color = color;
        setX();
        setY();
    }

    public Coordinates getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Coordinates currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public boolean outOfBoard(int x,int y) {
        return x < 0 || x > 7  || y > 7 || y < 0;
    }

    public int getX() {
        return x;
    }

    public void setX() {
        this.x = this.currentLocation.getX();
    }

    public int getY() {
        return y;
    }

    public void setY() {
        this.y = this.currentLocation.getY();
    }
}
