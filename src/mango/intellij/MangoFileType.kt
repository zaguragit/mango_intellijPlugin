package mango.intellij

import com.intellij.openapi.fileTypes.LanguageFileType

class MangoFileType private constructor() : LanguageFileType(MangoLanguage.INSTANCE) {

    override fun getIcon() = MangoIcons.FILE

    override fun getName() = "mango file"

    override fun getDefaultExtension() = "m"

    override fun getDescription() = "mango language file"

    companion object {
        val INSTANCE: MangoFileType = MangoFileType()
    }
}