package Ship.Food

data class Food(val name: String) {
}

data class Food2(val name: String, val mainIngredient: String) {

}

object MargeritaPizza {
    val type = "pizza";
}

enum class FoodColor (val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

sealed class DeepDishPizza

class ChicagoPizza: DeepDishPizza();
class NewYorkPizza: DeepDishPizza();


fun makeFood() {
    val food1 = Food("pizza");
}