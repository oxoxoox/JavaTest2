import java.time.LocalDate;

public class Beer extends Drinks{
    private float content;

    public Beer( String name,double cost, LocalDate dateInProduced,  float content) {
        super(name, cost, dateInProduced, 30);
        this.content = content;
    }

    public float getContent() {
        return content;
    }

    public void setContent(float content) {
        this.content = content;
    }

    public String toString(){
        return "饮料名称"+getName()+"成本"+getCost()+"度数"+getContent()+"是否过期"+isOverdue();
    }
}
