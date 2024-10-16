/*
 * @lc app=leetcode.cn id=1286 lang=java
 *
 * [1286] 字母组合迭代器
 */

// @lc code=start
class CombinationIterator {

    private String characters;
    private char[] charArray;
    private int start;
    private int combinationLength;

    public CombinationIterator(String characters, int combinationLength) {
        this.start = 0;
        this.characters = characters;
        this.charArray = characters.toCharArray();
        this.combinationLength = combinationLength;
    }

    public String next() {
        if (start + combinationLength - 1 < characters.length()) {
            return characters.substring(start++, start + combinationLength - 1);
        }
        return null;
    }

    public boolean hasNext() {
        System.out.println("hasNext:" + start);
        return start + combinationLength - 1 < characters.length();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters,
 * combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

/**
 * 1286.字母组合迭代器
 */
class asdasdasdasdaw {
    public static void main(String[] args) {
        CombinationIterator ci = new CombinationIterator("abc", 1);
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
    }

}