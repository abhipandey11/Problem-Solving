//BRUTE FORCE (Use ArrayList for storing nodes and then go directly to remove node)
//O(N), O(N)

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> arr= new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            arr.add(curr);
            curr=curr.next;
        }

        int removeindex=arr.size()-n;
        if(removeindex==0){
            return head.next;
        }
        arr.get(removeindex-1).next=arr.get(removeindex).next;
        return head;
        
    }
}

// Iteration(Two Pass) without storing nodes
//O(N), O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N=0;
        ListNode curr=head;
        while(curr!=null){
            N++;
            curr=curr.next;
        }

        int removeindex=N-n;
        if(removeindex==0){
            return head.next;
        }
        curr=head;
        for(int i=0;i<N-1;i++){
            if(i==removeindex-1){
                curr.next=curr.next.next;
                break;
            }
            curr=curr.next;
        }
        return head;
        
    }
}
// Recursion

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
    int count=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null){
        return null;
       } 
       head.next=removeNthFromEnd(head.next,n);
       count++;
       if(count==n){
        return head.next;
       }
       return head;
        
    }
    
}