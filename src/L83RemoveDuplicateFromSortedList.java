import java.util.*;
public class L83RemoveDuplicateFromSortedList {
    public void RemoveDuplicate(linkedlistsinjava.Node head){
        linkedlistsinjava.Node temp = head;
        linkedlistsinjava.Node current = head;
        while(temp != null){
            while(temp.next != null && temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

    }


    public void main(){
        linkedlistsinjava.singlylinkedlist s1 = new linkedlistsinjava.singlylinkedlist();
        s1.insertathead(1);
        s1.insertathead(1);
        s1.insertattail(2);
        s1.insertattail(3);
        s1.insertattail(3);

        System.out.println("Original List : ");
        s1.printll();

        RemoveDuplicate(s1.head);
        System.out.println("new List : ");
        s1.printll();
    }
}
