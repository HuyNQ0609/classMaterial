package model;

import java.time.LocalDate;
public class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour() {}

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public String toString() {
        return "CrispyFlour: "
                + "id = " + getId()
                + ", name = " + getName()
                + ", manufacturingDate = " + getManufacturingDate()
                + ", cost = " + getCost()
                + ", quantity = " + getQuantity();
    }

    @Override
    public double getRealMoney() {
        int dueMonth = getExpiryDate().getMonthValue() - LocalDate.now().getMonthValue();
        if (dueMonth <= 2) {
            return getAmount() * (1 - 0.4);
        } else if (dueMonth <= 4) {
            return getAmount() * (1 - 0.2);
        } else {
            return getAmount() * (1 - 0.05);
        }
    }

}
