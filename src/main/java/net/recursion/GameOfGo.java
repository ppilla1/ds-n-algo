package net.recursion;

import lombok.extern.slf4j.Slf4j;

/*
 * Find if a given Black is conquered in the board game Go.
 * 1. Black and White play alternately.
 * 2. Black is conquered if it is (and all its neighboring blacks, if any, are also)
 * surrounded by whites or boarders of the board
 * 3. Board size is 19 x 19
 *
 * .e.g:
 * |B|W|B| |
 * ---------
 * |B|B|W| |
 * ---------
 * |W|W| | |
 * ---------
 * | | | | |
 *
 * Let value 2 represents Black , 1 represents White, 0 represents Empty space and -1 Visited
 */
@Slf4j
public class GameOfGo {
    private final int[][] board;

    static class Coordinate{
        final int x;
        final int y;

        public Coordinate(int xValue, int yValue){
            this.x = xValue;
            this.y = yValue;
        }
    }
    public GameOfGo(int[][] problemBoard){
        this.board = problemBoard;
    }

    public boolean isConquered(Coordinate problemCoordinate, Coordinate solutionCoordinate){
        boolean result = false;

        log.info("Value of problem space {}",board[problemCoordinate.x][problemCoordinate.y]);

        if (board[problemCoordinate.x][problemCoordinate.y] != 2 && board[problemCoordinate.x][problemCoordinate.y] != -1){
            throw new IllegalStateException("Only can check state of Black piece");
        }
        // Happy case
        if ((solutionCoordinate.x >=0 && solutionCoordinate.x < board.length) &&
            (solutionCoordinate.y >=0 && solutionCoordinate.y < board[0].length) &&
            board[solutionCoordinate.x][solutionCoordinate.y] == 0){
            result = false;
        }else if (
                        (solutionCoordinate.x >= board.length || solutionCoordinate.x < 0) ||
                        (solutionCoordinate.y >= board[0].length || solutionCoordinate.y < 0) ||
                         board[solutionCoordinate.x][solutionCoordinate.y] == 1 ||
                         board[solutionCoordinate.x][solutionCoordinate.y] == -1
        ){
            result = true;
        }else {

            // Check UP
            Coordinate newProblem = new Coordinate(solutionCoordinate.x, solutionCoordinate.y);
            Coordinate newSolution = new Coordinate(solutionCoordinate.x - 1, solutionCoordinate.y);
            board[newProblem.x][newProblem.y]=-1;
            result = isConquered(newProblem, newSolution);

            // Check DOWN
            if (result){
                newProblem = new Coordinate(solutionCoordinate.x, solutionCoordinate.y);
                newSolution = new Coordinate(solutionCoordinate.x + 1, solutionCoordinate.y);
                board[newProblem.x][newProblem.y]=-1;
                result = isConquered(newProblem, newSolution);
            }

            // Check LEFT
            if (result){
                newProblem = new Coordinate(solutionCoordinate.x, solutionCoordinate.y);
                newSolution = new Coordinate(solutionCoordinate.x , solutionCoordinate.y - 1);
                board[newProblem.x][newProblem.y]=-1;
                result = isConquered(newProblem, newSolution);
            }

            // Check RIGHT
            if (result){
                newProblem = new Coordinate(solutionCoordinate.x, solutionCoordinate.y);
                newSolution = new Coordinate(solutionCoordinate.x , solutionCoordinate.y + 1);
                board[newProblem.x][newProblem.y]=-1;
                result = isConquered(newProblem, newSolution);
            }

        }
        return result;
    }
}
