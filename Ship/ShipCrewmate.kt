package Ship

abstract class ShipCrewmate {
    abstract val name: String;
}

class Doctor: ShipCrewmate(), CrewAction {
    override val name = "Chopper";

    override fun eat() {
        println("$name eats cotton candy!")
    }
}

class Captain: ShipCrewmate(), CrewAction by PrintCrewAction("meat"), FavoriteFood by MeatFood {
    override val name = "Luffy";

    override fun eat() {
        println("$name eats meat!")
    }
}

interface CrewAction {
    fun eat();
}

interface FavoriteFood {
    val food: String;
}

object MeatFood: FavoriteFood {
    override val food = "meat";
}

class PrintCrewAction(val food: String): CrewAction {
    override fun eat() {
        println(food);
    }
}