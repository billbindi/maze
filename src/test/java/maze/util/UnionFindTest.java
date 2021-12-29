package maze.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnionFindTest {

    @Test
    public void testAllStartAsOwnSet() {
        int size = 10;
        UnionFind unionFind = UnionFind.create(size);
        for (int i = 0; i < size; i++) {
            assertEquals(unionFind.find(i), i);
        }
    }

    @Test
    public void testUnion() {
        UnionFind unionFind = UnionFind.create(10);
        unionFind.union(0, 1);
        assertEquals(unionFind.find(0), unionFind.find(1));
        assertTrue(unionFind.areSame(0, 1));
    }

    @Test
    public void testSeveralUnion() {
        UnionFind unionFind = UnionFind.create(10);
        unionFind.union(0, 1);
        unionFind.union(3, 4);
        unionFind.union(4, 8);
        unionFind.union(8, 0);
        assertEquals(unionFind.find(0), unionFind.find(3));
        assertEquals(unionFind.find(0), unionFind.find(4));
        assertEquals(unionFind.find(3), unionFind.find(8));
    }
}
