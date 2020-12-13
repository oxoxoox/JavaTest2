import java.time.LocalDate;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate dateInProduced;

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getDateInProduced() {
        return dateInProduced;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    private int expirationDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDateInProduced(LocalDate dateInProduced) {
        this.dateInProduced = dateInProduced;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Drinks(String name, double cost, LocalDate dateInProduced, int expirationDate){
        this.name=name;
        this.cost=cost;
        this.dateInProduced=dateInProduced;
        this.expirationDate=expirationDate;
    }
    public boolean isOverdue(){
        LocalDate data =this.dateInProduced.plusDays(expirationDate);
        if(data.isAfter(LocalDate.now()))
            return true;
        else
            return false;
    }
    public abstract String toString();
}
