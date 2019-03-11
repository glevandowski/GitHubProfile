package sdash.app.githubprofile.di

import android.arch.lifecycle.ViewModel
import sdash.app.githubprofile.viewmodel.ProjectListViewModel
import sdash.app.githubprofile.viewmodel.ProjectViewModel
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import android.util.ArrayMap
import java.util.concurrent.Callable
import javax.inject.Singleton

@Singleton
class ProjectViewModelFactory @Inject
constructor(viewModelSubComponent: ViewModelSubComponent) : ViewModelProvider.Factory {
    private val creators: ArrayMap<Class<*>, Callable<out ViewModel>>

    init {
        creators = ArrayMap()

        // View models cannot be injected directly because they won't be bound to the owner's
        // view model scope.
        creators.put(ProjectViewModel::class.java, Callable {  viewModelSubComponent.projectViewModel()})

        creators.put(ProjectListViewModel::class.java, Callable {  viewModelSubComponent.projectListViewModel()})
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        var creator: Callable<out ViewModel>? = creators.get(modelClass)

        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}