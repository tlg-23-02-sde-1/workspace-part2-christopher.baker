package com.electricalpanel;

public class ElectricalPanel {
    //we only want to accept even num of slots
    private static final int MIN_SLOTS = 2;
    private static final int MAX_SLOTS = 60;

//    enum EPBrand {
//        SIEMENS, SQUARE_D, GE
//    }

    private EPBrand EPBrand;
    private boolean isOnePhase;
    private int numOfSlots;
    private boolean isEnergized;    //boolean default is false
    private int serialNumber = 0;



    public ElectricalPanel(EPBrand EPBrand, boolean isOnePhase, int numOfSlots) {
        this.EPBrand = EPBrand;
        this.isOnePhase = isOnePhase;
        setNumOfSlots(numOfSlots);
        setIsEnergized(false);
        serialNumber++;
    }

    public EPBrand getBrand() {
        return EPBrand;
    }

    public boolean getIsOnePhase() {
        return isOnePhase;
    }

    public void setNumOfSlots(int numOfSlots) {
        if (numOfSlots % 2 == 0 && numOfSlots >= MIN_SLOTS && numOfSlots <= MAX_SLOTS) {
            this.numOfSlots = numOfSlots;
        } else {
            System.out.println("Number of slots must be an even number between " + MIN_SLOTS + " slots " + MAX_SLOTS);
        }
    }

    public boolean getIsEnergized() {
        return isEnergized;
    }

    public void setIsEnergized(boolean energized) {
        isEnergized = energized;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String toString() {
        return " Electrical Panel: EPBrand " + getBrand() + ", " +
                " serial number " + serialNumber++ + ", " +
                " with One-phase: " + getIsOnePhase() + ", " +
                " has " + numOfSlots + " number of slots." +
                " and is energized:" + isEnergized;
    }
}