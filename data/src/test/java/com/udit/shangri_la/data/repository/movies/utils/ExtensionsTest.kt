package com.udit.shangri_la.data.repository.movies.utils

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 ** Created by Udit on 08/11/17.
 */
class ExtensionsTest {

    private val DATE_IN_LONG = 1510079400000L //8th nov, 2017

    @Test
    fun DateFormat_Should_FormatDate_When_DateFormatIsValid() {
        val date = Date(DATE_IN_LONG)
        val dateInString = date.format(API_DATE_FORMAT)
        Assert.assertEquals("2017-11-08", dateInString)
    }

    @Test
    fun DateFormat_Should_ReturnEmptyString_When_DateFormatIsInvalid() {
        val date = Date(DATE_IN_LONG)
        val dateInString = date.format("")
        Assert.assertEquals("", dateInString)
    }

    @Test
    fun StringToDate_Should_ParseToDate_When_InputStringIsValid() {
        val dateInString = "2017-11-08"
        val parsedDate = dateInString.toDate(API_DATE_FORMAT)
        Assert.assertEquals(Date(DATE_IN_LONG), parsedDate)
    }

    @Test
    fun StringToDate_Should_ReturnNull_When_InputStringIsInvalid() {
        val dateInString = "gibrish"
        val parsedDate = dateInString.toDate(API_DATE_FORMAT)
        Assert.assertEquals(null, parsedDate)
    }
}