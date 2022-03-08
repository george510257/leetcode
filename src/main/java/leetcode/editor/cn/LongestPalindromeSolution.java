package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4813 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromeSolution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int length1 = getMaxLength(s, i, i);
            int length2 = getMaxLength(s, i, i + 1);
            int length = Math.max(length1, length2);
            int start = i - (length - 1) / 2;
            int end = i + length / 2;
            str = max(str, s.substring(start, end + 1));
        }
        return str;
    }

    private static String max(String str1, String str2) {
        int length = Math.max(str1.length(), str2.length());
        if (length == str1.length()) {
            return str1;
        } else {
            return str2;
        }
    }

    private static int getMaxLength(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
