package com.example.patrickpolacek;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Simulation simulation = new Simulation();

        ArrayList<Item> phase1Item = simulation.loadItems(new File("C:\\Users\\Polacek\\IntelliJProjectJavaMasterClass\\SpaceChallenge-master2-master\\src\\phase-1.txt"));

        ArrayList<Item> phase2Item = simulation.loadItems(new File("C:\\Users\\Polacek\\IntelliJProjectJavaMasterClass\\SpaceChallenge-master2-master\\src\\phase-2.txt"));


        System.out.println(phase1Item);

        System.out.println(phase2Item);

        System.out.println(simulation.loadU1(phase1Item));
        System.out.println(simulation.loadU1(phase2Item));



//        System.out.println("The cost of this mission in phase1 is: " + simulation.runSimulation(phase1Rockets));
//
//        System.out.println("The cost of this mission in phase2 is: " + simulation.runSimulation(phase2Rockets));

    }
}
