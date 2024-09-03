class dll{
    Node head;
    Node tail;
    int size=0;
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.prev=next;
        }
        public Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
    public void insert(int val){
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null) head.prev=node;
        head=node;
        if(tail==null) tail=head;
        size++;
    }
    public void insertAtIndex(int val,int index){
        Node node=new Node(val);
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        node.prev=temp;
        node.next.prev=node;
    }
    public void insertAtEnd(int val){
        Node node=new Node(val);
        tail.next=node;
        node.next=null;
        tail=node;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }public void displayReverse(){
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.prev;
        }
        System.out.println("null");
    }
}
public class DDL {
    public static void main(String[] args) {
        dll ll=new dll();
        ll.insert(5);
        ll.insert(6);
        ll.insert(3);
        ll.insert(8);
        ll.insert(9);
        ll.display();
        ll.insertAtEnd(1);
        ll.display();
        ll.insertAtIndex(2,3);
        ll.display();
    }
}
