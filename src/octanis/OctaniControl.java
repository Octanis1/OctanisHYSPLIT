package octanis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sam on 06/06/14.
 * Creates a new HYSPLIT CONTROL file
 */
public class OctaniControl extends OctaniSim{



    public static void createControl(Calendar date, int runtime, double lat, double lon, int[] alts) throws IOException{

        try {
            PrintWriter ControlFile = new PrintWriter(new FileWriter(new File(WORKING_DIR + "CONTROL"), false));

            ControlFile.println((new SimpleDateFormat("Y M d hh").format(date)));
            ControlFile.println(alts.length);

            for (int i = 0; i < alts.length; i++) {
                ControlFile.println(lat + " " + lon + " " + alts[i]);
            }

            ControlFile.println(runtime);
            ControlFile.println(VERTICAL_MOTION);
            ControlFile.println(TOP_OF_MODEL_DOMAIN);

            //count gdas files in GDAS_DIR
            File gdas = new File(GDAS_DIR);
            File gdasfiles[] = gdas.listFiles();

            ControlFile.println(GDAS_DIR);
            ControlFile.println(gdasfiles.length);

            for (int i = 0; i < gdasfiles.length; i++) {
                ControlFile.println(gdasfiles[i].getName());
            }

            ControlFile.println(WORKING_DIR);
            ControlFile.println("tdump");
        }catch(IOException e){
            System.out.println("File not created "+e.getMessage());
        }catch(NullPointerException e){
            System.out.println(" ");
        }



    }

}

