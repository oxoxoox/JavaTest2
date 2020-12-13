public class SetMeal {
    private String setMealName;
    private double price;
    private String friedChickenName;
    private Drinks drink;
    public SetMeal(){
    }
    public SetMeal(String setMealName,double price,String friedChickenName,Beer beer){
        this.setMealName=setMealName;
        this.price=price;
        this.friedChickenName=friedChickenName;
        this.drink=beer;
    }
    public SetMeal(String setMealName,double price,String friedChickenName,Juice juice){
        this.setMealName=setMealName;
        this.price=price;
        this.friedChickenName=friedChickenName;
        this.drink=juice;
    }

    public String getSetMealName() {
        return setMealName;
    }
    public double getPrice(){
        return price;
    }
    public String getFriedChickenName(){
        return friedChickenName;
    }
    public Drinks getDrink(){
        return drink;
    }
    public String toString(){
        return ("套餐名："+getSetMealName()+"套餐价格"+getPrice()+"炸鸡名"+getFriedChickenName()+drink.toString());
    }
}
