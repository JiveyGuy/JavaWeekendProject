public class Stopwatch { 
  
  private long start;
  
  /**
   * Initializes a new stopwatch.
   */
  public Stopwatch() {
    start = System.currentTimeMillis();
  } 
  
  
  /**
   * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
   *
   * @return elapsed CPU time (in seconds) since the stopwatch was created
   */
  public double getTime() {
    long now = System.currentTimeMillis();
    return (now - start) ;
  }
  
  public void setTime(){
    start = System.currentTimeMillis();
  }
}