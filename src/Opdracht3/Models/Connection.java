package Opdracht3.Models;

import Opdracht3.GameColor;

public class Connection {
    private Field fieldTo;
    private Field fieldFrom;
    private GameColor color;

    public Connection(Field fieldTo, Field fieldFrom, GameColor color){
        this.fieldTo = fieldTo;
        this.fieldFrom = fieldFrom;
        this.color = color;
    }

    public Field getFieldTo() {
        return fieldTo;
    }

    public void setFieldTo(Field fieldTo) {
        this.fieldTo = fieldTo;
    }

    public Field getFieldFrom() {
        return fieldFrom;
    }

    public void setFieldFrom(Field fieldFrom) {
        this.fieldFrom = fieldFrom;
    }

    public GameColor getColor() {
        return color;
    }

    public void setColor(GameColor color) {
        this.color = color;
    }
}
