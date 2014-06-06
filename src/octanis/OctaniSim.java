package octanis;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sam on 06/06/14.
 */
public class OctaniSim {

    public final static String WORKING_DIR = "/Applications/Hysplit4/working";
    public final static String GDAS_DIR = WORKING_DIR + "/gdas";

    public final static int TOP_OF_MODEL_DOMAIN = 35000;
    public final static int VERTICAL_MOTION = 4;


    //simulation runs for a fixed latitude per iteration, where LLDist is the distance from the last lat/lon component in degrees
    //TimeInterval is in hours
    public void run(Calendar StartDate, Calendar EndDate, int TimeInterval, int[][] AltSet, double StartLong, double EndLong, double StartLat, double EndLat, double LLDist){

        double NumberOfSimulationsTime = ((EndDate.getTimeInMillis() - StartDate.getTimeInMillis())/(TimeInterval*1000*3600));
        double NumberOfSimulationsLat = (Math.abs(StartLat)-Math.abs(EndLat))/LLDist;
        double NumberOfSimulationsLong = (Math.abs(StartLat)-Math.abs(EndLat))/LLDist;
        double NumberOfSimulationsAlts = AltSet.length;

        double NumberOfSimulations = NumberOfSimulationsTime*NumberOfSimulationsLat*NumberOfSimulationsLong*NumberOfSimulationsAlts;


        System.out.println("Number of Simulations that will run: " + NumberOfSimulations);

        System.exit(-1);
        //iterate date
        for(long SimDateTime=StartDate.getTimeInMillis();SimDateTime<EndDate.getTimeInMillis();SimDateTime=SimDateTime+TimeInterval*1000*3600){
            System.out.println(SimDateTime);

            //iterate lat
            for(double SimLat=StartLat; SimLat<EndLat; SimLat=SimLat+LLDist){

                System.out.println("test");


                //iterate lon
                for(double SimLong=StartLong;SimLong<EndLong;SimLong=SimLong+LLDist){
                    //iterate altitude sets
                    //OctaniControl.createControl();

                    System.out.println(SimLat + " " + SimLong);
                }
            }

        }

    }


    public static void main(String args[]){

        Calendar SimStartDate = new GregorianCalendar(2014,5,19,0,0);
        Calendar SimEndDate = new GregorianCalendar(2014,5,19,5,0);
        int SimTimeInterval = 1;

        int[][] SimAltitudes = {{1000,10000,15000},{500,15000,25000},{5000,25000,35000}};

        double[] SimLong = {-80,-20};
        double[] SimLat = {-89,-66};

        OctaniSim Simulation = new OctaniSim();


        System.out.println("Running simulation.");


        Simulation.run(SimStartDate, SimEndDate, SimTimeInterval, SimAltitudes, SimLong[0], SimLong[1], SimLat[0], SimLat[1], 1);

    }
}
