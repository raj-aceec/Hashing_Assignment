function areAnagrams(str1, str2) {
    const charCountMap = new Map();

    for (const c of str1) {
        if (c !== ' ') {
            const char = c.toLowerCase();
            charCountMap.set(char, (charCountMap.get(char) || 0) + 1);
        }
    }

    for (const c of str2) {
        if (c !== ' ') {
            const char = c.toLowerCase();
            charCountMap.set(char, (charCountMap.get(char) || 0) - 1);
        }
    }

    for (const count of charCountMap.values()) {
        if (count !== 0) {
            return false;
        }
    }

    return true;
}

