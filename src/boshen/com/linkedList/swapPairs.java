package boshen.com.linkedList;

public class swapPairs {
    public ListNode leetcode24(ListNode head) {
        ListNode dunnyHead = new ListNode(-1);
        dunnyHead.next=head;
        ListNode cur = dunnyHead;
        while(cur.next!=null&&cur.next.next!=null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            ListNode nextparir = node2.next;
            cur.next = node2;
            node2.next = node1;
            node1.next = nextparir;
            cur=node1;
        }
        return dunnyHead.next;
    }
}
