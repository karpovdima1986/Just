package ru.netology


fun main() {

    println(agoToText(2460))
}

enum class TimeVizit(val value : Int){
    MINUTE(60), HOUR(60 * 60), DAY(60 * 60 * 24)
}


fun agoToText (timeVizit: Int) = when (timeVizit){
    in 0..TimeVizit.MINUTE.value -> " был(а) только что"

    in 61.. (TimeVizit.HOUR.value - 1) -> {
        val tempTime = timeVizit / TimeVizit.MINUTE.value
        print( "был(а) $tempTime ${timeToText(tempTime, TimeVizit.MINUTE)} назад ")
    }

    in TimeVizit.HOUR.value.. TimeVizit.DAY.value -> {
        val tempTime = timeVizit / TimeVizit.HOUR.value
        print( "был(а) $tempTime ${timeToText(tempTime, TimeVizit.HOUR)} назад ")
    }

    in (TimeVizit.DAY.value + 1).. 2 * TimeVizit.DAY.value -> "был(а) вчера"

    in (2 * TimeVizit.DAY.value + 1).. 3 * TimeVizit.DAY.value -> "был(а) позавчера"

    else -> "был(а) давно"
}

fun timeToText(time: Int, type: TimeVizit): String {

    val lastSymbol = time

    when (type) {

        TimeVizit.MINUTE ->

            when (lastSymbol) {
                1, 21, 31, 41, 51  -> return "минуту"

                in 2..4, in 22..24, in 32..34,
                in 42..44, in 52..54 -> return "минуты"

                in 5..9, in 15..19, in 25..29,
                in 35..39, in 45..49,
                in 55..59,  10, 20, 30 , 40, 50 -> return "минут"

                11,12,13,14 -> return "минут"
            }

        TimeVizit.HOUR ->

            when (lastSymbol) {
                1, 21 -> return "час"

                in 2..4 , 22, 23-> return "часа"

                in 5..20 -> return "часов"
            }
        else -> return "Error"
    }
    return "Error"
}


