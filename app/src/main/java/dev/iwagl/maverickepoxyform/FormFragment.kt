package dev.iwagl.maverickepoxyform

import com.airbnb.mvrx.activityViewModel

class FormFragment : MavericksBaseFragment() {

    private val viewModel: FormViewModel by activityViewModel()

    override fun epoxyController() = simpleController(viewModel) { state ->

        formLabelModel {
            id("id_label_prompt")
            text("Enter something")
        }

        formEditTextModel {
            // In order for the diffing alg to work these id strings need to be fixed and not "hashcode()"
            id("id_edit_text")
            text(state.someString)
            onEditTextChanged { viewModel.updateSomeString(it) }
        }

        formLabelModel {
            id("id_label")
            text(state.someString)
        }
    }
}