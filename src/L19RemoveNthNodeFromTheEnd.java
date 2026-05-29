public class L19RemoveNthNodeFromTheEnd {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    ListNode head;
    public static class linkedlist {
        ListNode head;
        public void insertathead(int num) {
            ListNode newnode = new ListNode(num);
            newnode.next = head;
            head = newnode;

        }
    }

    public void solution(ListNode point, int n){
        int count = 0;
        ListNode temp = head;
        ListNode current = head;
        if(head == null){
            return;
        }
        if(temp.next == null){
            head = null;
        }
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        //now your temp is at last possible element;

        ListNode prev = head;
        for (int i = 0; i < count-n ;i++){
            current = current.next;
        }
        for (int i = 0; i < count-n-1; i++){
            prev = prev.next;
        }
        prev.next = current;

    }


    public void main(){


    }
}
