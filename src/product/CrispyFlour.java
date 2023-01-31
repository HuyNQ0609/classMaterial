package product;

import java.time.LocalDate;
public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour() {

    }

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
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public String toString() {
        return "CrispyFlour: "
                + "id = " + id
                + ", name = " + name
                + ", manufacturingDate = " + manufacturingDate
                + ", cost = " + cost
                + ", quantity = " + quantity;
    }
    public double getPriceAfterSale() {
        int dueMonth = getExpiryDate().getMonthValue() - LocalDate.now().getMonthValue();
        if (dueMonth <= 2) {
            return getAmount() * (1 - 0.4);
        } else if (dueMonth <= 4) {
            return getAmount() * (1 - 0.2);
        } else {
            return getAmount() * (1 - 0.05);
        }
    }

    @Override
    public double getRealMoney(Material material) {
        return 0;
    }
}
