package Opdracht3.Models;

public class Pawn {
    private Field currentField;

    public Pawn(Field currentField){
        this.currentField = currentField;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }
}
