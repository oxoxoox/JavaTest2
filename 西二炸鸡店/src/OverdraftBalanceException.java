public class OverdraftBalanceException extends RuntimeException{
    private double difference;
    public OverdraftBalanceException(double d){
        super("提示顾客，饮料售光");
        this.difference=d;
    }
    public double getDifference(){
        return difference;
    }
}
