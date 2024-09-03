package Ship




fun buildShip() {
    val myShip = Ship();
}

fun makeCrewmates() {
    val doctor = Doctor();
    val captain = Captain();

    println("${doctor.name} is the doctor and ${captain.name} is the captain!")
    doctor.eat();
    captain.eat();
}




fun main(args: Array<String>) {
    buildShip();
    makeCrewmates();
}

