package Opdracht3;

import Opdracht3.Models.*;

import java.util.*;

public class Main {

    private static int moveNo = 0;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Board board = new Board();
        List<Field> startFields = board.createBoard();

        Pawn pawn1 = new Pawn(startFields.get(0));
        Pawn pawn2 = new Pawn(startFields.get(1));

        findFinish(pawn1, pawn2, new ArrayList<>());
    }

    private LinkedList<PawnStatePair> findFinish(Pawn pawn1, Pawn pawn2, List<PawnStatePair> visited) {
        LinkedList<PawnStatePair> solution;
        // remember visited fields as a state
        visited.add(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));

        // remember both fields the pawns are on to use backtracking
        // because both pawn objects change frequently and are unreliable when returning from recursive call
        Field pawn1Field = pawn1.getCurrentField();
        Field pawn2Field = pawn2.getCurrentField();

        // if one of the fields is on the finish field return it
        if (isFinish(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()))) {
            solution = new LinkedList<>();
            solution.add(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
            return solution;
        } else {
            // look through all possible connections from pawn1
            for (Connection connection : pawn1Field.getConnections()) {
                // cycle detection
                boolean alreadyVisited = false;
                for (PawnStatePair pair : visited) {
                    if (pair.samePositions(new PawnStatePair(connection.getFieldTo(), pawn2Field)) && connection.getColor() == pawn2Field.getColor()) {
                        System.out.println("DUPLICATE: " + "Pawn 1 wants to move from " + pawn1Field + " to " + pair.getPawnOnePosition() + "\t\t| Pawn 2 current field: " + pair.getPawnTwoPosition());
                        alreadyVisited = true;
                    }
                }
                if (!alreadyVisited) {
                    // compare colors and change pawn position if there is a match
                    if (connection.getColor() == pawn2Field.getColor()) {
                        pawn1.setCurrentField(connection.getFieldTo());
                        pawn2.setCurrentField(pawn2Field);
                        System.out.println("MOVE " + ++moveNo + ": Pawn 1 moves from " + pawn1Field + " to " + pawn1.getCurrentField());
                        // recursive call to continue en route to finish with new pawn position
                        solution = findFinish(pawn1, pawn2, visited);
                        // if goal is reached we return the solution
                        if (goalIsReached(solution)) {
                            solution.addFirst(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
                            return solution;
                        }
                    }
                }
            }

            // look through all possible connections from pawn2
            // same thing as above
            for (Connection connection : pawn2Field.getConnections()) {
                boolean alreadyVisited = false;
                for (PawnStatePair pair : visited) {
                    if (pair.samePositions(new PawnStatePair(pawn1Field, connection.getFieldTo())) && connection.getColor() == pawn1Field.getColor()) {
                        System.out.println("DUPLICATE: " + "Pawn 2 wants to move from  " + pawn2Field + " to "  + pair.getPawnTwoPosition() + "\t\t| Pawn 1 current field: " + pair.getPawnOnePosition());
                        alreadyVisited = true;
                    }
                }
                if (!alreadyVisited) {
                    if (connection.getColor() == pawn1Field.getColor()) {
                        pawn2.setCurrentField(connection.getFieldTo());
                        pawn1.setCurrentField(pawn1Field);
                        System.out.println("MOVE " + ++moveNo + ": Pawn 2 moves from " + pawn2Field + " to " + pawn2.getCurrentField());
                        solution = findFinish(pawn1, pawn2, visited);
                        if (goalIsReached(solution)) {
                            solution.addFirst(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
                            return solution;
                        }
                    }
                }
            }
        }
        System.out.println("BACKTRACKING \n" +
                "Pawn 1: " + pawn1Field + " \n" +
                "Pawn 2: " + pawn2Field);
        return new LinkedList<>();
    }

    private boolean isFinish(PawnStatePair position) {
        //The color of the finish block is blue. Therefore if the pawn meets this color it won.
        return position.getPawnOnePosition().getColor() == GameColor.BLUE || position.getPawnTwoPosition().getColor() == GameColor.BLUE;
    }

    private boolean goalIsReached(LinkedList<PawnStatePair> solution) {

        for (PawnStatePair pair : solution) {
            if (pair.getPawnTwoPosition().getColor() == GameColor.BLUE || pair.getPawnOnePosition().getColor() == GameColor.BLUE) {
                return true;
            }
        }
        return false;
    }

}
