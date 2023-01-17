package run;

import product.CrispyFlour;
import product.Discount;
import product.Material;
import product.Meat;

import java.time.LocalDate;
import java.util.*;

public class MaterialManager implements Discount {
    List<Material> materials;

    public MaterialManager() {
        materials = new ArrayList<>();
        materials.add(new CrispyFlour("No.1", "name1",
                LocalDate.now().plusMonths(5), 150, 25));
        materials.add(new Meat("No.2", "name2",
                LocalDate.now().plusDays(-1), 160, 2));
        materials.add(new CrispyFlour("No.3", "name3",
                LocalDate.now().plusMonths(7), 170, 24));
        materials.add(new Meat("No.4", "name4",
                LocalDate.now().plusDays(-2), 180, 2.5));
        materials.add(new CrispyFlour("No.5", "name5",
                LocalDate.now().plusMonths(1), 190, 23));
        materials.add(new Meat("No.6", "name6",
                LocalDate.now().plusDays(-3), 200, 3));
        materials.add(new CrispyFlour("No.7", "name7",
                LocalDate.now().plusMonths(1), 210, 22));
        materials.add(new Meat("No.8", "name8",
                LocalDate.now().plusDays(-5), 220, 3.5));
        materials.add(new CrispyFlour("No.9", "name9",
                LocalDate.now().plusMonths(1), 230, 21));
        materials.add(new Meat("No.10", "name10",
                LocalDate.now().plusDays(-1), 240, 4));
    }
    public void print() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public void deleteElements(String id) {
        for (int i = 0; i < materials.size(); i++) {
            if (id.equals(materials.get(i).getId())) {
                materials.remove(i);
            }
        }
    }
    public void addElement(Material material) {
        materials.add(material);
    }

    public void update(Material material1, int index) {
        materials.add(index, material1);
    }

    public List<Material> getMaterials() {
        return materials;
    }

    @Override
    public double getRealMoney(Material material) {
        double priceAfterSale = 0;
        if (material instanceof Meat) {
            int dueDate = material.getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth();
            if (dueDate <= 5) {
                System.out.println("Sale 30%");
                priceAfterSale = material.getCost() * (1- 0.3);
            }
            else {
                System.out.println("Sale 10%");
                priceAfterSale = material.getCost() * (1- 0.1);
            }
            System.out.println(priceAfterSale);
        } else {
            int dueMonth = material.getExpiryDate().getMonthValue() - LocalDate.now().getMonthValue();
            if (dueMonth <= 2) {
                System.out.println("Sale 40%");
                priceAfterSale = material.getCost() * (1 - 0.4);
            } else if (dueMonth <= 4) {
                System.out.println("Sale 20%");
                priceAfterSale = material.getCost() * (1 - 0.2);
            } else {
                System.out.println("Sale 5%");
                priceAfterSale = material.getCost() * (1 - 0.05);
            }
            System.out.println(priceAfterSale);
        }
        return priceAfterSale;
    }

}
