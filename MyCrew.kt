import java.util.*




var dirtiness: Int = 0;




fun feedTheCrew() {
    val day = randomDay();
    val food = crewFood(day);
    println("Today is $day and the crew will eat $food!");
    dailyActivity();

    if (shouldCleanShip(day)) {
        println("The crew needs to clean the ship today.");
    }
}

fun fedCrew(dirty: Int) = dirty + 2;

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty);
}

fun dirtyProcessor() {
    dirtiness = updateDirty(dirtiness,cleanShip);
    dirtiness = updateDirty(dirtiness, ::fedCrew);
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
    val isDirty = dirty > 10;
    val isCleaningDay = day == "Wednesday";

    return when {
        isDirty -> true;
        isCleaningDay -> true;
        else -> false;
    }
}

val cleanShip: (Int) -> Int = {dirty -> dirty / 2};

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

    val fishingGear = "fishing rod" to "catch fish";
    val (tool, use) = fishingGear;
    println("The crew will use a $tool to $use!");

    val favoriteFoodList = mutableListOf("meat", "cotton candy", "cola", "sandwiches", "beer");
    favoriteFoodList.add("tea");
    favoriteFoodList.remove("cola");
    favoriteFoodList.contains("meat");
    favoriteFoodList.contains("cola");
    println(favoriteFoodList.subList(2, favoriteFoodList.size))

    val favoriteFoods = mapOf("luffy" to "meat", "chopper" to "cotton candy", "franky" to "cola");
    println(favoriteFoods.get("chopper"));
    println(favoriteFoods["chopper"]);
    println(favoriteFoods.getOrDefault("nami", "unknown"));
    favoriteFoods.getOrElse("nami") {"still unknown"}

    val favoriteWeapons = mutableMapOf("luffy" to "hands");
    favoriteWeapons.put("chopper", "transformations");
    favoriteWeapons.remove("luffy");
}