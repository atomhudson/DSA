package Data_Structures;
class MyHashMap {
    private static class Node {
        private final int key;
        private int value;
        private Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node head;
    public MyHashMap() {
        head = null;
    }
    public void put(int key, int value) {
        if (head == null) {
            head = new Node(key, value);
            return;
        }
        Node temp = head;
        while (true) {
            if (temp.key == key) {
                temp.value = value;
                return;
            }
            if (temp.next == null) break;
            temp = temp.next;
        }
        temp.next = new Node(key, value);
    }

    public int get(int key) {
        Node temp = head;
        while (temp != null){
            if (temp.key == key) return temp.value;
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node dummy = new Node(-1,-1);
        dummy.next = head;
        Node prev = dummy, curr = head;
        while(curr != null){
            if (curr.key == key){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        head = dummy.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class _011_Design_HashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 2);
        map.put(2, 3);
        System.out.println(map.get(1)); // 2
        map.put(1, 5);
        System.out.println(map.get(1)); // 5
        map.remove(1);
        System.out.println(map.get(1)); // -1
    }

}
