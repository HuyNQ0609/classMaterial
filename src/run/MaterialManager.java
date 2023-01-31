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
        materials.add(new CrispyFlour("1", "name1", LocalDate.now().plusMonths(5), 150, 25));
        materials.add(new CrispyFlour("2", "name3", LocalDate.now().plusMonths(4), 170, 24));
        materials.add(new CrispyFlour("3", "name5", LocalDate.now().plusMonths(3), 190, 23));
        materials.add(new CrispyFlour("4", "name7", LocalDate.now().plusMonths(2), 210, 22));
        materials.add(new CrispyFlour("5", "name9", LocalDate.now().plusMonths(1), 230, 21));
        materials.add(new Meat("6", "name2", LocalDate.now().plusDays(-1), 160, 2));
        materials.add(new Meat("7", "name4", LocalDate.now().plusDays(-2), 180, 2.5));
        materials.add(new Meat("8", "name6", LocalDate.now().plusDays(-3), 200, 3));
        materials.add(new Meat("9", "name8", LocalDate.now().plusDays(-5), 220, 3.5));
        materials.add(new Meat("10", "name10", LocalDate.now().plusDays(-1), 240, 4));
    }
    public void print() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public int size() {
        return materials.size();
    }

    public void add(Material material) {
        materials.add(material);
    }

    public int getIndex() {
        System.out.println("Enter the index: ");
        return input.nextInt();
    }

    public void deleteElements() {
        int index = getIndex();
        if (index < 0 || index > size() - 1) {
            System.out.println("Materials delete be added at this location!");
        } else {
            materials.remove(index);
        }
    }

    public void addToIndex(Material material) {
        int index = getIndex();
        if(index < 0) {
            System.out.println("Materials cannot be added at this location!");
        } else if (index > size() - 1) {
            add(material);
        } else {
            materials.add(index, material);
        }
    }
}
