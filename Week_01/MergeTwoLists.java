package array;

import javax.swing.*;
import java.util.LinkedList;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<Integer>(3,new ListNode(4,new ListNode(5,null)));
        ListNode<Integer> l2 = new ListNode<Integer>(2,new ListNode(3,new ListNode(4,null)));
        ListNode r = mergeTwoLists(l1,l2);
        System.out.println(r.toString());
    }

    private static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    private static class ListNode<T> {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
