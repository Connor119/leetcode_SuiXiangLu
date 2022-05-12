package boshen.com.linkedList;

public class CreatAList {
    public class Node{
        int val;
        Node next;
        public Node(int value){
            this.val = value;
        }
    }

    Node dunnyHead = new Node(-1);
    int size = 0;
    public CreatAList() {

    }

    public int get(int index) {
        if(index<0 || index >= size){
            return -1;
        }
        Node temp = dunnyHead;
        int count = 0;
        while(count<=index){
            temp=temp.next;
            count++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        // Node cur = dunnyHead.next;
        Node pre = dunnyHead;
        // int count = 0;
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        // while(count<index){
        //     pre=cur;
        //     cur=cur.next;
        //     count++;
        // }
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // pre.next = newNode;
        // newNode.next = cur;
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        //写法1
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        Node pred = dunnyHead;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        //写法2
        // if(index<0||index>=size){
        //     return;
        // }
        // Node cur = dunnyHead.next;
        // Node pre = dunnyHead;
        // int count = 0;
        // while(count<index){
        //     pre=cur;
        //     cur=cur.next;
        //     count++;
        // }
        // if(cur.next==null){
        //     pre.next = null;
        // }else{
        //      pre.next = cur.next;
        // }
        // size--;
    }
}
