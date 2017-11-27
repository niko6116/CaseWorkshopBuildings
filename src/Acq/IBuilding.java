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
public interface IBuilding {

    public void addNewTempSensor();

    public void addNewCO2Sensor();

    public ObservableList<ISensor> getTempSensors();

    public ObservableList<ISensor> getCO2Sensors();

}
