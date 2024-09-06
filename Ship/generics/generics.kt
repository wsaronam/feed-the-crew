package Ship.generics

open class FoodSupply(var needsCooking: Boolean)

class Soup: FoodSupply(true) {
    fun addSpices() {
        needsCooking = false;
    }
}

class PrecookedSoup: FoodSupply(false);

class SpoiledSoup: FoodSupply(false) {
    fun throwaway() {
        needsCooking = false;
    }
}

class Ship<T: FoodSupply>(val foodSupply: T) {
    fun addIngredients() {
        check(!foodSupply.needsCooking) { "food needs cooking!" }
        println("adding ingredients from $foodSupply")
    }
}

fun main(args: Array<String>) {
    val myShip = Ship(Soup());
    myShip.foodSupply.addSpices();
}