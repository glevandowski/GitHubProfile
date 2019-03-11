package sdash.app.githubprofile.di

import dagger.Provides
import sdash.app.githubprofile.business.repository.GitHubService
import javax.inject.Singleton
import android.arch.lifecycle.ViewModelProvider
import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***
 *  AppModule is a Dagger module responsible for providing singleton services on the application
 *  level such as GitHubService and ProjectViewModelFactory.
 */
class AppModule {

    @Singleton
    @Provides
    fun provideGithubService(): GitHubService {
        return Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService::class.java)
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(
            viewModelSubComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory {

        return ProjectViewModelFactory(viewModelSubComponent.build())
    }
}