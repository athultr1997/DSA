~~# Min Cost to Connect All Points

Problem
Description: [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points)

## Solution I: Using Prims Algorithm for MST

### Algorithm

```
MST-PRIM(G,w,r):
 for each u in G.V:
 	u.key = inf
    u.pie = NIL
 r.key = 0
 Q = G.V  // initialize Q to contain all vertices
 while Q is not empty:
 	u = EXTRACT-MIN(Q)
    for each v in G.Adj[u]
     if v in Q and w(u,v) < v.key:
      v.pie = u
      v.key = w(u,v)
```

### Observations

* No standard library offers `DECREASE-KEY` in min heap. Hence, have to add the same node multiple
  times in the queue with different values.
* Can be made faster by making sure the minQueue is popped only `N` times. This is because we store
  the same node multiple times in the queue with different values. This reduces the duplicate
  processing but does not prevent it.

### Complexity Analysis

N is the length of the `points` array.

#### Computational Complexity: O(N^2.lnN)

The computational complexity of Prim's algorithm with `DECREASE-KEY` operation of binary heap
is `O(E.lnV)`. Since we do not have such a heap readily available we add all elements to the
minQueue multiple times, and we do not use the `DECREASE-KEY` operation. Hence, the complexity
is `O(N^2.lnN)` where the factor `lnN` captures the extra processing done for duplicate nodes.

#### Space Complexity: O(N^2)

`DECREASE-KEY` is not being used and each node is added as many out-degree's times.

## Solution II: Prims Algorithm Optimized for Complete Graphs

### Algorithm

* Create an array of length V called `minDist` which stores the minimum distance from each node to
  the growing MST.
* Initialize `minDist[0] = inf`. `0` is the node from which we start iteration. Compute and store
  the distance from `0` to each node in the rest of the indices for the array.
* Find the index having the minimum value in `minDist`. Let it be `minIndex`.
* Set `minDist[minIndex] = inf` and compute distance from `minIndex` to the remaining nodes.
  Update `minDist` if the distance is greater.
* Repeat the above 2 steps `V - 1` times.

### Observations

* Only works because the graph is a complete graph. The information of the edges which are connected
  does not need to be captured.
* Searching for the `minIndex` is an `O(N)` operation here as opposed to `O(1)` in min heap.
* Since it is a complete graph, the search for the value of a node which happens `O(N^2)` times can
  be done in `O(1)` times using this approach. In min heap approach, since `DECREASE-KEY` is not
  used we have to add the node `O(N^2)` times.

### Complexity Analysis

#### Computational Complexity: O(N^2)

#### Space Complexity: O(N)

## Solution III: Kruskal's Algorithm

TODO
