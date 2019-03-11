package sdash.app.githubprofile.business.repository

import retrofit2.Call
import sdash.app.githubprofile.business.model.Project
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    companion object {
        var HTTPS_API_GITHUB_URL: String = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>

}