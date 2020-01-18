package Opdracht3.Models;

import Opdracht3.GameColor;

public class Connection {
    private Field fieldTo;
    private GameColor color;

    public Connection(Field fieldTo, GameColor color){
        this.fieldTo = fieldTo;
        this.color = color;
    }

    public Field getFieldTo() {
        return fieldTo;
    }

    public GameColor getColor() {
        return color;
    }
}
