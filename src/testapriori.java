import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class testapriori{
    double minsup=0.6;//最小支持度
    double minconf=0.2;//最小置信度
    int item_counts=0;//候选1项目集大小,即字母的个数
    int frequent_top;
    HashMap rule=new HashMap();
    String trans_set[]={"邓镭 丁兆云 九鸣","邓镭 丁兆云 九鸣","邓镭 九鸣 你好 人民","丁兆云 九鸣 你好 中国","邓镭 丁兆云 九鸣 你好","邓镭 丁兆云 九鸣 你好 中国"};//事务集
    TreeSet[] frequent_set=new TreeSet[10];//频繁项集数组，[0]:代表1频繁集...
    TreeSet max_frequent=new TreeSet(new CollatorComparator());//最大频繁集
    TreeSet item1_canditate=new TreeSet(new CollatorComparator());//1候选集
    TreeSet canditate_set[]=new TreeSet[10];//候选集数组    
    
    
    
    public testapriori(){
        max_frequent=new TreeSet(new CollatorComparator());
        item_counts=counts();
        //frequent_set[]=new TreeSet[3];
        //frequent_set[]=new TreeSet[item_counts];
        for(int i=0;i<item_counts+1;i++){    
            frequent_set[i]=new TreeSet(new CollatorComparator());
            canditate_set[i]=new TreeSet(new CollatorComparator());
        }
        //System.out.println(frequent_set[0].size());
        canditate_set[0]=item1_canditate;
    }
    
    public class CollatorComparator implements Comparator {
    	Collator collator = Collator.getInstance();
    	public int compare(Object element1, Object element2) {
    		CollationKey key1 = collator.getCollationKey(element1.toString());
    		CollationKey key2 = collator.getCollationKey(element2.toString());
    		return key1.compareTo(key2);
    	}
    }
    //计算1候选集个数
    public int counts(){
		 
		 for(int i = 0;i<trans_set.length;i++){
				String Tem_Set = trans_set[i];					
				String [] Tem_keyword = Tem_Set.split(" ");
				for (int j = 0; j < Tem_keyword.length; j++) {					
					item1_canditate.add(Tem_keyword[j]+" ");
				} 
		 }
		 return item1_canditate.size();
	}
    
    //计算项目集支持度
    double count_sup(String x){
        int temp=0;
        for(int i = 0;i<trans_set.length;i++){
        	String Tem_Set = trans_set[i];			
			String [] Tem_keyword = x.split(" ");
			boolean tem_var = true;
			for (int j = 0; j < Tem_keyword.length; j++) {
				tem_var = tem_var && Tem_Set.contains(Tem_keyword[j]);
				if(tem_var == false)break;
			}
			if(tem_var == true) temp ++;
        }
        return temp;
    }
    
    //构造1候选集合＆频繁集
    public void item1_gen(){
        String temp1="";
        double m=0;
        Iterator temp=canditate_set[0].iterator();
        while(temp.hasNext()){
            temp1=(String)temp.next();	            
            m=count_sup(temp1);
            if(m>=minsup*trans_set.length){	            	
                frequent_set[0].add(temp1);
            }    
        }
    }
    
    //由k频繁集和1频繁集生成k+1候选集
    public void canditate_gen(int k){
        String y="",z="",m="";
        char c1='a',c2='a';
        Collator collator = Collator.getInstance();
        Iterator temp1=frequent_set[k-2].iterator();
        Iterator temp2=frequent_set[0].iterator();
        TreeSet h=new TreeSet(new CollatorComparator());	        
        while(temp1.hasNext()){
            y=(String)temp1.next();
            String [] Tem_keyword = y.split(" ");
            CollationKey key1 = collator.getCollationKey(
            		Tem_keyword[Tem_keyword.length-1].toString());	              
            while(temp2.hasNext()){
                z=(String)temp2.next();  	              
                String [] Tem_keyword1 = z.split(" ");
	            CollationKey key2 = collator.getCollationKey(
	            		Tem_keyword1[0].toString());
                if(key1.compareTo(key2)>=0) 
                    continue;
                else{
                    m=y+z;	                 
                    h.add(m);
                    }
            }
            temp2=frequent_set[0].iterator();
        }
        canditate_set[k-1]=h;
    }
    
    //k候选集=>k频繁集
    public void frequent_gen(int k){
        String s1="";
        Iterator ix=canditate_set[k-1].iterator();
        while(ix.hasNext()){
            s1=(String)ix.next();	            
            if(count_sup(s1)>=(minsup*trans_set.length)){
                frequent_set[k-1].add(s1);
            }
        }
    }
    
    public boolean is_frequent_empty(int k){	    	
        if(frequent_set[k-1].isEmpty())
            return true;
        else
            return false;
    }

    public boolean included(String s1,String s2){
    	String [] Tem_s = s1.split(" ");
        for(int i=0;i<Tem_s.length;i++){
            if(!s2.contains(Tem_s[i]))
                return false;
            else
                if(i==Tem_s.length-1)
                    return true;
        }
        return true;
    }
    //该类函数复杂度过高，有待改进算法！！
    public void maxfrequent_gen(){
        int i,j;
        Iterator iterator,iterator1,iterator2;
        String temp="",temp1="",temp2="";
        for(i=0;i<frequent_top;i++){
            max_frequent.addAll(frequent_set[i]);
        }
        for(i=0;i<frequent_top;i++){
            iterator1=frequent_set[i].iterator();
            while(iterator1.hasNext()){
                temp1=(String)iterator1.next();
                for(j=i+1;j<frequent_top;j++){	                    
                    iterator2=frequent_set[j].iterator();
                    while(iterator2.hasNext()){
                        temp2=(String)iterator2.next();
                        if(included(temp1,temp2))
                            max_frequent.remove(temp1);
                    }
                }    
            }    
        }
    }

    public void print_maxfrequent(){
        Iterator iterator=max_frequent.iterator();
        System.out.print("最大频繁项集：");
        while(iterator.hasNext()){
            System.out.print((String)iterator.next()+"\t");
        }
        System.out.println();
    }
    
    public void subGen(String s){
        String x="",y="";
        String [] Tem_s = s.split(" ");
        for(int i=1;i< (1<<Tem_s.length)-1;i++){
            for(int j=0;j<Tem_s.length;j++){
                if(((1<<j)&i)!=0){
                    x+=Tem_s[j]+" ";
                }
            }	            
            for(int j=0;j<Tem_s.length;j++){
                if(((1<<j)&(~i))!=0){	                    
                    y+=Tem_s[j]+" ";	               
                }
            }    	            
            if(count_sup(x+y)/count_sup(x)>=minconf){
                rule.put(x,y);
            }
            x="";y="";
            
        }
    }
    
    public void ruleGen(){
        String s;
        Iterator iterator=max_frequent.iterator();
        while(iterator.hasNext()){
            s=(String)iterator.next();
            subGen(s);
        }
    }
    
    public void rulePrint(){
        String x,y;
        double temp=0;
        Set hs=rule.keySet();
        Iterator iterator=hs.iterator();
        System.out.println("关联规则：");
        while(iterator.hasNext()){
            x=(String)iterator.next();
            y=(String)rule.get(x);
            temp=(count_sup(x+y)/count_sup(x));
            System.out.println(x+"==>"+y+"\t"+temp);
        }
    }
    
    public void run(){
        int k=1;         
        item1_gen();//产生第一个候选项
        do{
                k++;
                canditate_gen(k);
                frequent_gen(k);
        }while(!is_frequent_empty(k));
        frequent_top=k-1;
        print_canditate();
        maxfrequent_gen();
        print_maxfrequent();
        ruleGen();
        rulePrint();
  }
    
    public static void main(String [] args){
        testapriori x=new testapriori();
        x.run();
    }

    //for test
    void print1(){
        Iterator temp=canditate_set[0].iterator();
        while(temp.hasNext())
            System.out.println(temp.next());    
    } 
    //for test
    void print2(){
        Iterator temp=frequent_set[0].iterator();
        while(temp.hasNext())
            System.out.println((String)temp.next());
    }
    //for test
    void print3(){
        canditate_gen(1);
        frequent_gen(2);
        Iterator temp=canditate_set[1].iterator();
        Iterator temp1=frequent_set[1].iterator();
        while(temp.hasNext())
            System.out.println("候选"+(String)temp.next());
        while(temp1.hasNext())
            System.out.println("频繁"+(String)temp1.next());
    }
    
    void print_canditate(){
        
        for(int i=0;i<frequent_set[0].size();i++){
            Iterator ix=canditate_set[i].iterator();
            Iterator iy=frequent_set[i].iterator();
            System.out.print("候选集"+(i+1)+":");
            while(ix.hasNext()){
                System.out.print((String)ix.next()+"\t");
            }
            System.out.print("\n"+"频繁集"+(i+1)+":");
            while(iy.hasNext()){
                System.out.print((String)iy.next()+"\t");
            }
            System.out.println();
        }
    }   

/*    //main function for test
    public static void main(String [] args){
    myapriori run=new myapriori();
    run.item1_gen();
    run.print2();
    run.print3();
    }
*/

}