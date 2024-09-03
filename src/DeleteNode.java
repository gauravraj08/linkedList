class DeleteNodeList {
    Node head;
    Node tail;
    int size = 0;

    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
    public void delete(){
        head=head.next;
        if(head==null) tail=null;
        size--;
    }
    public Node get(int index){
        Node node=head;
        for (int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }
    public void deleteFromLast(){
        Node secondLast=get(size-2);
        int tempVal= tail.val;
        tail=secondLast;
        tail.next=null;
        size--;
    }
    public void deleteFromIndex(int index){
        Node prev=get(index-1);
        prev.next=prev.next.next;
        size--;
    }
}
class DeleteNode{
    public static void main(String[] args) {
        DeleteNodeList dn = new DeleteNodeList();
        dn.insert(7);
        dn.insert(9);
        dn.insert(6);
        dn.insert(8);
        dn.display();
        dn.deleteFromIndex(2);
        dn.display();
    }
}

