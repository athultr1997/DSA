#include<bits/stdc++.h>
using namespace std;

enum Color {RED, BLACK};

class Node {
    public:
        int key;
        Color color; // red or black
        Node* p; // parent
        Node* left; // left child
        Node* right; // right child
}

class RedBlackTree {
    public:
        Node* head;
        void leftRotate();
        void rightRotate();
        void insert(int value);
}

void RedBlackTree::leftRotate(Node* x) {
    if (x == NULL) return;

    y = x->right;

    if (y == NULL) return;

    x->right = y->left;
    if (y->left != NULL)
        y->left->p = x;

    y->p = x->p;
    if (y->p == NULL)
        head = y;
    else if (x->p->left == x)
        x->p->left = y;
    else
        x->p->right = y;

    x->p = y;
    y->left = x;
}

void RedBlackTree::rightRotate(Node* x) {
    if (x == NULL) return;

    y = x->left;

    if (y == NULL) return;

    x->left = y->right;
    if (y->right != NULL) y->right->p = x;

    y->p = x->p;
    if (x->p == NULL)
        head = y;
    else if (x->p->left == x)
        x->p->left = y;
    else
        x->p->right = y;

    x->p = y;
    y->right = x;
}

int main() {
    RedBlackTree rbt;

}