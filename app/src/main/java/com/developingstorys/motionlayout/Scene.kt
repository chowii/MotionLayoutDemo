package com.developingstorys.motionlayout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.developingstorys.motionlayout.simple.SimpleSceneActivity
import com.developingstorys.motionlayout.transitionfragment.FragmentTransitionActivity
import com.developingstorys.motionlayout.transitionfragment.LoginFragment
import com.developingstorys.motionlayout.transitionfragment.SecondFragment
import com.developingstorys.motionlayout.youtube.YoutubeTransitionActivity
import java.io.Serializable


data class Scene(val sceneName: String, val layoutDescriptionRes: Int, val sceneType: SceneType) : Serializable

sealed class SceneType(val activityRef: Class<out AppCompatActivity>) : Serializable {
    object Primary : SceneType(SimpleSceneActivity::class.java)
    object CoordinatorLayout : SceneType(MainActivity::class.java) // todo create for coordinator layouts
    object YoutubeTransition : SceneType(YoutubeTransitionActivity::class.java)
    data class FragmentTransition(val fragmentScene: FragmentScene) : SceneType(FragmentTransitionActivity::class.java)
}

enum class FragmentScene(val fragmentRef: Fragment) : Serializable {
    LONG_TEXT(SecondFragment.newInstance()),
    LOGIN(LoginFragment.newInstance())
}