package Week1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Company {
	public static List<Employee> el = new ArrayList<Employee>();
	public static Map<String,List<Dakalnfo>> m2 = new HashMap<>();
	
	public void add(Employee e){
		el.add(e);
		System.out.println("添加信息成功");
	}
	public void delete(Employee e) {
		el.remove(e);
		System.out.println("删除信息成功");
	}
	public  static Employee select(int Id) {
		int i1 = -1;
		int i2 = 0;
		for(Employee e: el) {
			i1 = i2;
			if (e.getId() == Id) {
				return el.get(i1);
			}
			i2++;
		}
		return null;
	}
	public static void show() {
		for (Map.Entry<String, List<Dakalnfo>> m: m2.entrySet()) {
			System.out.println("签到情况：" + ((Dakalnfo) m.getValue()).getId() + ((Dakalnfo) m.getValue()).getInDate() + ((Dakalnfo) m.getValue()).getOutDate());
		}
	}
	public static void Checkin() 
			throws NumberFormatException, IOException, ParseException {
		Date date = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String inDate = df1.format(date);
		String inTime = df2.format(date);
		System.out.println("请输入签到员工ID：");
		Scanner s = new Scanner(System.in);
		int i = Integer.parseInt(s.nextLine());
		List<Dakalnfo> Dk = null;
		/*if (!el.contains(i)) {
			System.out.println("无此员工ID");
			return;
		}*/
		if (!m2.containsKey(inDate)) {
			Dk = new ArrayList<>();
			Dakalnfo in = new Dakalnfo();
			in.setId(i);;
			in.setInDate(inTime);
			in.setOutDate("");
			Dk.add(in);
			((Map<String, List<Dakalnfo>>) m2).put(inDate,Dk);
			System.out.println("卡号：" + i + "打卡成功！");
			Main.saveData(m2);
		}else {
			Dk = m2.get(inDate);
			boolean a = false;
			for (Dakalnfo Dl : Dk) {
				if(Dl.getId() == i) {
					System.out.println("今天已经打过卡了");
					a = true;
					break;
				}
			}
			if (!a) {
				Dakalnfo Dl = new Dakalnfo();
				Dl.setId(i);
				Dl.setInDate(inTime);
				Dl.setOutDate("");
				Dk.add(Dl);
				((Map<String, List<Dakalnfo>>) m2).put(inDate,Dk);
				System.out.println("卡号：" + i + "打卡成功！");
				Main.saveData(m2);
			}
		}
	}
	public static void Checkout() 
			throws NumberFormatException, IOException, ParseException{
		Date date = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outDate = df1.format(date);
		String outTime = df2.format(date);
		System.out.println("请输入签退员工ID：");
		Scanner s = new Scanner(System.in);
		int i = Integer.parseInt(s.nextLine());
		/*if (!el.contains(i)) {
			System.out.println("无此ID员工");
			return;
		}*/
		List<Dakalnfo> Dk = m2.get(outDate);
		if (!m2.containsKey(outDate)) {
			System.out.println("卡号：" + i + "今天没有签到，无法签退");
		}
		else {
			boolean a = false;
			for (Dakalnfo Dl : Dk) {
				if(Dl.getId() == i) {
					Dl.setOutDate(outTime);
					a = true;
					break;
				}
			}
			if (!a) {
				System.out.println("卡号：" + i + "今天没有签到，无法签退");
			}else {
				Main.saveData(m2);
				System.out.println("卡号：" + i + "签退成功");
			}
	    }	
     }
	public static void showAttendence() {
 		Date d =new Date();
 		String s = new SimpleDateFormat("yyyy-MM-dd").format(d);
 		List<Dakalnfo> Dk = m2.get(s);
 		if (Dk != null && Dk.isEmpty() == false) {
 			for (Dakalnfo Dl: Dk) {
 				int Id = Dl.getId();
 				Employee e = Company.select(Id);
 				System.out.println("工号是：" + e.getId() + "姓名：" + e.getName());
 				System.out.println("签到时间为：" +Dl.getInDate());
 				try {
 					System.out.println("签退时间为：" + Dl.getOutDate());
 				}catch (NullPointerException e1){
 					System.out.println("签退时间为：无记录");
 				}
 			}
 		}else {
 			System.out.println("今天暂时没有打卡信息");
 		}
 	}
}
