package org.example.service;

public class KTX implements Transformation {
    private int distance;

    public KTX(int distance) {
        this.distance = distance;
    }
    @Override
    public int feeCalc() {
        int a = ((distance*50)>30000)? distance*50 : 30000;
        return a;
    }
}
