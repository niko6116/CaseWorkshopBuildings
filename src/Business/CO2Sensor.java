/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ISensor;
import java.util.LinkedList;

/**
 *
 * @author Bruger
 */
public class CO2Sensor implements ISensor {

    private LinkedList<Double> readings; // ppm^2
    private int maxNumOfReadings;

    public CO2Sensor() {
        this.readings = new LinkedList<>();
        this.maxNumOfReadings = 30;
    }

    @Override
    public double getMeasurement() {
        Double[] r = (Double[]) readings.toArray();
        return r[r.length - 1];
    }

    @Override
    public LinkedList<Double> getReadings() {
        return this.readings;
    }

    @Override
    public void addReading(double reading) {
        this.readings.add(reading);

        double oldest = 0;
        while (this.readings.size() > this.maxNumOfReadings) {
            for (Double r : this.readings) {
                oldest = r;
                break;
            }
            this.readings.remove(oldest);
        }
    }
}
