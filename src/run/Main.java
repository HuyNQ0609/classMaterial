package run;

import product.CrispyFlour;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
//        System.out.println("---------------Add new material----------------\n");
//        materialManager.add(new CrispyFlour("11", "name11", LocalDate.now().plusMonths(5), 250, 20));
//        materialManager.print();
//
//        System.out.println("---------------Add new material to index----------------\n");
//        materialManager.addToIndex(new CrispyFlour("11", "name11", LocalDate.now().plusMonths(5), 250, 20));
//        materialManager.print();
//
//        System.out.println("---------------Delete new material to index----------------\n");
//        materialManager.deleteElements();
//        materialManager.print();

        System.out.println("---------------Repair material to index----------------\n");
        materialManager.editMaterial(new CrispyFlour("11", "name11", LocalDate.now().plusMonths(5), 250, 20));
        materialManager.print();
    }
}




















//        Scanner input = new Scanner(System.in);
//        int numberChoose;
//        do {
//            System.out.println("Menu:\n" +
//                               "1. Show material list.\n" +
//                               "2. Add a new Material.\n" +
//                               "3. Set Material.\n" +
//                               "4. Delete Material.\n" +
//                               "5. Origin and sale price of CrispyFlour.\n" +
//                               "6. Origin and sale price of Meat.\n" +
//                               "0. Exit.");
//            System.out.println("Enter choose of you: ");
//            numberChoose = input.nextInt();
//            switch (numberChoose) {
//                case 1 -> materialManager.print();
//                case 2 -> materialManager.a();
//                case 1 -> materialManager.print();
//            }
//        } while (numberChoose != 0);