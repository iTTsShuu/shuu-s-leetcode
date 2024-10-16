/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

class Trie {

    char[] val;
    boolean isEnd;
    char[] next;

    public Trie() {
        this.val = new char[26];
        this.next = new char[26];
    }

    public void insert(String word) {
        char[] chs = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            node.next[ch-'a'].
        }
    }

    public boolean search(String word) {

    }

    public boolean startsWith(String prefix) {

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
