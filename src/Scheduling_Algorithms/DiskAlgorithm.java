package Scheduling_Algorithms;

import java.util.ArrayList;

public abstract class DiskAlgorithm {


    protected ArrayList<Integer> DiskQueue = new ArrayList<>();
    protected ArrayList<Integer> Sequence_queue = new ArrayList<>();
    protected int Init_Head;

    public abstract int Calculate_Total_Head_Movements();

    protected int Absolute(int num)
    {
        if(num < 0) num *= -1;
        return num;
    }

    public ArrayList<Integer> getSequence_queue() {
        return Sequence_queue;
    }

    protected void setSequence_queue(ArrayList<Integer> sequence_queue) {
        Sequence_queue = sequence_queue;
    }
}
