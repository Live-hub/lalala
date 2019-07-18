package D2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//题1
		List l = new LinkedList();
		for (int i=1;i<=5;i++) {
			l.add(i);
		}
		System.out.println(l);
		l.add(4,null);
		System.out.println(l);
		Object b = l.get(2);
		System.out.println(b);
	    if(l.isEmpty()) ;
		//题2
		List a = new ArrayList(5);
		a.add(0,"1");
		a.add(1,"5");
		a.add(2,"3");
		a.add(3,"2");
		a.add(4,"4");
		for(int i=0;i<5;i++) {
			for(int j=0;j<a.size()-i-1;j++) {
				int x = Integer.parseInt(String.valueOf(a.get(j)));
				int y = Integer.parseInt(String.valueOf(a.get(j+1)));
				if (x>y) {
					a.set(j, y);
					a.set(j+1, x);
					}
				}
		}//ArrayList中的选择排序法。
		System.out.println(a);
		//题3
        LinkedList<String> link = new LinkedList<String>();
        
        link.add("apple");
        link.add("grape");
        link.add("banana");
        link.add("pear");
        System.out.println("最大的元素为"+Collections.max(link));
        System.out.println("最小的元素为"+Collections.min(link));
        
        Collections.sort(link);
        for(String s :link){
            System.out.println(s);
        }
		
	}
}
