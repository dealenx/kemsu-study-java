package app;
import app.example.*;

public class ThreadApp {

	public static void main(String[] args) {
		/*MyThread2 t = new MyThread2("Test");
		t.start();*/

		Runnable r = new MyThread2("thread2");
		Thread t3 = new Thread(r);
		t3.start();
	}
}
