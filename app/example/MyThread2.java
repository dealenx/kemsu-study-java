package app.example;

class  MyThread2 extends Thread{
    String name;
    public MyThread2(String name){
        super(name);
    }
    public void run(){  //вызвать start в main, он вызывает run
      for (int i = 0;i <=5 ;i++ ) {
        try {
          sleep(1000);
          System.out.println("Main: "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
    }

}
