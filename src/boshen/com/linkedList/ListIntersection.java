package boshen.com.linkedList;

public class ListIntersection {
    /*
    *两个链表相交就让两个指针从两个链表的头部分别出发，到尾后从另外一个头部继续出发
    * 相撞后即是链表的交点
    * */
    public ListNode Leetcode106(ListNode headA, ListNode headB) {
        ListNode dunnyHead1 = new ListNode(-1);
        ListNode dunnyHead2= new ListNode(-2);
        dunnyHead1.next=headA;
        dunnyHead2.next=headB;
        ListNode pointOne = dunnyHead1;
        ListNode pointTwo = dunnyHead2;
        ListNode res=null;
        int countNull=0;
        // if(headA==headB){
        //     res=headA;
        // }
        while(pointOne!=pointTwo){
            while(pointOne!=null || pointTwo!=null){
                if(pointOne==null){
                    pointOne=headB;
                    countNull++;
                }else{
                    pointOne=pointOne.next;
                }

                if(pointTwo==null){
                    pointTwo=headA;
                    countNull++;
                }else{
                    pointTwo=pointTwo.next;
                }

                if(pointTwo==pointOne){
                    res = pointOne;
                    break;
                }
                if(countNull>2){
                    break;
                }
            }
        }
        return res;
    }
}
