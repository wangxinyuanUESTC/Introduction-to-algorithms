package Chapter15_DP;
/*
 * �ö�̬�滮�ķ������������Ӵ� ʱ�临�Ӷ�ΪO[mn] ֻ������һ����ά����
 * http://www.voidcn.com/blog/fjssharpsword/article/p-6104035.html
 */
public class LongestCommonSub {
	// ���緵�������ַ���������������еĳ���
		public static int[][] longestCommonSubsequence(String str1, String str2) {
	        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];//������ά����
	        // ������
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
		//���ݾ������LCS
		public static void print(int[][] opt, String X, String Y, int i, int j) {
	        if (i == 0 || j == 0) {
	                return;
	        }
	        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
	                print(opt, X, Y, i - 1, j - 1);
	                System.out.print(X.charAt(i - 1));
	        } else if (opt[i - 1][j] >= opt[i][j]) { //ע��ӵȺ����bcba���ӵȺ����BDAB���ǶԵ�
	                print(opt, X, Y, i - 1, j);
	        } else {
	                print(opt, X, Y, i, j - 1);
	        }
		}
		public static void main(String[] args) {
        // TODO Auto-generated method stub
			//�����"DCBADCBA"�����ĸ�����Ӵ�  ���������ֻ�����ABA  ��©��
        String str1 ="DCBADCBA" ;//"ABCBDAB";
        String str2 = "ABCDABCD";//"BDCABA";
        //����lcs�ݹ����
        int[][] re = longestCommonSubsequence(str1, str2);
        //��ӡ����
        for (int i = 0; i <= str1.length(); i++) {
                for (int j = 0; j <= str2.length(); j++) {
                        System.out.print(re[i][j] + " ");
                }
                System.out.println();
        }
        //���LCS
        print(re, str1, str2, str1.length(), str2.length());
	}

	

}