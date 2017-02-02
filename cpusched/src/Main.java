/**
 * Created by jmebia on 2/2/17.
 */
import java.util.*;

public class Main {

    private static ArrayList<Job> jobs = new ArrayList<>();

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        int jobNo;

        // get number of jobs
        System.out.print("Enter number of jobs: ");
        jobNo = in.nextInt();

        // create all new jobs
        for(int i = 1; i <= jobNo; i++ ) {
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
            jobs.add( new Job(i, hr, mins, sec, bt));
            System.out.println("Job #" + i + " added!"+
                    "\n-----------------------------\n");
        }

        // iterate over all jobs to display initial values
        System.out.println("Job #	Arrival Time	Burst Time");
        for (Job j : jobs) {
            System.out.println(j.getNumber() + "	" + j.getHours() + ":" + j.getMins() + ":" + j.getSecs() +
                    "	" + j.getBurstTime());
        }


        System.out.println("\n\nJob#	AT	BT	ST	FT	WT");

        Job currentLowestJob = null;
        Stack<Job> finishedJobs = new Stack<>();
        finishedJobs.push(new Job(999, 0, 0, 0, 0));

        // iterates over all the jobs to determine final output
        for (int i = jobNo; i > 0; i--) {
            for (Job j : jobs) {
                if (currentLowestJob != null) {
                    if (finishedJobs.peek().getNumber() != currentLowestJob.getNumber()) {
                        if (currentLowestJob.getArrivalTimeDec() > j.getArrivalTimeDec())
                            currentLowestJob = j;
                    }
                }
                else {
                    currentLowestJob = j;
                }
            }
            System.out.println(currentLowestJob.getNumber());
            finishedJobs.push(currentLowestJob);
            jobs.remove(currentLowestJob);
        }

    }
}


