package sdash.app.githubprofile.business.repository

import sdash.app.githubprofile.business.model.Project
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRepository {

        private val gitHubService: GitHubService? = null

        fun getProjectListRepository(userId: String): LiveData<List<Project>> {
            val data = MutableLiveData<List<Project>>()

            gitHubService?.getProjectList(userId)?.enqueue(object : Callback<List<Project>?> {
                override fun onResponse(call: Call<List<Project>?>?, response: Response<List<Project>?>?) {
                    data.setValue(response?.body())
                }

                override fun onFailure(call: Call<List<Project>?>?, t: Throwable?) {
                }
            })
            return data
        }
}