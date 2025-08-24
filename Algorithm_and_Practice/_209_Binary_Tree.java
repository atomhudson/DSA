package Algorithm_and_Practice;

import java.util.Scanner;

/**
 * Pre-Required:
 * - Recursion
 * - Object-Oriented Programming (OOP)

 * Trees Overview:
 * - In trees, every node is connected to two nodes (in binary trees).

 * Why Use Trees?
 * - CRUD (Create, Read, Update, Delete) operations can be performed in O(log N) time.
 * - Efficient insertion and deletion operations.
 * - Unlike linked lists, trees provide structured data storage.
 * - Cost-efficient in terms of operations.

 * Limitations of Trees:
 * 1. Unbalanced Binary Trees: Operations can degrade to O(n) in worst cases.
 *    - Algorithm_and_Practice.Solution: Use Self-Balancing Binary Trees (e.g., AVL Tree, Red-Black Tree).
 * 2. Binary Trees may be insufficient for sorted data.

 * Real-World Applications of Trees:
 * - File Systems (e.g., Directory structures)
 * - Databases (e.g., Algorithm_and_Practice.B-Trees, Binary Search Trees)
 * - Pathfinding Algorithms in Networking
 * - Mathematical Computations
 * - Machine Learning (e.g., Decision Trees)
 * - File Compression (e.g., Huffman Encoding)
 * - Future Data Structures (e.g., Graph Theory)

 * Structure of a Tree:
 * - int value
 * - Node left
 * - Node right

 * Properties of Trees:
 * - size = Total number of nodes.
 * - Child and parent relationship.
 * - Two nodes having the same parent are known as siblings.
 * - Edges = Connecting link between two nodes.
 * - height = Maximum number of edges from the root to a leaf.
 * - leaf nodes = Nodes at the bottom without children.
 * - level = height of root - height of a given node.
 * - degree = Number of children a node has.
 * Types of Binary Trees:
 * 1. Complete Binary Tree:
 *    - Algorithm_and_Practice.A new level is created only when the previous level is completely filled.

 * 2. Full Binary Tree (Strict Binary Tree):
 *    - Each parent node has either 0 or 2 children (no single child allowed).
 *    - Use Case: Compression, Segment Trees.

 * 3. Perfect Binary Tree:
 *    - All internal nodes have exactly two children.
 *    - All leaf nodes are at the same level.

 * 4. Height Balanced Binary Tree:
 *    - The average height of the tree is log(N).

 * 5. Skewed Binary Tree:
 *    - Each node has only one child (either left or right).
 *    - Height: O(N).

 * 6. Ordered Binary Tree:
 *    - Every node follows a certain ordering property.
 *    - Example: Binary Search Tree (BST).

 * Key Properties of Binary Trees:
 * 1. Perfect Binary Tree:
 *    - Height (h): h
 *    - Total nodes: (2^(h+1)) - 1

 * 2. Leaf Nodes in a Perfect Binary Tree:
 *    - 2^h

 * 3. Total Number of Internal Nodes:
 *    - (2^(h+1)) - 1 - (2^h) = (2^h) - 1

 * 4. N = Number of Leaf Nodes:
 *    - At least log(N) + 1 levels.
 *    - Min level required for N nodes: log(N+1).

 * 5. Strict Binary Tree:
 *    - If there are N leaf nodes, then there are N-1 internal nodes.
 *    - Number of leaf nodes = Number of internal nodes + 1.

 *  Implementation:
 *  1. Linked Representation.
 *  2. Sequential -> using array.
 *
 */
public class _209_Binary_Tree {
    public _209_Binary_Tree(){}

    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    private Node root;
//    insert Elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of : "+ node.value);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of "+ node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to enter right of : "+ node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root," ");
    }
    private void display(Node node, String indent){
        if (node == null){
            return;
        }
        System.out.println(indent+ node.value);
        display(node.left,indent+"\t");
        display(node.right ,indent+"\t");
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node, int level){
        if (node == null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if (level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        _209_Binary_Tree tree = new _209_Binary_Tree();
        tree.populate(sc);
        tree.display();
        tree.prettyDisplay();
    }
}
