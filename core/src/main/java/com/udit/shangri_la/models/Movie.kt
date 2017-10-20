package com.udit.shangri_la.models

/**
 * Created by Udit on 19/10/17.
 */
data class Movie(val id: Int,
                 val original_title: String,
                 val overview: String,
                 val release_date: String,
                 val runtime: Int,
                 val tagline: String)