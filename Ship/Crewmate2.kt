package Ship

data class Crewmate2(var name: String) {

}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block();
}




fun main(args: Array<String>) {
    val crewmate = Crewmate2("luffy");
    myWith (crewmate.name) {
        capitalize();
    }

    val crewmate2 = Crewmate2("luffy").apply{name = "Chopper"};
    println(crewmate2.name);

    println(crewmate.let{it.name.capitalize()}
        .let{it + "crewmate"}
        .let{it.length}
        .let{it + 11})
}