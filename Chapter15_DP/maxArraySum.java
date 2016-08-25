package Chapter15_DP;

public class maxArraySum {
    public static void test(int []a,int n){
    	/* 算法思路：剑指offer171页，从数组的第一个元素开始累加 如果累加到sum为负数，那么再加上后面的数反而没有
    	 * 后面的一个元素的值大，也就没有必要再加上前面的元素和，因此直接将前面累加为负数的和丢弃，从新元素开始记起
    	 * 如果累加是正数把它复制给sum 和max比较 如果比max大则把sum赋值给max 然后sum继续和后面的元素累加
    	 * 继续和max比较知道找到最终的max
    	 * 注意：当数组全为负数以及数组为空的情况
    	 * 时间复杂度为O[n]
    	 */
    	int sum=0;//表示累加的和
    	int max=0;//表示最大和的值
    	for(int i=0;i<n;i++){
    		if(sum>0){//大于等于0都行
    			sum=sum+a[i];
    		}else{
    			sum=a[i];
    		}
    		if(sum>max){
    			max=sum;
    		}
    	}
    	System.out.println(max);
    }
   public static int MaxSubSum1(int []arr,int len)  
    {  
	   /* 
	    常规方法,时间复杂度O（n*n） 具体是n*(n-1)/2
	    先从第一个元素开始向后累加， 
	    每次累加后与之前的和比较，保留最大值， 
	    再从第二个元素开始向后累加，以此类推。 
	    */  
        int i,j;  
        int MaxSum = 0;  
        //每次开始累加的起始位置的循环  
        for(i=0;i<len;i++)  
        {  
            int CurSum = 0;  
            //向后累加的循环  
            for(j=i;j<len;j++)  
            {  
                CurSum += arr[j];  
                if(CurSum > MaxSum)  
                    MaxSum = CurSum;  
            }  
        }  
        return MaxSum;  
    }  
    public static void main(String[] args) {
     int[]a={1,3,-3,4,7,-5,-10,9,4,-1,8};
     int n=11;
     test(a,11);
     System.out.println(MaxSubSum1(a,n));
	}
}
/*

int Max3(int a,int b,int c)
{//求三个数中的最大值
	int Max = a;
	if(b > Max)
		Max = b;
	if(c > Max)
		Max = c;
	return Max;
}
int MaxSubSum2(int *arr,int left,int right)
{   //次优算法，采用分治策略
	int MaxLeftSum,MaxRightSum;	//左右边的最大和
	int MaxLeftBorderSum,MaxRightBorderSum;	//含中间边界的左右部分最大和
	int LeftBorderSum,RightBorderSum;	//含中间边界的左右部分当前和
	int i,center;
	//递归到最后的基本情况
	if(left == right)
		if(arr[left]>0)
			return arr[left];
		else
			return 0;
	//求含中间边界的左右部分的最大值
	center = (left + right)/2;
	MaxLeftBorderSum = 0;
	LeftBorderSum = 0;
	for(i=center;i>=left;i--)
	{
		LeftBorderSum += arr[i];
		if(LeftBorderSum > MaxLeftBorderSum)
			MaxLeftBorderSum = LeftBorderSum;
	}
	MaxRightBorderSum = 0;
	RightBorderSum = 0;
	for(i=center+1;i<=right;i++)
	{
		RightBorderSum += arr[i];
		if(RightBorderSum > MaxRightBorderSum)
			MaxRightBorderSum = RightBorderSum;
	}

	//递归求左右部分最大值
	MaxLeftSum = MaxSubSum2(arr,left,center);
	MaxRightSum = MaxSubSum2(arr,center+1,right);

	//返回三者中的最大值
	return Max3(MaxLeftSum,MaxRightSum,MaxLeftBorderSum+MaxRightBorderSum);
}


int MaxSubSum2_1(int *arr,int len)
{//将分支策略实现的算法封装起来
	return MaxSubSum2(arr,0,len-1);
}

 */
