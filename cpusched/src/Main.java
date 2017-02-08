/**
 * Created by jmebia on 2/2/17.
 */
import java.util.*;

public class Main {

    final static Scanner in = new Scanner(System.in);

    // method that contains all the main functions of the program
    public static void main(String[] args) {

        // stores user input
        int choice = 0;

        do {

            System.out.println("     _______.  ______  __    __   _______  _______   __    __   __       __  .__   __.   _______ \n" +
                    "    /       | /      ||  |  |  | |   ____||       \\ |  |  |  | |  |     |  | |  \\ |  |  /  _____|\n" +
                    "   |   (----`|  ,----'|  |__|  | |  |__   |  .--.  ||  |  |  | |  |     |  | |   \\|  | |  |  __  \n" +
                    "    \\   \\    |  |     |   __   | |   __|  |  |  |  ||  |  |  | |  |     |  | |  . `  | |  | |_ | \n" +
                    ".----)   |   |  `----.|  |  |  | |  |____ |  '--'  ||  `--'  | |  `----.|  | |  |\\   | |  |__| | \n" +
                    "|_______/     \\______||__|  |__| |_______||_______/  \\______/  |_______||__| |__| \\__|  \\______| ");

            System.out.print("[1] First In First Out\n[2] Shortest Jump First\n[0] Exit" +
                    "\nChoice: ");

            // sets the user's input to the 'choice' variable
            choice = in.nextInt();

            switch (choice) {

                case 1:

                    // displays title
                    System.out.println("\n" +
                            "\n" +
                            "     _______  __   _______   ______   \n" +
                            "    |   ____||  | |   ____| /  __  \\  \n" +
                            "    |  |__   |  | |  |__   |  |  |  | \n" +
                            "    |   __|  |  | |   __|  |  |  |  | \n" +
                            "    |  |     |  | |  |     |  `--'  | \n" +
                            "    |__|     |__| |__|      \\______/  \n" +
                            "                                      \n" +
                            "\n");

                    // runs the FIFO method
                    fifo();
                    break;

                case 2:

                    // displays title
                    System.out.println("\n" +
                            "\n" +
                            "         _______.       __   _______ \n" +
                            "        /       |      |  | |   ____|\n" +
                            "       |   (----`      |  | |  |__   \n" +
                            "        \\   \\    .--.  |  | |   __|  \n" +
                            "    .----)   |   |  `--'  | |  |     \n" +
                            "    |_______/     \\______/  |__|     \n" +
                            "                                     \n" +
                            "\n");

                    // runs the SJF method
                    sjf();
                    break;
            }
        } while (choice != 0);

    }

    // procedure that performs the First In First Out scheduling algorithm simulation
    private static void fifo() {

        // array list that will contain all the jobs
        ArrayList<FIFO> jobs = new ArrayList<>();

        // number of jobs to be defined by the user
        int jobNo = 0;

        // stores the last checked job's finnish time
        double prevFinishTime = 0;

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
            jobs.add(new FIFO(i, hr, mins, sec, bt));
            System.out.println("Job #" + i + " added!" +
                    "\n-----------------------------\n");
        }

        // displays table column titles
        System.out.println("Job #\tArrival Time\tBurst Time");

        // iterates over all the jobs in the array list
        for (FIFO j : jobs) {
            System.out.println(j.getNumber() + "\t" + j.getHours() + ":" + j.getMins() + ":" + j.getSecs() +
                    "\t" + j.getBurstTime());
        }

        // creates a new line for readability
        System.out.println("\n");

        // sorts the 'jobs' array list in ascending order
        Collections.sort(jobs);

        // displays table header
        System.out.println("Job#\tArrival Time\tBurst Time\tStarting Time\tFinish Time");

        // iterates over all the jobs to for the FIFO
        for(Job job: jobs) {

            // displays the current job's status; checks if the prevArrivalTime
            // is greater than the last arrival time, then it displays the
            // current arrival/finish time based on the result
            System.out.print( job.getNumber()+"\t"+job.getArrivalTime()+"\t"+job.getBurstTime()+"\t"
                    +(job.getArrivalTime() > prevFinishTime? job.getArrivalTime():prevFinishTime)
                    + "\t");

            // change the value of the finish time
            prevFinishTime = (prevFinishTime < job.getArrivalTime()?
                    job.getBurstTimeDec() + job.getArrivalTime()
                    : prevFinishTime + job.getBurstTimeDec());

            System.out.println(prevFinishTime);
        }

        // creates a new line for readability
        System.out.println("\n");

    }

    // procedure that performs the Shortest Jump First scheduling algorithm simulation
    private static void sjf() {
        // array list that will contain all the jobs
        ArrayList<SJF> jobs = new ArrayList<>();

        // number of jobs to be defined by the user
        int jobNo = 0;

        // stores the last checked job's finnish time
        double prevFinishTime = 0;

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
            jobs.add(new SJF(i, hr, mins, sec, bt));
            System.out.println("Job #" + i + " added!" +
                    "\n-----------------------------\n");
        }

        // displays table column titles
        System.out.println("Job #\tArrival Time\tBurst Time");

        // iterates over all the jobs in the array list
        for (SJF j : jobs) {
            System.out.println(j.getNumber() + "\t" + j.getHours() + ":" + j.getMins() + ":" + j.getSecs() +
                    "\t" + j.getBurstTime());
        }

        // creates a new line for readability
        System.out.println("\n");

        // displays table header
        System.out.println("Job#\tArrival Time\tBurst Time\tStarting Time");

        // finds the lowest arrival time first

        // sorts the 'jobs' array list in ascending order
        Collections.sort(jobs);

        // iterates over all the jobs for the lowest burst time
        for(Job job: jobs) {

            // displays the current job's status; checks if the prevArrivalTime
            // is greater than the last arrival time, then it displays the
            // current arrival/finish time based on the result
            System.out.print( job.getNumber()+"\t"+job.getArrivalTime()+"\t"+job.getBurstTime()+"\t"
                    +(job.getArrivalTime() > prevFinishTime? job.getArrivalTime():prevFinishTime) + "\t");

            // change the value of the finish time
            prevFinishTime = (prevFinishTime < job.getArrivalTime()?
                    job.getBurstTimeDec() + job.getArrivalTime()
                    : prevFinishTime + job.getBurstTimeDec());

            System.out.println(prevFinishTime);
        }

        // creates a new line for readability
        System.out.println("\n");

    }
}