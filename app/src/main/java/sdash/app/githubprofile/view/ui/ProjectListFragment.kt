package sdash.app.githubprofile.view.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import sdash.app.githubprofile.business.model.Project
import sdash.app.githubprofile.view.adapter.ProjectAdapter
import sdash.app.githubprofile.viewmodel.ProjectListViewModel

class ProjectListFragment : Fragment() {
    lateinit var projectAdapter: ProjectAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)

        observeViewModel(viewModel);
    }
    fun observeViewModel( viewModel: ProjectListViewModel) {
        // Update the list when the data changes
//        viewModel.getProjectListObservable().observe(this,object : Observer<List<Project>> {
//            override fun onChanged(t: List<Project>?) {
//                projectAdapter.setProjectList(projects);
//            }
//        });

        viewModel.getProjectListObservable().observe(this, Observer<List<Project>> {
            it?.let { itl -> projectAdapter.setProjectList(itl) }
        })
    }
}