package com.developingstorys.motionlayout

import androidx.appcompat.app.AppCompatActivity
import com.developingstorys.motionlayout.simple.SimpleSceneActivity
import com.developingstorys.motionlayout.transitionfragment.FragmentTransitionActivity


data class Scene(val sceneName: String, val layoutDescriptionRes: Int, val sceneType: SceneType)

enum class SceneType(val classRef: Class<out AppCompatActivity>) {
    PRIMARY(SimpleSceneActivity::class.java),
    COORDINATOR_LAYOUT(MainActivity::class.java),// todo create for coordinator layouts
    FRAGMENT_TRANSITION(FragmentTransitionActivity::class.java)
}