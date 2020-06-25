package com.android.domain.common

import org.mockito.Mockito

/**
 * Created by hassanalizadeh on 21,June,2020
 */

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)