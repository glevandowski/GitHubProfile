package sdash.app.githubprofile.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import sdash.app.githubprofile.business.model.Project
import sdash.app.githubprofile.business.repository.ProjectRepository

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {

    private var  projectListObservable : LiveData<List<Project>>

    init {
        projectListObservable = ProjectRepository().getProjectListRepository("Google");
    }

     fun getProjectListObservable():LiveData<List<Project>> = projectListObservable

}