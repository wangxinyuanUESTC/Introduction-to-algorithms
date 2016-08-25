package Chapter15_DP;
import java.util.Arrays;
/*
 * 用动态规划的方法求一个字符串的最长升序子串  可以间隔，时间复杂度为O[n*n/2]
 * 基本思想：定义一个数组存放每个元素之前小于此索引指向的元素的个数+1， +1代表当前元素 
 * 比如"FGCBACFDKE"则数组的值为：[1, 2, 1, 1, 1, 2, 3, 3, 4, 4]
 * 并且把最长的一个子串输出 
 */
public class LongestUpSeries {
	   int maxlength=0;                                                                   //最大升序子串长度
	   int maxlengthIndex=0;                                                              //最大升序子串的最后一个元素的索引
	   public  void longestUpSeries(String s,int []a){
		   a[0]=1;                                        //第一个元素不用比较
		   for(int i=1;i<s.length();i++){                 //从第二个元素开始比较
			   if(s.charAt(i)>s.charAt(i-1))
				  a[i]=a[i-1]+1;
			   else{
				   int j=i-1;                             //已经和前面的一个比较过了 结果试小于等于前面的数  所以j--，只用和再前面的比较就行了
				   while(j>0&&s.charAt(i)<=s.charAt(j))
					   j--;
				   if(j==0&&s.charAt(i)<=s.charAt(j))     //如果 当和第一个元素比较过后还是小于第一个元素 那么直接将a[i]==1
					   a[i]=1;
				   else
					   a[i]=a[j]+1;
			   }
			   if(maxlength<a[i]){                        //如果最把第一个最长的传给maxlength
				   maxlength=a[i];
			       maxlengthIndex=i;
			   }
		   }
		   System.out.println("最长子串长度为："+maxlength+" 最长子串的（第一个）最后一个元素索引："+maxlengthIndex+" 元素为："+s.charAt(maxlengthIndex));
	   }
	   public void serchIndex(int index,int maxlength,int []a,String s){                  //用递归的方法 求最大子串  从最大子串的最后一个元素的索引处开始
		   if(a[index]==1){
			   System.out.print(s.charAt(index)+" ");                                     //如果a[index]=1的时候把此索引的元素输出
			   return;
		   }
		   if(a[index]<=maxlength){                                                       //如果小于前面的值 递归 然后输出此索引指向的元素
			   serchIndex(index-1,maxlength-1,a,s);
		       System.out.print(s.charAt(index)+" ");
		   }else
			   serchIndex(index-1,maxlength,a,s);                                         //如果不小于前面的元素  则最大长度保持不变 只用往前递归即可
	   }
       public static void main(String args[]){
    	   LongestUpSeries l=new LongestUpSeries();
           String s="FGCBACFDKEKSDJFKFPOEOPEFJKKDLKJDKSJDAYUIWEPPOJDPSFJIOGHEOPOFKVNKX";	   
           int []a=new int[s.length()];
           l.longestUpSeries(s, a);
           System.out.println(Arrays.toString(a));
           char[]c=s.toCharArray();
           System.out.println(Arrays.toString(c));
           l.serchIndex(l.maxlengthIndex,l.maxlength, a,s);
       }
}
