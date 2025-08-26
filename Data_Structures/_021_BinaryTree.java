 package Data_Structures;

 /**
  * <h2>Binary Tree Concepts</h2>
  *
  * <h3>1. Degree of a Node</h3>
  * <ul>
  *   <li>Number of children a node has.</li>
  *   <li>Leaf node → degree <b>0</b></li>
  *   <li>Node with 2 children → degree <b>2</b></li>
  * </ul>
  *
  * <h3>2. Degree of a Tree</h3>
  * <p>The maximum degree among all nodes in the tree.</p>
  *
  * <h3>3. Level of a Node</h3>
  * <p>Distance of the node from the root (root = level <b>1</b>).</p>
  *
  * <h3>4. Depth of a Node</h3>
  * <p>Distance of the node from the root (root = depth <b>0</b>).</p>
  *
  * <h3>5. Height of a Node</h3>
  * <p>Longest path from the node to a leaf.</p>
  *
  * <h3>6. Height of a Tree</h3>
  * <p>Height of the root node. Also defined as maximum level or maximum depth.</p>
  *
  * <hr/>
  * <h3>Example Binary Tree:</h3>
  *
  * <pre>
  *              (A) Root
  *             /     \
  *           (B)     (C)
  *           / \        \
  *         (D) (E)      (F)
  * </pre>
  *
  * <ul>
  *   <li>Degree of (A): <b>2</b></li>
  *   <li>Degree of (B): <b>2</b></li>
  *   <li>Degree of (C): <b>1</b></li>
  *   <li>Degree of Tree: <b>2</b></li>
  *   <li>Level of (A): <b>1</b></li>
  *   <li>Level of (E): <b>3</b></li>
  *   <li>Depth of (E): <b>2</b></li>
  *   <li>Height of (A): <b>3</b></li>
  *   <li>Height of (B): <b>2</b></li>
  *   <li>Height of (D/E/F): <b>1</b></li>
  * </ul>
  *
  * <hr/>
  * <h3>Important Binary Tree Properties</h3>
  * <ul>
  *   <li>Maximum nodes at level <i>l</i>: 2<sup>l-1</sup></li>
  *   <li>Maximum nodes in a tree of height <i>h</i>: (2<sup>h</sup>) - 1</li>
  *   <li>Minimum height for <i>n</i> nodes: ⌈log<sub>2</sub>(n+1)⌉</li>
  *   <li>Leaf nodes in a full binary tree: (n+1)/2</li>
  * </ul>
  *
  * <hr/>
  * <h3>Types of Binary Trees</h3>
  * <ul>
  *   <li><b>Generic Tree</b> → Node can have any number of children</li>
  *   <li><b>Binary Tree</b> → Node can have at most 2 children</li>
  *   <li><b>Binary Search Tree (BST)</b> → Left &lt; Root &lt; Right</li>
  *   <li><b>AVL / Red-Black Tree</b> → Self-balancing BST variants</li>
  * </ul>
  *
  * <h4>Special Types:</h4>
  * <ol>
  *   <li>Full Binary Tree → Every node has 0 or 2 children</li>
  *   <li>Complete Binary Tree → All levels filled except possibly last (left → right)</li>
  *   <li>Perfect Binary Tree → All leaves at same level, total nodes = (2<sup>h</sup>) - 1</li>
  *   <li>Balanced Binary Tree → Height difference ≤ 1 at any node</li>
  *   <li>Degenerate (Skewed) Tree → Each node has one child (like a linked list)</li>
  * </ol>
  *
  * <hr/>
  *  * <h2>Binary Tree Concepts & Implementation</h2>
  *  *
  *  * <p>This class demonstrates the basic structure of a Binary Tree
  *  * and provides utility methods to compute:</p>
  *  * <ul>
  *  *   <li><b>Size</b> → Number of nodes in the tree</li>
  *  *   <li><b>Sum</b> → Sum of all node values</li>
  *  *   <li><b>Maximum</b> → Largest value in the tree</li>
  *  *   <li><b>Height</b> → Longest path from root to a leaf (in terms of edges)</li>
  *  *   <li><b>Display</b> → Prints the tree in root → left → right fashion</li>
  *  * </ul>
  *  *
  *  * <hr/>
  *  * <h3>Binary Tree Used in <code>main</code>:</h3>
  *  *
  *  * <pre>
  *  *               (1)
  *  *              /   \
  *  *            (4)   (7)
  *  *            / \   /
  *  *          (2) (5) (8)
  *  * </pre>
  *  *
  *  * <ul>
  *  *   <li>Size = 6</li>
  *  *   <li>Sum = 27</li>
  *  *   <li>Max = 8</li>
  *  *   <li>Height = 2</li>
  *  * </ul>
  *  *
  *  * <hr/>
  *  * <h3>Notes:</h3>
  *  * <ul>
  *  *   <li>Height is defined as number of edges in the longest path.</li>
  *  *   <li>If a tree has only root → height = 0.</li>
  *  *   <li>If a tree is empty → size = 0, sum = 0, max = -∞.</li>
  *  * </ul>
  */


 public class _021_BinaryTree {
     /** Node structure of the binary tree */
     public static class Node {
         Node left;
         int value;
         Node right;

         Node(int value) {
             this.value = value;
         }
     }

     /**
      * Prints each node in format:
      * <pre> value -> leftChild, rightChild </pre>
      */
     public static void display(Node root) {
         if (root == null) return;
         System.out.print(root.value + " -> ");
         System.out.print(root.left == null ? "null, " : root.left.value + ", ");
         System.out.print(root.right == null ? "null" : root.right.value);
         System.out.println();
         display(root.left);
         display(root.right);
     }

     /** @return total number of nodes in the tree */
     public static int size(Node root) {
         if (root == null) return 0;
         return size(root.left) + size(root.right) + 1;
     }

     /** @return sum of all node values */
     public static int sum(Node root) {
         if (root == null) return 0;
         return root.value + sum(root.left) + sum(root.right);
     }

     /** @return maximum value in the tree */
     public static int max(Node root) {
         if (root == null) return Integer.MIN_VALUE;
         return Math.max(root.value, Math.max(max(root.left), max(root.right)));
     }

     /**
      * @return height of the tree
      * <p>Height is counted as number of edges in longest root-to-leaf path.</p>
      */
     public static int height(Node root) {
         if (root == null) return 0;
         if (root.left == null && root.right == null) return 0;
         return 1 + Math.max(height(root.left), height(root.right));
     }

     public static void main(String[] args) {
         Node root = new Node(1);
         Node a = new Node(4);
         Node b = new Node(7);
         Node c = new Node(2);
         Node d = new Node(5);
         Node e = new Node(8);

         root.left = a;
         root.right = b;
         a.left = c;
         a.right = d;
         b.left = e;

         System.out.println("Size: " + size(root));
         System.out.println("Sum: " + sum(root));
         System.out.println("Max: " + max(root));
         System.out.println("Height: " + height(root));
     }
}
