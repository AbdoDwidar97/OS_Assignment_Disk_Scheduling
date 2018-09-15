package Scheduling_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SCAN extends DiskAlgorithm {

    int Arm_Disk;

    public SCAN(){}

    public SCAN(ArrayList<Integer> dsk, int init,int armdsk)
    {
        this.DiskQueue = dsk;
        this.Init_Head = init;
        this.Arm_Disk = armdsk;
    }

    public int Calculate_Total_Head_Movements()
    {
        ArrayList<Integer> AllQueueWithRange = new ArrayList<>();
        AllQueueWithRange.add(Init_Head);
        AllQueueWithRange.add(Arm_Disk);
        AllQueueWithRange.addAll(DiskQueue);

        int Total_Head = 0;
        ArrayList<Integer> Arranged_Queue = Arrange_DiskQueue(AllQueueWithRange);
        for (int idx=1; idx < Arranged_Queue.size(); idx++)
        {
            Total_Head += Absolute(Arranged_Queue.get(idx) - Arranged_Queue.get(idx-1));
        }
        return Total_Head;
    }

    private ArrayList<Integer> Arrange_DiskQueue(ArrayList<Integer> AllQueueWithRange)
    {
        ArrayList<Integer> Arranged_Queue = new ArrayList<>();
        Collections.sort(AllQueueWithRange);

        int IndexOf_Arm = 0, IndexOf_InitHead = 0;
        for (int idx=0; idx < AllQueueWithRange.size(); idx++)
        {
            if(AllQueueWithRange.get(idx) == Arm_Disk) IndexOf_Arm = idx;
            if(AllQueueWithRange.get(idx) == Init_Head) IndexOf_InitHead = idx;
        }

        List<Integer> Qp1 = AllQueueWithRange.subList(IndexOf_Arm,IndexOf_InitHead+1);
        Collections.sort(Qp1);

        List<Integer> Qp2;
        if(IndexOf_Arm > IndexOf_InitHead)
        {
            Qp2 = AllQueueWithRange.subList(IndexOf_Arm+1,AllQueueWithRange.size());
        }
        else
        {
            Qp2 = AllQueueWithRange.subList(IndexOf_InitHead+1,AllQueueWithRange.size());
            Collections.sort(Qp2);
            Collections.reverse(Qp1);
        }

        Arranged_Queue.addAll(Qp1);
        Arranged_Queue.addAll(Qp2);
        setSequence_queue(Arranged_Queue);
        return Arranged_Queue;
    }

}
