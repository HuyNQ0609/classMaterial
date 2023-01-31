package run;

import product.CrispyFlour;
import product.Meat;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager product = new MaterialManager();
        Scanner input = new Scanner(System.in);
        int numberChoose;
        do {
            System.out.println("""
                    
                    Menu:
                    1. Show material list.
                    2. Add a new Crispy Flour.
                    3. Add a new Meat.
                    4. Edit a new Crispy Flour.
                    5. Edit a new Meat.
                    6. Delete Material.
                    7. Origin and sale price of CrispyFlour.
                    8. Origin and sale price of Meat.
                    0. Exit.""");
            System.out.println("Enter choose of you: ");
            numberChoose = input.nextInt();
            switch (numberChoose) {
                case 1 -> product.print();

                case 2 -> {
                    product.addMaterial(new CrispyFlour(product.enterId(),
                            product.enterName(), LocalDate.now().plusMonths(product.addMonths()),
                            product.enterCost(), product.enterQuantity()));
                    product.print();
                }

                case 3 -> {
                    product.addMaterial(new Meat(product.enterId(),
                            product.enterName(), LocalDate.now().plusDays(product.addDays()),
                            product.enterCost(), product.enterWeight()));
                    product.print();
                }

                case 4 -> {
                    product.editMaterial(new CrispyFlour(product.enterId(),
                            product.enterName(), LocalDate.now().plusMonths(product.addMonths()),
                            product.enterCost(), product.enterQuantity()));
                    product.print();
                }

                case 5 -> {
                    product.editMaterial(new Meat(product.enterId(),
                                product.enterName(), LocalDate.now().plusDays(product.addDays()),
                                product.enterCost(), product.enterWeight()));
                    product.print();
                }

                case 6 -> {
                    product.deleteMaterial();
                    product.print();
                }
                case 7 -> product.differenceCostCrispyFlour();
                case 8 -> product.differenceCostMeat();
                case 0 -> System.exit(numberChoose);
                default -> System.out.println("Please choose again!\n");
            }
        } while (true);
    }
}
