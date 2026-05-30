public class doublylinkedlists {
    public class Node{
        int data;
        Node next;
        Node prev;

        Node(int val){
            this.data = val;
        }

        Node(int val, Node forward){
            this.data = val;
            this.next = forward;

        }

        Node(int val, Node forward, Node backward){
            this.data = val;
            this.next = forward;
            this.prev = backward;
        }
    }
    Node head;
    Node tail;

    public class doublelinkedlist{

        public void printdll(){
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
                System.out.print(temp.data);
                System.out.print("->");
            }
            System.out.print("null");
            System.out.println();

        }

        public int length(){
            int length = 0;
            Node temp = head;
            while(temp.next != null){
                length++;
                temp = temp.next;
            }
            return length;
        }

        public void insertathead(int num){
            Node newNode = new Node(num);
            if(head == null) head = newNode;
            else{
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void insertattail(int num){
            Node newNode = new Node(num);
            if(head == null){
                head = tail = newNode;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void insertatk(int num, int k){
            Node newNode = new Node(num);
            if(head == null){
                head = tail = newNode;
            }
            Node temp = head;
            for(int i = 0; i < k-1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
        }


    }


    public void main(String[] args){
        doublelinkedlist l1 = new doublelinkedlist();
        l1.insertathead(1);
        l1.insertattail(2);
        l1.insertattail(3);
        l1.insertattail(4);
        l1.printdll();

    }
}
