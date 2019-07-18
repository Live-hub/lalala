package W2D2;

import java.io.*;
import java.net.*;

public class Tserve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----服务器端----");
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			String str1 = dis.readUTF();	
			String[] arr1 =str1.split(" ");
			int[] arr2 = new int[arr1.length];
			for (int i=0;i<arr1.length;i++) {
				arr2[i] = Integer.valueOf(arr1[i]);
			}
			for (int x=0;x<arr1.length-1;x++) {
				for(int y=0;y<arr1.length-1;y++) {
					if (arr2[y]>arr2[y+1]) {
						int temp = arr2[y];
						arr2[y] = arr2[y+1];
						arr2[y+1] = temp;
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			String str2 = null;
			for (int j=0;j<arr1.length;j++) {
			    str2 = sb.append(arr2[j]+" ").toString();
			}
			String st = str2.substring(0,str2.length()-1);
			dos.writeUTF(st);
			dos.flush();
			dis.close();
			dos.close();
			s.close();
			ss.close();
			}catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}catch (IOException e) {
		        e.printStackTrace();
		    }
		

	}

}
