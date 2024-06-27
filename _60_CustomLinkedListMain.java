public class _60_CustomLinkedListMain {
        public static void main(String[] args) {
                _59_CustomLinkedList list = new _59_CustomLinkedList();
                list.insertFirst(3);
                list.insertFirst(4);
                list.insertFirst(8);
                list.insertFirst(7);
                list.insertLast(99);
                list.justInsert(55,0);

                System.out.print("Original Linked List: [");
                list.display();
                System.out.print("]");

                System.out.printf("\n-----------------------------------------");

                System.out.printf("\nBefore Deletion From Start: ");
                list.display();
                System.out.printf("\nDeleted Value: "+list.deleteFirst());
                System.out.printf("\nAfter Deletion From Start: ");
                list.display();


                System.out.printf("\n-----------------------------------------");


                System.out.printf("\nBefore Deletion from Last: ");
                list.display();
                System.out.printf("\nDeleted Value: "+list.deleteLast());
                System.out.printf("\nAfter Deletion From Last: ");
                list.display();

                System.out.printf("\n-----------------------------------------");

                System.out.printf("\nBefore Deletion: ");
                list.display();
                System.out.printf("\nDeleted Value: "+list.delete(1));
                System.out.printf("\nAfter Deletion: ");
                list.display();

                System.out.printf("\n-----------------------------------------");

                System.out.printf("\nOutput: "+list.find(9));






        }
}
