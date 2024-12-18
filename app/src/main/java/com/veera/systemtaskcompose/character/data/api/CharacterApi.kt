package com.veera.systemtaskcompose.character.data.api

import com.veera.systemtaskcompose.character.data.api.model.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINTS)
    suspend fun getCharacter():List<Character>
}