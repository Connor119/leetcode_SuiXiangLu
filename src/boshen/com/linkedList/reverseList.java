package boshen.com.linkedList;


public class reverseList {

    public Dunnyhead.ListNode Leetcode206(Dunnyhead.ListNode head) {
        // 先定义一个最尾的null
        Dunnyhead.ListNode pre = null;
        Dunnyhead.ListNode cur = head;
        while(cur!=null){
            Dunnyhead.ListNode tempNode = cur.next;
            cur.next = pre;
            pre=cur;
            cur=tempNode;
        }
        return pre;
    }
}
