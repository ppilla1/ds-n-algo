package net.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * .e.g:
 * |B|W|B| |
 * ---------
 * |B|B|W| |
 * ---------
 * |W|W| | |
 * ---------
 * | | | | |
 *
 * Let value 2 represents Black , 1 represents White and 0 represents Empty space
 */

@Slf4j
public class TestGameOfGo {
    private GameOfGo gameOfGo;

    @Before
    public void setUp(){
        gameOfGo = new GameOfGo(new int[][] {{2,1,2,0}, {2,2,1,0}, {1,1,0,0}, {0,0,0,0}});
    }

    @After
    public void tearDown(){
        gameOfGo=null;
    }

    @Test
    public void testCornerBlackIsConquired(){
        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(0, 0), new GameOfGo.Coordinate(0, 0)));

        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(1, 0), new GameOfGo.Coordinate(1, 0)));
    }

    @Test
    public void testInsideBlackIsConquired(){
        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(1, 1), new GameOfGo.Coordinate(1, 1)));
    }

    @Test
    public void testOuterBlackIsConquired(){
        assertTrue(!gameOfGo.isConquered(new GameOfGo.Coordinate(0, 2), new GameOfGo.Coordinate(0, 2)));
    }

    @Test
    public void testOuterWhiteIsConquired(){
        try {
            boolean result = gameOfGo.isConquered(new GameOfGo.Coordinate(1, 2), new GameOfGo.Coordinate(1, 2));
        }catch (IllegalStateException e){
            assertTrue(true);
        }
    }

    @Test
    public void testInnerWhiteIsConquired(){
        try {
            boolean result = gameOfGo.isConquered(new GameOfGo.Coordinate(0, 1), new GameOfGo.Coordinate(0, 1));
        }catch (IllegalStateException e){
            assertTrue(true);
        }
    }

}
