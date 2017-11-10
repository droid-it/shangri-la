package com.udit.shangri_la.data.repository.movies.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.DataFormatException

/**
* Created by Udit on 08/11/17.
*/

fun Date.format(format: String): String {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return try {
        dateFormatter.format(this)
    } catch (e: DataFormatException) {
        ""
    }
}

fun String.toDate(format: String): Date? {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        return null
    }
}