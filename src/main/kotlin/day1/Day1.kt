package day1

import java.io.File
import kotlin.math.absoluteValue

private fun part1(list1:List<Int>, list2:List<Int>) {
    val sortedList1 = list1.sorted()
    val sortedList2 = list2.sorted()
    val pairs = List(sortedList1.size) { i -> Pair(sortedList1[i], sortedList2[i]) }
    val result = pairs.sumOf { (it.first - it.second).absoluteValue }
    println(result)
}

fun part2(list1:List<Int>, list2:List<Int>){
    val count = list2.groupingBy { it }.eachCount()
    val result = list1.sumOf { it * (count[it] ?: 0) }
    println(result)
}

fun main() {
    val file = "src/main/kotlin/day1/input_day1"
    val lines = File(file).readLines()
    val (list1, list2) = lines.map { line ->
        val (col1,col2) = line.split("   ").map { it.toInt() }
        col1 to col2
    }.unzip()
    part1(list1,list2)
    part2(list1,list2)
}

