/**
 * Created by jmebia on 2/8/17.
 */
public class FIFO extends Job implements Comparable<FIFO> {

    public FIFO(int jobNumber, double hr, double mins, double sec, double burst) {
        super(jobNumber, hr, mins, sec, burst);
    }

    // this method compares this object's arrival time to another given object's arrival time
    // and will return -1 if this' arrival time is less than the arrival time of the other object
    // and 1 if this' arrival time is greater than the other
    @Override
    public int compareTo(FIFO o) {
        int retVal = -1;

        if (this.getArrivalTime() > o.getArrivalTime())
            retVal = 1;

        return retVal;
    }

}
