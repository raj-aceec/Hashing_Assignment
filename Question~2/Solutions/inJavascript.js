class HashMap {
    constructor(size) {
        this.size = size;
        this.table = new Array(size).fill(null).map(() => []);
    }

    hashFunction(key) {
        return key % this.size;
    }

    insert(key, value) {
        const hash = this.hashFunction(key);
        for (const pair of this.table[hash]) {
            if (pair[0] === key) {
                pair[1] = value;
                return;
            }
        }
        this.table[hash].push([key, value]);
    }

    remove(key) {
        const hash = this.hashFunction(key);
        this.table[hash] = this.table[hash].filter(pair => pair[0] !== key);
    }

    get(key) {
        const hash = this.hashFunction(key);
        for (const pair of this.table[hash]) {
            if (pair[0] === key) {
                return pair[1];
            }
        }
        return -1; // Return -1 if the key does not exist
    }
}
