package com.bcd;

/**
 * JR: Below expectations, flawed in several areas, and does not demonstrate understanding
 * of program concepts.
 *
 * Validation testing is incomplete, and ClientArgs is severely flawed.
 * Basic principles such as data encapsulation (private fields) are not employed.
 *
 * No "action" or "business" methods - only accessor (get/set) methods.
 *
 * Code formatting and adhering to Java naming conventions needs improvement.
 *  Formatting: place a blank line between each ctor and method, otherwise looks too crowded.
 *  Methods, if, and if-else blocks should use block structure, not {code} on one editor line.
 *
 * See comments below and in the other classes.
 *
 * Class participation is good, but needs to be maintained, keep it up.
 *
 * Class names, package names, and overall structure are correct.
 */
public class BuoyancyCompensatorDevice {
    public static final int MIN_TANKS = 1;
    public static final int MAX_TANKS = 3;

    //FIELDS or INSTANCE VARIABLES

    // JR: fields should be private (basic principle of data encapsulation)

    // JR: use enum instead, e.g., Color - see setColor()
    public String color;       // Red, Black, Blue, Yellow

    // JR: use enum instead, e.g., Manufacturer - see setManufacturer()
    public String manufacturer;// Scuba Pro, Aqualung, Cressi, Dive Rite

    public DeviceType deviceType;  // constraint: {"Jacket", "Semi-Wing", "Backplate/Wing"]

    // JR: if 'tanks' must be between MIN/MAX_TANKS (1-3), then provide a default value in that range
    // JR: comment says "default 1" but it's not coded that way - the default here is 0.
    public int tanks;          // number of tanks BCD can hold constraint: 1, 2, 3 (default 1)

    // JR: not named according to Java naming conventions, should be something like 'dRings'
    public int d_rings;        // number of D-rings that are on the BCD. (default 0)

    // JR: perhaps 'hasIntegratedWeights' is a better name
    public boolean integratedWeights = true;



    //CONSTRUCTORS
    // JR: across the board, ctors are not calling setters when they should be

    public BuoyancyCompensatorDevice(){
    }
    public BuoyancyCompensatorDevice(String color){
        this();
        setColor (color);
    }
    public BuoyancyCompensatorDevice(String color, String manufacturer){
        this(color);
        setManufacturer(manufacturer);
    }
    public BuoyancyCompensatorDevice(String color, String manufacturer, DeviceType deviceType){
        this(color, manufacturer);
        this.deviceType = deviceType;   // JR: call the setter here
    }
    public BuoyancyCompensatorDevice(String color, String manufacturer, DeviceType deviceType, int tanks){
        this(color, manufacturer, deviceType);
        this.tanks = tanks;             // JR: call the setter here
    }
    public BuoyancyCompensatorDevice(String color, String manufacturer, DeviceType deviceType, int tanks, int d_rings){
        this(color, manufacturer, deviceType, tanks);
        this.d_rings = d_rings;         // JR: call the setter here
    }
    public BuoyancyCompensatorDevice(String color, String manufacturer, DeviceType deviceType, int tanks, int d_rings, boolean integratedWeights){
        this(color, manufacturer, deviceType, tanks, d_rings);
        this.integratedWeights = integratedWeights; // JR: call the setter here
    }

    //business-oriented methods
    // JR: these are accessor (get/set) methods, not "action" or "business" methods

    public String getColor() {
        return color;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public int getTanks(){
        return tanks;
    }
    public int getD_rings(){
        return d_rings;
    }
    public boolean isIntegratedWeights(){
        return integratedWeights;
    }

    //data constraints: Red, Black, Blue, Yellow
    // JR: use enum instead, e.g., Color - then no validation necessary
    public void setColor(String color){
        if (color.equals("Red")         ||
                color.equals("Black")   ||
                color.equals("Blue")    ||
                color.equals("Yellow")) {
            this.color = color;
        }
        // JR: format as block of code, not as {code}
        else {System.out.println("Invalid color: " + color + ", valid colors are Red, Black, Blue, Yellow");}
    }

    //Scuba Pro, Aqualung, Cressi, Dive Rite
    // JR: use enum instead, e.g., Manufacturer - then no validation necessary
    public void setManufacturer(String manufacturer){
        if (manufacturer.equals("Scuba Pro")    ||
                manufacturer.equals("Aqualung") ||
                manufacturer.equals("Cressi")   ||
                manufacturer.equals("Dive Rite")) {
            this.manufacturer = manufacturer;}
        else {
            // JR: client-provided value not included in error message, formatting is off (closing })
            System.out.println("Invalid manufacturer: " + ", valid manufacturers are Scuba Pro, Aqualung, Cressi, Dive Rite");}
    }
    //"Jacket", "Semi-Wing", "Backplate/Wing"
    public void setDeviceType(DeviceType deviceType){
        this.deviceType = deviceType;
    }
    public DeviceType getDeviceType() {
        return deviceType;
    }

    /*
     * JR: logic flawed, incoming 'tanks' value never used in the condition.
     * Should be:
     *  if (tanks >= MIN_TANKS && tanks <= MAX_TANKS)
     *      this.tanks = tanks;
     *  else
     *      error message
     */
    public void setTanks(int tanks) {
        if (MIN_TANKS <= 1 || 3 <= MAX_TANKS){
            this.tanks = tanks;
        }
        else{
            // JR: no magic numbers, use your class constants MIN/MAX_TANKS
            System.out.println("Invalid tank number: %s, valid range is 1 - 3");
        }
    }
    public void setD_rings(int d_rings) {
        this.d_rings = d_rings;
    }

    // JR: this method does nothing
    public void setIntegratedWeights(boolean integratedWeights){

    }
    public String toString() {
        return String.format("BCD: Color= %s, Manufacturer= %s, Device Type= %s, Tanks= %s, #D Rings= %s, Weights are integrated: %s",
                getColor(), getManufacturer(), getDeviceType(), getTanks(), getD_rings(), integratedWeights);
    }
}