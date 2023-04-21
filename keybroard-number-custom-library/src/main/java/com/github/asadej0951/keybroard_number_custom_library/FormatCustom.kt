package com.github.asadej0951.keybroard_number_custom_library

import android.util.Log

class FormatCustom {

    fun setFormat(format: String = "###-###-####", string: String = "123-456-7890"): String {
        val charArrayFormat = format.toCharArray()
        var stringReturn = string
        if (stringReturn.length <= format.length){
            val stringReplace = string.replace(Regex("\\D"),"")
            val charIndices = format.withIndex().filter { it.value == '#' }.map { it.index }
            stringReplace.mapIndexed { index, c ->
                charArrayFormat[charIndices[index]] = c
            }

            stringReturn = String(charArrayFormat).replace("#","")
            if (!stringReturn.last().isDigit()){
                stringReturn = stringReturn.replace(Regex("${stringReturn.last()}+"),"${stringReturn.last()}")
                stringReturn = stringReturn.substring(0,stringReturn.length-1)
            }
        }
        return stringReturn
    }

}