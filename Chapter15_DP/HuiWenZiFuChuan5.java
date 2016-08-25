package Chapter15_DP;
import java.util.Scanner;
/*
 * 用动态规划求�?大回文子�?
 */
public class HuiWenZiFuChuan5 {
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
     
    while(scan.hasNext()) {
        String s = scan.nextLine();
        System.out.println(s);
        int len = lenghOfLCS(s, new StringBuffer(s).reverse().toString());
        System.out.println(s.length() - len);
    }
    scan.close();
}

//动�?�规划求�?长公共子序列的长�?
public static int lenghOfLCS(String s1, String s2) {
    char[] ch1 = s1.toCharArray();
    char[] ch2 = s2.toCharArray();
     
    int n1 = s1.length();
    int n2 = s2.length();
    int[][] table = new int[n1][n2];//�?有元素默认初始化�?0
     
    if(ch1[0] == ch2[0]) table[0][0] = 1;
     
    //单独计算s2与s1首字母之间的的LCS长度
    for(int i = 1; i < n2; ++i) {
        if(ch1[0] == ch2[i])
            table[0][i] = 1;
        else
            table[0][i] = table[0][i-1];
    }
     
    //单独计算s1与s2首字母之间的LCS长度
    for(int i = 1; i < n1; ++i) {
        if(ch2[0] == ch1[i])
            table[i][0] = 1;
        else
            table[i][0] = table[i-1][0];
    }
     
    //递推求解各个字符处的LCS
    for(int i = 1; i < n1; ++i) {
        for(int j = 1; j < n2; ++j) {
            if(ch1[i] == ch2[j]) {
                table[i][j] = table[i-1][j-1] + 1;
            }else
                table[i][j] = table[i-1][j] > table[i][j-1] ? table[i-1][j] : table[i][j-1];
        }
    }

    return table[n1-1][n2-1];
}
}