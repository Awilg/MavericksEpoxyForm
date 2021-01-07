package dev.iwagl.maverickepoxyform

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class FormLabelModel@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val label by lazy { findViewById<TextView>(R.id.label) }
    init {
        inflate(context, R.layout.layout_form_label, this)
        orientation = VERTICAL
    }

    @TextProp
    fun setText(text: CharSequence) {
        this.label.text = text
    }
}