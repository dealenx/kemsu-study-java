package app;


import java.awt.*;
import java.awt.event.*;


public class ThreadApp {

	public static void main(String[] args) {
		/*MyThread1 t = MyThread1("Text");
		t.start();*/
		Runnable r = new MyThread2("thread2");
		Thread t3 = new Thread(r);
		t3.start();

	}
}
