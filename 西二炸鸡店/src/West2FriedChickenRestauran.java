import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class West2FriedChickenRestauran implements FriedChickenResaurant{
    private double balance;
    Map<Beer,Integer> beers=new HashMap<>();
    Map<Juice,Integer> juices=new HashMap<>();
    static Set<SetMeal> meals=new HashSet<>();
    private void use(Beer beer) throws IngredientSortOutException{
        int n=beers.get(beer);
        if(n<1){
            throw new IngredientSortOutException(beer);
        }
        else {
            beers.put(beer,beers.get(beer)-1);
        }
    }
    private void use(Juice juice) throws IngredientSortOutException {
            int n = juices.get(juice);
            if (n < 1) {
                throw new IngredientSortOutException(juice);
            } else {
                juices.put(juice, juices.get(juice) - 1);
            }
        }

    @Override
    public void sellMeal(SetMeal setMeal) {
        try{
            if(setMeal.getDrink() instanceof Juice){
                Juice j=(Juice)setMeal.getDrink();
                use(j);
                balance+=setMeal.getPrice();
            }
            if(setMeal.getDrink() instanceof Beer){
                Beer b=(Beer) setMeal.getDrink();
                use(b);
                balance+=setMeal.getPrice();
            }
        }
        catch (IngredientSortOutException e){
            System.out.println("饮料售光，售光饮料为："+e.getName());
        }
    }

    @Override
    public void batchPurchase(Drinks drinks,int number) throws OverdraftBalanceException{
        if(this.balance<drinks.getCost()*number){
            throw new OverdraftBalanceException(drinks.getCost()*number-this.balance);
        }
        else {
            if(drinks instanceof Beer){
                Beer b=(Beer)drinks;
                beers.put(b,beers.get(b)+number);
                this.balance-=drinks.getCost();
            }
            else if(drinks instanceof Juice){
                Juice j=(Juice) drinks;
                juices.put(j,juices.get(j)+number);
                this.balance-=drinks.getCost();
            }
        }
    }
    static {
        SetMeal m1=new SetMeal();
        SetMeal m2=new SetMeal();
        SetMeal m3=new SetMeal();
        meals.add(m1);
        meals.add(m2);
        meals.add(m3);
    }
}
