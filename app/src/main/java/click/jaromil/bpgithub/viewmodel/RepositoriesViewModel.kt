package click.jaromil.bpgithub.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import click.jaromil.bpgithub.model.Contributor
import click.jaromil.bpgithub.model.Repo
import click.jaromil.bpgithub.api.repository.ApiRepository
import click.jaromil.bpgithub.util.ErrorHandler

class RepositoriesViewModel(private val apiRepository: ApiRepository) : ViewModel() {
    val error = MutableLiveData<String>()
    val repoItems = ObservableArrayList<Repo>()
    val contributorItems = ObservableArrayList<Contributor>()
    val currentRepo =  MutableLiveData<Repo>()
    val isLoading = ObservableField<Boolean>()
    val repoPage = MutableLiveData<Int>()
    
    init {
        repoPage.value = 0
    }
    
    companion object {
        const val PER_PAGE = 25
    }

    override fun onCleared() {
        apiRepository.dispose()
    }
    
    /**
     * get all public repositories, nr. of results PER_PAGE, sort desc
     *
     * @param page current page to be loaded using gh api pagination
     */
    fun getGitHubRepos(page: Int) {
        isLoading.set(true)
        apiRepository.getPublicRepos(page, PER_PAGE, { repos ->
            repoItems.addAll(repos)
            repoPage.value =+ 1
            isLoading.set(false)
        }, { throwable ->
            error.value = ErrorHandler.processError(throwable)
            isLoading.set(false)
        })
    }
    
    
    /**
     * get all contributors of repo
     *
     * @param fullName full name of repository
     */
    fun getRepoContributors(fullName: String) {
        val splitName = fullName.split("/")
        isLoading.set(true)
        apiRepository.getRepoContributors(splitName[0], splitName[1], { contributors ->
            contributorItems.clear()
            contributorItems.addAll(contributors)
            isLoading.set(false)
        }, { throwable ->
            error.value = ErrorHandler.processError(throwable)
            isLoading.set(false)
        })
    }
}