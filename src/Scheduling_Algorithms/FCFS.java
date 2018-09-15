package Scheduling_Algorithms;

import java.util.ArrayList;

public class FCFS extends DiskAlgorithm{

    public FCFS(ArrayList<Integer> dsk, int init)
    {
        this.DiskQueue = dsk;
        this.Init_Head = init;

        ArrayList<Integer> SeqQ = new ArrayList<>();
        SeqQ.add(Init_Head);
        SeqQ.addAll(DiskQueue);
        setSequence_queue(SeqQ);
    }

    public int Calculate_Total_Head_Movements()
    {
        int Total_Head = 0;
        Total_Head += Absolute(Init_Head - DiskQueue.get(0));

        for (int idx=1; idx < DiskQueue.size(); idx++)
        {
            Total_Head += Absolute(DiskQueue.get(idx) - DiskQueue.get(idx-1));
        }

        return Total_Head;
    }

}
