package org.example.service;

public class Bus implements Transformation{
    private int distance;
    public Bus(int distance) {
        this.distance = distance;
    }
    @Override
    public int feeCalc(){
        int a = ((distance*10)>10000)? 40000+(distance*10) : 50000;
        return a;
    }
}
