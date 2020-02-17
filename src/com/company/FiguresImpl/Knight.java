package com.company.FiguresImpl;

import com.company.Enums.Color;
import com.company.Coordinates;
import com.company.Figure;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Figure {

    public Knight(Coordinates currentLocation, Color color) {
        super(currentLocation, color);
    }

    @Override
    public List<Coordinates> getCoveredFields() {
        ArrayList<Coordinates> arrayList = new ArrayList<>();
        for (int i = this.getX()-2; i <= this.getX()+2; i++) {
            for (int j = this.getY()-2; j <= this.getY()+2; j++) {
                if (!outOfBoard(i,j) && (!isNearFields(i,j)) &&(
                        ((i+j-3==this.getX()+this.getY()))
                        ||(i+j-1==this.getX()+this.getY())
                        ||(i+j+1==this.getX()+this.getY())
                        ||(i+j+3==this.getX()+this.getY())
                )) {
                    arrayList.add(new Coordinates(i, j));
                }
            }
        }
        arrayList.remove(this.getCurrentLocation());
        return arrayList;
    }
    protected boolean isNearFields(int x, int y) {
        return this.getX()==x || this.getY()==y;
    }
}
