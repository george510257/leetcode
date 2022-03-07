package leetcode.editor.cn;
//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 131 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class ConvertToBase7Solution {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int absNum = Math.abs(num);
        StringBuilder stringBuilder = new StringBuilder();
        while (absNum > 0) {
            stringBuilder.append(absNum % 7);
            absNum = absNum / 7;
        }
        if (num < 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
