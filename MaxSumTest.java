/* Jason Ivey
* 2017
*
* Probably the worst program I have ever written....
*/


import java.util.Random;
public class MaxSumTest{
  
  private static final boolean DEBUG = false;
  
  public static void main(String args[]){
    
    if (DEBUG) System.out.println("Called for:  " + args[0] + " : " + args[1]);
    //I would write handlers to stop crash and burn.... but, meh....
    int lengthOfArray = Integer.parseInt(args[0]);
    int numberOfTests = Integer.parseInt(args[1]);
    if (DEBUG) System.out.println("lengthOfArray = " + lengthOfArray + " Numbers of tests = " + numberOfTests);
    
    int[] array = randomGen(lengthOfArray);
    
    Stopwatch timer = new Stopwatch();
    
    double[] accum = new double[3];
    accum[ 0 ] = 0.0;
    accum[ 1 ] = 0.0;
    accum[ 2 ] = 0.0; //accum stand for accumulator
    
    for( int iteration = 0; iteration < numberOfTests; iteration++  ){
      if (DEBUG) System.out.print("Loop " + iteration + " ");
      timer.setTime();
      int maxSum = maxSum(array, lengthOfArray);
      accum[ 0 ] += timer.getTime();
      if (DEBUG) System.out.print("Accum0 = " + accum[ 0 ] + " ");
      timer.setTime();
      maxSum += maxSumQ(array, lengthOfArray);
      accum[ 1 ] += timer.getTime();
      if (DEBUG) System.out.print("Accum1 = " + accum[ 1 ] + " ");
      timer.setTime();
      maxSum += maxSumK(array, lengthOfArray);
      accum[ 2 ] += timer.getTime();
      if (DEBUG) System.out.println("Accum2 = " + accum[ 2 ] + " ");
      
    } System.out.println(accum[0] / numberOfTests + " " + accum[1] / numberOfTests + " " + accum[2] / numberOfTests);
  }
  
  public static int[] randomGen(int n){
    if (DEBUG) System.out.println("Random gen = " + n + " ");
    int[] result = new int[n];
    Random rand = new Random();
    
    for(int x = 0; x < n; x++){
      
      result[x] = rand.nextInt(500) + 1;
      if (DEBUG) System.out.println("Random Loop " + x + " : " + result[x]);
    }
    
    return result; 
  }
  
  
  public static int maxSumK(int a[], int n)
  {
    int maxSum = 0,sum = 0;
    int i;
    for(i = 0;i<n;i++)
    {
      
      sum = sum + a[i];
      if(sum < 0)
        sum = 0;
      else if(sum > maxSum)
        maxSum = sum;
      if (DEBUG) System.out.println("maxSumK Loop " + i + " : " + maxSum);
    }
    return maxSum;
  }
  
  
  
  public static int maxSumQ(int a[],int n )
  {
    int i,j,sum,maxSum;
    maxSum = 0;
    for(i = 0;i<n;i++)
    {
      sum = 0;
      for(j=i;j<n;j++)
      {
        sum = sum + a[j];
        if(sum>maxSum)
          maxSum = sum;
      }
      if (DEBUG) System.out.println("maxSumQ Loop " + i + " : " + maxSum);
    }
    return maxSum;
  }
  
  
  
  public static int maxSum(int a[],int n)
  {
    int i,j,k;
    int sum,maxSum = 0;
    for(i=0; i<n; i++)
    {
      for(j=i; j<n; j++)
      {
        sum = 0;
        for(k=i ; k<j; k++)
        {
          sum = sum + a[k];
        }
        if(sum>maxSum)
          maxSum = sum;
      }
      if (DEBUG) System.out.println("maxSum Loop " + i + " : " + maxSum);
    }
    return maxSum;
  } 
}