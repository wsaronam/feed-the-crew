package Ship

class Crewmate (val name: String = "", var weight: Int) {

    var crewmateName = name;
    var realWeight = weight;

    constructor(): this("", 150) {}

    init {
        if (name.lowercase() == "franky") {
            realWeight = 300;
        }
    }

}

fun makeDefaultCrewmate() = Crewmate("random guy", 150);
