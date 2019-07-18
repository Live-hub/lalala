package D1;

public class A {
	//题1

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] argString = {"4","3"};
		int a = Integer.parseInt(argString[0]);
		int b = Integer.parseInt(argString[1]);
		int c = a + b;
		System.out.println(c);
	//题2
		
		String s = "delete";
		int num = 0;
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)== 'e') {
				num++;
			}
		}
		System.out.println("'e'出现的次数是" + num);
	//题3
		//法1
		
		int[] arr = new int[10];
		for(int i = 1;i <= 10;i ++) {

	    	arr[i-1] = (int)(Math.random()*101);

	    }
		for(int x=0;x<10;x++) {
			for(int y=0;y<arr.length-x-1;y++) {
				if (arr[y]>arr[y+1]) {
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
		for(int z=0; z<arr.length;z++) {
			System.out.println(arr[z]+" ");
		}//数组中的选择排序
	}

}

