package maze.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void testOrigin() {
        Coordinate origin = new Coordinate(0, 0);
        assertEquals(0, origin.getX());
        assertEquals(0, origin.getY());
    }

    @Test
    public void testSimpleCoordinate() {
        Coordinate origin = new Coordinate(10, 5);
        assertEquals(10, origin.getX());
        assertEquals(5, origin.getY());
    }

    @Test
    public void testInBounds() {
        Coordinate first = new Coordinate(0, 0);
        assertTrue(first.isInBounds(10, 10));
        assertTrue(first.isInBounds(1, 1));
        assertTrue(first.isInBounds(10, 1));
        assertTrue(first.isInBounds(1, 10));

        Coordinate second = new Coordinate(7, 7);
        assertTrue(second.isInBounds(10, 10));
        assertFalse(second.isInBounds(1, 1));
        assertFalse(second.isInBounds(10, 1));
        assertFalse(second.isInBounds(1, 10));
    }

    @Test
    public void testNegativeAlwaysOutOfBounds() {
        Coordinate negativeX = new Coordinate(-1, 0);
        assertFalse(negativeX.isInBounds(10, 10));
        assertFalse(negativeX.isInBounds(1, 1));
        assertFalse(negativeX.isInBounds(10, 1));
        assertFalse(negativeX.isInBounds(1, 10));

        Coordinate negativeY = new Coordinate(0, -1);
        assertFalse(negativeY.isInBounds(10, 10));
        assertFalse(negativeY.isInBounds(1, 1));
        assertFalse(negativeY.isInBounds(10, 1));
        assertFalse(negativeY.isInBounds(1, 10));
    }

    @Test
    public void testLeft() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate expectedOriginShift = new Coordinate(-1, 0);
        Coordinate actualOriginShift = origin.coordinateLeft();
        assertEquals(expectedOriginShift, actualOriginShift);

        Coordinate simple = new Coordinate(5, 3);
        Coordinate expectedSimpleShift = new Coordinate(4, 3);
        Coordinate actualSimpleShift = simple.coordinateLeft();
        assertEquals(expectedSimpleShift, actualSimpleShift);
    }

    @Test
    public void testRight() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate expectedOriginShift = new Coordinate(1, 0);
        Coordinate actualOriginShift = origin.coordinateRight();
        assertEquals(expectedOriginShift, actualOriginShift);

        Coordinate simple = new Coordinate(5, 3);
        Coordinate expectedSimpleShift = new Coordinate(6, 3);
        Coordinate actualSimpleShift = simple.coordinateRight();
        assertEquals(expectedSimpleShift, actualSimpleShift);
    }

    @Test
    public void testUp() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate expectedOriginShift = new Coordinate(0, -1);
        Coordinate actualOriginShift = origin.coordinateUp();
        assertEquals(expectedOriginShift, actualOriginShift);

        Coordinate simple = new Coordinate(5, 3);
        Coordinate expectedSimpleShift = new Coordinate(5, 2);
        Coordinate actualSimpleShift = simple.coordinateUp();
        assertEquals(expectedSimpleShift, actualSimpleShift);
    }

    @Test
    public void testDown() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate expectedOriginShift = new Coordinate(0, 1);
        Coordinate actualOriginShift = origin.coordinateDown();
        assertEquals(expectedOriginShift, actualOriginShift);

        Coordinate simple = new Coordinate(5, 3);
        Coordinate expectedSimpleShift = new Coordinate(5, 4);
        Coordinate actualSimpleShift = simple.coordinateDown();
        assertEquals(expectedSimpleShift, actualSimpleShift);
    }

    @Test
    public void testCopyIsNewCoordinate() {
        Coordinate original = new Coordinate(3, 7);
        Coordinate copy = original.copy();
        assertEquals(original, copy);

        copy.setX(7);
        copy.setY(3);
        assertNotEquals(original, copy);
    }
}
