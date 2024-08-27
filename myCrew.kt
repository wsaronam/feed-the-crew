import java.util.*

fun feedTheCrew() {
    val day = randomDay();
    val food = crewFood(day);
    println("Today is $day and the crew will eat $food!");
    dailyActivity();

    if (shouldCleanShip(day)) {
        println("The crew needs to clean the ship today.");
    }
}

fun randomDay() : String {
    val weekArr = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    return weekArr[Random().nextInt(7)];
}

fun crewFood(day: String): String {
    return when (day) {
        "Monday" -> "sandwich";
        "Tuesday" -> "meat";
        "Wednesday" -> "cola";
        "Thursday" -> "salad";
        "Friday" -> "pasta";
        "Saturday" -> "barbecue";
        "Sunday" -> "fish";
        else -> "bread";
    }
}

fun dailyActivity(activity: String = "sleep") {
    println("Today the crew will $activity");
}

fun shouldCleanShip(day: String, dirty: Int = 0): Boolean {
    return true;
}

fun addMoreCrewmates(shipSize: Int,
                     currentCrew: Array<String>,
                     numOfNewCrewmates: Int = 1,
                     hasFurniture: Boolean = true): Boolean {
    // For the sake of this example, I will say that having furniture in the ship counts as 4 additional crewmates.
    // The ship size will determine the maximum number of crewmates that can belong on the ship.
    var numOfCrewMates: Int = currentCrew.size + numOfNewCrewmates;
    if (hasFurniture) {
        numOfCrewMates += 4;
    }

    if (numOfCrewMates <= shipSize) {
        return true;
    }
    return false;
}

fun main(args: Array<String>) {
    feedTheCrew();
}