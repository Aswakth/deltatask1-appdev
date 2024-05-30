package com.example.colorconquest.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StorePref(private val context: Context) {
    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "high_score")
        val HIGH_SCORE = stringPreferencesKey(name = "high_score")
    }

    val getScore: Flow<String?> = context.dataStore.data
        .map {
            it[HIGH_SCORE]
        }

    suspend fun saveScore(name: String){
        context.dataStore.edit {
            it[HIGH_SCORE]=name
        }
    }
}