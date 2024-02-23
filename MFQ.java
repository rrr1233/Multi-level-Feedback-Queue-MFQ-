public class MFQ {
    public int timer=0; // Timer to keep track processes
    public Process[] a; // array of process 
    
    public MFQ(Process[] array) {
      a=array; // assign the array taken from the user to a
    }
    /**
    * Q0
    * This algorithm will let the process enter the CPU for 8ms then interrupt it
     */
    public void RR1() { // First round roben with quantum 8
        for(int i=0; i<a.length; i++) {
           
                a[i].responseTime=timer; // first respose to the requst
            
            if(a[i].BurstTime<=8) { // check if the burst time less than or equal 8 to not cause logic error
                timer+=a[i].BurstTime; // increase the timer: timer = timer + a[i].BurstTime
                a[i].turnArountTime=timer; // the complation time = timer when the process burst is finish
                a[i].BurstTime=0; // process bursttime=0 that means we don't have to make the process enter again
                a[i].Q="Q0";
                continue; // continue to another process
            }
                  // else
            a[i].BurstTime-=8; // decrease the burst time by 8
            timer+=8; // increase the timer by 8
        }
               
        
        // Now we finish the first RR with quantum 8 and we are going to move the rest of processes to Q1
        
            } // End method
   
    
           /**
    * Q1
    * This algorithm will let the process enter the CPU for 16ms then interrupt it
     */
        public void RR2() {
        for(int i=0; i<a.length; i++) {
            if(a[i].BurstTime==0) // Does the process complate its execution in Q0? skip it!!!
                continue;

            if(a[i].BurstTime<=16) { // check if the burst time less than or equal 16 to not cause logic error
                timer+=a[i].BurstTime; // increase the timer: timer = timer + a[i].BurstTime
                a[i].turnArountTime=timer; // the complation time = timer when the process burst is finish
                a[i].BurstTime=0; // process bursttime=0 that means we don't have to make the process enter again
                a[i].Q="Q1";
                continue; // continue to another process
            }
                  // else
            a[i].BurstTime-=16; // decrease the burst time by 16
            timer+=16; // increase the timer by 16
        }
               
        
        // Now we finish the first RR with quantum 16 and we are going to move the rest of processes to Q2    
            } // End method
            
        
    /**
    * Q2
    * This algorithm will let the process enter the CPU to end their burst time
     */
          public void FCFS() {
              // The rest of processes will finish their burst time here
              
              for(int i=0;i<a.length;i++) {
                  if(a[i].BurstTime==0) // Does the process complate its execution in Q0 or Q1? skip it!!!
                      continue;
                  timer+=a[i].BurstTime;
                  a[i].BurstTime=0;
                  a[i].turnArountTime=timer;
                  a[i].Q="Q2";
              }
              
              
          } // End method
            
          
     /**
    * This method report to the user how many processes end their execution at specific time
    * @Param int time from the user
    * @return number of processes that end their execution from the start to the time that user wants
     */
          public int Report(int time) {
              int n=0;
              
              for(int i=0; i<a.length ; i++) {
                  if(a[i].BurstTime==0 && a[i].turnArountTime<=time)
                      n++;
              }
              
              
              return n;
          } // End 
            
    
} // End class
