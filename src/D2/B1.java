package D2;

import java.util.Scanner;

public class B1 {
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    //题1
	    try {
		    Scanner scanner = new Scanner(System.in);
            String s1 = scanner.next();
            String s2 = scanner.next();
            int x, y;
            x = Integer.parseInt(s1);
            y = Integer.parseInt(s2);
            int z = 0;
		    z = x/y;
		    System.out.println(z);
	   }catch(NumberFormatException ne) {
           ne.printStackTrace();
	   }catch(ArithmeticException ae) {
		   ae.printStackTrace();
	   }
	    finally {
		    System.out.println("总是被执行");
	   }
    }
}
