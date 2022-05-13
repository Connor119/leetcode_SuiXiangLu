package boshen.com.linkedList;

public class CircularList {
    public ListNode leetcode022(ListNode head) {
        ListNode res = null;
        ListNode slow = head;
        ListNode fast = head;
        // if(head==null||head.next==null){
        //     return res;
        // }
        while(fast!=null){
            if(fast==null||fast.next==null||fast.next.next==null){
                return res;
            }
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                ListNode point1 = slow;
                ListNode point2 = head;
                while(point1!=point2){
                    point1=point1.next;
                    point2=point2.next;
                }
                res = point1;
                break;
            }
        }
        return res;
    }
}
