package maze;

import maze.app.MazeModel;
import maze.util.Coordinate;

import java.util.*;

public final class MazeSolver {

    private static final Set<Coordinate> VISITED = new HashSet<>();

    public static List<Coordinate> solve(MazeModel model) {
        VISITED.clear();
        List<Coordinate> solution = doSolve(model, new Coordinate(0, 0));
//        Collections.reverse(solution);
        return solution;
    }

    private static List<Coordinate> doSolve(MazeModel model, Coordinate current) {
        VISITED.add(current);
        if (current.equals(model.getExit())) {
            return List.of(current);
        } else {
            List<Coordinate> solution = new ArrayList<>();

            Coordinate left = current.coordinateLeft();
            if (model.canMoveLeft(current) && !VISITED.contains(left)) {
                List<Coordinate> possibleSolution = doSolve(model, left);
                if (!possibleSolution.isEmpty()) {
                    solution.add(current);
                    solution.addAll(possibleSolution);
                }
            }

            Coordinate down = current.coordinateDown();
            if (model.canMoveDown(current) && !VISITED.contains(down)) {
                List<Coordinate> possibleSolution = doSolve(model, down);
                if (!possibleSolution.isEmpty()) {
                    solution.add(current);
                    solution.addAll(possibleSolution);
                }
            }

            Coordinate right = current.coordinateRight();
            if (model.canMoveRight(current) && !VISITED.contains(right)) {
                List<Coordinate> possibleSolution = doSolve(model, right);
                if (!possibleSolution.isEmpty()) {
                    solution.add(current);
                    solution.addAll(possibleSolution);
                }
            }

            Coordinate up = current.coordinateUp();
            if (model.canMoveUp(current) && !VISITED.contains(up)) {
                List<Coordinate> possibleSolution = doSolve(model, up);
                if (!possibleSolution.isEmpty()) {
                    solution.add(current);
                    solution.addAll(possibleSolution);
                }
            }

            return solution;
        }
    }

    private MazeSolver() {
        // no instantiation
    }
}
