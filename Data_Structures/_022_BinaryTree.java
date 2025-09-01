package Data_Structures;

import java.util.*;

public class _022_BinaryTree {
    public static class Node {
         Node left;
         int value;
         Node right;
         Node(int value) {
             this.value = value;
         }
    }

    public static int height(Node root){
        if (root == null) return 0;
        if (root.left == null || root.right == null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    /**
     * Prints all nodes present at the given level in a binary tree.
     *
     * <p>The method uses recursion to traverse down the tree until it reaches
     * the specified level. When the level becomes 1, it prints the node's value.</p>
     *
     * <h3>Time Complexity Analysis:</h3>
     * <ul>
     *   <li>If the tree is balanced and the given level is {@code k},
     *       the method visits nodes only up to that level.</li>
     *   <li>At level {@code k}, the maximum number of nodes is <code>2<sup>(k-1)</sup></code>.</li>
     *   <li>Hence, the worst-case time complexity for printing the {@code k}-th level is:
     *       <b>O(2<sup>k</sup>)</b>.</li>
     *   <li>If {@code k} equals the height {@code h} of the tree, the complexity becomes
     *       <b>O(2<sup>h</sup>)</b>.</li>
     *   <li>For skewed trees (like a linked list), the complexity reduces to <b>O(k)</b>
     *       since at most one node exists at each level.</li>
     * </ul>
     *
     * <h3>Example:</h3>
     * <pre>
     *      Tree:
     *           1
     *          / \
     *         2   3
     *        / \   \
     *       4   5   6
     *
     *   nthLevelData(root, 3) → Output: 4 5 6
     *   (because nodes at 3rd level are 4, 5, and 6)
     * </pre>
     *
     * @param root  the root node of the binary tree
     * @param level the level to print (1 = root level)
     */
    public static void nthLevelData(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.value + " ");
            return;
        }
        nthLevelData(root.left, level - 1);
        nthLevelData(root.right, level - 1);
    }

