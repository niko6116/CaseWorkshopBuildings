/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Bruger
 */
public class BusinessFacade {

    private BuildingManagement buildingManagement;

    public BusinessFacade() {
        this.buildingManagement = new BuildingManagement();
    }

    public BuildingManagement getBuildingManagement() {
        return this.buildingManagement;
    }

    public void addNewBuilding(String name, String adress) {
        this.buildingManagement.createNewBuilding(name, adress);
    }
}
