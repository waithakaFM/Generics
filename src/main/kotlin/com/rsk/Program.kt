package com.rsk

fun main(args: Array<String>) {
    var names = listOf<String>("Franco", "Mwangi", "Waithaka")

    val name = names.itemAt(0)

    println(name)


    val n: Node<Int> = Node(2)

    println(n.value())
}

// this is a generic function
fun <T> List<T>.itemAt(ndx: Int): T{
    return this[ndx]
}

// Constrain generic type T is of type number -> useful when you want to constrain the type to particular interface
class Node<T: Number>(private val item:T){
    fun value(): T{
        return item
    }
}