package com.fstac.behaviouralsdk

class TypingPatternProcessor {

    fun process(typingEvents: List<TypingDataCollector.TypingEvent>): List<Feature> {
        val features = mutableListOf<Feature>()

        for (i in 1 until typingEvents.size) {
            val duration = typingEvents[i].timestamp - typingEvents[i - 1].timestamp
            features.add(Feature(typingEvents[i].char, duration))
        }

        return features
    }

    data class Feature(val char: Char, val duration: Long)
}
