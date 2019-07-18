package Week1;
import java.io.*;
import java.text.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) 
			throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		Company c = new Company();
		c.add(new Employee(1111,"张三"));
		c.add(new Employee(1112,"李四"));
		c.add(new Employee(1113,"王五"));
		int  input;

		while (true){
				System.out.println("----员工打卡系统----"+ "\n"
				             + "输入0--------退出" + "\n"
						     + "输入1--------签到" + "\n"
				             + "输入2--------签退" + "\n"
						     + "输入3--------查看签到信息" + "\n"
				             +"请输入想执行的操作：");
				Scanner s= new Scanner(System.in);
				input = Integer.parseInt(s.nextLine());
				
				if (input == 0) {
					System.out.println("退出");
					break;
				}else if (input ==1) {
					Company.Checkin();
				}else if (input==2) {
					Company.Checkout();
				}else if (input==3){
					Company.showAttendence();
				}else {
					System.out.println("Invalid choice:  " + input);
				}
		    } 
	}
	public static void saveData(Object obj) {
		FileOutputStream f = null;
		ObjectOutputStream o = null;
		try {
			f = new FileOutputStream("F:/Youxun/Install/dk.txt");
			o = new ObjectOutputStream(f);
			o.writeObject(obj);
			o.flush();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				if (f != null) {
					f.close();
				}
				if (o != null) {
					o.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
	

