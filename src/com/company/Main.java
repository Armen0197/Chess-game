package com.company;

import com.company.Enums.Color;
import com.company.FiguresImpl.Bishop;
import com.company.FiguresImpl.King;
import com.company.FiguresImpl.Knight;
import com.company.FiguresImpl.Queen;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Figure> figures = new ArrayList<>();
        figures.add(new King(new Coordinates(0,0),Color.WHITE));
        figures.add(new King(new Coordinates(0,7),Color.BLACK));
        figures.add(new Knight(new Coordinates(0,2),Color.BLACK));
        figures.add(new Queen(new Coordinates(6,1),Color.BLACK));
        figures.add(new Bishop(new Coordinates(2,2),Color.BLACK));
        SetupBoard setupBoard = new SetupBoard(figures);
        GameResult gameResult = new GameResult(setupBoard);
        System.out.println(gameResult.toString());
    }
}
