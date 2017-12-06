package com.udit.shangri_la.core.models

import java.util.*

/**
* Created by Udit on 19/10/17.
*/
data class Movie(val id: Int,
                 val title: String,
                 val description: String,
                 val releaseDate: Calendar,
                 val runtime: Int)