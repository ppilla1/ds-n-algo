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
 */
@Slf4j
public class GameOfGo {
    private final CheckerType[][] board;
    private final CheckerType piece;

    static enum CheckerType{
        BLACK,WHITE,VISITED,EMPTY;
    }
    static class Coordinate{
        final int x;
        final int y;

        public Coordinate(int xValue, int yValue){
            this.x = xValue;
            this.y = yValue;
        }
    }
    public GameOfGo(CheckerType[][] problemBoard, CheckerType checkerType){
        this.board = problemBoard;
        this.piece= checkerType;
    }

    public boolean isConquered(Coordinate solutionCoordinate){
        boolean result = false;

        // Happy case
        if ((solutionCoordinate.x >=0 && solutionCoordinate.x < board.length) &&
            (solutionCoordinate.y >=0 && solutionCoordinate.y < board[0].length) &&
            board[solutionCoordinate.x][solutionCoordinate.y] == CheckerType.EMPTY){
            result = false;
        }else if (
                        (solutionCoordinate.x >= board.length || solutionCoordinate.x < 0) ||
                        (solutionCoordinate.y >= board[0].length || solutionCoordinate.y < 0) ||
                        (board[solutionCoordinate.x][solutionCoordinate.y] != piece && board[solutionCoordinate.x][solutionCoordinate.y] != CheckerType.VISITED)||
                         board[solutionCoordinate.x][solutionCoordinate.y] == CheckerType.VISITED
        ){
            result = true;
        }else {

            board[solutionCoordinate.x][solutionCoordinate.y]=CheckerType.VISITED;

            // Check UP
            Coordinate newSolution = new Coordinate(solutionCoordinate.x - 1, solutionCoordinate.y);
            result = isConquered(newSolution);

            // Check DOWN
            if (result){
                newSolution = new Coordinate(solutionCoordinate.x + 1, solutionCoordinate.y);
                result = isConquered(newSolution);
            }

            // Check LEFT
            if (result){
                newSolution = new Coordinate(solutionCoordinate.x , solutionCoordinate.y - 1);
                result = isConquered(newSolution);
            }

            // Check RIGHT
            if (result){
                newSolution = new Coordinate(solutionCoordinate.x , solutionCoordinate.y + 1);
                result = isConquered(newSolution);
            }

        }
        return result;
    }
}
