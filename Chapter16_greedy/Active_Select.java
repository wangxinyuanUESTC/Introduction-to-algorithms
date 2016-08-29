package Chapter16_greedy;
import java.util.ArrayList;
import java.util.TreeMap;
/*
 * ��һ�ַ������ü��� �ٶ�������ʱ�������״̬��    ��û����Ľ���ʱ��ͽ���ʱ����ӵ�TreeMap�� Ȼ��ӵ�һ��Ԫ�ؿ�ʼ�Ȱѵ�һ��Ԫ����ӵ����������Ȼ��ɾ��
 * �ӵ�һ��Ԫ�ؿ�ʼ��ɾ�����һ����ڶ�����Ϊ��һ������ʼ�Ƚϣ������ǰԪ�صĿ�ʼʱ��Ƚ���Ľ���ʱ������ɾ�������������ӵ����������
 * ����¼����ʱ�� Ȼ���TreeMap��ɾ��  ʱ�临�Ӷ�ΪO[n]
 */
public class Active_Select {
	static int str_mapvalue_time=0;                                  //��¼����Ҫ��Ŀ�ʼʱ��   ����Ҫ�þ�̬��
	static int end_mapkey_time=0;                                    //��¼����Ҫ��Ľ���ʱ��
    public static ArrayList<String> activSelect(TreeMap<Integer,Integer> map){
		ArrayList<String>result=new ArrayList<String>();
		add(map,result);
	    while(map.firstEntry()!=null){                                //���Ӵ�����Ҳ����
	    	if(map.get(map.firstKey())<end_mapkey_time)               //�����ʼʱ��С��ǰһ���Ľ���ʱ�� ɾ��
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
        map.put(4,1);                                       //��ΪҪ������ʱ������ ���԰ѽ���ʱ��ŵ�ǰ��
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
