package Chapter15_DP;
/*
 * 删除几个元素成回文字符串功能
 * 没写�?
 */
public class Palindrome3 {
   public void huiwen(String[] str){
	  
	   for(int i=0;i<str.length;i++){
		   String s1=str[i];
		   StringBuffer s2 = new StringBuffer(s1);
		   s2.reverse(); //反转字符�?
		   int m=0;
		  System.out.println(s2);
		   
		   }
		   
	   }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome3 hw=new Palindrome3();
		String string[]={"abcdef","cdefg"};
		hw.huiwen(string);
	}

}