    /**
     * <h2>Performs a Level Order Traversal (Breadth-First Search, BFS) on a binary tree.</h2>
     *
     * <p>This method uses a <b>queue</b> data structure, which follows the
     * FIFO (First-In-First-Out) principle. At each step:
     * <ol>
     *   <li>Remove (dequeue) the front node from the queue.</li>
     *   <li>Print its value.</li>
     *   <li>Add (enqueue) its children (left, then right) to the queue.</li>
     * </ol>
     *
     * <h3>Example Tree:</h3>
     * <pre>
     *             1
     *            / \
     *           2   3
     *          / \ / \
     *         4  5 6  7
     * </pre>
     *
     * <h3>Queue Simulation:</h3>
     * <pre>
     * Step 1:  Add -> [1]            | Remove -> 1
     * Step 2:  Add -> [2, 3]         | Remove -> 2
     * Step 3:  Add -> [3, 4, 5]      | Remove -> 3
     * Step 4:  Add -> [4, 5, 6, 7]   | Remove -> 4
     * Step 5:  Add -> [5, 6, 7]      | Remove -> 5
     * Step 6:  Add -> [6, 7]         | Remove -> 6
     * Step 7:  Add -> [7]            | Remove -> 7
     * Step 8:  Add -> [] (empty)     | Done
     * </pre>
     *
     * <h3>Output:</h3>
     * <pre>
     * 1 2 3 4 5 6 7
     * </pre>
     *
     * <h3>Time Complexity:</h3>
     * <ul>
     *   <li>Each node is enqueued and dequeued exactly once.</li>
     *   <li>Total time complexity: <b>O(n)</b>, where {@code n} is the number of nodes.</li>
     * </ul>
     *
     * <h3>Space Complexity:</h3>
     * <ul>
     *   <li>In the worst case (a complete binary tree), the queue can hold up to O(n/2) nodes at the last level.</li>
     *   <li>Thus, space complexity: <b>O(n)</b>.</li>
     * </ul>
     */
    public static void levelOrderTraversal(Node root){ // Iterative Way
        Queue<Node> queue = new LinkedList<>();
        if (root != null ) queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.peek();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            System.out.print(temp.value+" ");
            queue.remove();
        }
    }

    /**
     * Computes the <b>Diameter of a Binary Tree</b>.
     *
     * <p>The diameter of a binary tree is the <b>longest path</b> between any two nodes
     * in the tree. The path may or may not pass through the root. The diameter is
     * defined as the number of edges (or nodes, depending on convention) in the
     * longest path.</p>
     *
     * <h3>Example Tree 1 (Simple):</h3>
     * <pre>
     *          1
     *        /   \
     *       2     3
     *      / \     \
     *     4   5     6
     *        / \
     *       7   8
     * </pre>
     *
     * <h4>Longest Paths:</h4>
     * <ul>
     *   <li>4 → 2 → 1 → 3 → 6  → Length = 4 edges</li>
     *   <li>7 → 5 → 2 → 1 → 3 → 6  → Length = 5 edges</li>
     *   <li>8 → 5 → 2 → 1 → 3 → 6  → Length = 5 edges</li>
     * </ul>
     * <p>Hence, the diameter of this tree = <b>5</b>.</p>
     *
     * <h3>Example Tree 2 (Complex):</h3>
     * <pre>
     *                 1
     *               /   \
     *              2     3
     *             / \     \
     *            4   5     6
     *           /   / \      \
     *          9   7   8      10
     *             /            \
     *            11             12
     *                           /
     *                          13
     * </pre>
     *
     * <h4>Longest Path Analysis:</h4>
     * <ul>
     *   <li>Path A: 9 → 4 → 2 → 5 → 7 → 11 → Length = 5 edges</li>
     *   <li>Path B: 11 → 7 → 5 → 2 → 1 → 3 → 6 → 10 → 12 → 13 → Length = 9 edges</li>
     *   <li>Path C: 8 → 5 → 2 → 1 → 3 → 6 → 10 → 12 → 13 → Length = 8 edges</li>
     * </ul>
     * <p>Hence, the diameter of this tree = <b>9</b>.</p>
     *
     * <h3>Common Mistake:</h3>
     * <p>A naive thought might be:</p>
     * <pre>
     * Diameter = height(root.left) + height(root.right) + 2
     * </pre>
     *
     * <p>This only computes the longest path <b>through the root node</b>.
     * However, the true diameter might lie <b>entirely within the left subtree</b>
     * or <b>entirely within the right subtree</b>, and in those cases, this formula
     * will miss it.</p>
     *
     * <h4>Correct Formula:</h4>
     * <pre>
     * Diameter = max(
     *     diameter(root.left),
     *     diameter(root.right),
     *     height(root.left) + height(root.right)
     * )
     * </pre>
     *
     * <h3>Approach:</h3>
     * <ol>
     *   <li>For each node, compute the height of its left and right subtrees.</li>
     *   <li>At every node, update the diameter as:
     *       <ul>
     *         <li>max of the left subtree diameter</li>
     *         <li>max of the right subtree diameter</li>
     *         <li>path through the current node (left height + right height)</li>
     *       </ul>
     *   </li>
     *   <li>Return the maximum diameter found.</li>
     * </ol>
     *
     * <h3>Time Complexity:</h3>
     * <ul>
     *   <li>Naive approach (recomputing heights for each node): <b>O(n²)</b></li>
     *   <li>Optimized approach (using post-order DFS and storing heights): <b>O(n)</b></li>
     * </ul>
     *
     * <h3>Space Complexity:</h3>
     * <ul>
     *   <li>Auxiliary space for recursion (stack depth) = <b>O(h)</b>, where h is the height of the tree.</li>
     *   <li>In the worst case (skewed tree), h = n → <b>O(n)</b>.</li>
     * </ul>
     *
     * <h3>Edge Cases:</h3>
     * <ul>
     *   <li>Empty tree → diameter = 0</li>
     *   <li>Single node → diameter = 0 (no edges)</li>
     *   <li>Skewed tree (like a linked list) → diameter = n - 1</li>
     *   <li>Balanced tree → diameter often passes through the root</li>
     *   <li>Unbalanced tree → diameter may lie entirely in one subtree</li>
     * </ul>
     */

    public static int diameterOfBinaryTree(Node root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        int leftAns = diameterOfBinaryTree(root.left);
        int rightAns = diameterOfBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(mid,Math.max(leftAns,rightAns));
    }

    public static void nodeToRootPath(Node root, List<Integer> path){
        if (root == null) return;
        path.add(Integer.valueOf(root.value));

        // Print current node -> root path (reverse order of path list)
        System.out.print("Node " + root.value + " -> Root Path: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + (i == 0 ? "" : " -> "));
        }
        System.out.println();

        // Recurse for children
        nodeToRootPath(root.left, path);
        nodeToRootPath(root.right, path);
        // Backtrack
        path.remove(path.size() - 1);
    }

    public static String nodeToRootPath(Node root, Node target){
        if (root == null) return "";
        String ans = "";
        if (root == target){
            ans+=root.value+"->";
            return ans;
        }
        String leftPath = nodeToRootPath(root.left, target);
        if (!leftPath.isEmpty()) {
            return leftPath + root.value + "->";
        }
        String rightPath = nodeToRootPath(root.right, target);
        if (!rightPath.isEmpty()) {
            return rightPath + root.value + "->";
        }
        return ans;
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q){
        if (p == root || q == root) return root;
        if (p == q) return p;
        boolean leftP = contains(root.left,p);
        boolean rightQ = contains(root.right,q);
        if (leftP && rightQ || !leftP && !rightQ ) return root;
        if (leftP && !rightQ) return lowestCommonAncestor(root.left,p,q);
        if (!leftP && rightQ) return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    private static boolean contains(Node root, Node target){
        if (root == null) return false;
        if (root == target) return true;
        return contains(root.left,target) || contains(root.right,target);
    }

    public static Node lowestCommon_Ancestor(Node root,Node p,Node q){
        if (root == null || root == p || root == q){
            return root;
        }
        Node left = lowestCommon_Ancestor(root.left,p,q);
        Node right = lowestCommon_Ancestor(root.right,p,q);
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }

    public static List<List<Integer>> zigzagPrinting(Node root) {
        int height = heightOfTree(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= height; i++) {
            List<Integer> arr = nthLevelDataList(root, i, i % 2 == 1); // odd level = left->right
            if (!arr.isEmpty()) ans.add(arr);
        }
        return ans;
    }

    private static List<Integer> nthLevelDataList(Node root, int level, boolean leftToRight) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (level == 1) {
            ans.add(Integer.valueOf(root.value));
            return ans;
        }
        if (leftToRight) {
            ans.addAll(nthLevelDataList(root.left, level - 1, leftToRight));
            ans.addAll(nthLevelDataList(root.right, level - 1, leftToRight));
        } else {
            ans.addAll(nthLevelDataList(root.right, level - 1, leftToRight));
            ans.addAll(nthLevelDataList(root.left, level - 1, leftToRight));
        }
        return ans;
    }

    private static int heightOfTree(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);

        root.left = a;
        root.right = b;

        a.left=c;
        a.right=d;

        b.left=e;
        b.right=f;

        levelOrderTraversal(root);
        System.out.println();
        System.out.println(diameterOfBinaryTree(root));

        nodeToRootPath(root,new ArrayList<>());
        System.out.println();
        System.out.println(nodeToRootPath(root,f));
        System.out.println(nodeToRootPath(root,f).contains("3"));
        System.out.println(lowestCommonAncestor(root,e,d).value);
        System.out.println(lowestCommon_Ancestor(root,e,d).value);
        System.out.println(zigzagPrinting(root));
        System.out.printf("Hello World");

    }
}
