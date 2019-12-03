package com.mikhail.jmxclient;

import java.util.Random;

public class Airplane implements AirplaneMBean {
    private String name;
    private long passengers;

    public int getSpeed() {
        return Math.abs(new Random().nextInt()) % 1600;
    }

    public int getAltitude() {
        return Math.abs(new Random().nextInt()) % 10000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeOff() {
        System.out.println("Airplane takes off");
    }

    public void landing() {
        System.out.println("Airplane landings");
    }

    public void passengerBoarding(int count) {
        passengers += count;
        System.out.println("Now airplane contains "+passengers+" passengers");

    }
}
