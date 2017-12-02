package app;

import java.io.*;

public class SyncApp {

    public static void main(String args[]) {
        Callme target = new Callme();
        Caller obj1 = new Caller(target, "Welcome");
        Caller obj2 = new Caller(target, "to synchronized");
        Caller obj3 = new Caller(target, "world!");
        try {
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch(InterruptedException e) {
            System.out.println("interrupted!");
        }
    }

}

class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted!");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public Caller(Callme trg, String s) {
        target = trg;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    public void run() {
            synchronized(target) {
                target.call(msg);
            }

    }
}
