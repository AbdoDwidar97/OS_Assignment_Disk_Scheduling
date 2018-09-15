package Scheduling_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_LOOK extends C_SCAN {

    public C_LOOK(ArrayList<Integer> dsk, int init , int armdsk[])
    {
        this.DiskQueue = dsk;
        this.Init_Head = init;
        this.Arm_Disk = armdsk[0];
    }

    public int Calculate_Total_Head_Movements()
    {
        ArrayList<Integer> AllQueueWithRange = new ArrayList<>();
        AllQueueWithRange.add(Init_Head);
        AllQueueWithRange.add(Arm_Disk);
        AllQueueWithRange.addAll(DiskQueue);

        int Total_Head = 0;
        ArrayList<Integer> Arranged_Queue = Optimized_Queue(AllQueueWithRange);
        for (int idx=1; idx < Arranged_Queue.size(); idx++)
        {
            Total_Head += Absolute(Arranged_Queue.get(idx) - Arranged_Queue.get(idx-1));
        }

        return Total_Head;
    }

    private ArrayList<Integer> Optimized_Queue(ArrayList<Integer> DiskQ)
    {
        ArrayList<Integer> ArrangedQ = Arrange_DiskQueue(DiskQ);
        for (int idx=0; idx < ArrangedQ.size(); idx++)
        {
            if(ArrangedQ.get(idx) == Arm_Disk) ArrangedQ.remove(idx);
        }
        setSequence_queue(ArrangedQ);
        return ArrangedQ;
    }

}
