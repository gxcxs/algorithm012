//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1254 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", n, n);
        return res;
    }

    private void generateParenthesis(List<String> res, String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0)
            generateParenthesis(res, s + "(", left - 1, right);

        if (right > 0 && right > left)
            generateParenthesis(res, s + ")", left, right - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
