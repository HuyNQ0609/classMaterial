package model;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {}

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
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusWeeks(1);
    }

    @Override
    public String toString() {
        return "Meat: "
                + "id = " + getId()
                + ", name = " + getName()
                + ", manufacturingDate = " + getManufacturingDate()
                + ", cost = " + getCost()
                + ", weight = " + getWeight();
    }
    @Override
    public double getRealMoney() {
        int dueDate = getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth();
        if (dueDate <= 5) {
            return getAmount() * (1 - 0.3);
        }
        else {
            return getAmount() * (1 - 0.1);
        }
    }
}
