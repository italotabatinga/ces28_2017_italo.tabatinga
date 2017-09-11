package Q1.pubV0;

public class DBIngredient {
	
	private static final String INGREDIENT1 = "rum";
    private static final String INGREDIENT2 = "grenadine";
    private static final String INGREDIENT3 = "lime_juice";
    private static final String INGREDIENT4 = "green_stuff";
    private static final String INGREDIENT5 = "tonic_water";
    private static final String INGREDIENT6 = "gin";
    
	protected int getIngredientPrice(String ingredient) {
		if (ingredient.equals(INGREDIENT1)) {
            return 65;
        }
        else if (ingredient.equals(INGREDIENT2)) {
            return 10;
        }
        else if (ingredient.equals(INGREDIENT3)) {
        	return 10;
        }
        else if (ingredient.equals(INGREDIENT4)) {
        	return 10;
        }
        else if (ingredient.equals(INGREDIENT5)) {
        	return 20;
        }
        else if (ingredient.equals(INGREDIENT6)) {
        	return 85;
        }
        else {
            throw new RuntimeException("No such ingredient exists");
        }
	}
}
