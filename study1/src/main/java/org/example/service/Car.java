package org.example.service;

public class Car implements Transformation {

    private int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    @Override
    public int feeCalc() {
        return (this.distance)*130;
    }
}
