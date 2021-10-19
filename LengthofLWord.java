class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastWord = s.lastIndexOf(" ") + 1;
        return s.length() - lastWord;
    }
}
