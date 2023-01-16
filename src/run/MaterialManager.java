package run;

import product.CrispyFlour;
import product.Material;
import product.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaterialManager {
    Material[] materials;
    Scanner input = new Scanner(System.in);

    public void display() {
        materials = new Material[10];
        materials[0] = new CrispyFlour("er1", "rer1", LocalDate.now().plusMonths(5), 149, 26);
        materials[1] = new Meat("er2", "rer2", LocalDate.now().plusDays(7), 150, 3.5);
        materials[2] = new CrispyFlour("er3", "rer3", LocalDate.now().plusMonths(4), 151, 27);
        materials[3] = new Meat("er4", "rer4", LocalDate.now().plusDays(3), 152, 3.6);
        materials[4] = new CrispyFlour("er5", "rer5", LocalDate.now().plusMonths(2), 153, 28);
        materials[5] = new Meat("er6", "rer6", LocalDate.now().plusDays(4), 154, 3.7);
        materials[6] = new CrispyFlour("er7", "rer7", LocalDate.now().plusMonths(6), 155, 29);
        materials[7] = new Meat("er8", "rer8", LocalDate.now().plusDays(2), 156, 3.8);
        materials[8] = new CrispyFlour("er9", "rer9", LocalDate.now().plusMonths(3), 157, 30);
        materials[9] = new Meat("er10", "rer10", LocalDate.now().plusDays(5), 158, 3.9);
//        ArrayList<Material> lists = new ArrayList<>(Arrays.asList(materials));
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public void menu() {
        System.out.println("The price after lowing down: " + cheapenPriceMeat(meterials, ));
    }

    public void deleteElements(ArrayList<Material> lists) {

    }
    public double cheapenPriceMeat(Material[] materials, int priceOfSale) {
        for (Material material : materials) {
            if (material instanceof Meat) {
                if (material.getManufacturingDate().compareTo(material.getExpiryDate()) <= 5) {
                    priceOfSale = priceOfSale * (100 - 30) / 100;
                }
                else {
                    priceOfSale = priceOfSale * (100 - 10) / 100;
                }
            }
        }
        return priceOfSale;
    }
}
