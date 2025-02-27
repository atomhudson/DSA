/**
 * Insertion , Deletion , Searching --> all are in O(logN)
 * The height of a node is the number of edges from that node to the deepest leaf node in its subtree.
 * The balance factor of a node is calculated as:
 * Balance Factor = Height of Left Subtree − Height of Right Subtree.
 *
 *
 */
public class _210_Binary_Search_Tree {
    public class Node{
        private int value;
        private Node right;
        private Node left;
        private int height;
        public Node(int value){this.value=value;}
        public int getValue() {
            return value;
        }
    }
    private Node root;
    public _210_Binary_Search_Tree() {}
    public int height(Node node){
        if (node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int value){
        root = insert(value,root);
    }
    private Node insert(int value,Node node){
        if (node == null){
            node = new Node(value);
            return node;
        }

        if (value < node.value){
            node.left = insert(value,node.left);
        }

        if (value > node.value){
            node.right = insert(value,node.right);
        }
        node.height =   Math.max(height(node.left),height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums){
        for (int num : nums) {
            this.insert(num);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[] nums,int start,int end){
        if (start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);
    }
    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root,"Root Node: ");
    }
    private void display(Node node,String details){
        if (node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of "+node.value+" : ");
        display(node.right, "Right child of "+node.value+" : ");
    }

    public static void main(String[] args) {
        _210_Binary_Search_Tree bst = new _210_Binary_Search_Tree();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        bst.populate(nums);
        bst.display();
        int[] num1 = {1,2,3,4,5,6,7,8,9,10};
        bst.populateSorted(num1);
        bst.display();
    }
}
