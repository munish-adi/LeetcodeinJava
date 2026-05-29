public class L24SwapNodesinPairs {
    public static linkedlistsinjava.Node swapnodesinpairs(linkedlistsinjava.Node head){

        // 1. Create our Dummy Node to anchor the list
        linkedlistsinjava.Node dummy = new linkedlistsinjava.Node(0);
        dummy.next = head;

        // 'prev' will always sit right behind the pair we are swapping
        linkedlistsinjava.Node prev = dummy;

        // Loop as long as there is a PAIR of nodes ahead of us to swap
        while(prev.next != null && prev.next.next != null){

            // Identify the two nodes to swap
            linkedlistsinjava.Node first = prev.next;
            linkedlistsinjava.Node second = prev.next.next;

            // --- THE SWAP ---
            // 1. Point the first node to the rest of the list (e.g. 1 points to 3)
            first.next = second.next;

            // 2. Point the second node back to the first node (e.g. 2 points to 1)
            second.next = first;

            // 3. Connect the previous part of the list to the newly swapped pair
            prev.next = second;

            // --- MOVE FORWARD ---
            // 'first' is now the second node in the swapped pair.
            // We move 'prev' there to get ready for the next pair.
            prev = first;
        }

        // Return the actual head of the new list
        return dummy.next;
    }

    // Standard Java main method
    public static void main(String[] args){
        linkedlistsinjava.singlylinkedlist s1 = new linkedlistsinjava.singlylinkedlist();
        s1.insertathead(1);
        s1.insertattail(2);
        s1.insertattail(3);
        s1.insertattail(4);

        System.out.print("Original List : ");
        s1.printll();
        System.out.println();

        // Catch the returned new head
        s1.head = swapnodesinpairs(s1.head);

        System.out.print("New List : ");
        s1.printll();
    }
}
