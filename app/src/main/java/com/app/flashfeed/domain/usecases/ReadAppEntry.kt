package com.app.flashfeed.domain.usecases

import com.app.flashfeed.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(  private val localUserManager : LocalUserManager
) {

    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}