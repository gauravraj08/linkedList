class cl {
    Node head;
    Node tail;
    int size=0;
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public void insert(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size++;
    }
    public void display(){
        Node temp=head;
        while(temp!=tail){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println(tail.val);
    }
    public int cycleLength(Node head) {
        Node fast=head;
        Node slow=head;
        int length=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
    public void delete(int val){
        Node temp=head;
        if(temp.val==val){
            head=head.next;
            tail.next=head;
            return;
        }
        do{
            Node n=temp.next;
            if(n.val==val){
                temp.next=n.next;
                break;
            }
            temp=temp.next;
        }
        while(temp!=head);
    }
}
public class cll {
    public static void main(String[] args) {
        cl l=new cl();
        l.insert(2);
        l.insert(5);
        l.insert(6);
        l.insert(7);
        l.insert(8);
        l.display();
        l.delete(7);
        l.display();
    }
}
