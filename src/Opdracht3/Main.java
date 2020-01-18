package Opdracht3;

import Opdracht3.Models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Board board = new Board();
        List<Field> startFields = board.createBoard();

        Pawn pawn1 = new Pawn(startFields.get(0));
        Pawn pawn2 = new Pawn(startFields.get(1));

        List<Field> visited = new ArrayList<>();
        List<Field> visited2 = new ArrayList<>();

        findFinish(pawn1, pawn2, visited, visited2);

//        for (PawnStatePair pair: findFinish(pawn1, pawn2, visited, visited2)) {
//            System.out.println(pair.getPawnOnePosition().getId() + " " + pair.getPawnTwoPosition().getId());
//        }
    }

    LinkedList<PawnStatePair> findFinish(Pawn pawn1, Pawn pawn2, List<Field> visitedpawn1, List<Field> visitedpawn2) {
        LinkedList<PawnStatePair> solution;
        // remember visited fields seperately
        // TODO: use pawnStatePair object and just one list to accurately represent route to finish
        visitedpawn1.add(pawn1.getCurrentField());
        visitedpawn2.add(pawn2.getCurrentField());

        // if one of the fields is on the finish field return it
        if (isFinish(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()))) {
            solution = new LinkedList<PawnStatePair>();
            solution.add(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
            return solution;
        } else {
            // remember both fields the pawns are on to use backtracking
            // because both pawn objects change frequently and are unreliable when returning from recursive call
            Field pawn1Field = pawn1.getCurrentField();
            Field pawn2Field = pawn2.getCurrentField();
            // look through all possible connections from pawn1
            for (Connection connection: pawn1Field.getConnections()) {
                // TODO: fix cycle detection
//                if (!visitedpawn1.contains(connection.getFieldTo())) {
                // compare colors and change pawn position if there is a match
                    if (connection.getColor() == pawn2Field.getColor()) {
                        pawn1.setCurrentField(connection.getFieldTo());
                        pawn2.setCurrentField(pawn2Field);
                        // recursive call to continue en route to finish with new pawn position
                        solution = findFinish(pawn1, pawn2, visitedpawn1, visitedpawn2);
                        // if goal is reached we return the solution
                        if (goalIsReached(solution)) {
                            solution.addFirst(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
//                            for (Field field: visitedpawn1) {
//                                System.out.println("Pawn1: " + field.getId());
//                            }
                            return solution;
                        }
                    }
//                }
            }

            // look through all possible connections from pawn2
            // same thing as above
            for (Connection connection: pawn2Field.getConnections()) {
                    if (connection.getColor() == pawn1Field.getColor()) {
                        pawn2.setCurrentField(connection.getFieldTo());
                        pawn1.setCurrentField(pawn1Field);
                        solution = findFinish(pawn1, pawn2, visitedpawn1, visitedpawn2);
                        if (goalIsReached(solution)) {
                            solution.addFirst(new PawnStatePair(pawn1.getCurrentField(), pawn2.getCurrentField()));
                            for (Field field: visitedpawn2) {
                                System.out.println("Pawn2: " + field.getId());
                            }
                            return solution;
                        }
                    }
            }
        }
        visitedpawn1.remove(pawn1.getCurrentField());
        visitedpawn2.remove(pawn2.getCurrentField());
        return new LinkedList<PawnStatePair>();
    }


    public boolean isFinish(PawnStatePair position) {
        return position.getPawnOnePosition().getColor() == GameColor.BLUE || position.getPawnTwoPosition().getColor() == GameColor.BLUE;
    }

    public boolean goalIsReached(LinkedList<PawnStatePair> solution) {
        for (PawnStatePair pair: solution) {
            if (pair.getPawnTwoPosition().getColor() == GameColor.BLUE || pair.getPawnOnePosition().getColor() == GameColor.BLUE) {
                return true;
            }
        }
        return false;
    }

}
