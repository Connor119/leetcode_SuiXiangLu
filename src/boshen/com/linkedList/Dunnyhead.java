package boshen.com.linkedList;

public class Dunnyhead {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * 虚拟头节点是用来解决头节点处理逻辑与其它节点处理逻辑不一样的问题的，通常链表中使用pre指针和cur指针
    * 分别指向前一个节点和当前节点，如果当前节点符合某些逻辑即需要对其处理，所以我们需要让cur的第一个
    * 位置是head，而不是head的下一个节点。这是为什么要存在虚拟头节点的原因。
    * */
    public ListNode leetcode203(ListNode head, int val) {
        if(head==null){
            return head;
        }
        // 新建一个节点作为虚拟头节点
        ListNode dunnyHead = new ListNode(1);
        dunnyHead.next = head;
        ListNode pre = dunnyHead;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dunnyHead.next;
    }
}
