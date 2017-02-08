/**
 * Created by jmebia on 2/8/17.
 */
public class SJF extends Job implements Comparable<SJF> {

    // constructor
    public SJF(int jobNumber, double hr, double mins, double sec, double burst) {
        super(jobNumber, hr, mins, sec, burst);
    }

    // this method compares this object's burst time to another given object's burst time
    // and will return -1 if this' burst time is less than the burst time of the other object
    // and 1 if this' burst time is greater than the other
    @Override
    public int compareTo(SJF o) {
        int retVal = -1;

        if (this.getBurstTime() > o.getBurstTime())
            retVal = 1;

        return retVal;
    }
}
