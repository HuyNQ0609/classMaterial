package views;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Material> materialList = new ArrayList<>();
    public static MaterialManager product = new MaterialManager(materialList);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int numberChoose;
        do {
            System.out.println("""

                    Menu:
                    1. Add a new Crispy Flour.
                    2. Add a new Meat.
                    3. Edit an other Crispy Flour.
                    4. Edit an other Meat.
                    5. Show material list.
                    6. Delete Material.
                    7. Total crispy flour and meat price difference today.
                    0. Exit.""");
            System.out.print("Enter choose of you: ");
            numberChoose = input.nextInt();
            extracted(numberChoose);
        } while (true);
    }

    private static void extracted(int numberChoose) {
        switch (numberChoose) {
            case 1 -> product.addMaterial(new CrispyFlour(enterId(), enterName(),
                        LocalDate.now().plusMonths(enterMonths()), enterCost(), enterQuantity()));

            case 2 -> product.addMaterial(new Meat(enterId(), enterName(),
                        LocalDate.now().plusDays(enterDays()), enterCost(), enterWeight()));

            case 3 -> {
                product.editMaterial(new CrispyFlour(enterId(), enterName(),
                        LocalDate.now().plusMonths(enterMonths()), enterCost(), enterQuantity()));
                print();
            }

            case 4 -> {
                product.editMaterial(new Meat(enterId(), enterName(),
                        LocalDate.now().plusDays(enterDays()), enterCost(), enterWeight()));
                print();
            }

            case 5 -> print();

            case 6 -> {
                product.deleteMaterial(enterIndex());
                System.out.println(materialList);

            }
            case 7 -> System.out.println(product.getDifference());
            case 0 -> System.exit(numberChoose);
            default -> System.out.println("Please choose again!\n");
        }
    }

    public static void print() {
        for (Material material : materialList) {
            System.out.println(material);
        }
    }

    public static int enterIndex() {
        System.out.print("Enter index: ");
        return input.nextInt();
    }

    public static String enterId() {
        System.out.print("Enter id: ");
        input.nextLine();
        return input.nextLine();
    }

    public static String enterName() {
        System.out.print("Enter name: ");
        return input.nextLine();
    }

    public static int enterCost() {
        System.out.print("Enter cost: ");
        return input.nextInt();
    }

    public static int enterQuantity() {
        System.out.print("Enter quantity: ");
        return input.nextInt();
    }

    public static double enterWeight() {
        System.out.print("Enter weight: ");
        return input.nextDouble();
    }

    public static int enterMonths() {
        System.out.print("Enter the number of months you want to add: ");
        return input.nextInt();
    }

    public static int enterDays() {
        System.out.print("Enter the number of days you want to add: ");
        return input.nextInt();
    }
}
