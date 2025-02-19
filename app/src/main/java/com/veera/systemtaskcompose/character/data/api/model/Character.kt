package com.veera.systemtaskcompose.character.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "actor")
    val actor: String,
    @Json(name = "alive")
    val alive: Boolean,
    @Json(name = "ancestry")
    val ancestry: String,
    @Json(name = "dateOfBirth")
    val dateOfBirth: String,
    @Json(name = "eyeColour")
    val eyeColour: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "hairColour")
    val hairColour: String,
    @Json(name = "house")
    val house: String,
    @Json(name = "image")
    val image: String,
)