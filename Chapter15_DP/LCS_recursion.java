package Chapter15_DP;
public class LCS_recursion {
	 static char[]c1={'0','A','B','C','B','D','A','B'};
      static char[]c2={'1','B','D','C','A','B','A'};
	 static int  c[][]=new int[c1.length][c2.length];
    public int [][] lcsrecursion(int i,int j,char[]c1,char[]c2){
       if(i<=0||j<=0){
    	   return c;
       }
    	if(c1[i]==c2[j]){
    		return lcsrecursion(i-1,j-1,c1,c2);
    	}else{
    		return(c[i-1][j]>=c[i][j-1]?lcsrecursion(i-1,j,c1,c2):lcsrecursion(i,j-1,c1,c2));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    LCS_recursion lcs=new LCS_recursion();
    lcs.lcsrecursion(c1.length-1,c2.length-1,c1, c2);
//    for(int i=0;i<c1.length;i++){
//    	for(int j=0;j<c2.length;j++){
//    		System.out.print(n[i][j]+" ");
//    	}
    	System.out.println();
//    }
	}

}
