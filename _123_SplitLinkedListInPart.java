public class _123_SplitLinkedListInPart {
    public static void main(String[] args) {
        _122_SplitLinkedListInParts linkedListInParts = new _122_SplitLinkedListInParts();
        linkedListInParts.insertLast(1);
        linkedListInParts.insertLast(2);
        linkedListInParts.insertLast(3);
        linkedListInParts.display();
        System.out.println();
        System.out.println(linkedListInParts.size());
        _122_SplitLinkedListInParts.Node[] nodes = linkedListInParts.splitListToParts(5);
        for (_122_SplitLinkedListInParts.Node node : nodes) {
            if (node != null) {
                _122_SplitLinkedListInParts.Node temp = node;
                while (temp != null) {
                    System.out.print(temp.getValue() + " -> ");
                    temp = temp.getNext();
                }
                System.out.print("End");
            } else {
                System.out.print("null");
            }
            System.out.println();
        }
    }
}
