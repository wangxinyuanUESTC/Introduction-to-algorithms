package Chapter15_DP;
/*
 * 求一个字符串的最大回文数，暴力法时间复杂度为n^3
 */

public class Palindrome2 {
	private static String longestPalindrome(String str){
		if(str==""){
			return "";
		}
		int n=str.length();
		int maxLength=-1;
		int beginIndex=0;
		int endIndex=0;		
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				int start=i;
				int end=j;	
				boolean flag=true;
				while(start<=end){					
					if(str.charAt(start)!=str.charAt(end)){
						flag=false;	
						break;//跳出while循环
					}
					start++;
					end--;
				}
				int tmpLength=j-i+1;
				if(flag&&tmpLength>maxLength){
					maxLength=tmpLength;
					beginIndex=i;
					endIndex=j+1;
				}
			}
		}
		return str.substring(beginIndex,endIndex);
	}
	
	public static void main(String[] args){
		String str="abcdefedab";
		String s=longestPalindrome(str);
		System.out.println(s);
	}
}