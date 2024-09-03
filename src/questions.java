class llq{
    Node head;
    Node tail;
    int size=0;
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
//    public void insertAtIdx(int val,int idx){
//        head=insertAtIndex(val,idx,head);
//    }
    //recursion
//    private Node insertAtIndex(int val,int idx,Node node){
//        if(idx==0){
//            Node temp=new Node(val,node);
//            size++;
//            return temp;
//        }
//        node.next=insertAtIndex(val,idx-1,node.next);
//        return node;
//    }

    //happy no
    public boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    public int findSquare(int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
    //remove duplicates
    public void deleteDup(){
        Node temp=head;
        while(temp!=null){
            if(temp.next!=null && temp.val==temp.next.val){
                temp.next=temp.next.next;
                size--;
            }
            else {
                temp=temp.next;
            }
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
    public Node insertLast(int val,Node node){
        if(node==null){
            Node temp=new Node(val);
            return temp;
        }
        else{
            node.next=insertLast(val,node.next);
        }
        return node;
    }
    public void display(Node node){
        if(node==null) {
            System.out.println("null");
            return;
        }
        System.out.print(node.val+"->");
        display(node.next);
    }

}
public class questions {
    public static void main(String[] args) {
        llq lq=new llq();
        lq.findSquare(12);
//        lq.insertFirst(4);
//        lq.insertFirst(2);
//        lq.insertFirst(2);
//        lq.insertFirst(1);
//        lq.insertFirst(1);
//        lq.insertFirst(1);
//
//        lq.display(lq.head);
//        lq.deleteDup();
//        lq.display(lq.head);

    }
}
