package click.jaromil.bpgithub.api.repository

import click.jaromil.bpgithub.model.Contributor
import click.jaromil.bpgithub.model.Repo

interface ApiRepository {
    fun getPublicRepos(page: Int, perPage: Int, responseListener: (List<Repo>) -> Unit, errorListener: (Throwable) -> Unit)
    fun getRepoContributors(firstName: String, lastName: String, responseListener: (List<Contributor>) -> Unit, errorListener: (Throwable) -> Unit)
    fun dispose()
}