package com.android.domain.common

import com.android.domain.entity.WordObject


/**
 * Created by hassanalizadeh on 21,June,2020
 */
object TestUtil {

    fun getWords(): List<WordObject> {
        return listOf<WordObject>(
            WordObject("primary school", "escuela primaria"),
            WordObject("teacher", "profesor / profesora"),
            WordObject("pupil", "alumno / alumna"),
            WordObject("holidays", "vacaciones"),
            WordObject("class", "curso"),
            WordObject("bell", "timbre"),
            WordObject("group", "grupo"),
            WordObject("exercise book", "cuaderno"),
            WordObject("quiet", "quieto")
        )
    }

}