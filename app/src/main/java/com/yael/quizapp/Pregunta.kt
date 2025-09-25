package com.yael.quizapp

import androidx.annotation.StringRes

data class Pregunta(@StringRes val textResId: Int, val respuesta: Boolean)