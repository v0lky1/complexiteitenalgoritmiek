package Opdracht3.Models;

public class PawnStatePair {

    private Field pawnOnePosition;
    private Field pawnTwoPosition;

    public PawnStatePair(Field pawnOnePosition, Field pawnTwoPosition) {
        this.pawnOnePosition = pawnOnePosition;
        this.pawnTwoPosition = pawnTwoPosition;
    }

    public Field getPawnOnePosition() {
        return pawnOnePosition;
    }

    public Field getPawnTwoPosition() {
        return pawnTwoPosition;
    }

    public boolean samePositions(PawnStatePair pair) {
        if (pair.getPawnOnePosition() == pawnOnePosition && pair.getPawnTwoPosition() == pawnTwoPosition) {
            return true;
        } else {
            return false;
        }
    }
}
