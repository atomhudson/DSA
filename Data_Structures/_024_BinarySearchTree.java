package Data_Structures;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Applies for all node
 * B.T with a property -> Every node the left of given node is smaller than the node.
 *                     -> Every node to the right of a node is greater than the node.
 *
 *        5
 *      /  \
 *     2    8
 *    /\   / \
 *   0  6 4  10
 *
 *   Is this a Binary Search Tree -> No
 *   Reason: 6 is in the left of 5 which is incorrect
 *          if 6 is 3 in left subtree than yes it's correct
 *          and in the right side 4 is present in smaller than root(5).
 *          if 4 is 6 than it is correct
 *
 *        5
 *      /  \
 *     2    8
 *    /\   / \
 *   0  3 6  10
 *   Now it correct
 *   Why to Learn it
 *   -> Insertion is fast
 *   -> Deletion is fast
 *   -> O(logn) searching(Balanced BST)
 *   -> O(n) (Skewed BST)
 *   usage in implementation of other data structures like set maps priority queuee etc
 *
 *   Disadv.
 *   Lack of suppor of range quries
 *   not that efficient in case of unbalanced trees
 *
 *   like there is sorted array
 *   2 13 18 29 36 44 58 65
 *
 *   how many elements are there is this array which are b/w 10 to 40
 *   in O(n) -> starting searching from the start of the array
 *  use binary search
 *  in binary search tree
 *      -> searching is fast [O(logn)]
 *      -> but there is no indexing
 * Traversal
 * -> Inorder traversal of the bst is always in sorted order
 *
 * Deleteion
 *  -> The node has 0 child -> easy
 *  -> The node has 1 child -> easy
 *  -> The node has 2 child -> tricky
 *
 */

public class _024_BinarySearchTree {
    static class Node {
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val = val;
        }
    }
    public static int height(Node root){
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static Node constructTree(String[] arr){
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i < n-1){
            Node temp = q.remove();
            Node left = new Node(10);
            Node right = new Node(100);
            if (arr[i].isEmpty() || arr[i].equals("null")) left = null;
            else{
                left.val= Integer.parseInt(arr[i]);
                q.add(left);
            }
            if (arr[i + 1].isEmpty() || arr[i].equals("null")) right = null;
            else{
                right.val = Integer.parseInt(arr[i+1]);
                q.add(right);
            }
            temp.left = left;
            temp.right = right;
            i+=2;
        }
        return root;
    }
    private static void preOrder(Node root){
        if (root==null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void postOrder(Node root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    private static void inOrder(Node root){
        if (root==null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void deleteLeafNode(Node root, int val){
        if (root==null) return;
        if (root.val > val){ // go left
            if (root.left == null) return;
            if (root.left.val == val) root.left = null;
            else deleteLeafNode(root.left,val);
        }else{
            if (root.right == null) return;
            if (root.right.val == val) root.right = null;
            else deleteLeafNode(root.right,val);
        }
    }
    public static void deleteNodeHavingOneNode(Node root, int val){
        if (root==null) return;
        if (root.val > val){ // go left
            if (root.left == null) return;
            if (root.left.val == val) {
                Node l = root.left;
                if (l.left == null && l.right == null) root.left = null; // 0 children
                else if (l.left == null || l.right==null) {
                    if (l.left!=null) root.left = l.left;
                    else root.left = l.right;
                }
            }
            else deleteNodeHavingOneNode(root.left,val);
        }else{
            if (root.right == null) return;
            if (root.right.val == val){
                Node r = root.right;
                if (r.left == null && r.right == null) root.right = null;
                else if (r.left == null || r.right == null) { // o children
                    if (r.left!=null) root.right = r.left;
                    else root.right = r.right;
                }
            }
            else deleteNodeHavingOneNode(root.right,val);
        }
    }
    public static void deleteNodeHavingTwoNode(Node root, int val){
        if (root==null) return;
        if (root.val > val){ // go left
            if (root.left == null) return;
            if (root.left.val == val) {
                Node l = root.left;
                if (l.left == null && l.right == null) root.left = null; // 0 children
                else if (l.left == null || l.right==null) { // 1 children
                    if (l.left!=null) root.left = l.left;
                    else root.left = l.right;
                }else{ // 2 children
                    Node curr = l;
                    Node pred = curr.left;
                    while (pred.right!=null) pred = pred.right;
                    deleteNodeHavingTwoNode(root, pred.val);
                    curr.left = pred.left;
                    curr.right = pred.right;
                    root.left = pred;
                }
            }
            else deleteNodeHavingTwoNode(root.left,val);
        }else{
            if (root.right == null) return;
            if (root.right.val == val){
                Node r = root.right;
                if (r.left == null && r.right == null) root.right = null;
                else if (r.left == null || r.right == null) { // o children
                    if (r.left!=null) root.right = r.left;
                    else root.right = r.right;
                }else{ // 2 children
                    Node curr = r;
                    Node pred = curr.left;
                    while (pred.right!=null) pred = pred.right;
                    deleteNodeHavingTwoNode(root, pred.val);
                    curr.left = pred.left;
                    curr.right = pred.right;
                    root.left = pred;
                }
            }
            else deleteNodeHavingTwoNode(root.right,val);
        }
    }


    public static void main(String[] args) {
        String[] arr = {"10","5","15","2","8","12","17"};
        String[] arr2 = {"50","20","60","17","34","55","89","10","","28","","","","70","","","14"};
        Node root = constructTree(arr);
        System.out.print("PreOrder: ");preOrder(root);
        System.out.println();
        System.out.print("PostOrder: ");postOrder(root);
        System.out.println();
        System.out.print("InOrder: ");inOrder(root);
        System.out.println();
        Node root2 = constructTree(arr2);
        System.out.print("PreOrder: ");preOrder(root2);
//        deleteLeafNode(root2,14);
//        System.out.println();
//        System.out.print("PreOrder: ");preOrder(root2);
        deleteNodeHavingOneNode(root2,34);
        System.out.println();
        System.out.print("PreOrder: ");preOrder(root2);

    }
}
