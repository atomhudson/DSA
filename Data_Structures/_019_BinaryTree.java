 package Data_Structures;

/**
 * Binary Tree Concepts

 * 1. Degree of a Node:
 *    - The number of children a node has.
 *    - Example:
 *      - Leaf node has degree 0.
 *      - Node with 2 children has degree 2.

 * 2. Degree of a Tree:
 *    - The maximum degree among all nodes in the tree.

 * 3. Level of a Node:
 *    - Distance of the node from the root, starting at 1.
 *    - Root is at level 1.

 * 4. Depth of a Node:
 *    - Distance of the node from the root, starting at 0.
 *    - Root has depth 0.

 * 5. Height of a Node:
 *    - Longest path from the node to a leaf node.

 * 6. Height of a Tree:
 *    - Height of the root node.
 *    - Can also be defined as the maximum level or maximum depth.

 * -------------------------------------------------------
 * Example Binary Tree:

 *              (A) Root
 *             /   \
 *           (B)   (C)
 *           / \      \
 *         (D) (E)    (F)

 * - Degree of (A): 2
 * - Degree of (B): 2
 * - Degree of (C): 1
 * - Degree of Tree: 2
 * - Level of (A): 1
 * - Level of (E): 3
 * - Depth of (E): 2
 * - Height of (A): 3
 * - Height of (B): 2
 * - Height of (D/E/F): 1

 * -------------------------------------------------------
 * Important Binary Tree Properties

 * - Maximum nodes at level `l`: 2^(l-1)
 * - Maximum nodes in a tree of height `h`: ((2^h) - 1)
 * - Minimum height for `n` nodes: ⌈log2(n+1)⌉
 * - Number of leaf nodes in a full binary tree: (n+1)/2

 * --------------------------------------------------------

 * Types of Binary Trees
 * 1. Full Binary Tree – Every node has 0 or 2 children.
 * 2. Complete Binary Tree – All levels are completely filled except
 *                           possibly the last, which is filled left to right.
 * 3. Perfect Binary Tree – A complete tree where all leaf nodes are at the
 *                          same level, total nodes = ((2^h) - 1).
 * 4. Balanced Binary Tree – Height of left and right subtrees differ by at
 *                           most 1 at any node.
 * 5. Degenerate (Skewed) Binary Tree – Each node has only one child;
 *                                      behaves like a linked list.
 * 6. Binary Search Tree (BST) – Left subtree has smaller values,
 *                               right subtree has larger values.
 * 7. AVL Tree / Red-Black Tree – Self-balancing BST variants.
 */

public class _019_BinaryTree {





}
