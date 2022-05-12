package boshen.com.linkedList;

public class DeletePenultimateElement {
    public ListNode leetcode19(ListNode head, int n) {
        ListNode dunnyHead = new ListNode(-1);
        dunnyHead.next=head;
        ListNode slowPoint = dunnyHead;

        ListNode fastPoint = head;
        for(int i=0;i<n;i++){
            fastPoint=fastPoint.next;
        }
        while(fastPoint!=null){
            fastPoint=fastPoint.next;
            slowPoint=slowPoint.next;
        }
        slowPoint.next = slowPoint.next.next;
        return dunnyHead.next;
    }

}
