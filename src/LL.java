public class LL {
    Node head;
    Node tail;
    int size;
    public LL(){
        this.size=0;
    }
    class Node{
        int value;
        Node next;
        public Node (int val){
            this.value=val;
        }
        public Node(int value,Node next){
            this.next=next;
            this.value=value;
        }
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertAtIndex(int val,int index){
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public void insertRec(int val,int idx){
        head=insertRec(val,idx,head);
    }
    //insertAtIndex using recursion
    private Node insertRec(int val,int idx,Node temp){
        if(idx==0){
            Node node=new Node(val,temp);
            size++;
            return node;
        }
        temp.next=insertRec(val,idx--,temp.next);
        return temp;
    }
    public void insertAtEnd(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

}
