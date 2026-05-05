package com.abplua.qiitaly

import android.app.Application
import com.abplua.qiitaly.di.initKoin
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

@HiltAndroidApp
class QiitalyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        OAuthConfig.clientId = BuildConfig.QIITA_CLIENT_ID
        OAuthConfig.clientSecret = BuildConfig.QIITA_CLIENT_SECRET

        initKoin {
            androidContext(this@QiitalyApplication)
            androidLogger()
        }
    }
}
