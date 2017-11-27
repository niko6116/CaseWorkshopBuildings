/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ISensor;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public class TempSensor implements ISensor {

    private LinkedList<Double> readings; // celsius
    private int maxNumOfReadings;

    public TempSensor() {
        this.readings = new LinkedList<>();
        this.maxNumOfReadings = 30;
    }

    @Override
    public double getMeasurement() {
        Double[] r = (Double[]) readings.toArray();
        return r[r.length - 1];
    }

    @Override
    public ObservableList<Double> getReadings() {
        ObservableList<Double> values = FXCollections.observableArrayList();
        for (Double d : readings) {
            values.add(d);
        }
        return values;
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
