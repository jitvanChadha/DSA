public class DisjointSet {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize the arrays
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Every element is initially its own root
            rank[i] = 0;
        }
    }

    // FIND: This method explicitly finds and returns the ROOT of element 'i'
    public int find(int i) {
        if (parent[i] == i) {
            return i; // Found the root!
        }
        // Path compression: update parent pointer directly to the root
        return parent[i] = find(parent[i]);
    }

    // UNION: Connects the sets of i and j by finding their roots
    public void union(int i, int j) {
        int rootI = find(i); // Gets the root of i
        int rootJ = find(j); // Gets the root of j

        // If they have the same root, they are already in the same set
        if (rootI != rootJ) {
            // Union by Rank optimization
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }

    // Main method to test and see the roots being returned
    public static void main(String[] args) {
        int n = 6;
        DisjointSet uf = new DisjointSet(n);

        // Create a chain: 0 -> 2 -> 4
        uf.union(0, 2);
        uf.union(2, 4);

        // Create another chain: 1 -> 3
        uf.union(1, 3);

        System.out.println("--- Current Roots ---");
        System.out.println("Root of 0 is: " + uf.find(0));
        System.out.println("Root of 2 is: " + uf.find(2));
        System.out.println("Root of 1 is: " + uf.find(1));

        // Merge both sets together
        System.out.println("\n--- Merging the two sets ---");
        uf.union(0, 1);

        System.out.println("New Root of 3 is: " + uf.find(3));
        System.out.println("New Root of 0 is: " + uf.find(0));
    }
}

/*******************************************************************************
 * CRITICAL INTERVIEW QUESTIONS & CONCEPTS
 *******************************************************************************
 *
 * 1. TIME COMPLEXITY
 * - What is it? Near-constant time: O(alpha(N)) for both Union and Find.
 * - What is alpha? It is the Inverse Ackermann function. In practical
 * applications, it never exceeds 4, making it essentially O(1).
 * - Space Complexity: O(N) to store the parent and rank arrays.
 *
 * 2. WHAT HAPPENS IF WE REMOVE OPTIMIZATIONS?
 * - Path Compression ONLY: Average time drops to O(log N), but worst-case
 * can still degrade to O(N) under bad sequences.
 * - Union by Rank ONLY: Strictly bounds the tree height, yielding O(log N).
 * - Both combined: Achieves the highly efficient O(alpha(N)).
 *
 * 3. RANK VS SIZE VARIATION
 * - Union by Rank tracks the deepness/height of the tree.
 * - Union by Size tracks total nodes per tree. Both provide identical
 * theoretical time complexity. Size is preferred when you need to answer
 * "How large is this connected network?" instantly.
 *
 * 4. FREQUENT CODING QUESTIONS ON UNION-FIND
 * - Cycle Detection: If find(u) == find(v) BEFORE calling union(u, v),
 * it means adding this edge introduces a cycle (e.g., LeetCode 684).
 * - Number of Component Groups: Track a 'count' variable starting at N.
 * Whenever a successful union happens (rootI != rootJ), do count--.
 * - Grid to 1D Mapping: Used for matrix problems (like LeetCode 200).
 * Map (row, col) into a 1D index using: index = row * total_cols + col.
 *
 * 5. KEY INTERVIEW TALKING POINT
 * - Always suggest Union-Find over BFS/DFS if the graph is *dynamic* * (meaning edges are actively being added over time). BFS/DFS would require
 * re-running the entire graph from scratch, whereas Union-Find processes
 * the incoming stream in O(1) time per edge.
 *******************************************************************************/