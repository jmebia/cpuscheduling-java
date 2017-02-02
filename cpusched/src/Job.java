/**
 * Created by jmebia on 2/2/17.
 */

// a template for all the jobs to be inputted
class Job {
    private int jobNumber = 0;
    private double hr = 0, mins = 0, sec = 0, arrivalTime= 0, burstTime = 0;

    public Job(int jobNumber, double hr, double mins, double sec, double burst) {
        this.jobNumber = jobNumber;
        this.hr = hr;
        this. mins = mins;
        this.sec = sec;
        burstTime = burst;

        // solve for arrival time
        arrivalTime = hr + mins/60 + sec/3600;
    }

    int getNumber() {
        return jobNumber;
    }

    double getHours() {
        return hr;
    }

    double getMins() {
        return mins;
    }

    double getSecs() {
        return sec;
    }

    double getArrivalTimeDec() {
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

    double getBurstTime() {
        return burstTime;
    }

}
