package Data_Structures;

import java.util.List;

public class _004_Remove_Duplicates_From_Sorted_List {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode head = null;

    public void insertInLast(int value){
        ListNode new_node = new ListNode(value);
        if (head == null){
            head = new_node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new_node;
    }

    public void traverse(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+"-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head){
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        _004_Remove_Duplicates_From_Sorted_List list = new _004_Remove_Duplicates_From_Sorted_List();
        list.insertInLast(1);
        list.insertInLast(1);
        list.insertInLast(2);
        list.traverse();
        _004_Remove_Duplicates_From_Sorted_List result = new _004_Remove_Duplicates_From_Sorted_List();
        result.head = result.deleteDuplicates(list.head);
        result.traverse();

    }
}
