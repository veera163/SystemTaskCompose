package com.veera.systemtaskcompose.character.data.network

import com.veera.systemtaskcompose.Utils.ApiConstants
import com.veera.systemtaskcompose.character.data.model.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINTS)
    suspend fun getCharacter():List<Character>
}