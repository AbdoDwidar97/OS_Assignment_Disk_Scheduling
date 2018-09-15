package Scheduling_Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class NewOptimized extends DiskAlgorithm {

    public NewOptimized(ArrayList<Integer> dsk, int init)
    {
        this.DiskQueue = dsk;
        this.Init_Head = init;

        ArrayList<Integer> SorQ = DiskQueue;
        Collections.sort(SorQ);
        SorQ.set(0,Init_Head);
        setSequence_queue(SorQ);
    }

    public int Calculate_Total_Head_Movements()
    {
        ArrayList<Integer> SortedQ = DiskQueue;
        Collections.sort(SortedQ);
        SortedQ.set(0,Init_Head);

        int Total_Head = 0;
        for (int idx=1; idx < SortedQ.size(); idx++)
        {
            Total_Head += Absolute(SortedQ.get(idx) - SortedQ.get(idx-1));
        }

        return Total_Head;
    }


}
