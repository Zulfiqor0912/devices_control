package uz.gita.devicecontrol.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.devicecontrol.data.common.source.Pref
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StoreModule {

    @[Singleton Provides]
    fun provideStore(@ApplicationContext context: Context): Pref = Pref(context)
}