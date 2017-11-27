/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseworkshopbuildings;

import Acq.*;
import Business.BusinessFacade;
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
    private TextFlow infoTextFlow;
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
    
    private BusinessFacade businessFacade;
    
    private ObservableList<IBuilding> buildings;
    private ObservableList<ISensor> tempSensors;
    private ObservableList<ISensor> co2Sensors;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        businessFacade = new BusinessFacade();
        buildings = FXCollections.observableArrayList();
        tempSensors = FXCollections.observableArrayList();
        co2Sensors = FXCollections.observableArrayList();
        
        buildingsListView.setItems(buildings);
        buildingsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tempSensorsListView.setItems(tempSensors);
        tempSensorsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        co2SensorsListView.setItems(co2Sensors);
        co2SensorsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
    @FXML
    private void handleButtonActionAddBuilding(ActionEvent event) {
        String name = buildingNameTextField.getText();
        String adress = buildingAdressTextField.getText();
        businessFacade.addNewBuilding(name, adress);
        buildings.add(businessFacade.getBuildingManagement().getBuilding(adress));
    }
    
    @FXML
    private void handleButtonActionAddTempSensor(ActionEvent event) {
        buildingsListView.getSelectionModel().getSelectedItem().addNewTempSensor();
    }
    
    @FXML
    private void handleButtonActionAddCO2Sensor(ActionEvent event) {
        buildingsListView.getSelectionModel().getSelectedItem().addNewCO2Sensor();
    }
    
    @FXML
    private void handleButtonActionAddTemp(ActionEvent event) {
        tempSensorsListView.getSelectionModel().getSelectedItem();
        BigDecimal value = new BigDecimal(tempTextField.getText());
    }
    
    @FXML
    private void handleButtonActionAddCO2Level(ActionEvent event) {
        co2SensorsListView.getSelectionModel().getSelectedItem();
        BigDecimal value = new BigDecimal(co2TextField.getText());
    }
    
    @FXML
    private void handleBuildingsSelectionChanged(Event event) {
        tempSensors = buildingsListView.getSelectionModel().getSelectedItem().getTempSensors();
        tempSensorsListView.setItems(tempSensors);
        co2Sensors = buildingsListView.getSelectionModel().getSelectedItem().getCO2Sensors();
        co2SensorsListView.setItems(co2Sensors);
    }
}
