package leetcode.editor.cn;
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 2162 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class MinDistanceSolution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }

        int[][] temp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    temp[i][j] = j;
                } else if (j == 0) {
                    temp[i][j] = i;
                } else if ((word1.charAt(i - 1) != word2.charAt(j - 1))) {
                    temp[i][j] = Math.min(temp[i - 1][j], Math.min(temp[i][j - 1], temp[i - 1][j - 1])) + 1;
                } else {
                    temp[i][j] = Math.min(temp[i - 1][j], Math.min(temp[i][j - 1], temp[i - 1][j - 1] - 1)) + 1;
                }
            }
        }
        return temp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
