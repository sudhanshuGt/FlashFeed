package com.app.flashfeed.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.app.flashfeed.domain.manager.LocalUserManager
import com.app.flashfeed.util.Constant
import com.app.flashfeed.util.Constant.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImp( private val contexts : Context ) : LocalUserManager {
    override suspend fun saveAppEntry() {
        contexts.dataStore.edit {
            it[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry() : Flow<Boolean> {
        return contexts.dataStore.data.map { it[PreferencesKeys.APP_ENTRY] ?: false }
     }

}


private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constant.APP_ENTRY)
}