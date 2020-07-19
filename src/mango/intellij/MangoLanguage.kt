package mango.intellij

import com.intellij.lang.Language

class MangoLanguage private constructor() : Language("mango") {

    companion object {
        val INSTANCE: MangoLanguage = MangoLanguage()
    }
}