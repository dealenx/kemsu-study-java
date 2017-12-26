class Process implements Runnable{ 
  private volatile boolean isStopped = false;
  public void run() {
    while(!isStopped){
      System.out.println("Game thread is running....."); System.out.println("Game thread is now going to pause");
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {

        e.printStackTrace();
      }
      System.out.println("Game thread is now resumed ..");
    } System.out.println("Game thread is stopped...."); }
    public void stop(){
      isStopped = true;
    }
}
