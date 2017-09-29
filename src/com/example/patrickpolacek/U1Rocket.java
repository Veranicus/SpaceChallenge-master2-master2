package com.example.patrickpolacek;

public class U1Rocket extends Rocket {

//    Declaring fields of the U1Rocket class
//    @cost - represents the cost of the rocket
//    @weight - represents the weight of the rocket
//    @maxWeight - represents the max weight of the rocket

    private double cost = 100000000;
    private double weight = 10000;
    private double maxWeight = 18000;

    public U1Rocket(double cost, double weight) {
        this.cost = cost;
        this.weight = weight;
    }



    @Override
    public boolean launch() {
        double probabilityToExplodeAtLaunch = 0.05 * (weight / maxWeight);

        if ((Math.random() * 100) > probabilityToExplodeAtLaunch) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean land() {
        double probabilityToExplodeAtLand = 0.01 * (weight / maxWeight);

        if ((Math.random() * 100) > probabilityToExplodeAtLand) {
            return true;
        } else {
            return false;
        }
    }


    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }


    @Override
    public void setCost(double cost) {
        super.setCost(this.cost);
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(this.weight);
    }

    @Override
    public void setMaxWeight(double maxWeight) {
        super.setMaxWeight(maxWeight);
    }
}
