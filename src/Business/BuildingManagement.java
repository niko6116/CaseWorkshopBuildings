/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public class BuildingManagement implements IBuildingManagement {

    private HashMap<String, Building> buildings;

    public BuildingManagement() {
        this.buildings = new HashMap<>();
    }

    public void addBuilding(Building building) {
        this.buildings.put(building.getAdress(), building);
    }

    public Building getBuilding(String adress) {
        if (this.buildings.containsKey(adress)) {
            return this.buildings.get(adress);
        } else {
            return null;
        }
    }

    @Override
    public void createNewBuilding(String name, String adress) {
        addBuilding(new Building(name, adress));
    }
}
