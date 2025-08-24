package Data_Structures;

import java.util.*;
import java.util.Stack;
import java.util.PriorityQueue;

/**
 * Collection Framework in Java
 *
 * The Collection Framework provides a set of classes and interfaces
 * for storing and manipulating groups of data as a single unit.
 *
 * Key Interfaces and Classes:
 *
 *                                Collection Framework
 *                                       |
 *        ---------------------------------------------------------------------------------------------
 *        |                   |                        |                           |                  |
 *      List                  Set                     Queue                        Map              Iterator
 *       |                    |                         |                           |                 |
 *       | -> ArrayList       | -> EnumSet              | -> ArrayDeque             | -> HashMap      | -> ListIterator
 *       | -> LinkedList      | -> HashSet              | -> LinkedList             | -> TreeMap
 *       | -> Stack           | -> LinkedHashSet        | -> PriorityQueue          | -> EnumMap
 *       | -> Vector          | -> TreeSet                                          | -> LinkedHashMap
 *                                                                                  | -> WeakHashMap
 *
 * Commonly Used Methods in the Java Collection Framework
 *
 * 1. List
 *    - ArrayList, LinkedList, Stack, Vector
 *    --------------------------------------------------
 *    add(E e)            -> Adds an element.
 *    add(int index, E e) -> Inserts at a specific index.
 *    get(int index)      -> Retrieves element at index.
 *    set(int index, E e) -> Updates element at index.
 *    remove(int index)   -> Removes element at index.
 *    remove(Object o)    -> Removes first occurrence.
 *    size()              -> Returns number of elements.
 *    contains(Object o)  -> Checks if element exists.
 *    indexOf(Object o)   -> Returns index of element.
 *    clear()             -> Removes all elements.
 *    isEmpty()           -> Checks if list is empty.
 *    iterator()          -> Returns an Iterator.
 *
 *
 * 2. Set
 *    - HashSet, LinkedHashSet, TreeSet, EnumSet
 *    --------------------------------------------------
 *    add(E e)            -> Adds an element (ignores duplicates).
 *    remove(Object o)    -> Removes the specified element.
 *    contains(Object o)  -> Checks if element exists.
 *    size()              -> Returns number of elements.
 *    clear()             -> Removes all elements.
 *    isEmpty()           -> Checks if set is empty.
 *    iterator()          -> Returns an Iterator.
 *    first() / last()    -> (TreeSet) Retrieves sorted ends.
 *
 *
 * 3. Queue / Deque
 *    - LinkedList, ArrayDeque, PriorityQueue
 *    --------------------------------------------------
 *    offer(E e)          -> Inserts an element.
 *    add(E e)            -> Inserts (throws exception if full).
 *    poll()              -> Retrieves and removes head; returns null if empty.
 *    remove()            -> Retrieves and removes head; throws exception if empty.
 *    peek()              -> Retrieves head without removing; returns null if empty.
 *    element()           -> Retrieves head without removing; throws exception if empty.
 *    push(E e)           -> (Deque) Inserts at front.
 *    pop()               -> (Deque) Removes from front.
 *
 *
 * 4. Map
 *    - HashMap, LinkedHashMap, TreeMap, EnumMap, WeakHashMap
 *    --------------------------------------------------
 *    put(K key, V value)         -> Inserts or updates entry.
 *    putIfAbsent(K key, V value) -> Inserts only if key is absent.
 *    get(Object key)             -> Returns value for key.
 *    remove(Object key)          -> Removes entry by key.
 *    containsKey(Object key)     -> Checks if key exists.
 *    containsValue(Object value) -> Checks if value exists.
 *    keySet()                    -> Returns Set of keys.
 *    values()                    -> Returns Collection of values.
 *    entrySet()                  -> Returns Set of key-value pairs.
 *    size()                      -> Returns number of entries.
 *    clear()                     -> Removes all entries.
 *    isEmpty()                   -> Checks if map is empty.
 *
 *
 * 5. Iterator / ListIterator
 *    --------------------------------------------------
 *    hasNext()          -> Checks if next element exists.
 *    next()             -> Returns the next element.
 *    remove()           -> Removes last returned element.
 *
 *    (ListIterator only:)
 *    hasPrevious()      -> Checks if previous element exists.
 *    previous()         -> Returns the previous element.
 *    add(E e)           -> Inserts element at current position.
 *    set(E e)           -> Replaces last returned element.
 *
 * Observation:
 *
 * We can see that LinkedList is part of both the List and Queue collections.
 * However, its usage differs in each context.
 *
 * Queue Implementations:
 *   - LinkedList
 *   - PriorityQueue
 *
 * Common Queue Methods:
 *
 * LinkedList (when used as a Queue):
 *   - offer()  -> Inserts an element.
 *   - poll()   -> Retrieves and removes the head element.
 *   - peek()   -> Retrieves but does not remove the head element.
 *
 * PriorityQueue:
 *   - offer()  -> Inserts an element based on priority.
 *   - poll()   -> Retrieves and removes the head (highest priority) element.
 *
 *
 */

