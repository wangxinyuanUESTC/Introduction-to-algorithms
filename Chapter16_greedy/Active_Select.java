package Chapter16_greedy;
import java.util.ArrayList;
import java.util.TreeMap;
/*
 * 第一种方法利用集合 假定按结束时间升序的状态下    把没个活动的结束时间和结束时间添加到TreeMap中 然后从第一个元素开始先把第一个元素添加到结果集合中然后删除
 * 从第一个元素开始（删除后第一个后第二个变为第一个）开始比较，如果当前元素的开始时间比结果的结束时间早则删除，如果晚则添加到结果集合中
 * 并记录结束时间 然后从TreeMap中删除  时间复杂度为O[n]
 */
public class Active_Select {
	static int str_mapvalue_time=0;                                  //记录符合要求的开始时间   必须要用静态的
	static int end_mapkey_time=0;                                    //记录符合要求的结束时间
    public static ArrayList<String> activSelect(TreeMap<Integer,Integer> map){
		ArrayList<String>result=new ArrayList<String>();
		add(map,result);
	    while(map.firstEntry()!=null){                                //不加大括号也可以
	    	if(map.get(map.firstKey())<end_mapkey_time)               //如果开始时间小于前一个的结束时间 删除
	    		map.pollFirstEntry();
	    	else
	    		add(map,result);
	    }
    	return result;
    }
    public static void add(TreeMap<Integer,Integer> map,ArrayList<String> result){
		str_mapvalue_time=map.get(map.firstKey());            
		end_mapkey_time=map.firstKey();                       
		String res=""+str_mapvalue_time+"->"+end_mapkey_time;
		map.pollFirstEntry();
		result.add(res);                          
    }
	public static void main(String[] args) {
        TreeMap<Integer,Integer>map=new TreeMap<Integer,Integer>();
        map.put(4,1);                                       //因为要按结束时间排序 所以把结束时间放到前面
        map.put(5,3);
        map.put(6,0);
        map.put(7,5);
        map.put(9,3);
        map.put(9,5);
        map.put(10,6);
        map.put(11,8);
        map.put(12,8);
        map.put(14,2);
        map.put(16,12);
        System.out.println(activSelect(map)); 
        
	}

}
