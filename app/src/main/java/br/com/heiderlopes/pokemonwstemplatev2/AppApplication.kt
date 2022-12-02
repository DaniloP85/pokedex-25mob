package br.com.heiderlopes.pokemonwstemplatev2

import android.app.Application
import br.com.heiderlopes.pokemonwstemplatev2.di.dataModules
import br.com.heiderlopes.pokemonwstemplatev2.di.domainModules
import br.com.heiderlopes.pokemonwstemplatev2.di.networkModules
import br.com.heiderlopes.pokemonwstemplatev2.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(domainModules)
            modules(dataModules)
            modules(presentationModules)
            modules(networkModules)
        }
    }
}