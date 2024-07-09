public class _60_CustomLinkedListMain {
        public static void main(String[] args) {
//                _59_CustomSinglyLinkedList list = new _59_CustomSinglyLinkedList();
//                list.insertFirst(3);
//                list.insertFirst(4);
//                list.insertFirst(8);
//                list.insertLast(12);
//                list.insertFirst(7);
//                list.insertLast(99);
//                list.justInsert(55,0);
//
//                System.out.print("Original Linked List: [");
//                list.display();
//                System.out.print("]");
//
//                System.out.printf("\n-----------------------------------------");
//
//                System.out.printf("\nBefore Deletion From Start: ");
//                list.display();
//                System.out.printf("\nDeleted Value: "+list.deleteFirst());
//                System.out.printf("\nAfter Deletion From Start: ");
//                list.display();
//
//
//                System.out.printf("\n-----------------------------------------");
//
//
//                System.out.printf("\nBefore Deletion from Last: ");
//                list.display();
//                System.out.printf("\nDeleted Value: "+list.deleteLast());
//                System.out.printf("\nAfter Deletion From Last: ");
//                list.display();
//
//                System.out.printf("\n-----------------------------------------");
//
//                System.out.printf("\nBefore Deletion: ");
//                list.display();
//                System.out.printf("\nDeleted Value: "+list.delete(1));
//                System.out.printf("\nAfter Deletion: ");
//                list.display();
//
//                System.out.printf("\n-----------------------------------------");
//
//                System.out.printf("\nOutput: "+list.find(12));

//                System.out.printf("-----------------------------------------\n");
//                System.out.println("Doubly Linked List:");
//                System.out.printf("-----------------------------------------\n");

//                _61_DoublyLinkedList list = new _61_DoublyLinkedList();
//                list.insertFirst(3);
//                list.insertFirst(2);
//                list.insertFirst(8);
//                list.insertLast(15);
//                list.insertLast(16);
//                list.insertAtParticularIndex(18,2);
//                list.insertAtParticularIndex(20,4);
//                list.insertAfterNode(20,68);
//                list.display();


                System.out.printf("-----------------------------------------\n");
                System.out.println("Circular Linked List:");
                System.out.printf("-----------------------------------------\n");

                _62_CircularLinkedList list = new _62_CircularLinkedList();
                list.insert(1);
                list.insert(2);
                list.insert(3);
                list.insert(4);
                list.insert(5);
                list.insert(6);
                list.delete(4);
                list.delete(6);
                list.display();
        }
}
