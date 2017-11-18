package dealenx.gui;

class  MyThread2 implements Runnable{
    String name;
    public MyThread2(String name){
        super(name);
    }
    public void run(){  //вызвать start в main, он вызывает run
      for (int i = 0;i <=5 ;i++ ) {
        try {
          t.sleep(1000);
          System.out.println("Main: "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
    }

}
