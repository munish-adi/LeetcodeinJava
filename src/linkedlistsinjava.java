public class linkedlistsinjava {
    public static class Node{
        int data;
        Node next;

        Node(int num){
            this.data = num;
            this.next = null;
        }

        Node(int num, Node next){
            this.data = num;
            this.next = next;
        }
    }

    public static class singlylinkedlist{

        Node head;

        public void printll(){
            Node current = head;
            while(current != null){
                System.out.print(current.data);
                System.out.print("->");
                current = current.next;
            }
            System.out.print("null");
        }

        public int lengthofll(){
            int count = 0;
            Node temp = head;
            while(temp.next != null){
                count++;
            }
            return count;
        }

        public void insertathead(int num){
            Node newnode = new Node(num);
            newnode.next = head;
            head = newnode;

        }

        public void insertattail(int num){
            Node newnode = new Node(num);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }

        public void insertatk(int num, int k){
            Node newnode = new Node(num);
            Node temp = head;
            for (int i = 0; i < k-1; i++){
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }

        public void deleteathead(){
            if(head == null){
                return;
            }
            Node temp = head;
            head = temp.next;
        }

        public void deleteattail(){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }

        public void deleteatk(int k){
            Node current = head;
            for(int i = 0; i < k; i++){ //sup k=2 => element to remove is 8 (see o/p)
                current = current.next;
            }

            Node temp = current.next;

            Node prev = head;
            for (int i = 0; i < k-1; i++){
                prev = prev.next;
            }
            prev.next = temp;
        }

        public void deleteatkfromtheend(int k){
            int count = 0;
            Node temp = head;

            while(temp != null){
                count++;
                temp = temp.next;
            }

            Node current = head;
            for(int i = 1; i < count-k; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }



    public static void main(String[] args){
        singlylinkedlist l1 = new singlylinkedlist();
        l1.insertathead(5);
        l1.insertattail(7);
        l1.insertattail(8);
        l1.insertattail(9);
        l1.insertattail(10);
        l1.insertatk(6,1);

        l1.printll();
        System.out.println();
        System.out.print("Delete at head : ");
        l1.deleteathead();
        l1.printll();
        System.out.println();
        System.out.print("Delete at tail : ");
        l1.deleteattail();
        l1.printll();
        System.out.println();
        l1.deleteatk(2);
        l1.printll();

        System.out.println();
        System.out.println("Deleting from end : ");
        l1.deleteatkfromtheend(2);
        l1.printll();
    }

}
public class linkedlistsinjava {
    public static class Node{
        int data;
        Node next;

        Node(int num){
            this.data = num;
            this.next = null;
        }

        Node(int num, Node next){
            this.data = num;
            this.next = next;
        }
    }

    public static class singlylinkedlist{

        Node head;

        public void printll(){
            Node current = head;
            while(current != null){
                System.out.print(current.data);
                System.out.print("->");
                current = current.next;
            }
            System.out.print("null");
        }

        public int lengthofll(){
            int count = 0;
            Node temp = head;
            while(temp.next != null){
                count++;
            }
            return count;
        }

        public void insertathead(int num){
            Node newnode = new Node(num);
            newnode.next = head;
            head = newnode;

        }

        public void insertattail(int num){
            Node newnode = new Node(num);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }

        public void insertatk(int num, int k){
            Node newnode = new Node(num);
            Node temp = head;
            for (int i = 0; i < k-1; i++){
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }

        public void deleteathead(){
            if(head == null){
                return;
            }
            Node temp = head;
            head = temp.next;
        }

        public void deleteattail(){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }

        public void deleteatk(int k){
            Node current = head;
            for(int i = 0; i < k; i++){ //sup k=2 => element to remove is 8 (see o/p)
                current = current.next;
            }

            Node temp = current.next;

            Node prev = head;
            for (int i = 0; i < k-1; i++){
                prev = prev.next;
            }
            prev.next = temp;
        }

        public void deleteatkfromtheend(int k){
            int count = 0;
            Node temp = head;

            while(temp != null){
                count++;
                temp = temp.next;
            }

            Node current = head;
            for(int i = 1; i < count-k; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }



    public static void main(String[] args){
        singlylinkedlist l1 = new singlylinkedlist();
        l1.insertathead(5);
        l1.insertattail(7);
        l1.insertattail(8);
        l1.insertattail(9);
        l1.insertattail(10);
        l1.insertatk(6,1);

        l1.printll();
        System.out.println();
        System.out.print("Delete at head : ");
        l1.deleteathead();
        l1.printll();
        System.out.println();
        System.out.print("Delete at tail : ");
        l1.deleteattail();
        l1.printll();
        System.out.println();
        l1.deleteatk(2);
        l1.printll();

        System.out.println();
        System.out.println("Deleting from end : ");
        l1.deleteatkfromtheend(2);
        l1.printll();
    }

}
