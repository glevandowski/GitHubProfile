package sdash.app.githubprofile.di

import dagger.Subcomponent
import sdash.app.githubprofile.viewmodel.ProjectViewModel
import sdash.app.githubprofile.viewmodel.ProjectListViewModel

/**
 *  ViewModelSubComponent is a sub component to create View Model instances.
 */
@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun projectListViewModel(): ProjectListViewModel
    fun projectViewModel(): ProjectViewModel

}