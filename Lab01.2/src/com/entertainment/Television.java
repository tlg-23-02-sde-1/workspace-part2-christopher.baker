package com.entertainment;

import java.util.Objects;

public class Television {
    private String brand;
    private int volume;

// Television has a HAS-A
    private Tuner tuner = new Tuner();

//fields
//constructor
    public Television(){

    }
    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

//business method
//helper method
//accessor method get/set/toString

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getCurrentChannel(){
        return tuner.getChannel();
    }
    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() &&
                Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode(){  // this is a poorly written function due to easily resulting in "hash collision"
        // a "hash collision" is when different objects (by equals()) has the SAME hashCode.
        return Objects.hash(getBrand(), getVolume());
    }

    public boolean equals(Television obj){

        boolean result = false;

        //proceed only if 'obj' is really a reference to a Television object.
        if (obj instanceof Television) {
            //downcast to more specific type Television, so we can call Television methods.
            Television other = (Television) obj;

            result = this.getBrand().equals(other.getBrand()) && this.getVolume() == other.getVolume();
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() + ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
    }
}