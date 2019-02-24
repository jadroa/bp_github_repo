package click.jaromil.bpgithub.model
import android.databinding.BaseObservable
import com.squareup.moshi.Json



data class Repo(
    @Json(name = "archive_url")
    val archiveUrl: String?,
    @Json(name = "archived")
    val archived: Boolean?,
    @Json(name = "assignees_url")
    val assigneesUrl: String?,
    @Json(name = "blobs_url")
    val blobsUrl: String?,
    @Json(name = "branches_url")
    val branchesUrl: String?,
    @Json(name = "clone_url")
    val cloneUrl: String?,
    @Json(name = "collaborators_url")
    val collaboratorsUrl: String?,
    @Json(name = "comments_url")
    val commentsUrl: String?,
    @Json(name = "commits_url")
    val commitsUrl: String?,
    @Json(name = "compare_url")
    val compareUrl: String?,
    @Json(name = "contents_url")
    val contentsUrl: String?,
    @Json(name = "contributors_url")
    val contributorsUrl: String?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "default_branch")
    val defaultBranch: String?,
    @Json(name = "deployments_url")
    val deploymentsUrl: String?,
    @Json(name = "description")
    val description: Any?,
    @Json(name = "downloads_url")
    val downloadsUrl: String?,
    @Json(name = "events_url")
    val eventsUrl: String?,
    @Json(name = "fork")
    val fork: Boolean?,
    @Json(name = "forks")
    val forks: Int?,
    @Json(name = "forks_count")
    val forksCount: Int?,
    @Json(name = "forks_url")
    val forksUrl: String?,
    @Json(name = "full_name")
    val fullName: String?,
    @Json(name = "git_commits_url")
    val gitCommitsUrl: String?,
    @Json(name = "git_refs_url")
    val gitRefsUrl: String?,
    @Json(name = "git_tags_url")
    val gitTagsUrl: String?,
    @Json(name = "git_url")
    val gitUrl: String?,
    @Json(name = "has_downloads")
    val hasDownloads: Boolean?,
    @Json(name = "has_issues")
    val hasIssues: Boolean?,
    @Json(name = "has_pages")
    val hasPages: Boolean?,
    @Json(name = "has_projects")
    val hasProjects: Boolean?,
    @Json(name = "has_wiki")
    val hasWiki: Boolean?,
    @Json(name = "homepage")
    val homepage: Any?,
    @Json(name = "hooks_url")
    val hooksUrl: String?,
    @Json(name = "html_url")
    val htmlUrl: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "issue_comment_url")
    val issueCommentUrl: String?,
    @Json(name = "issue_events_url")
    val issueEventsUrl: String?,
    @Json(name = "issues_url")
    val issuesUrl: String?,
    @Json(name = "keys_url")
    val keysUrl: String?,
    @Json(name = "labels_url")
    val labelsUrl: String?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "languages_url")
    val languagesUrl: String?,
    @Json(name = "license")
    val license: License?,
    @Json(name = "merges_url")
    val mergesUrl: String?,
    @Json(name = "milestones_url")
    val milestonesUrl: String?,
    @Json(name = "mirror_url")
    val mirrorUrl: Any?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "node_id")
    val nodeId: String?,
    @Json(name = "notifications_url")
    val notificationsUrl: String?,
    @Json(name = "open_issues")
    val openIssues: Int?,
    @Json(name = "open_issues_count")
    val openIssuesCount: Int?,
    @Json(name = "owner")
    val owner: Owner?,
    @Json(name = "private")
    val `private`: Boolean?,
    @Json(name = "pulls_url")
    val pullsUrl: String?,
    @Json(name = "pushed_at")
    val pushedAt: String?,
    @Json(name = "releases_url")
    val releasesUrl: String?,
    @Json(name = "score")
    val score: Int?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "ssh_url")
    val sshUrl: String?,
    @Json(name = "stargazers_count")
    val stargazersCount: Int?,
    @Json(name = "stargazers_url")
    val stargazersUrl: String?,
    @Json(name = "statuses_url")
    val statusesUrl: String?,
    @Json(name = "subscribers_url")
    val subscribersUrl: String?,
    @Json(name = "subscription_url")
    val subscriptionUrl: String?,
    @Json(name = "svn_url")
    val svnUrl: String?,
    @Json(name = "tags_url")
    val tagsUrl: String?,
    @Json(name = "teams_url")
    val teamsUrl: String?,
    @Json(name = "trees_url")
    val treesUrl: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "watchers")
    val watchers: Int?,
    @Json(name = "watchers_count")
    val watchersCount: Int?
) : BaseObservable()

data class License(
    @Json(name = "key")
    val key: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "node_id")
    val nodeId: String?,
    @Json(name = "spdx_id")
    val spdxId: String?,
    @Json(name = "url")
    val url: String?
) : BaseObservable()

data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String?,
    @Json(name = "events_url")
    val eventsUrl: String?,
    @Json(name = "followers_url")
    val followersUrl: String?,
    @Json(name = "following_url")
    val followingUrl: String?,
    @Json(name = "gists_url")
    val gistsUrl: String?,
    @Json(name = "gravatar_id")
    val gravatarId: String?,
    @Json(name = "html_url")
    val htmlUrl: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "login")
    val login: String?,
    @Json(name = "node_id")
    val nodeId: String?,
    @Json(name = "organizations_url")
    val organizationsUrl: String?,
    @Json(name = "received_events_url")
    val receivedEventsUrl: String?,
    @Json(name = "repos_url")
    val reposUrl: String?,
    @Json(name = "site_admin")
    val siteAdmin: Boolean?,
    @Json(name = "starred_url")
    val starredUrl: String?,
    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?
) : BaseObservable()