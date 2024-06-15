#include <iostream>
#include <list>
#include <vector>

class HashMap {
private:
    std::vector<std::list<std::pair<int, int>>> table;
    int size;

    int hashFunction(int key) {
        return key % size;
    }

public:
    HashMap(int s) : size(s) {
        table.resize(size);
    }

    void insert(int key, int value) {
        int hash = hashFunction(key);
        for (auto &pair : table[hash]) {
            if (pair.first == key) {
                pair.second = value;
                return;
            }
        }
        table[hash].emplace_back(key, value);
    }

    void remove(int key) {
        int hash = hashFunction(key);
        table[hash].remove_if([key](std::pair<int, int> const &pair) {
            return pair.first == key;
        });
    }

    int get(int key) {
        int hash = hashFunction(key);
        for (auto &pair : table[hash]) {
            if (pair.first == key) {
                return pair.second;
            }
        }
        return -1; // Return -1 if the key does not exist
    }
};
