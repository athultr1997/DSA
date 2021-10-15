#include <bits/stdc++.h>
using namespace std;

const int ALPHABET_SIZE = 26;

class TrieNode {
    public:
        vector<TrieNode*> children;
        bool isEndOfWord;
        
        TrieNode() : children(ALPHABET_SIZE) {}
};

class Trie {
    public:
        TrieNode* head;
        
        Trie(): head(NULL) {}
        TrieNode* createNewNode();
        void createHead();
        bool isEmpty(TrieNode* pointer);
        void insert(string word);
        bool search(string word);
        void remove(string word);
        TrieNode* remove_helper(TrieNode* pointer, string word, int depth);
};

TrieNode* Trie::createNewNode() {
    TrieNode* node = new TrieNode();
    node->isEndOfWord = false;
    for (int i = 0; i < ALPHABET_SIZE; ++i) {
        node->children[i] = NULL;
    }
    return node;
}

void Trie::createHead() {
    head = createNewNode();
}

bool Trie::isEmpty(TrieNode* pointer) {
    if (!pointer) return true;
    
    for (int i = 0; i < pointer->children.size(); ++i) {
        if (pointer->children[i]) return false;
    }
    return true;
}

void Trie::insert(string word) {
    cout << "Inserting word: " << word << endl;
    if (!head) {
        cout << "head created when inserting word"<< endl;
        createHead();
    }
    TrieNode* pointer = head;
    for (int i = 0; i < word.size(); ++i) {
        int index = word[i] - 'a';
        if (!pointer->children[index]) {
            pointer->children[index] = createNewNode();
        }
        pointer = pointer->children[index];
        cout << "index = " << index << endl;
    }
    pointer->isEndOfWord = true;
    cout << "Word Inserted *********************" << endl << endl;
}

bool Trie::search(string word) {
    TrieNode* pointer = head;
    int i = 0;
    while (pointer) {
        if (pointer->isEndOfWord && i == word.size()) {
            return true;
        }
        pointer = pointer->children[word[i] - 'a'];
        ++i;
    }
    return false;
}

void Trie::remove(string word) {
    remove_helper(head, word, 0);
}

TrieNode* Trie::remove_helper(TrieNode* pointer, string word, int depth = 0) {
    if (!pointer) {
        return NULL;
    }

    if (depth == word.size()) {
        pointer->isEndOfWord = false;
        // deleting node if not prefix of larger word
        if (isEmpty(pointer)) {
            delete pointer;
            pointer = NULL;
        }
        return pointer;
    }

    int index = word[depth] - 'a';
    pointer->children[index] = remove_helper(pointer->children[index], word, depth + 1);
    
    // deleting nodes forming part of word
    if (isEmpty(pointer) && !pointer->isEndOfWord) {
        delete pointer;
        pointer = NULL;
    }
    return pointer;
}

int main() {
    Trie trie;
    trie.insert("hello");
    trie.insert("hey");
    cout << trie.search("hello") << endl;
    trie.remove("hello");
    cout << trie.search("hello") << endl;
    return 0;
}