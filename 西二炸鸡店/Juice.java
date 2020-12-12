import java.time.LocalDate;

public class Juice extends Drinks {
    public Juice(String name,double cost, LocalDate dateInProduced) {
        super(name, cost, dateInProduced, 2);
    }
    public String toString(){
        return "饮料名称"+getName()+"成本"+getCost()+"是否过期"+isOverdue();
    }
}
