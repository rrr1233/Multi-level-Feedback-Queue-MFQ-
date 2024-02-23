import java.util.Scanner;


public class OS_Project {


    public static void main(String[] args) {
 
        int processNum = 0, x,num;
        double avg =0 , throughput= 0;
 
        // promot to take the processes number 
        System.out.println("-------------------------------WELCOME----------------------------------------");
        System.out.print("Enter how many process do you want: ");
         processNum =isNumViald();
         Process P[] =new Process[processNum];
         int[] BurstTimeCopy=new int[processNum];

       // Take the burst time for each process
      for (int i =0; i<processNum;i++){
       System.out.print("Enter the burst time for process "+ (i+1)+": ");
       x = isNumViald();
       P[i]=new Process(x);
       } 
      
      // Make copy from burst time to use it in calculation
        for(int i=0;i<P.length;i++) {
         BurstTimeCopy[i]=P[i].BurstTime;
       }
        
        // Call the queues
       MFQ test=new MFQ(P);
       test.RR1();
       test.RR2();
       test.FCFS();
       
       
       
        System.out.println("P\t WT\t RT\t TT\t BT \t Q");
         for (int i =0; i<processNum;i++){
          P[i].waittingTime = P[i].turnArountTime - BurstTimeCopy[i] ;
     System.out.println("P"+(i+1)+"\t "+P[i].waittingTime +"\t "+P[i].responseTime+"\t "+ P[i].turnArountTime+"\t "+BurstTimeCopy[i]+
             "\t "+P[i].Q);
     avg+=P[i].waittingTime;
     throughput+=P[i].turnArountTime;
      }
         
         
        avg = avg / processNum; // calculate the average waiting time
        throughput = throughput / processNum; // calculate the throughput 
 
     System.out.printf("The Avarge Waitting Time is : %.2f \n" ,avg); 
     System.out.printf("The Throughput is : %.2f \n" ,throughput);
     System.out.println("Total time: "+test.timer);
     System.out.print("Enter the time you want to see how many processes have been executed: "); 
     num =isNumViald();
     System.out.println("The Number of process is: "+test.Report(num)); 
        
        
    
    
        }
    /**
 * Validation method
 * @return non zero number
 */
    public static int isNumViald() {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        while(n<=0) {
            System.out.print("Invild number..\nThe number should be larger then 0\nRetry: ");
            n = scan.nextInt();
            System.out.println();
        }
        
        return n;
    }
    
}
