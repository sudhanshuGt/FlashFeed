package com.app.flashfeed.domain.usecases

import com.app.flashfeed.domain.manager.LocalUserManager

class SaveAppEntry (private val localUserManager : LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

 }