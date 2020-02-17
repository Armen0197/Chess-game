package com.company;

import com.company.Enums.Color;
import com.company.FiguresImpl.King;

import java.util.HashSet;

public class GameResult {
    private SetupBoard setupBoard;
    private HashSet<Coordinates> whiteFiguresCoveredFields;
    private HashSet<Coordinates> blackFiguresCoveredFields;
    private King king;

    public GameResult(SetupBoard setupBoard) {
        this.setupBoard = setupBoard;
        setBlackFiguresCoveredFields();
        setWhiteFiguresCoveredFields();
    }

    protected boolean ifKingIsCheck() {
        for (int i = 0; i < setupBoard.getWhiteFigures().size(); i++) {
            if (setupBoard.getWhiteFigures().get(i)instanceof King) {
                if (blackFiguresCoveredFields.contains(setupBoard.getWhiteFigures().get(i).getCurrentLocation())) {
                    ((King) setupBoard.getWhiteFigures().get(i)).setInCheck(true);
                    king = (King) setupBoard.getWhiteFigures().get(i);
                }
            }
        }
        if (king==null) {
            for (int i = 0; i < setupBoard.getBlackFigures().size(); i++) {
                if (setupBoard.getBlackFigures().get(i) instanceof King) {
                    if (whiteFiguresCoveredFields.contains(setupBoard.getBlackFigures().get(i).getCurrentLocation())) {
                        ((King) setupBoard.getBlackFigures().get(i)).setInCheck(true);
                        king = (King) setupBoard.getBlackFigures().get(i);
                    }
                }
            }
        }
            return king!=null;
    }
    protected boolean ifThereIsMat() {
       if  (ifKingIsCheck()) {
           if (king.getColor() == Color.WHITE) {
           for (int i = 0; i < blackFiguresCoveredFields.size(); i++) {
               if (blackFiguresCoveredFields.containsAll(king.getCoveredFields())) {
                   return true;
               }
           }
       }
           else {
               for (int i = 0; i < whiteFiguresCoveredFields.size(); i++) {
                   if (whiteFiguresCoveredFields.containsAll(king.getCoveredFields())) {
                       return true;
                   }
               }
           }
       }
       return false;
    }

    public void setWhiteFiguresCoveredFields() {
        if (!setupBoard.getWhiteFigures().isEmpty()) {
         whiteFiguresCoveredFields = new HashSet<>();
            for (int i = 0; i < setupBoard.getWhiteFigures().size(); i++) {
                this.whiteFiguresCoveredFields.addAll(setupBoard.getWhiteFigures().get(i).getCoveredFields());
            }
        }
    }

    public void setBlackFiguresCoveredFields() {
        if (!setupBoard.getBlackFigures().isEmpty()) {
            blackFiguresCoveredFields = new HashSet<>();
            for (int i = 0; i < setupBoard.getBlackFigures().size(); i++) {
                this.blackFiguresCoveredFields.addAll(setupBoard.getBlackFigures().get(i).getCoveredFields());
            }
        }
    }

    @Override
    public String toString() {
        return "It is Mat " + ifThereIsMat() + " there is Shah " + ifKingIsCheck();
    }
}
