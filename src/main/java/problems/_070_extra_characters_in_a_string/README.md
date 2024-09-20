# Extra Characters In a String

Problem
Description: [Extra Characters In a String](https://leetcode.com/problems/extra-characters-in-a-string/description/)

## Solution I: Dynamic Programming

### Intuition

* Recurrence Relationship: `f(i) = min(1 + f(i+1), f(mi_1 + 1), ..., f(mi_n + 1))` where `i` is the
  start of the string. `1 + f(i+1)` denotes the choice where the character at index i is considered
  as extra. `mi` stands for the end of the index which matches a word in dictionary, which means the
  substring `[i, mi]` is found in the dictionary.
* The complexity of the problem arises because a given substring can be a word by itself or maybe a
  part of a larger word. Also, if we find a substring in the dictionary, there might be the
  possibility that the word found is part of a larger word in the dictionary. However, if we keep
  expanding hoping to find larger dictionary words, we might not find any and could be left with
  non-optimal solutions. Depending on the choice we make now, the substring breaks we make ahead
  may not be optimal. Hence, we have to consider all the possible cases.
* The case when the substring's starting index is out of bounds, the result of the function `f` is
  zero.

### Complexity

Let `N` be the total characters in the string.
Let `M` be the average length of the strings in dictionary.
Let `K` be the length of the dictionary.

#### Time Complexity: O(N^3)

The two nested loops cause `N^2`. One `N` is due to the substring method.

#### Space Complexity: O(N + M.K)

`M.K` is the size of the set used to store the dictionary. `N` is due to the dp array.

## Solution II: Dynamic Programming and Trie

### Intuition

* Use Trie data structure to reduce the complexity due to substring search.
* Everything else remains unchanged from Solution I.

### Complexity

Let `N` be the total characters in the string.
Let `M` be the average length of the strings in dictionary.
Let `K` be the length of the dictionary.

#### Time Complexity: O(N^2 + M.K)

#### Space Complexity:
