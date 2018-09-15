import Scheduling_Algorithms.*;

import java.util.ArrayList;

public class Main {

    public static void main(String []args)
    {

        int InitHead;
        ArrayList<Integer> DskQueu = Advanced.ReadFile("fcfs.txt");
        InitHead = DskQueu.get(0);
        DskQueu.remove(0);

        int DiskRange[] = {Advanced.Min_EndDisk,Advanced.Max_EndDisk};

        ArrayList<DiskAlgorithm> Team_A = new ArrayList<>();
        Team_A.add(new FCFS(DskQueu,InitHead));
        Team_A.add(new SSTF(DskQueu,InitHead));
        Team_A.add(new NewOptimized(DskQueu,0));

        ArrayList<DiskAlgorithm> Team_B = new ArrayList<>();
        Team_B.add(new SCAN(DskQueu,InitHead,DiskRange[0]));
        Team_B.add(new C_SCAN(DskQueu,InitHead,DiskRange));
        Team_B.add(new NewOptimized(DskQueu,0));

        ArrayList<DiskAlgorithm> Team_C = new ArrayList<>();
        Team_C.add(new SCAN(DskQueu,InitHead,DiskRange[0]));
        Team_C.add(new SCAN(DskQueu,InitHead,DiskRange[0]));
        Team_C.add(new NewOptimized(DskQueu,0));


        System.out.println("Team A ==========================================================");
        for (int idx=0; idx < Team_A.size(); idx++)
        {
            int TotalHead = Team_A.get(idx).Calculate_Total_Head_Movements();
            ArrayList<Integer> sequance = Team_A.get(idx).getSequence_queue();

            for (int itr : sequance) System.out.print(itr + " , ");
            System.out.println("Total head movements = " + TotalHead);
        }


        System.out.println("");
        System.out.println("Team B ==========================================================");
        for (int idx=0; idx < Team_B.size(); idx++)
        {
            int TotalHead = Team_B.get(idx).Calculate_Total_Head_Movements();
            ArrayList<Integer> sequance = Team_B.get(idx).getSequence_queue();

            for (int itr : sequance) System.out.print(itr + " , ");
            System.out.println("Total head movements = " + TotalHead);
        }


        System.out.println("");
        System.out.println("Team C ==========================================================");
        for (int idx=0; idx < Team_C.size(); idx++)
        {
            int TotalHead = Team_C.get(idx).Calculate_Total_Head_Movements();
            ArrayList<Integer> sequance = Team_C.get(idx).getSequence_queue();

            for (int itr : sequance) System.out.print(itr + " , ");
            System.out.println("Total head movements = " + TotalHead);
        }

        /*
        ArrayList<DiskAlgorithm> Dalgo = new ArrayList<>();
        Dalgo.add(new FCFS(DskQueu,InitHead));
        Dalgo.add(new SSTF(DskQueu,InitHead));
        Dalgo.add(new SCAN(DskQueu,InitHead,DiskRange[0]));
        Dalgo.add(new C_SCAN(DskQueu,InitHead,DiskRange));
        Dalgo.add(new C_LOOK(DskQueu,InitHead,DiskRange));
        Dalgo.add(new NewOptimized(DskQueu,0));

        int TotalHead_fcfs = Dalgo.get(0).Calculate_Total_Head_Movements();
        ArrayList<Integer> fcfs = Dalgo.get(0).getSequence_queue();

        int TotalHead_sstf = Dalgo.get(1).Calculate_Total_Head_Movements();
        ArrayList<Integer> sstf = Dalgo.get(1).getSequence_queue();

        int TotalHead_scan = Dalgo.get(2).Calculate_Total_Head_Movements();
        ArrayList<Integer> scann = Dalgo.get(2).getSequence_queue();

        int TotalHead_c_scan = Dalgo.get(3).Calculate_Total_Head_Movements();
        ArrayList<Integer> c_scan = Dalgo.get(3).getSequence_queue();

        int TotalHead_c_look = Dalgo.get(4).Calculate_Total_Head_Movements();
        ArrayList<Integer> c_look = Dalgo.get(4).getSequence_queue();

        int TotalHead_new_optimized = Dalgo.get(5).Calculate_Total_Head_Movements();
        ArrayList<Integer> new_optimized = Dalgo.get(5).getSequence_queue();


        for (int itr : fcfs) System.out.print(itr + " , ");
        System.out.println("Total head movements (FCFS) = " + TotalHead_fcfs);

        for (int itr : sstf) System.out.print(itr + " , ");
        System.out.println("Total head movements (SSTF) = " + TotalHead_sstf);

        for (int itr : scann) System.out.print(itr + " , ");
        System.out.println("Total head movements (SCAN) = " + TotalHead_scan);

        for (int itr : c_scan) System.out.print(itr + " , ");
        System.out.println("Total head movements (C-SCAN) = " + TotalHead_c_scan);

        for (int itr : c_look) System.out.print(itr + " , ");
        System.out.println("Total head movements (C-LOOK) = " + TotalHead_c_look);

        for (int itr : new_optimized) System.out.print(itr + " , ");
        System.out.println("Total head movements (New Optimized) = " + TotalHead_new_optimized);
        */

    }

}
