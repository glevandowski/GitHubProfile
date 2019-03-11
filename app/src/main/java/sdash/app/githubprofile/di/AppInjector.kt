package sdash.app.githubprofile.di

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.support.v4.app.FragmentManager
import sdash.app.githubprofile.MVVMApplication

/**
 * AppInjector is a helper class to automatically inject fragments if they implement Injectable interface.
 */
class AppInjector {

//    fun init(mvvmApplication: MVVMApplication) {
//        DaggerAppComponent.builder().application(mvvmApplication).build().inject(mvvmApplication)
//
//        mvvmApplication
//                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
//                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
//                        handleActivity(activity)
//                    }
//
//                    // Other methods are omitted for simplification …
//                })
//    }
//
//    private fun handleActivity(activity: Activity) {
//        if (activity is HasSupportFragmentInjector) {
//            AndroidInjection.inject(activity)
//        }
//        if (activity is FragmentActivity) {
//            activity.supportFragmentManager
//                    .registerFragmentLifecycleCallbacks(
//                            object : FragmentManager.FragmentLifecycleCallbacks() {
//                                fun onFragmentCreated(fm: FragmentManager, fragment: Fragment, savedInstanceState: Bundle) {
//                                    if (fragment is Injectable) {
//                                        AndroidSupportInjection.inject(fragment)
//                                    }
//                                }
//                            }, true)
//        }
//    }
}