package click.jaromil.bpgithub.api

import click.jaromil.bpgithub.model.Contributor
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/repositories")
    fun getAllRepositoriesRx(
        @Query("q") query: String,
        @Query("order") order: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Single<GetRepositoriesResponse>
    
    @GET("repos/{first_name}/{last_name}/contributors")
    fun getRepoContributorsRx(
        @Path("first_name") firstName: String,
        @Path("last_name") lastName: String
    ): Single<List<Contributor>>
}