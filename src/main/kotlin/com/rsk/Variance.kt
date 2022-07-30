package com.rsk

fun main(args: Array<String>) {
    var financeMeeting = mutableListOf(FinanceMeeting())
    var meetings: AllMeetings<FinanceMeeting> = AllMeetings(financeMeeting)

    attendAllMeeting(meetings)
}

// out: means I am only trying to get from T, but not trying to save things from into the list
class AllMeetings< out T: Meeting> (val meetings: List<Meeting>){
    val count: Int get() = meetings.count()

//    return a given meeting at specific index
    operator fun get(i: Int) = meetings[i]
}

fun attendAllMeeting(meeting: AllMeetings<Meeting>){
//    pass all meeting and iterate over the meeting and mark it attended
    for (i in 0 until meeting.count){
        meeting[i].attend()
    }
}