public class _017_Collection_Framework {
    public static void main(String[] args) {

        // 1. LIST DEMO (ArrayList, LinkedList, Stack, Vector)
        System.out.println("=== LIST DEMO ===");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add(1, "Grapes");
        System.out.println("List: " + list);
        System.out.println("Get index 2: " + list.get(2));
        list.set(2, "Mango");
        System.out.println("Updated List: " + list);
        list.remove("Banana");
        System.out.println("After Removal: " + list);
        System.out.println("Contains 'Apple'? " + list.contains("Apple"));
        System.out.println("Size: " + list.size());

        // LinkedList as Queue
        Queue<Integer> linkedQueue = new LinkedList<>();
        linkedQueue.offer(10);
        linkedQueue.offer(20);
        linkedQueue.offer(30);
        System.out.println("\nLinkedList as Queue: " + linkedQueue);
        System.out.println("Peek: " + linkedQueue.peek());
        System.out.println("Poll: " + linkedQueue.poll());
        System.out.println("After Poll: " + linkedQueue);

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        System.out.println("\nStack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After Pop: " + stack);

        // Vector
        Vector<String> vector = new Vector<>();
        vector.add("X");
        vector.add("Y");
        vector.add("Z");
        System.out.println("\nVector: " + vector);

        // 2. SET DEMO (HashSet, LinkedHashSet, TreeSet)
        System.out.println("\n=== SET DEMO ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Two"); // duplicate ignored
        System.out.println("HashSet (Unordered): " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        System.out.println("LinkedHashSet (Insertion Order): " + linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(3);
        System.out.println("TreeSet (Sorted): " + treeSet);

        // 3. QUEUE / DEQUE DEMO (ArrayDeque, PriorityQueue)
        System.out.println("\n=== QUEUE / DEQUE DEMO ===");
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer("Front");
        deque.offerLast("Middle");
        deque.offerFirst("Start");
        System.out.println("ArrayDeque: " + deque);
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());
        System.out.println("After Poll: " + deque);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(40);
        priorityQueue.offer(10);
        priorityQueue.offer(30);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Poll (Smallest): " + priorityQueue.poll());
        System.out.println("Peek: " + priorityQueue.peek());

        // 4. MAP DEMO (HashMap, LinkedHashMap, TreeMap)
        System.out.println("\n=== MAP DEMO ===");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.putIfAbsent(3, "Duplicate");
        System.out.println("HashMap: " + hashMap);
        System.out.println("Get key 2: " + hashMap.get(2));
        hashMap.remove(2);
        System.out.println("After Removing key 2: " + hashMap);
        System.out.println("Contains key 1? " + hashMap.containsKey(1));
        System.out.println("KeySet: " + hashMap.keySet());
        System.out.println("Values: " + hashMap.values());
        System.out.println("EntrySet:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "Ten");
        linkedHashMap.put(20, "Twenty");
        System.out.println("\nLinkedHashMap (Insertion Order): " + linkedHashMap);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "Beta");
        treeMap.put(1, "Alpha");
        treeMap.put(3, "Gamma");
        System.out.println("TreeMap (Sorted by Key): " + treeMap);

        // 5. ITERATOR / LISTITERATOR
        System.out.println("\n=== ITERATOR / LISTITERATOR DEMO ===");
        Iterator<String> iterator = list.iterator();
        System.out.print("Iterator over List: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nListIterator forward & backward:");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.print("\nBackward: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}

