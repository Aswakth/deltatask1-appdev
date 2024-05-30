package com.example.colorconquest.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreWins(private val context: Context) {
    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "wins")
        val WINS= stringPreferencesKey(name = "wins")
    }
    val getWins: Flow<String?> = context.dataStore.data
        .map {
            it[WINS] ?: ""
        }
    suspend fun saveWins(name: String){
        context.dataStore.edit {
            it[WINS]=name
        }
    }
}