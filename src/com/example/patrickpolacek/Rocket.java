package com.example.patrickpolacek;

public class Rocket implements SpaceShip {

    private double cost;
    private double weight;
    private double maxWeight;

    public Rocket(double cost, double weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public Rocket() {
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (weight + item.getWeight() > maxWeight) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void carry(Item item) {

        weight += item.getWeight();
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
