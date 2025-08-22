package Data_Structures;

public class _012_Swaps_Nodes_In_Pair {

    static class Node{
        private int value;
        private Node next;
        Node(){}
        Node (int value){
            this.value = value;
        }
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private static class Solution{
        public Node swapPairs(Node head) {
            if (head == null) return null;

            Node dummy = new Node(0);

            dummy.next = head;

            Node prev = dummy;

            while(prev.next != null && prev.next.next != null){
                Node a = prev.next;
                Node b = a.next;

//                real swap;
                a.next = b.next;
                b.next = a;

//                updating pointers;
                prev.next = b;
                prev = a;
            }
            return dummy.next;
        }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4)
                        )
                )
        );
        System.out.print("Original list: ");
        printList(head);

        Solution sol = new Solution();
        Node swapped = sol.swapPairs(head);

        System.out.print("After swapPairs: ");
        printList(swapped);

    }

}
