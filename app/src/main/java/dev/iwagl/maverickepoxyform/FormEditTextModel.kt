package dev.iwagl.maverickepoxyform

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class FormEditTextModel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val editText by lazy { findViewById<EditText>(R.id.input_edit_text) }
    private val editTextWatcher = SimpleTextWatcher { onEditTextChanged?.invoke(it) }

    @set:TextProp
    var text: CharSequence? = null

    @set:CallbackProp
    var onEditTextChanged: ((newText: String) -> Unit)? = null

    init {
        inflate(context, R.layout.layout_form_input, this)
    }

    @AfterPropsSet
    fun postBindSetup() {
        editText.also {
            it.setTextIfDifferent(text)
            it.removeTextChangedListener(editTextWatcher)
            it.addTextChangedListener(editTextWatcher)
        }
    }

    @OnViewRecycled
    fun onViewRecycled() {
        editText.removeTextChangedListener(editTextWatcher)
    }

}