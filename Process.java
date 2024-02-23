public class Process {
    public int BurstTime=0;  // Burst time in the cpu
    public int turnArountTime=0;  // The time that the procces complate its execution
    public int responseTime=0; // The time from first requst to first response
    public int waittingTime=0; // BurstTime - turnArountTime;
    public String Q="";
/**
 * constructor
 * @param burst time to assign it to process burst time
 */
   public Process(int BurstTime) { // constructor will set the burst time from user and assign at to burst time
  this.BurstTime=BurstTime;
}


}
