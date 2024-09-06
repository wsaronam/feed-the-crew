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


open class ShipFurniture(val color: String, private val size: Int)
class BrownCouchFurniture(size: Int): ShipFurniture("brown", size);
fun ShipFurniture.isBrown() = color == "brown";
fun ShipFurniture.print() = println("This is a ship furniture!");
fun BrownCouchFurniture.print() = println("This is a brown couch ship furniture!");

val ShipFurniture.isRed: Boolean
    get() = color == "red";

fun ShipFurniture?.pull() {
    this?.apply {
        println("removing $this");
    }
}


fun furnitureFunc() {
    val myCouch = BrownCouchFurniture(size = 5);
    myCouch.print();
    val myFurniture = myCouch;
    myFurniture.print();

    val myFurniture2 = ShipFurniture("red", 3);
    myFurniture2.isRed;

    val myFurniture3: ShipFurniture? = null;
    myFurniture3.pull();
}