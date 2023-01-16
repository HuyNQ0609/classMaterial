package run;

import product.Material;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        materialManager.display();
    }
}