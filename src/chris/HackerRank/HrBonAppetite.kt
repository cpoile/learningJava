package chris.HackerRank

fun readToInts(): IntArray {
    return readLine()!!.split(" ").map(String::toInt).toIntArray()
}

fun HrBonAppetite(args: Array<String>?) {
    val (n, k) = readToInts()
    val cost = readToInts()
    val bCharged = readToInts()[0]
    val shouldCost = cost
    shouldCost[k] = 0
    val shouldCharged = shouldCost.sum() / 2

    if (shouldCharged == bCharged)
        println("Bon Appetit")
    else
        println(bCharged - shouldCharged)
}