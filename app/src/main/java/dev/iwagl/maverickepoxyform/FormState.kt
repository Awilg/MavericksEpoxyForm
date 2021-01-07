package dev.iwagl.maverickepoxyform

import com.airbnb.mvrx.MavericksState

data class FormState(
    val someString: String = ""
) : MavericksState