/**
 * Created by jmebia on 2/2/17.
 */
import java.util.*;

public class Main {

    // method that contains all the main functions of the program
    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        // array list that will contain all the jobs
        ArrayList<Job> jobs = new ArrayList<>();

        int jobNo = 0; // number of jobs to be defined by the user

        // get number of jobs
        System.out.print("Enter number of jobs: ");
        jobNo = in.nextInt();

        // create all new jobs
        for (int i = 1; i <= jobNo; i++) {
            double hr, mins, sec, bt; // at is arrival time and bt is burst time
            System.out.println("Job #" + i);
            System.out.println("Arrival Time");
            System.out.print("Enter hours(AT): ");
            hr = in.nextDouble();
            System.out.print("Enter minutes(AT): ");
            mins = in.nextDouble();
            System.out.print("Enter seconds(AT): ");
            sec = in.nextDouble();
            System.out.print("Burst Time\nEnter minutes(BT): ");
            bt = in.nextDouble();
            jobs.add(new Job(i, hr, mins, sec, bt));
            System.out.println("Job #" + i + " added!" +
                    "\n-----------------------------\n");
        }

        System.out.println("Job #\tArrival Time\tBurst Time");

        // iterates over all the jobs in the array list
        for (Job j : jobs) {
            System.out.println(j.getNumber() + "\t" + j.getHours() + ":" + j.getMins() + ":" + j.getSecs() +
                    "\t" + j.getBurstTime());
        }

        // runs the FIFO method and throws the array list of jobs
        FIFO(jobs);
    }

    // procedure that displays
    private static void FIFO(ArrayList<Job> jobs) {

        double prevFinishTime = 0;

        // sorts the 'jobs' array list in ascending order
        Collections.sort(jobs);
        System.out.println(jobs);

        // displays table header
        System.out.println("Job#\tArrival Time\tBurst Time\tStarting Time");

        // iterates over all the jobs to for the FIFO
        for(Job job: jobs) {

            // displays the current job's status
            System.out.println( job.getNumber()+"\t"+job.getArrivalTime()+"\t"+job.getBurstTime()+"\t"
                    +(prevFinishTime==0? job.getArrivalTime():prevFinishTime) );

            // sets up finish time
            prevFinishTime += (prevFinishTime==0? job.getBurstTimeDec(1) + job.getArrivalTime()
                    : job.getBurstTimeDec(1));
        }
    }
}
