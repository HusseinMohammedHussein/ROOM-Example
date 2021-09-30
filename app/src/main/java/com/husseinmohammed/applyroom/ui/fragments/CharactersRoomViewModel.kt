package com.husseinmohammed.applyroom.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.husseinmohammed.applyroom.data.api.ApiHelper
import com.husseinmohammed.applyroom.data.local.DbHelper
import com.husseinmohammed.applyroom.data.local.CharactersLocalPojo
import com.husseinmohammed.applyroom.utils.Resource
import kotlinx.coroutines.launch

class CharactersRoomViewModel(private val apiHelper: ApiHelper, private val dbHelper: DbHelper) :
    ViewModel() {

    private val chars = MutableLiveData<Resource<List<CharactersLocalPojo>>>()

    fun getChars(): LiveData<Resource<List<CharactersLocalPojo>>> {
        viewModelScope.launch {
            chars.postValue(Resource.loading(null))
            try {
                val charFromDb = dbHelper.getCharacters()
                if (charFromDb.isEmpty()) {
                    val charFromApi = apiHelper.getCharacters()
                    val charToInsertInDb = mutableListOf<CharactersLocalPojo>()
                    for (apiChar in charFromApi) {
                        val char = CharactersLocalPojo(
                            apiChar.id,
                            apiChar.name,
                            apiChar.thumbnail
                        )
                        charToInsertInDb.add(char)
                    }
                    dbHelper.installCharacters(charToInsertInDb)
                    chars.postValue(Resource.success(charToInsertInDb))
                } else {
                    chars.postValue(Resource.success(charFromDb))
                }
            } catch (e: Exception) {
                chars.postValue(Resource.error(e.toString(), null))
            }
        }
        return chars
    }
}