package Data_Structures;

import java.util.ArrayList;
import java.util.List;

public class _023_BinaryTree {
    public static class Node {
         Node left;
         int value;
         Node right;
         Node(int value) {
             this.value = value;
         }
    }

    static List<List<Integer>> levelOrderTraversalII(Node root){
        int height = heightOfTree(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = height; i > 0 ; i++) {
            boolean leftToRight = (height - i) % 2 == 0;
            ans.add(traversal(root, i, leftToRight));
        }
        return ans;
    }
    private static List<Integer> traversal(Node root,int level,boolean leftToRight){
        if (root == null) return new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        if (level == 1){
            arr.add(Integer.valueOf(root.value));
            return arr;
        }
        if (leftToRight){
            arr.addAll(traversal(root.left,level-1,leftToRight));
            arr.addAll(traversal(root.right,level-1,leftToRight));
        }else{
            arr.addAll(traversal(root.right,level-1,leftToRight));
            arr.addAll(traversal(root.left,level-1,leftToRight));
        }
        return arr;
    }
    static int heightOfTree(Node root){
        if (root==null)return 0;
        return 1+Math.max(heightOfTree(root.left),heightOfTree(root.right));
    }

    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root, new ArrayList<>(),0,targetSum ,allPaths);
        return allPaths;
    }

    private static void dfs(Node root, List<Integer> path,int currentSum ,int targetSum,List<List<Integer>> allPaths) {
        if (root == null) return;
        path.add(Integer.valueOf(root.value));
        currentSum+=root.value;
        if (root.left == null && root.right == null && currentSum == targetSum) {
            allPaths.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path,currentSum, targetSum, allPaths);
            dfs(root.right, path,currentSum, targetSum, allPaths);
        }
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        Node root = new Node(5);

        Node n1 = new Node(4);
        Node n2 = new Node(8);
        root.left = n1;
        root.right = n2;

        Node n3 = new Node(11);
        n1.left = n3;
        // n1.right = null (already null by default)

        Node n4 = new Node(13);
        Node n5 = new Node(4);
        n2.left = n4;
        n2.right = n5;

        Node n6 = new Node(7);
        Node n7 = new Node(2);
        n3.left = n6;
        n3.right = n7;

        System.out.println(levelOrderTraversalII(root));
        pathSum(root,22);

    }
}
