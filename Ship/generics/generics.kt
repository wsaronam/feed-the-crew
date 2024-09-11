package Ship.generics

open class FoodSupply(var needsCooking: Boolean)

class Soup: FoodSupply(true) {
    fun addSpices() {
        needsCooking = false;
    }

    fun improveDish() {
        needsCooking = true;
    }
}

class PrecookedSoup: FoodSupply(false);

class SpoiledSoup: FoodSupply(false) {
    fun throwaway() {
        needsCooking = false;
    }
}

class Dish<out T: FoodSupply>(val foodSupply: T) {
    fun addIngredients(ingredients: Ingredient<T>) {
        if (foodSupply.needsCooking) {
            ingredients.improve(foodSupply);
        }
        println("adding ingredients from $foodSupply")
    }
}

interface Ingredient<in T: FoodSupply> {
    fun improve(foodSupply: T)
}

class SoupDishImprover: Ingredient<Soup> {
    override fun improve(foodSupply: Soup) {
        foodSupply.improveDish();
    }
}

fun <T: FoodSupply> isFoodCooked(food: Dish<T>) {
    println("Food is cooked: ${food.foodSupply.needsCooking}")
}

inline fun <reified T: FoodSupply> FoodSupply.isOfType() = this is T;
inline fun <reified R: FoodSupply> Dish<*>.hasFoodSupplyOfType() = foodSupply is R;


fun main(args: Array<String>) {
    val soupDishImprover = SoupDishImprover();
    val myDish = Dish(Soup());
    myDish.foodSupply.addSpices();
    myDish.addIngredients(soupDishImprover);

    isFoodCooked(myDish);
    myDish.hasFoodSupplyOfType<Soup>();
    myDish.foodSupply.isOfType<SpoiledSoup>();
}