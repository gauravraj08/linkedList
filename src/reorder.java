class reSol{
    ListNode head;
    ListNode tail;
    int size=0;
    class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val=val;
        }
    }
    public void insert(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public ListNode reverseList(ListNode node){
        ListNode prev=null;
        ListNode current=node;
        ListNode next=node.next;
        while(current!=null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
    public ListNode midNode(ListNode node){
        ListNode fast=node;
        ListNode slow=node;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //reorder
    public void reOrderr(ListNode node){
        if(node==null || node.next==null) return;
        ListNode mid=midNode(node);
        ListNode headFirst=node;
        ListNode headSecond=reverseList(mid);
        while (headFirst!=null && headSecond!=null){
            ListNode temp=headFirst.next;
            headFirst.next=headSecond;
            headFirst=temp;

            temp=headSecond.next;
            headSecond.next=headFirst;
            headSecond=temp;
        }
        if(headFirst!=null){
            headFirst.next=null;
        }
    }
}

public class reorder {
    public static void main(String[] args) {

    }
}
