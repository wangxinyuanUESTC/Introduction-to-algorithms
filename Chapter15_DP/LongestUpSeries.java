package Chapter15_DP;
import java.util.Arrays;
/*
 * �ö�̬�滮�ķ�����һ���ַ�����������Ӵ�  ���Լ����ʱ�临�Ӷ�ΪO[n*n/2]
 * ����˼�룺����һ��������ÿ��Ԫ��֮ǰС�ڴ�����ָ���Ԫ�صĸ���+1�� +1����ǰԪ�� 
 * ����"FGCBACFDKE"�������ֵΪ��[1, 2, 1, 1, 1, 2, 3, 3, 4, 4]
 * ���Ұ����һ���Ӵ���� 
 */
public class LongestUpSeries {
	   int maxlength=0;                                                                   //��������Ӵ�����
	   int maxlengthIndex=0;                                                              //��������Ӵ������һ��Ԫ�ص�����
	   public  void longestUpSeries(String s,int []a){
		   a[0]=1;                                        //��һ��Ԫ�ز��ñȽ�
		   for(int i=1;i<s.length();i++){                 //�ӵڶ���Ԫ�ؿ�ʼ�Ƚ�
			   if(s.charAt(i)>s.charAt(i-1))
				  a[i]=a[i-1]+1;
			   else{
				   int j=i-1;                             //�Ѿ���ǰ���һ���ȽϹ��� �����С�ڵ���ǰ�����  ����j--��ֻ�ú���ǰ��ıȽϾ�����
				   while(j>0&&s.charAt(i)<=s.charAt(j))
					   j--;
				   if(j==0&&s.charAt(i)<=s.charAt(j))     //��� ���͵�һ��Ԫ�رȽϹ�����С�ڵ�һ��Ԫ�� ��ôֱ�ӽ�a[i]==1
					   a[i]=1;
				   else
					   a[i]=a[j]+1;
			   }
			   if(maxlength<a[i]){                        //�����ѵ�һ����Ĵ���maxlength
				   maxlength=a[i];
			       maxlengthIndex=i;
			   }
		   }
		   System.out.println("��Ӵ�����Ϊ��"+maxlength+" ��Ӵ��ģ���һ�������һ��Ԫ��������"+maxlengthIndex+" Ԫ��Ϊ��"+s.charAt(maxlengthIndex));
	   }
	   public void serchIndex(int index,int maxlength,int []a,String s){                  //�õݹ�ķ��� ������Ӵ�  ������Ӵ������һ��Ԫ�ص���������ʼ
		   if(a[index]==1){
			   System.out.print(s.charAt(index)+" ");                                     //���a[index]=1��ʱ��Ѵ�������Ԫ�����
			   return;
		   }
		   if(a[index]<=maxlength){                                                       //���С��ǰ���ֵ �ݹ� Ȼ�����������ָ���Ԫ��
			   serchIndex(index-1,maxlength-1,a,s);
		       System.out.print(s.charAt(index)+" ");
		   }else
			   serchIndex(index-1,maxlength,a,s);                                         //�����С��ǰ���Ԫ��  ����󳤶ȱ��ֲ��� ֻ����ǰ�ݹ鼴��
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
