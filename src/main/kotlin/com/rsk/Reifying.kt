package com.rsk

// by using inline reified type we can type check without getting runtime error

fun main(args: Array<String>) {
    val names = listOf("Wanjiru", "Cherono", "Chamgei")

    printType(listOf(1))
}

fun printType (items: List<Any>){
    val stuff = items as List<String>

    stuff.filter{s -> s==""}
}