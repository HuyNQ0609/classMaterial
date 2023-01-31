package product;

import product.Material;

import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat() {

    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return cost * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusDays(7);
    }

    @Override
    public String toString() {
        return "Meat: "
                + "id = " + id
                + ", name = " + name
                + ", manufacturingDate = " + manufacturingDate
                + ", cost = " + cost
                + ", weight = " + weight;
    }

    public double getPriceAfterSale() {
        int dueDate = getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth();
        if (dueDate <= 5) {
            return getAmount() * (1- 0.3);
        }
        else {
            return getAmount() * (1- 0.1);
        }
    }

    @Override
    public double getRealMoney(Material material) {
        return 0;
    }
}
