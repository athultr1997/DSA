# Palindrome Linked List

Problem
Description: [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

## Solution I: Stack and Comparison

### Algorithm

1. Iterate through both the linked list and add all elements to a stack.
2. Find the size of the linked list.
3. Again start iteration from the beginning of the linked list.
4. Start popping elements from the stack.
5. Compare the popped element and the element at the linked list.
6. If they are not equal, it is not a palindrome.
7. Repeat steps 3 to 6 till half the size of the linked list is covered.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(N)**

## Solution II: Reversing Linked List

### Explanation

There is a link between the last element of the left half and the first element of the right half. But this is not
important because the right half is smaller and we are iterating till the right half linked list is fully traversed.

### Algorithm

1. Initialize the fast and the slow pointer to the start of the Linked List.
2. Increment the slow pointer by one step and the fast pointer by two steps.
3. Repeat steps 1 and 2 till the fast pointer reaches the end of the Linked List.
4. Increment the slow pointer if the fast pointer is not null. This is done so that the right half is smaller in case of
   odd number of elements.
5. Reverse the linked list starting from the slow pointer. This will form a new head at the end of the linked list.
6. Start comparing the right and left heads.
7. If the values are not equal the linked list is not a palindrome.
8. Repeat steps 6 to 7 till the right half is over.
9. If we reach till step 8 the linked list is a palindrome.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

## Solution II: Recursion

TODO
