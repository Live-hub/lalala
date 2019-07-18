package D2;
import java.util.*;

public class B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s1 = null;
			String s2 = "abc";
			compare(s1,s2);
		}catch (NullPointerException e){
			e.printStackTrace();
		}
	}

	private static void compare(String s1, String s2) throws NullPointerException{
		// TODO Auto-generated method stub
		if (s1==null || s2==null) {
			System.out.println("1");
			throw new NullPointerException();
		}else {
			if (s1.equals(s2)) {
				System.out.println("2");
			}else {
				System.out.println("1");
			}
		}
	}
}
