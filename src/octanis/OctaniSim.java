package octanis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sam on 06/06/14.
 */
public class OctaniSim {

    public final String WORKING_DIR = "/Applications/Hysplit4/working";
    public final String GDAS_DIR = WORKING_DIR + "/gdas";

    public final int TOP_OF_MODEL_DOMAIN = 35000;
    public final int VERTICAL_MOTION = 4;


    //simulation runs for a fixed latitude per iteration, where LLDist is the distance from the last lat/lon component in degrees
    //TimeInterval is in hours
    public void run(Date StartDate, Date EndDate, long TimeInterval, int[][] AltSet, int StartLong, int StopLong, int StartLat, int StartLon, int LLDist){

        //iterate date
        for(long SimDateTime=StartDate.getTime();SimDateTime<EndDate.getTime();SimDateTime=SimDateTime+TimeInterval*1000*3600){


            //iterate lat
            for () {
                //iterate lon
                for() {
                    //iterate altitude sets
                    OctaniControl.createControl();
                }
            }

        }

    }

}
