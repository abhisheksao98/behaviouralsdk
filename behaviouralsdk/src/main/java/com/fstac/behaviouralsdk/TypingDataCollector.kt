package com.fstac.behaviouralsdk
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class TypingDataCollector(private val editText: EditText) {

    private val typingPattern = mutableListOf<TypingEvent>()

    init {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for this implementation
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Capture typing data
                val currentTime = System.currentTimeMillis()
                for (i in start until start + count) {
                    typingPattern.add(TypingEvent(s?.get(i) ?: ' ', currentTime))
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed for this implementation
            }
        })
    }

    fun getTypingPattern(): List<TypingEvent> {
        return typingPattern
    }

    data class TypingEvent(val char: Char, val timestamp: Long)
}
