package maze.util;

import com.google.common.base.Preconditions;

public class UnionFind {
    private int[] sets;

    private UnionFind(int[] sets) {
        this.sets = sets;
    }

    public static UnionFind create(int size) {
        int[] sets = new int[size];
        for (int i = 0; i < size; i++) {
            sets[i] = -1;
        }
        return new UnionFind(sets);
    }

    public int find(int num) {
        Preconditions.checkArgument(num >= 0 && num < sets.length,
                String.format("Find value out of bounds. %d not in range [0, %d]", num, sets.length - 1));

        // check if this is the representative number
        int parent = sets[num];
        if (parent >= 0) {
            // compress for future find efficiency
            parent = find(parent);
            sets[num] = parent;
            return parent;
        } else {
            return num;
        }
    }

    public void union(int a, int b) {
        if (!areSame(a, b)) {
            sets[find(a)] = find(b);
        }
    }

    public boolean areSame(int a, int b) {
        return find(a) == find(b);
    }
}
