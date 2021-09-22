package value

import androidx.compose.ui.graphics.Color

private val flaor = "For"

abstract class StrClass {
    abstract val noS: String
    val flavorName: String = flaor
    abstract val login: String
    abstract val signup: String
    abstract val findAccount: String
    abstract val noB: String
}

object R {
    private val korString = object : StrClass() {
        override val login = "로그인하기"
        override val signup = "회원가입"
        override val findAccount = "ID/PW 찾기"
        override val noB = "None"
        override val noS: String = "Nos"
    }

    private val engString = object : StrClass() {
        override val login = "Login"
        override val signup = "Sign up"
        override val findAccount = "Find ID/PW"
        override val noB = "Nob"
        override val noS = "Nos"
    }

    val string = korString

    object color {
        val primary = Color(0xFF387FBC)
        val secondary = Color(0xFF0A0B0D)
        val grey = Color(0xFFC4C4C4)
        val green = Color(0xFF18A060)
        val white = Color(0xFFFFFFFF)
        val darkgrey = Color(0xFF898989)
        val lightgrey = Color(0xFFE5E5E5)
    }
}