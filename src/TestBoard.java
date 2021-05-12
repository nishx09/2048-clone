/**
 * @file: TestBoard.java
 * @Author: Nishant Garg
 * @Date: April 11, 2021
 * @Description: Tests for Board.java
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;


public class TestBoard {

    public Tile t1;
    public Tile t2;
    public Tile t3;
    public Tile t4;
    public Tile t5;

    public Board b1;
    public Board b2;
    public Board b3;
    public Board b4;
    public Board b5;

    @Before
    public void setUp() {
        t1 = new Tile();
        t2 = new Tile(4);
        t3 = new Tile(8);
        t4 = new Tile(32);
        t5 = new Tile(2048);
        Tile[][] tt1 = new Tile[][]{{t1, t1, t3, t1}, {t1, t1, t3, t1}, {t1, t1, t1, t1}, {t1, t1, t1, t1}};
        b1 = new Board(tt1);
        Tile[][] tt2 = new Tile[][]{{t4, t4, t1, t1}, {t1, t2, t2, t1}, {t1, t1, t1, t1}, {t3, t3, t1, t1}};
        b2 = new Board(tt2);
        Tile[][] tt3 = new Tile[][]{{t1, t1, t4, t4}, {t1, t1, t2, t2}, {t1, t1, t1, t1}, {t3, t4, t1, t5}};
        b3 = new Board(tt3);
        b4 = new Board(5);
        Tile[][] tt5 = new Tile[][]{{t4, t4, t1, t3}, {t1, t1, t2, t5}, {t2, t3, t4, t1}, {t3, t5, t1, t1}};
        b5 = new Board(tt5);
    }

    @After
    public void tearDown() {
        b1 = null;
        b2 = null;
        b3 = null;
        b4 = null;
        b5 = null;
    }

    @Test
    public void testgetScore1() {
        b1.up();
        Assert.assertEquals(16, b1.getScore());
    }

    @Test
    public void testgetScore2() {
        b2.left();
        Assert.assertEquals(88, b2.getScore());
    }

    @Test
    public void testhighestTile1() {
        Assert.assertEquals(8, b1.highestTile());
    }

    @Test
    public void testhighestTile2() {
        Assert.assertEquals(32, b2.highestTile());
    }

    @Test
    public void testspawn() {
        Board b = new Board();
        b.spawnRandom();
        assertTrue(b.highestTile() == 2 || b.highestTile() == 4);
    }

    @Test
    public void testmove1() {
        b1.move(MoveT.w);
        assertEquals(16, b1.getScore());
    }

    @Test
    public void testmove2() {
        b2.move(MoveT.a);
        assertEquals(88, b2.getScore());
    }

    @Test
    public void testmove3() {
        b2.move(MoveT.s);
        assertEquals(72, b2.getScore());
    }

    @Test
    public void testmove4() {
        b3.move(MoveT.d);
        assertEquals(72, b3.getScore());
    }

    @Test
    public void testgameWon1() {
        assertTrue(b3.gameWon());
    }

    @Test
    public void testgameWon2() {
        assertFalse(b2.gameWon());
    }

    @Test
    public void testgameOver1() {
        assertTrue(b4.gameOver());
    }

    @Test
    public void testgameOver2() {
        assertFalse(b5.gameOver());
    }

    @Test
    public void testup1() {
        b1.up();
        assertEquals(16, b1.getScore());
    }

    @Test
    public void testup2() {
        b5.up();
        assertEquals(0, b5.getScore());
    }

    @Test
    public void testdown1() {
        b2.down();
        assertEquals(72, b2.getScore());
    }

    @Test
    public void testdown2() {
        Tile[][] tt1 = new Tile[][]{{t1, t1, t1, t1}, {t1, t1, t1, t1}, {t2, t1, t4, t1}, {t2, t1, t4, t1}};
        Board b = new Board(tt1);
        b.down();
        assertEquals(72, b.getScore());
    }

    @Test
    public void testleft1() {
        b2.left();
        assertEquals(88, b2.getScore());
    }

    @Test
    public void testleft2() {
        b5.left();
        assertEquals(64, b5.getScore());
    }

    @Test
    public void testright1() {
        Tile[][] tt1 = new Tile[][]{{t4, t1, t3, t3}, {t4, t1, t1, t1}, {t1, t1, t1, t3}, {t1, t1, t1, t2}};
        Board b = new Board(tt1);
        b.right();
        assertEquals(16, b.getScore());
    }

    @Test
    public void testright2() {
        b3.right();
        assertEquals(72, b3.getScore());
    }
}

