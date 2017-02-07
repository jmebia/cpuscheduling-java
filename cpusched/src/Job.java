/**
 * Created by jmebia on 2/2/17.
 */

// a template for all the jobs to be inputted
class Job implements Comparable<Job> {

    private int jobNumber = 0;

    private double hr = 0, mins = 0, sec = 0, arrivalTime= 0, burstTime = 0;

    // constructor
    public Job(int jobNumber, double hr, double mins, double sec, double burst) {
        this.jobNumber = jobNumber;
        this.hr = hr;
        this. mins = mins;
        this.sec = sec;
        burstTime = burst;

        // solve for arrival time
        arrivalTime = hr + mins/60 + sec/3600;
    }

    // returns the job number of this object
    int getNumber() {
        return jobNumber;
    }

    // returns the value of hours of this
    double getHours() {
        return hr;
    }

    // returns the value of minutes of this
    double getMins() {
        return mins;
    }

    // returns the value of seconds of this
    double getSecs() {
        return sec;
    }

    // returns the computed arrival time in hours format
    double getArrivalTime() {
        return arrivalTime;
    }

    // 0 is hours; 1 is minutes; 2 is seconds
    double getBurstTimeDec(int choice) {
        double retval = 0;
        switch(choice) {
            case 0:
                retval = hr;
                break;
            case 1:
                retval = mins / 60;
                break;
            case 2:
                retval = sec / 3600;
                break;
            default:
                System.out.print("Invalid input!");
        }
        return retval;
    }

    // returns burst time
    double getBurstTime() {
        return burstTime;
    }

    // this method compares this object's arrival time to another given object's arrival time
    // and will return -1 if this' arrival time is less than the arrival time of the other object
    // and 1 if this' arrival time is greater than the other
    @Override
    public int compareTo(Job o) {
        int retVal = -1;

        if (this.getArrivalTime() > o.getArrivalTime())
            retVal = 1;

        return retVal;
    }
}
