package Q1.pubV0;

public class DBDrink {
	
	private DBIngredient _dbingredient = new DBIngredient();
	
	private static final String ONE_BEER = "hansa";
    private static final String ONE_CIDER = "grans";
    private static final String A_PROPER_CIDER = "strongbow";
    private static final String GT = "gt";
    private static final String BACARDI_SPECIAL = "bacardi_special";
	
    private int _price = 0;
    
	protected int getDrinkPrice(String drink) {
		if (drink.equals(ONE_BEER)) {
            _price = 74;
        }
        else if (drink.equals(ONE_CIDER)) {
            _price = 103;
        }
        else if (drink.equals(A_PROPER_CIDER)) {
        	_price = 110;
        }
        else if (drink.equals(GT)) {
            _price += _dbingredient.getIngredientPrice("gin"); //Ingredient 6
            _price += _dbingredient.getIngredientPrice("tonic_water"); //Ingredient 5
            _price += _dbingredient.getIngredientPrice("green_stuff"); //Ingredient 4
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
        	_price += _dbingredient.getIngredientPrice("gin"); //Ingredient 6
            _price += _dbingredient.getIngredientPrice("lime_juice"); //Ingredient 3
            _price += _dbingredient.getIngredientPrice("grenadine"); //Ingredient 2
        	_price += _dbingredient.getIngredientPrice("rum"); //Ingredient 1
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
		
		return _price;
	}
}
