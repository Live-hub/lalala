package W2D1;

public class PrimeNumber {
    private Integer mutex = 1;
    private static int num = 0;
    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        Thread1 t1 = pn.new Thread1(2, 1000);
        Thread1 t2 = pn.new Thread1(1000, 2000);
        Thread1 t3 = pn.new Thread1(2000, 3000);
        //规定每个线程进行的上下限，满足了题目要求
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("共有"+num+"个素数");
    }
    class Thread1 extends Thread {
    	//三个线程皆可调用
        private int start;
        private int end;
        public Thread1(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public void start() {
			// TODO Auto-generated method stub
			
		}
		public void run() {
            for (int i = start + 1; i < end; i++) {
                synchronized (mutex) {
                	//加锁的目的是防止算重。
                    int flag = 1;
                    for (int j = 2; j <= Math.ceil(Math.sqrt(i));/*对i进行开平方并取整*/ j++) {
                        if (i % j == 0) {
                            flag = 0;
                        }
                    }
                    if (flag == 1) {
                    	//运用Flag，巧妙选取素数，避免了用for循环一个个除不好提取结果的尴尬
                        num++;
                        System.out.println(i + "是素数");
                    }
                }
            }
        }
    }
}
