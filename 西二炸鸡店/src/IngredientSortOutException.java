public class IngredientSortOutException extends RuntimeException {
    private String name;
    public IngredientSortOutException(Drinks drinks){
        super("提示店主，余额不够");
        this.name=drinks.getName();
    }
    public String getName(){
        return name;
    }
}
