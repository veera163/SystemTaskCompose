package com.veera.systemtaskcompose.character.data.repository

import com.veera.systemtaskcompose.character.data.api.CharacterApi
import com.veera.systemtaskcompose.character.data.api.model.Character
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi
) {
    suspend fun getCharacters(): List<Character> {
        return characterApi.getCharacter()
    }
}