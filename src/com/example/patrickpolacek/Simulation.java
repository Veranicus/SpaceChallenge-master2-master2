package com.example.patrickpolacek;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    U1Rocket u1Rocket = new U1Rocket(100000000,100000);

    private ArrayList<Integer> weights = new ArrayList<>();

    public ArrayList<Item> loadItems(File file) throws Exception {
        ArrayList<String[]> name = new ArrayList<>();


        Scanner scanner = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            name.add(line.split("="));
        }
        for (int i = 0; i < name.size(); i++) {

            items.add(
                    new Item(
                            name.get(i)[0],
                            Integer.parseInt(name.get(i)[1]))
            );
            weights.add(Integer.parseInt(name.get(i)[1]));
            System.out.println(weights.get(i));
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        double additionalWeight = u1Rocket.getWeight();
        System.out.println(additionalWeight);
        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (additionalWeight <= u1Rocket.getMaxWeight() && i != items.size() - 1) {
                additionalWeight += items.get(i).getWeight();
            } else if (u1Rocket.getWeight() + additionalWeight >= u1Rocket.getMaxWeight()) {
                u1Rockets.add(new U1Rocket( u1Rocket.getCost(), additionalWeight));
            }
        }
        return u1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        double additionalWeight = 0.0;
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if ((additionalWeight <= 110000)) {
                additionalWeight += (double) items.get(i).getWeight();
            } else if (additionalWeight > 110000 || i < items.size()) {
                u2Rockets.add(new U2Rocket(100000000, 100000 + additionalWeight));
                additionalWeight = 0;

            }

        }
        return u2Rockets;
    }

    public double runSimulation(ArrayList<Rocket> rockets) {
        double budget = 0.0;
        for (int i = 0; i < rockets.size(); i++) {
            rockets.get(i).launch();
            System.out.printf("Rocket number " + i + " has been launched");
            rockets.get(i).land();
            System.out.printf("Rocket number " + i + " has landed");
            while (rockets.get(i).launch() == false) {
                rockets.get(i).launch();
            }
            while (rockets.get(i).land() == false) {
                rockets.get(i).land();
            }
            if (rockets.get(i) instanceof U1Rocket) {
                budget += 100000000;
            } else if (rockets.get(i) instanceof U2Rocket) {
                budget += 100000000;
            }
        }
        return budget;
    }
}



