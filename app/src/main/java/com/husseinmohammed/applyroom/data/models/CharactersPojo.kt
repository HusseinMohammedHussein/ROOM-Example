package com.husseinmohammed.applyroom.data.models

import com.google.gson.annotations.SerializedName

// Created by Your name on 9/26/2021.
data class CharactersPojo(
    @SerializedName("data") val characterData: CharacterDataPojo
) {
    data class CharacterDataPojo(
        @SerializedName("results") val resultsCharacter: ArrayList<CharacterPojo>
    ) {
        data class CharacterPojo(
            val id: Int,
            val name: String,
            val thumbnail: CharImage
        ) {
            data class CharImage(
                val path: String,
                val extension: String
            )
        }
    }
}
