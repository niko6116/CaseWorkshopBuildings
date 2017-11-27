/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public interface ISensor {

    public double getMeasurement();

    public ObservableList<Double> getReadings();

    public void addReading(double reading);

}
