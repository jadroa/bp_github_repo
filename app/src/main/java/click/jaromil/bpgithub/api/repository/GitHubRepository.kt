package click.jaromil.bpgithub.api.repository

import click.jaromil.bpgithub.api.ApiClient
import click.jaromil.bpgithub.model.Contributor
import click.jaromil.bpgithub.model.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class GitHubRepository(private val apiClient: ApiClient) : ApiRepository {
    private val compositeDisposable = CompositeDisposable()
    
    override fun dispose() {
        compositeDisposable.clear()
    }
    
    override fun getPublicRepos(
        page: Int,
        perPage: Int,
        responseListener: (List<Repo>) -> Unit,
        errorListener: (Throwable) -> Unit
    ) {
        val disposable = apiClient.gitHubApi.getAllRepositoriesRx("is:public", "desc", page, perPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { response ->
                    response.items?.let {
                        responseListener(it)
                    } ?: run {
                        errorListener(Throwable("Repos null!!!"))
                    }
                },
                onError = {
                    errorListener(it)
                }
            )
        compositeDisposable.add(disposable)
    }
    
    override fun getRepoContributors(
        firstName: String,
        lastName: String,
        responseListener: (List<Contributor>) -> Unit,
        errorListener: (Throwable) -> Unit
    ) {
        val disposable = apiClient.gitHubApi.getRepoContributorsRx(firstName, lastName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { contributors ->
                    contributors?.let {
                        responseListener(it)
                    } ?: run {
                        errorListener(Throwable("Contributors null!!!"))
                    }
                },
                onError = {
                    errorListener(it)
                }
            )
        compositeDisposable.add(disposable)
    }
}