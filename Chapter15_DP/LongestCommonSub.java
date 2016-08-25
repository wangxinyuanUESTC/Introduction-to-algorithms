package Chapter15_DP;
/*
 * 用动态规划的方法求最大回文子串 时间复杂度为O[mn] 只建立了一个二维数组
 * http://www.voidcn.com/blog/fjssharpsword/article/p-6104035.html
 */
public class LongestCommonSub {
	// 假如返回两个字符串的最长公共子序列的长度
		public static int[][] longestCommonSubsequence(String str1, String str2) {
	        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];//建立二维矩阵
	        // 填充矩阵
	        for (int i = 1; i <= str1.length(); i++) {
	                for (int j = 1; j <= str2.length(); j++) {
	                        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	                                matrix[i][j] = matrix[i - 1][j - 1] + 1;
	                        } else {
	                                matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j]
	                                                : matrix[i][j - 1]);
	                        }
	                }
	        }
	        return matrix;
		}
		//根据矩阵输出LCS
		public static void print(int[][] opt, String X, String Y, int i, int j) {
	        if (i == 0 || j == 0) {
	                return;
	        }
	        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
	                print(opt, X, Y, i - 1, j - 1);
	                System.out.print(X.charAt(i - 1));
	        } else if (opt[i - 1][j] >= opt[i][j]) { //注意加等号输出bcba不加等号输出BDAB都是对的
	                print(opt, X, Y, i - 1, j);
	        } else {
	                print(opt, X, Y, i, j - 1);
	        }
		}
		public static void main(String[] args) {
        // TODO Auto-generated method stub
			//如果是"DCBADCBA"则有四个最大子串  而这个程序只能输出ABA  有漏洞
        String str1 ="DCBADCBA" ;//"ABCBDAB";
        String str2 = "ABCDABCD";//"BDCABA";
        //计算lcs递归矩阵
        int[][] re = longestCommonSubsequence(str1, str2);
        //打印矩阵
        for (int i = 0; i <= str1.length(); i++) {
                for (int j = 0; j <= str2.length(); j++) {
                        System.out.print(re[i][j] + " ");
                }
                System.out.println();
        }
        //输出LCS
        print(re, str1, str2, str1.length(), str2.length());
	}

	

}