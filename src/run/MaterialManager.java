package run;

import product.CrispyFlour;
import product.Material;
import product.Meat;

import java.time.LocalDate;
import java.util.*;

public class MaterialManager {
    List<Material> materials;
    Scanner input = new Scanner(System.in);

    public MaterialManager() {
        materials = new ArrayList<>();
        materials.add(new CrispyFlour("1", "name1", LocalDate.now().plusMonths(-11), 150, 25));
        materials.add(new CrispyFlour("2", "name3", LocalDate.now().plusMonths(-9), 170, 24));
        materials.add(new CrispyFlour("3", "name5", LocalDate.now().plusMonths(-7), 190, 23));
        materials.add(new CrispyFlour("4", "name7", LocalDate.now().plusMonths(-5), 210, 22));
        materials.add(new CrispyFlour("5", "name9", LocalDate.now().plusMonths(-3), 230, 21));
        materials.add(new Meat("6", "name2", LocalDate.now().plusDays(-1), 160, 2));
        materials.add(new Meat("7", "name4", LocalDate.now().plusDays(-2), 180, 2.5));
        materials.add(new Meat("8", "name6", LocalDate.now().plusDays(-3), 200, 3));
        materials.add(new Meat("9", "name8", LocalDate.now().plusDays(-5), 220, 3.5));
        materials.add(new Meat("10", "name10", LocalDate.now().plusDays(-1), 240, 4));
    }

    /** Return size of List Material */
    public int size() {
        return materials.size();
    }

    /** Enter the index to add, edit and delete */
    public int getIndex() {
        System.out.println("Enter the index: ");
        return input.nextInt();
    }

    /** Print List Material */
    public void print() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    /** Add new material */
    public void addMaterial(Material material) {
        materials.add(material);
    }

    /** Edit material */
    public void editMaterial(Material material) {
        int index = getIndex();
        if(index < 0 || index > size() - 1) {
            System.out.println("Material cannot be added at this location!");
        } else {
            materials.set(index, material);
        }
    }

    /** Delete material */
    public void deleteMaterial() {
        int index = getIndex();
        if (index < 0 || index > size() - 1) {
            System.out.println("Material delete be added at this location!");
        } else {
            materials.remove(index);
        }
    }

    /** Create new material*/
    public String enterId() {
        System.out.println("Enter id: ");
        return input.nextLine();
    }
    public String enterName() {
        System.out.println("Enter name: ");
        return input.nextLine();
    }
    public int enterCost() {
        System.out.println("Enter cost: ");
        return input.nextInt();
    }
    public int addMonths() {
        System.out.println("Enter the number of months you want to add: ");
        return input.nextInt();
    }
    public int addDays() {
        System.out.println("Enter the number of days you want to add: ");
        return input.nextInt();
    }
    public double enterWeight() {
        System.out.println("Enter weight");
        return input.nextDouble();
    }
    public int enterQuantity() {
        System.out.println("Enter quantity: ");
        return input.nextInt();
    }

    /** Difference between discounted and non-discounted at today */
    public void differenceCostCrispyFlour() {
        double totalOriginCost = 0;
        double totalCostAfterSale = 0;
        double differenceCost;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                totalOriginCost += material.getAmount();
                totalCostAfterSale += ((CrispyFlour) material).getRealMoney();
            }
        }
        differenceCost = totalOriginCost - totalCostAfterSale;
        System.out.println("Initial CrispyFlour price: " + totalOriginCost);
        System.out.println("Promotional CrispyFlour price " + totalCostAfterSale);
        System.out.println("Price CrispyFlour difference: " + differenceCost);
    }

    public void differenceCostMeat() {
        double totalOriginCost = 0;
        double totalCostAfterSale = 0;
        double differenceCost;
        for (Material material : materials) {
            if (material instanceof Meat) {
                totalOriginCost += material.getAmount();
                totalCostAfterSale += ((Meat) material).getRealMoney();
            }
        }
        differenceCost = totalOriginCost - totalCostAfterSale;
        System.out.println("Initial Meat price: " + totalOriginCost);
        System.out.println("Promotional Meat price " + totalCostAfterSale);
        System.out.println("Price Meat difference: " + differenceCost);
    }
}
