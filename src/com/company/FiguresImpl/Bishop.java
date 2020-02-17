package com.company.FiguresImpl;

import com.company.Enums.Color;
import com.company.Coordinates;
import com.company.Figure;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure {

    public Bishop(Coordinates currentLocation, Color color) {
        super(currentLocation, color);
    }

    @Override
    public List<Coordinates> getCoveredFields() {
        ArrayList<Coordinates> arrayList = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (!outOfBoard(i, j) && (
                        (i + j==this.getX() + this.getY())
                        ||(i - j==this.getX() - this.getY())
                )) {
                    arrayList.add(new Coordinates(i, j));
                }
            }
        }
        arrayList.remove(this.getCurrentLocation());
        return arrayList;
    }
}
