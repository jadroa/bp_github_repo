package click.jaromil.bpgithub.api

import click.jaromil.bpgithub.model.Repo
import com.squareup.moshi.Json

data class GetRepositoriesResponse (
    @Json(name = "total_count")
    val totalCount: Int,
    val items: List<Repo>?
)