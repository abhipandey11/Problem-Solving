//Iteration(arraylist+ 2 pointer)
class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> nodes= new ArrayList<>();
        ListNode curr= head;
        while(curr!=null){
            nodes.add(curr);
            curr=curr.next;
        }

        int i=0;
        int j=nodes.size()-1;
        while(i<j){
            nodes.get(i).next=nodes.get(j);
            i++;
            if(i>=j){
                break;
            }
            nodes.get(j).next=nodes.get(i);
            j--;
        }
        nodes.get(i).next=null;

        
    }
}

// Reverse+Merge( Fast Slow pointer and 2 pointer)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
        }

        ListNode prev=null;
        ListNode curr=slow.next;
        slow.next=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        ListNode first=head;
        ListNode second=prev;

        while(second!=null){
            slow=first.next;
            fast=second.next;

            first.next=second;
            second.next=slow;

            first=slow;
            second=fast;
        }

        
    }
}

//Recursion approach
