package Chapter15_DP;

public class maxArraySum {
    public static void test(int []a,int n){
    	/* �㷨˼·����ָoffer171ҳ��������ĵ�һ��Ԫ�ؿ�ʼ�ۼ� ����ۼӵ�sumΪ��������ô�ټ��Ϻ����������û��
    	 * �����һ��Ԫ�ص�ֵ��Ҳ��û�б�Ҫ�ټ���ǰ���Ԫ�غͣ����ֱ�ӽ�ǰ���ۼ�Ϊ�����ĺͶ���������Ԫ�ؿ�ʼ����
    	 * ����ۼ��������������Ƹ�sum ��max�Ƚ� �����max�����sum��ֵ��max Ȼ��sum�����ͺ����Ԫ���ۼ�
    	 * ������max�Ƚ�֪���ҵ����յ�max
    	 * ע�⣺������ȫΪ�����Լ�����Ϊ�յ����
    	 * ʱ�临�Ӷ�ΪO[n]
    	 */
    	int sum=0;//��ʾ�ۼӵĺ�
    	int max=0;//��ʾ���͵�ֵ
    	for(int i=0;i<n;i++){
    		if(sum>0){//���ڵ���0����
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
	    ���淽��,ʱ�临�Ӷ�O��n*n�� ������n*(n-1)/2
	    �ȴӵ�һ��Ԫ�ؿ�ʼ����ۼӣ� 
	    ÿ���ۼӺ���֮ǰ�ĺͱȽϣ��������ֵ�� 
	    �ٴӵڶ���Ԫ�ؿ�ʼ����ۼӣ��Դ����ơ� 
	    */  
        int i,j;  
        int MaxSum = 0;  
        //ÿ�ο�ʼ�ۼӵ���ʼλ�õ�ѭ��  
        for(i=0;i<len;i++)  
        {  
            int CurSum = 0;  
            //����ۼӵ�ѭ��  
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
{//���������е����ֵ
	int Max = a;
	if(b > Max)
		Max = b;
	if(c > Max)
		Max = c;
	return Max;
}
int MaxSubSum2(int *arr,int left,int right)
{   //�����㷨�����÷��β���
	int MaxLeftSum,MaxRightSum;	//���ұߵ�����
	int MaxLeftBorderSum,MaxRightBorderSum;	//���м�߽�����Ҳ�������
	int LeftBorderSum,RightBorderSum;	//���м�߽�����Ҳ��ֵ�ǰ��
	int i,center;
	//�ݹ鵽���Ļ������
	if(left == right)
		if(arr[left]>0)
			return arr[left];
		else
			return 0;
	//���м�߽�����Ҳ��ֵ����ֵ
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

	//�ݹ������Ҳ������ֵ
	MaxLeftSum = MaxSubSum2(arr,left,center);
	MaxRightSum = MaxSubSum2(arr,center+1,right);

	//���������е����ֵ
	return Max3(MaxLeftSum,MaxRightSum,MaxLeftBorderSum+MaxRightBorderSum);
}


int MaxSubSum2_1(int *arr,int len)
{//����֧����ʵ�ֵ��㷨��װ����
	return MaxSubSum2(arr,0,len-1);
}

 */
