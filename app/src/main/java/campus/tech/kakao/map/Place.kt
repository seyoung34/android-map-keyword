package campus.tech.kakao.map

import androidx.annotation.DrawableRes

data class Place(
    val id : Int,
    @DrawableRes val image : Int,
    val name : String,
    val address : String,
    val kind : String
)
