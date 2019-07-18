package W2D2;

import java.io.*;
import java.net.*;
import java.util.*;

public class TClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----客户端----");
		try {
			Socket s = new Socket("127.0.0.1",6666);
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			dos.writeUTF(str);
			dos.flush();
			System.out.println(dis.readUTF());
			dis.close();
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
