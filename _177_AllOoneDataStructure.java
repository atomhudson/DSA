import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class _177_AllOoneDataStructure {

    // Inner AllOne class (nested class)
    class AllOne1 {
        private final HashMap<String, Integer> hashMap;
        public AllOne1() {
            hashMap = new HashMap<>();
        }
        public void inc(String key) {
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        public void dec(String key) {
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.getOrDefault(key, 0) - 1);
                if (hashMap.get(key) == 0) {
                    hashMap.remove(key);
                }
            }
        }
        public String getMaxKey() {
            if (hashMap.isEmpty()) {
                return null;
            }
            String maxKey = null;
            int maxValue = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            return maxKey;
        }
        public String getMinKey() {
            if (hashMap.isEmpty()) {
                return null;
            }
            String minKey = null;
            int minValue = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() < minValue) {
                    minValue = entry.getValue();
                    minKey = entry.getKey();
                }
            }
            return minKey;
        }
    }
    public static void main(String[] args) {
        _177_AllOoneDataStructure outer = new _177_AllOoneDataStructure();
        _177_AllOoneDataStructure.AllOne1 inner = outer.new AllOne1();
        inner.inc("hello");
        inner.inc("hello");
        System.out.println("Max Key (Nested): " + inner.getMaxKey());
        System.out.println("Min Key (Nested): " + inner.getMinKey());
        inner.inc("leet");
        System.out.println("Max Key (Nested): " + inner.getMaxKey());
        System.out.println("Min Key (Nested): " + inner.getMinKey());
        System.out.println("Inner HashMap (Nested): " + inner.hashMap);

        AllOne nonNestedAllOne = new AllOne();
        nonNestedAllOne.inc("hello");
        nonNestedAllOne.inc("hello");
        System.out.println("Max Key (Non-Nested): " + nonNestedAllOne.getMaxKey());
        System.out.println("Min Key (Non-Nested): " + nonNestedAllOne.getMinKey());
        nonNestedAllOne.inc("leet");
        System.out.println("Max Key (Non-Nested): " + nonNestedAllOne.getMaxKey());
        System.out.println("Min Key (Non-Nested): " + nonNestedAllOne.getMinKey());
    }
}
// Non-Nested AllOne Class
class AllOne {
    private class Node {
        private int count;
        LinkedHashSet<String> keys;
        private Node prev, next;

        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }
    private Map<String, Node> keyCountMap;
    private Node head, tail;
    public AllOne() {
        keyCountMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        } else {
            Node curNode = keyCountMap.get(key);
            int curCount = curNode.count;
            if (curNode.next == tail || curNode.next.count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }
            curNode.next.keys.add(key);
            keyCountMap.put(key, curNode.next);
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }
    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        Node curNode = keyCountMap.get(key);
        int curCount = curNode.count;
        curNode.keys.remove(key);
        if (curCount == 1) {
            keyCountMap.remove(key);
        } else {
            if (curNode.prev == head || curNode.prev.count != curCount - 1) {
                addNodeAfter(curNode.prev, curCount - 1);
            }
            curNode.prev.keys.add(key);
            keyCountMap.put(key, curNode.prev);
        }
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}
