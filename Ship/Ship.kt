package Ship

open class Ship (
    var crewSize: Int = 11,
    open var maxCrewSize: Int = 25,
    var crewWeightEa: Int = 150,
    open var maxWeight: Int = 10000) {

    var totalWeight: Int
        get() = crewSize * crewWeightEa
        set(value) {}

    constructor(crewSize: Int, currentWeight: Int): this() {
        crewWeightEa = currentWeight / crewSize;
    };

}


class OneManShip(): Ship() {
    override var maxCrewSize = 1;
    override var maxWeight = 500;
}