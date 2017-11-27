/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IBuilding;
import Acq.ISensor;
import java.util.LinkedHashSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public class Building implements IBuilding {

    private String name;
    private String adress;
    private LinkedHashSet<TempSensor> tempSensors;
    private LinkedHashSet<CO2Sensor> co2Sensors;

    public Building(String name, String adress) {
        this.name = name;
        this.adress = adress;
        this.tempSensors = new LinkedHashSet<>();
        this.co2Sensors = new LinkedHashSet<>();
    }

    @Override
    public String toString() {
        return this.name + " " + this.adress;
    }

    public String getName() {
        return this.name;
    }

    public String getAdress() {
        return this.adress;
    }

    @Override
    public void addNewTempSensor() {
        this.addSensor(new TempSensor());
    }

    @Override
    public void addNewCO2Sensor() {
        this.addSensor(new CO2Sensor());
    }

    public void addSensor(TempSensor sensor) {
        this.tempSensors.add(sensor);
    }

    public void addSensor(CO2Sensor sensor) {
        this.co2Sensors.add(sensor);
    }

    @Override
    public ObservableList<ISensor> getTempSensors() {
        ObservableList<ISensor> sensors = FXCollections.observableArrayList();
        for (TempSensor sensor : tempSensors) {
            sensors.add(sensor);
        }
        return sensors;
    }

    @Override
    public ObservableList<ISensor> getCO2Sensors() {
        ObservableList<ISensor> sensors = FXCollections.observableArrayList();
        for (CO2Sensor sensor : co2Sensors) {
            sensors.add(sensor);
        }
        return sensors;
    }
}
