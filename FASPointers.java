class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class FASPointers {
    public static boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast)
          return true; // found the cycle
      }
      return false;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      System.out.println("-----------");
      System.out.println("FASPointers");
      System.out.println("-----------");
      head.next.next.next.next.next.next = head.next.next;
      System.out.println("LinkedList has cycle: " + hasCycle(head));
    }
  }