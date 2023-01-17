package run;

import product.CrispyFlour;
import product.Material;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        System.out.println("\n");
        System.out.println("--------------------------------List Material Before--------------------------------");
        materialManager.print();
        System.out.println("\n");
        System.out.println("-----------------------------List Material After Delete-----------------------------");
        materialManager.deleteElements("No.3");
        materialManager.print();
        System.out.println("\n");
        materialManager.update(new CrispyFlour("er11", "rer11",
                LocalDate.now().plusMonths(5), 149, 26), 3);
        System.out.println("-----------------------------List Material After Repair-----------------------------");
        materialManager.print();
        System.out.println("\n");
        for (int i = 0; i < materialManager.getMaterials().size(); i++) {
            materialManager.getRealMoney(materialManager.getMaterials().get(i));
        }
    }
}