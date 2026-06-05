public class L147InsertionSortList {

    public linkedlistsinjava.Node InsertionSortList(linkedlistsinjava.Node head){
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node helps handle insertions at the head of the sorted list seamlessly
        linkedlistsinjava.Node dummy = new linkedlistsinjava()Node(0);
        linkedlistsinjava.Node current = head;

        while (current != null) {
            // Save the next node to process before altering current.next
            linkedlistsinjavaNode nextNode = current.next;

            // Start searching for the insertion point from the beginning of the sorted list
            linkedlistsinjava.Node prev = dNodeummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert the current node between prev and prev.next
            current.next = prev.next;
            prev.next = current;

            // Move to the next node in the original unsorted list
            current = nextNode;
        }

        return dummy.next;

    }

    public void main(String[] args){

    }


}
