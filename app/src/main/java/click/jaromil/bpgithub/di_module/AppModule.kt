package click.jaromil.bpgithub.di_module

import click.jaromil.bpgithub.api.ApiClient
import click.jaromil.bpgithub.api.repository.ApiRepository
import click.jaromil.bpgithub.api.repository.GitHubRepository
import click.jaromil.bpgithub.viewmodel.RepositoriesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


object AppModule {
    val appModule = module {
        viewModel { RepositoriesViewModel(get()) }
        single { GitHubRepository(get()) as ApiRepository }
        single { ApiClient() }
    }
}