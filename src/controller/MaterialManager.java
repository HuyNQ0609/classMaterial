package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.util.*;

public class MaterialManager {
    List<Material> materials;

    public MaterialManager(List<Material> materials) {
        this.materials = materials;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    /** Add new material */
    public void addMaterial(Material material) {
        materials.add(material);
    }

    /** Edit material */
    public void editMaterial(Material material) {
        int index = 0;
        materials.set(index, material);
    }

    /** Delete material */
    public void deleteMaterial(int index) {
            materials.remove(index);
    }

    /** Difference between discounted and non-discounted at today */
    public String getDifference() {
        double totalOfCrispyFlour = 0;
        double totalOfMeat = 0;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                totalOfCrispyFlour += material.getAmount() - ((CrispyFlour) material).getRealMoney();
            } else {
                totalOfMeat += material.getAmount() - ((Meat) material).getRealMoney();
            }
        }
        return "Total crispy flour price difference today: " + totalOfCrispyFlour
                + "\nTotal meat price difference today: " + totalOfMeat;
    }
}
