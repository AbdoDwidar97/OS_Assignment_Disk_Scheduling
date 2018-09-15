package Scheduling_Algorithms;

import java.util.ArrayList;

public class SSTF extends DiskAlgorithm{

    public SSTF(ArrayList<Integer> dsk, int init)
    {
        this.DiskQueue = dsk;
        this.Init_Head = init;
    }

    public int Calculate_Total_Head_Movements()
    {
        ArrayList<Integer> DiskQ = new ArrayList<>();
        DiskQ.add(Init_Head);
        DiskQ.addAll(DiskQueue);

        int Total_Head = 0;
        ArrayList<Integer> CloseQ = Queue_Closest(DiskQ);

        for (int idx=1; idx < CloseQ.size(); idx++)
        {
            Total_Head += Absolute(CloseQ.get(idx) - CloseQ.get(idx-1));
        }
        return Total_Head;
    }

    private ArrayList<Integer> Queue_Closest(ArrayList<Integer> DskQ)
    {
        ArrayList<Integer> CloseQ = new ArrayList<>();
        ArrayList<Integer> CopyOfDskQ = DskQ;

        int Min = 0;
        int MinValue = CopyOfDskQ.get(0);

        CloseQ.add(MinValue);
        CopyOfDskQ.remove(0);

        int Iterations = CopyOfDskQ.size();
        while (Iterations > 0)
        {

            int [] MinDistance = new int[CopyOfDskQ.size()]; Min = 0;
            for (int idy=0; idy<CopyOfDskQ.size(); idy++) MinDistance[idy] = Absolute(MinValue-CopyOfDskQ.get(idy));
            for (int idz=0; idz < MinDistance.length; idz++)
            {
                if(MinDistance[idz] < MinDistance[Min]) Min = idz;
            }

            MinValue = CopyOfDskQ.get(Min);
            CloseQ.add(MinValue);
            CopyOfDskQ.remove(Min);
            Iterations--;
        }
        setSequence_queue(CloseQ);
        return CloseQ;
    }

}

