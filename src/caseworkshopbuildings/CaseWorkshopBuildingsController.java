/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseworkshopbuildings;

import Acq.*;
import Business.BusinessFacade;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Bruger
 */
public class CaseWorkshopBuildingsController implements Initializable {

    @FXML
    private Button addTempSensorButton;
    @FXML
    private Button addTempButton;
    @FXML
    private TextField tempTextField;
    @FXML
    private Button addCO2SensorButton;
    @FXML
    private Button addCO2Button;
    @FXML
    private TextField co2TextField;
    @FXML
    private Button addBuildingButton;
    @FXML
    private TextField buildingNameTextField;
    @FXML
    private TextField buildingAdressTextField;
    @FXML
    private Tab tempTab;
    @FXML
    private Tab co2Tab;
    @FXML
    private Tab buildingsTab;
    @FXML
    private ListView<IBuilding> buildingsListView;
    @FXML
    private ListView<ISensor> tempSensorsListView;
    @FXML
    private ListView<ISensor> co2SensorsListView;
    @FXML
    private ListView<Double> outputTextView;
    @FXML
    private Text infoText;

    private BusinessFacade businessFacade;

    private ObservableList<IBuilding> buildings;
    private ObservableList<ISensor> tempSensors;
    private ObservableList<ISensor> co2Sensors;
    private ObservableList<Double> output;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        businessFacade = new BusinessFacade();
        buildings = FXCollections.observableArrayList();
        tempSensors = FXCollections.observableArrayList();
        co2Sensors = FXCollections.observableArrayList();
        output = FXCollections.observableArrayList();

        buildingsListView.setItems(buildings);
        buildingsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tempSensorsListView.setItems(tempSensors);
        tempSensorsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        co2SensorsListView.setItems(co2Sensors);
        co2SensorsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        outputTextView.setItems(output);
        outputTextView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void handleButtonActionAddBuilding(ActionEvent event) {
        if (buildingNameTextField.getText().equals("")) {
            if (buildingAdressTextField.getText().equals("")) {
                infoText.setText("Give the building a name and an adress");
            } else {
                infoText.setText("Give the building a name");
            }
        } else if (buildingAdressTextField.getText().equals("")) {
            infoText.setText("Give the building an adress");
        } else {
            String name = buildingNameTextField.getText();
            String adress = buildingAdressTextField.getText();
            businessFacade.addNewBuilding(name, adress);
            buildings.add(businessFacade.getBuildingManagement().getBuilding(adress));
            infoText.setText("Building added");
        }
    }

    @FXML
    private void handleButtonActionAddTempSensor(ActionEvent event) {
        try {
            buildingsListView.getSelectionModel().getSelectedItem().addNewTempSensor();
            infoText.setText("Temperature sensor added");
        } catch (NullPointerException ex) {
            infoText.setText("Choose a building");
        }
    }

    @FXML
    private void handleButtonActionAddCO2Sensor(ActionEvent event) {
        try {
            buildingsListView.getSelectionModel().getSelectedItem().addNewCO2Sensor();
            infoText.setText("CO2 sensor added");
        } catch (NullPointerException ex) {
            infoText.setText("Choose a building");
        }
    }

    @FXML
    private void handleButtonActionAddTemp(ActionEvent event) {
        Double value = new Double(tempTextField.getText());
        tempSensorsListView.getSelectionModel().getSelectedItem().addReading(value);
        infoText.setText("Temperature " + value + " added");
    }

    @FXML
    private void handleButtonActionAddCO2Level(ActionEvent event) {
        Double value = new Double(co2TextField.getText());
        co2SensorsListView.getSelectionModel().getSelectedItem().addReading(value);
        infoText.setText("CO2 level " + value + " added");
    }

    @FXML
    private void handleBuildingsSelectionChanged(Event event) {
        tempSensors = buildingsListView.getSelectionModel().getSelectedItem().getTempSensors();
        tempSensorsListView.setItems(tempSensors);
        co2Sensors = buildingsListView.getSelectionModel().getSelectedItem().getCO2Sensors();
        co2SensorsListView.setItems(co2Sensors);
    }

    @FXML
    private void handleTempSensorsSelectionChanged(MouseEvent event) {
        output = tempSensorsListView.getSelectionModel().getSelectedItem().getReadings();
        outputTextView.getSelectionModel().getSelectedItem();
        outputTextView.setItems(output);
    }

    @FXML
    private void handleCO2SensorsSelectionChanged(MouseEvent event) {
        output = co2SensorsListView.getSelectionModel().getSelectedItem().getReadings();
        outputTextView.getSelectionModel().getSelectedItem();
        outputTextView.setItems(output);
    }
}
