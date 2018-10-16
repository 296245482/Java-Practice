package swordtooffer;

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLength(p1);
        int length2 = getLength(p2);
        if(length1 > length2) {
            int len = length1 - length2;
            while(len > 0){
                p1 = p1.next;
                len --;
            }
        }else if(length1 < length2) {
            int len = length2 - length1;
            while(len > 0){
                p2 = p2.next;
                len--;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    private int getLength(ListNode p){
        int length = 0;
        ListNode current = p;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
