package Data_Structures;

public class _003_Merge_Two_Sorted_LinkList {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        _003_Merge_Two_Sorted_LinkList list1 = new _003_Merge_Two_Sorted_LinkList();
        list1.insertInLast(1);
        list1.insertInLast(2);
        list1.insertInLast(4);

        _003_Merge_Two_Sorted_LinkList list2 = new _003_Merge_Two_Sorted_LinkList();
        list2.insertInLast(1);
        list2.insertInLast(3);
        list2.insertInLast(4);

        _003_Merge_Two_Sorted_LinkList result = new _003_Merge_Two_Sorted_LinkList();
        result.head = result.mergeTwoLists(list1.head, list2.head);

        result.traverse();
    }
}
