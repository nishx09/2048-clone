/**
 * @file: TestTile.java
 * @Author: Nishant Garg
 * @Date: April 11, 2021
 * @Description: Tests for Tile.java
 */

package src;

import org.junit.*;

public class TestTile {

    public Tile t1;
    public Tile t2;

    @Before
    public void setUp() {
        t1 = new Tile();
        t2 = new Tile(4);
    }

    @After
    public void tearDown() {
        t1 = null;
        t2 = null;
    }

    @Test
    public void testgetValue1() {
        Assert.assertEquals(0, t1.getValue());
    }

    @Test
    public void testgetValue2() {
        Assert.assertEquals(4, t2.getValue());
    }

    @Test
    public void testsetValue1() {
        t1.setValue(2048);
        Assert.assertEquals(2048, t1.getValue());
    }

    @Test
    public void testsetValue2() {
        t2.setValue(0);
        Assert.assertEquals(0, t2.getValue());
    }

    @Test
    public void testtoString1() {
        Assert.assertEquals("0", t1.toString());
    }

    @Test
    public void testtoString2() {
        Assert.assertEquals("4", t2.toString());
    }
}

