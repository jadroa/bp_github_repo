package click.jaromil.bpgithub

import android.app.Application
import click.jaromil.bpgithub.di_module.AppModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class BpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    
        startKoin(this, listOf(AppModule.appModule))
    
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    
        Timber.plant(Timber.DebugTree())
    }
}