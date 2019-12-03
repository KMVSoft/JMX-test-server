package com.mikhail.jmxclient;

public interface AirplaneMBean {

    int getSpeed();
    int getAltitude();
    String getName();
    void setName(String name);

    void takeOff();
    void landing();

    void passengerBoarding(int count);


}
