package com.company.FiguresImpl;

import com.company.Enums.Color;
import com.company.Coordinates;
import com.company.Figure;

import java.util.ArrayList;
import java.util.List;

public class King extends Figure {
    public boolean isInCheck() {
        return isInCheck;
    }

    public void setInCheck(boolean inCheck) {
        isInCheck = inCheck;
    }

    private boolean isInCheck;

    public King(Coordinates coordinates, Color color) {
        super(coordinates,color);
    }

    @Override
    public List<Coordinates> getCoveredFields() {
        ArrayList<Coordinates> arrayList = new ArrayList<>();
        for (int i = this.getX() - 1; i <= this.getX() + 1; i++) {
            for (int j = this.getY() - 1; j <= this.getY() + 1; j++) {
                if (!outOfBoard(i, j)) {
                    arrayList.add(new Coordinates(i, j));
                }
            }
        }
        arrayList.remove(this.getCurrentLocation());
        return arrayList;
    }

}