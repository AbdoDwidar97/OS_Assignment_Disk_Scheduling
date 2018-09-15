import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Advanced {

    static int Max_EndDisk = 0;
    static int Min_EndDisk = 0;

    public static ArrayList<Integer> ReadFile(String FileName)
    {

        ArrayList<Integer> DiskQueue = new ArrayList<>();
        try
        {

            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);

            String EnDisk = br.readLine();
            String EndDisk[] = EnDisk.split(" ");
            Max_EndDisk = Integer.parseInt(EndDisk[1]);
            Min_EndDisk = Integer.parseInt(EndDisk[0]);

            String itr;
            while ((itr = br.readLine())!= null)
            {
                DiskQueue.add(Integer.parseInt(itr));
            }
            br.close();

            return DiskQueue;

        } catch (IOException e)
        {
            return null;
        }

    }

}
