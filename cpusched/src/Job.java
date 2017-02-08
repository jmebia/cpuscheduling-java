/**
 * Created by jmebia on 2/2/17.
 */

// a template for all the jobs to be inputted
class Job {

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
    double getBurstTimeDec() {
        return burstTime / 60;
    }

    // returns burst time
    double getBurstTime() {
        return burstTime;
    }

}
