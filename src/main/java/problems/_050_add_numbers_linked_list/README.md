# Add Two Numbers Represented As Linked List II

Problem
Description: [Add Two Numbers Represented As Linked List II](https://leetcode.com/problems/add-two-numbers-ii/)

## Solution I: Stack and Sum From End

### Algorithm

1. Iterate through both the linked list.
2. Add each element to different stacks one for each linked list.
3. Repeat steps 1 and 2 till both the linked list are traversed completely.
4. Pop elements from both the stacks.
5. Add the popped elements and the carry.
6. Add the ten's digit to the new linked list being made.
7. Store the carry in a variable.
8. Repeat steps 4, 5, 6, and 7 till both the queues are empty and carry is zero.
9. Return the next element of the head, since the head will now be pointing to a dummy variable.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(N)**

## Solution II: Adding and Normalization

### Algorithm
1. Find the size of both the input linked lists.
2. Iterate over the two linked list and add the numbers at the same positions.
3. If one linked list is greater in size, add its element with zero.
4. Store the sum without normalization in a new linked list.
5. Now, starting from the end normalize the sums stored in the new linked list.
6. Also, reverse the linked list while iterating from the end.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(N)**
