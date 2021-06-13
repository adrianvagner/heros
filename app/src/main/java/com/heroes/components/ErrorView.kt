package com.heroes.components

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.heroes.R
import com.heroes.databinding.LayoutErrorViewBinding

class ErrorView : LinearLayout {

    private val binding: LayoutErrorViewBinding by lazy {
        LayoutErrorViewBinding.bind(this)
    }

    var message: String? = null
    set(value) {
        field = value
        binding.tvErrorMessage.text = value
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        loadAttributes(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        loadAttributes(attrs)
    }

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER

        LayoutInflater.from(context).inflate(R.layout.layout_error_view, this)
    }

    private fun loadAttributes(attrs: AttributeSet?) {
        val customAttributes = context.obtainStyledAttributes(attrs, R.styleable.ErrorView)

        this.message = customAttributes.getString(R.styleable.ErrorView_message)

        customAttributes.recycle()
    }

}