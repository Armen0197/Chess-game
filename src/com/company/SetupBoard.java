package com.company;

import com.company.Enums.Color;
import com.company.NotEmptyFieldException;

import java.util.ArrayList;
import java.util.List;

public final class SetupBoard {

    private Field[][] board;
    private List<Figure> figureList;
    private List<Figure> blackFigures;
    private List<Figure> whiteFigures;

    public SetupBoard(List<Figure> figureList) throws Exception {
        setEmptyBoard();
        this.figureList=figureList;
        setBlackFigures();
        setWhiteFigures();
        setFiguresOnBoard();
    }

    public Field[][] getBoard() {
        return board;
    }

    public void setEmptyBoard() {
        this.board = new Field[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new Field(new Coordinates(i, j), null);
            }
        }
    }

    public void setFiguresOnBoard() throws NotEmptyFieldException {
        if (!figureList.isEmpty()) {
            Figure figure = null;
            int x;
            int y;
            for (Figure value : figureList) {
                figure = value;
                x = figure.getCurrentLocation().getX();
                y = figure.getCurrentLocation().getY();
                isFieldEmpty(x, y);
                this.board[x][y] = new Field(new Coordinates(x, y), (figure));
            }
        }
    }

    protected void isFieldEmpty(int x, int y) throws NotEmptyFieldException {
        if (this.board[x][y].getFigure() != null) {
            throw new NotEmptyFieldException("Two figures can't be in the same field");
        }
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    public void setFigureList(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public List<Figure> getBlackFigures() {
        return blackFigures;
    }

    public void setBlackFigures() {
        blackFigures = new ArrayList<>();
        for (int i = 0; i < figureList.size(); i++) {
            if (figureList.get(i).getColor().equals(Color.BLACK)) {
                this.blackFigures.add(figureList.get(i));
            }
        }
    }

    public List<Figure> getWhiteFigures() {
        return whiteFigures;
    }

    public void setWhiteFigures() {
        whiteFigures = new ArrayList<>();
        for (int i = 0; i < getFigureList().size(); i++) {
            if (getFigureList().get(i).getColor().equals(Color.WHITE)) {
                this.whiteFigures.add(getFigureList().get(i));
            }
        }
    }
}

