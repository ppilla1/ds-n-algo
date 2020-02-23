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

import static net.recursion.GameOfGo.CheckerType.*;

@Slf4j
public class TestGameOfGo {
    private GameOfGo gameOfGo;

    @Before
    public void setUp(){
        gameOfGo = new GameOfGo(new GameOfGo.CheckerType[][]{{BLACK,WHITE,BLACK,EMPTY}, {BLACK,BLACK,WHITE,EMPTY}, {WHITE,WHITE,EMPTY,EMPTY}, {EMPTY,EMPTY,EMPTY,EMPTY}}, BLACK);
    }

    @After
    public void tearDown(){
        gameOfGo=null;
    }

    @Test
    public void testCornerBlackIsConquired(){
        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(0, 0)));

        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(1, 0)));
    }

    @Test
    public void testInsideBlackIsConquired(){
        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(1, 1)));
    }

    @Test
    public void testOuterBlackIsConquired(){
        assertTrue(!gameOfGo.isConquered(new GameOfGo.Coordinate(0, 2)));
    }

    @Test
    public void testOuterWhiteIsConquired(){
        gameOfGo = new GameOfGo(new GameOfGo.CheckerType[][]{{BLACK,WHITE,BLACK,EMPTY}, {BLACK,BLACK,WHITE,EMPTY}, {WHITE,WHITE,EMPTY,EMPTY}, {EMPTY,EMPTY,EMPTY,EMPTY}}, WHITE);
        assertTrue(!gameOfGo.isConquered(new GameOfGo.Coordinate(1, 2)));
    }

    @Test
    public void testInnerWhiteIsConquired(){
        gameOfGo = new GameOfGo(new GameOfGo.CheckerType[][]{{BLACK,WHITE,BLACK,EMPTY}, {BLACK,BLACK,WHITE,EMPTY}, {WHITE,WHITE,EMPTY,EMPTY}, {EMPTY,EMPTY,EMPTY,EMPTY}}, WHITE);
        assertTrue(gameOfGo.isConquered(new GameOfGo.Coordinate(0, 1)));
    }

}
