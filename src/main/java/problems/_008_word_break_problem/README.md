## Solution 1: Using normal DFS and backtracking

DFS need to be done with every position in the board as the starting position since word can begin
at any location. The visited array should not be persisted in between each DFS. Perform normal DFS.
Do not use another visited array. The same can be used.

TC - _O(m^2 * n^2 + l)_ where `k` is max length of word in `words` and `l` is the number of word
in `words`. For each dfs the whole board will be searched, and it will repeat for each element on
the board. The `l` term is the complexity of adding the elements in to the hash set. Looking up in
the hashset will be an _O(1)_ operation.

SC - _O(mn + kl)_

## Solution 2: Using Trie, normal DFS and backtracking

TC - 
SC - 