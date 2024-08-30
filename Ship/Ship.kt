package Ship

class Ship (
    var crewSize: Int = 11,
    var maxCrewSize: Int = 25,
    var crewWeightEa: Int = 150,
    var maxWeight: Int = 10000) {

    var totalWeight: Int
        get() = crewSize * crewWeightEa
        set(value) {}

    constructor(crewSize: Int, currentWeight: Int): this() {
        crewWeightEa = currentWeight / crewSize;
    };

}