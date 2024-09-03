class solution{
    ListNode head;
    ListNode tail;
    int size=0;
    class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val=val;
            next=null;
        }

        public ListNode() {
        }
    }
    public ListNode joinTwoSortedList(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(list1 != null && list2 != null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        temp.next = (list1!=null) ? list1:list2;
        return dummy.next;
    }
    ListNode getMid(ListNode head){
        ListNode midprev=null;
        while(head!=null && head.next!=null){
            midprev = (midprev == null) ? head:midprev.next;
            head=head.next.next;
        }
        ListNode mid=midprev.next;
        midprev.next=null;
        return  mid;
    }
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return  joinTwoSortedList(left,right);
    }
    public void addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        ListNode tail=dummyHead;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int digit1 = (l1!=null) ? l1.val:0;
            int digit2 = (l2!=null) ? l2.val:0;

            int sum=digit1+digit2+carry;
            int digit=sum%10;
            carry = sum/10;

            ListNode node = new ListNode(digit);
            tail.next=node;
            tail=tail.next;

            l1=(l1!=null) ? l1.next:null;
            l2=(l2!=null) ? l2.next:null;
        }
        ListNode result = dummyHead.next;
        dummyHead.next=null;
        System.out.println(result.val+""+result.next.val+""+result.next.next.val);
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }
    //planidrome ll
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseList(mid);
        ListNode reverseHead=secondHead;
        while(head!=null && secondHead!=null){
            if(head.val != secondHead.val) break;
            head=head.next;
            secondHead=secondHead.next;
        }
        reverseList(reverseHead);

        return head==null || secondHead==null;
    }
    public ListNode reverseList(ListNode head){
        if(head==null) return head;
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
    public ListNode middleNode(ListNode head){
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public void displayList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class merge {
    public static void main(String[] args) {
        solution ll1=new solution();
        solution ll2=new solution();
        solution ll=new solution();

//        ll1.insert(3);
        ll1.insert(8);
        ll1.insert(3);
        ll1.insert(13);
        ll1.insert(2);
        ll1.insert(5);
        ll1.displayList(ll1.head);
        ll1.head=ll1.reverseList(ll1.head);
        ll1.displayList(ll1.head);
//        ll.addTwoNumbers(ll1.head,ll2.head);
    }
}
