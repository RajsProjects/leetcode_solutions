from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        print(slow.val)            

if __name__ == "__main__":
    # Example usage:
    # Creating a linked list: 1 -> 2 -> 3 -> 4
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    
    # Creating an instance of Solution and calling pairSum
    solution = Solution()
    solution.pairSum(head)  # This will print the value of the slow pointer at the midpoint of the list