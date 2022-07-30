package com.rsk

fun main(args: Array<String>) {
    val meetings = listOf(BoardMeeting(), FinanceMeeting(), BoardMeeting(), BoardMeeting())

//    return all the board meeting in the list
    val board = meetings.typeOf<BoardMeeting>()

    println(board.count())
}

// operate on one meeting at a time based on the type (*) means any
// by reifying the function and making inline we can now check the types at runtime
inline fun <reified T> List<*>.typeOf(): List<T>{
    val returnList = mutableListOf<T>()

    for(item in this){
        if(item is T){
            returnList.add(item)
        }
    }

    return returnList
}

// The function -> has a type parameter T which must be Meeting, takes a class obj of type T, takes an action that
//  operate on that type and returns it
fun <T: Meeting> buildMeeting(meetingClass: Class<T>, action: (T) -> Unit):T{
     val meeting: T = meetingClass.newInstance()
    action(meeting)
    return meeting
}

// instead of the above we can also do this -> we want certain parameter noinline
inline fun <reified T: Meeting> buildMeeting(noinline action: (T) -> Unit):T{
    return buildMeeting(T::class.java, action)
}

open class Meeting {
    fun attend() {
        TODO("Not yet implemented")
    }

}

class BoardMeeting: Meeting(){

}

class FinanceMeeting: Meeting(){

}