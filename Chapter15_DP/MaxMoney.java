package Chapter15_DP;
/*
 * 锟捷癸拷锟斤拷止锟斤拷锟斤拷锟叫革拷锟斤拷锟斤拷锟斤拷锟斤拷锟襟化课憋拷206
 * 锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷锟街碉拷嵌锟接︼拷募鄹锟斤拷锟斤拷锟轿拷懈锟侥筹拷锟斤拷
 */
public class MaxMoney {   //只锟角递癸拷
    public static int  maxmoney(int a[],int n){
    	if(n==0)  //锟斤拷 n==0时锟斤拷始锟接匡拷始锟斤拷每锟街凤拷锟斤拷锟斤拷值
    		return 0;
    	int q=-1;//锟饺筹拷始锟斤拷一锟斤拷锟斤拷值锟斤拷锟斤拷锟斤拷一锟轿比斤拷 
    	for(int i=1;i<=n;i++){ //循锟斤拷 锟斤拷锟斤拷呖锟绞� 锟斤拷锟斤拷锟斤拷锟絠锟斤拷锟叫ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷  锟斤拷锟斤拷n-i锟阶递癸拷锟斤拷锟斤拷锟斤拷锟斤拷  然锟斤拷冉锟斤拷锟絥锟街凤拷锟斤拷 锟斤拷锟斤拷蠓桨锟�
    		q=Math.max(q, a[i]+maxmoney(a,n-i));
    	}
		return q;
    }
	public static int  maxmoney1(int a[],int n){ //锟斤拷态锟芥划  锟皆讹拷锟斤拷锟斤拷  
		int array[]=new int[n+1];
		for(int i=0;i<=n;i++){
            array[i]=-1;			
		}
		return maxmoney11(a,n,array);
	}
	public static int maxmoney11(int a[],int n,int []r){  //也锟矫碉拷锟捷癸拷  锟斤拷锟斤拷堑牡莨锟�
		int q;                //锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		if(r[n]>=0)           //锟斤拷锟絩[n]锟斤拷值为锟斤拷 说锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷丫锟斤拷锟斤拷  直锟接凤拷锟斤拷  锟劫递癸拷锟斤拷锟斤拷锟斤拷锟解即锟斤拷
			return r[n];
		if(n==0){             //锟捷癸拷锟斤拷始锟斤拷
		 q=0; 	              //锟斤拷n=0时 锟斤拷示锟斤拷卟锟斤拷锟�  锟斤拷叩锟斤拷锟斤拷锟揭诧拷锟斤拷锟�0  锟斤拷时锟斤拷r[0]也为0
		}else{
			q=-1;             //锟斤拷锟絩[n]为锟斤拷值  也锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷没锟斤拷锟斤拷锟斤拷锟�  锟斤拷锟矫递癸拷锟斤拷
			for(int i=1;i<=n;i++){
				q=Math.max(q, a[i]+maxmoney11(a,n-i,r));
			}
		}
		r[n]=q;               //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷娲拷锟絩[n]
		return q;
		
	} 
	public static int maxmoney2(int []a,int n){  //自底向上
		int q = -1;
		int r[]=new int[n+1];
		for(int i=0;i<=n;i++){
			r[i]=0;
		}
		for(int j=1;j<=n;j++){
			
			for(int k=1;k<=j;k++){
				q=Math.max(q, a[k]+r[j-k]);   //不用递归
			}
			r[j]=q;
		}
		return q; 	
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[]a={0,1,5,8,9,10,17,17,20,24,30};
	    int n=4;
	    int result=maxmoney(a,n);
	    System.out.println(result);
	    
	    int result1=maxmoney1(a,n);
	    System.out.println(result1);
	    
	    int result2=maxmoney2(a,n);
	    System.out.println(result2);
	}

}
