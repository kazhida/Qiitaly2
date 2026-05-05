package com.abplua.qiitaly.di

import com.abplua.qiitaly.data.repositories.AuthRepository
import com.abplua.qiitaly.data.repositories.QiitaRepository
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single { QiitaRepository() }
    single { AuthRepository() }
}

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication =
    startKoin {
        config?.invoke(this)
        modules(appModule)
    }
