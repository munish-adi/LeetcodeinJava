public class removeallduplicates {
    public static linkedlistsinjava.Node RemoveallDuplicate(linkedlistsinjava.Node head){
        linkedlistsinjava.Node dummy = new linkedlistsinjava.Node(0);
        dummy.next = head;
        linkedlistsinjava.Node prev = dummy;
        while(head != null){
            if (head.next != null && head.data == head.next.data){
                while(head.next != null && head.data == head.next.data){
                    head = head.next;

                }
                prev.next = head.next;

            }
            else{
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;

    }



    public void main(String[] args){
        linkedlistsinjava.singlylinkedlist s1 = new linkedlistsinjava.singlylinkedlist();
        s1.insertathead(1);
        s1.insertathead(1);
        s1.insertattail(2);
        s1.insertattail(3);
        s1.insertattail(3);

        System.out.println("Original List : ");
        s1.printll();

        RemoveallDuplicate(s1.head);
        System.out.println("new List : ");
        s1.printll();

    }
}
