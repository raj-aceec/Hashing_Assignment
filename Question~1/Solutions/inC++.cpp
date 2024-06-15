#include <iostream>
#include <unordered_map>
#include <algorithm>

bool areAnagrams(std::string str1, std::string str2) {
    std::unordered_map<char, int> charCountMap;

    for (char c : str1) {
        if (c != ' ') {
            charCountMap[std::tolower(c)]++;
        }
    }

    for (char c : str2) {
        if (c != ' ') {
            charCountMap[std::tolower(c)]--;
        }
    }

    for (auto count : charCountMap) {
        if (count.second != 0) {
            return false;
        }
    }
    return true;
}
