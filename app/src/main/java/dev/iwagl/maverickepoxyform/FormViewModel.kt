package dev.iwagl.maverickepoxyform

import com.airbnb.mvrx.MavericksViewModel

class FormViewModel(initialState: FormState) : MavericksViewModel<FormState>(initialState) {

    fun updateSomeString(text: CharSequence?) {
        setState {
            copy(someString = text.toString())
        }
    }
}