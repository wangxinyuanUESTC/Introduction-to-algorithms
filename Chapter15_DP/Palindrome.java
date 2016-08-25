package Chapter15_DP;
/*
 * 求字符串的最大回文数，由中心向两边扩展法，时间复杂度为n*n
 * 只能找相邻的，不能查找相间的
 */
public class Palindrome {
	private static String longestPalindrome(String str){
		int n=str.length();
		if(str==""){
			return "";
		}
		String longest=str.substring(0, 1);//截取str中下�?0�?1的元素，并将截取的元素赋给longest
		for(int i=0;i<n-1;i++){
			String p1=expandAroundCenter(str,i,i);
			if(p1.length()>longest.length()){
				longest=p1;
			}
			String p2=expandAroundCenter(str,i,i+1);
			if(p2.length()>longest.length()){
				longest=p2;
			}
		}
		return longest;		
	}
	
	private static String expandAroundCenter(String str,int l,int r){
		int n=str.length();		
		while(l>=0&&r<=n-1&&str.charAt(l)==str.charAt(r)){
			l--;
			r++;
		}		
		
		return str.substring(l+1, r);		
	}
	public static void main(String[] args){
		String str="djdslkAABCDEAfjdl1234321skjflkdsjfkldsababasdlkfjsdwieowowwpw";
		String s=longestPalindrome(str);
		System.out.println(s);
		
	}
}
