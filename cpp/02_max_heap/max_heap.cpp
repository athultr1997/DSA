#include <bits/stdc++.h>
using namespace std;

class MinHeap {
    public:
        int* root;
        int capacity;
        int size;
        
        MinHeap(int cap);
        void minHeapify(int node);
        void display();
        void displayHelper(string prefix, int node, bool isLeft);
        void insert(int value);
        int getMin();
        int removeMin();
        void decreaseNode(int node, int newValue);
        void deleteNode(int node);
};

MinHeap::MinHeap(int cap) {
    capacity = cap;
    size = 0;
    root = new int[capacity];
}

void MinHeap::minHeapify(int node) {
    int smallest = node;
    int left = 2 * node + 1;
    int right = 2 * node + 2;
    if (left < size && root[left] < root[smallest]) {
        smallest = left;
    }
    if (right < size && root[right] < root[smallest]) {
        smallest = right;
    }
    if (smallest != node) {
        int tmp = root[smallest];
        root[smallest] = root[node];
        root[node] = tmp;
        minHeapify(smallest);
    }
}

void MinHeap::display() {
    displayHelper("", 0, false);
}

void MinHeap::displayHelper(string prefix, int node, bool isLeft) {
    if (node < 0 || node >= size) {
        return;
    }
    cout << prefix;
    cout << (isLeft ? "├──" : "└──" );
    cout << root[node] << endl;
    displayHelper(prefix + (isLeft ? "│   " : "    "), 2 * node + 1, true);
    displayHelper(prefix + (isLeft ? "│   " : "    "), 2 * node + 2, false);
}

void MinHeap::insert(int value) {
    if (size >= capacity) {
        cerr << "Heap Overflow !!" << endl;
        return;
    }

    int i = size;
    root[i] = value;
    size++;

    int tmp;
    int p = (i-1)/2;
    while (p >= 0 && root[i] < root[p]) {
        tmp = root[i];
        root[i] = root[p];
        root[p] = tmp;
        i = p;
        p = (i - 1) / 2;
    }
}

int MinHeap::getMin() {
    if (size <= 0) {
        throw "Heap is empty";
    }
    return root[size - 1];
}

int MinHeap::removeMin() {
    if (size <= 0) throw "Heap is empty";

    if (size == 1) {
        size--;
        return root[size];
    }

    int removed = root[0];
    root[0] = root[size - 1];
    size--;
    minHeapify(0);
    return removed;
}

void MinHeap::decreaseNode(int node, int newValue) {
    if (node >= size || node < 0) return;

    root[node] = newValue;
    int p = (node - 1) / 2;
    while (p >= 0 && root[node] < root[p]) {
        int tmp = root[node];
        root[node] = root[p];
        root[p] = tmp;
        node = p;
        p = (node - 1) / 2;
    }
}

void MinHeap::deleteNode(int node) {
    if (node >= size || node < 0) return;

    decreaseNode(node, INT_MIN);
    removeMin();
}

int main() {
    MinHeap minHeap(100);
    minHeap.insert(30);
    minHeap.insert(10);
    minHeap.insert(20);
    minHeap.insert(50);
    minHeap.insert(60);
    minHeap.insert(6);
    try {
        cout << "min = " << minHeap.getMin() << endl;
    } catch (const char* msg) {
        cerr << msg << endl;
    }
    minHeap.display();
    cout << "removed min = " << minHeap.removeMin() << endl;
    cout << endl << endl;
    minHeap.display();

    cout << "removed min = " << minHeap.removeMin() << endl;
    cout << endl << endl;
    minHeap.display();

    cout << endl << endl;
    minHeap.decreaseNode(3, 4);
    minHeap.display();

    cout << endl << endl;
    minHeap.deleteNode(2);
    minHeap.display();
}