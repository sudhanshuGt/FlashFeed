package com.app.flashfeed.di

import android.app.Application
import com.app.flashfeed.data.manager.LocalUserManagerImp
import com.app.flashfeed.domain.manager.LocalUserManager
import com.app.flashfeed.domain.usecases.AppEntryUseCases
import com.app.flashfeed.domain.usecases.ReadAppEntry
import com.app.flashfeed.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )


}