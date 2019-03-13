package com.developingstorys.motionlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.apply {
            adapter = SceneAdapter(sceneList, onSceneTypeClicked())
            layoutManager = GridLayoutManager(this@MainActivity, 3)
        }
    }

    private fun onSceneTypeClicked(): (Scene) -> Unit {
        return { scene ->
            val intent = Intent(this, scene.sceneType.activityRef).apply {
                putExtra(EXTRA_LAYOUT_DESCRIPTION_ID, SceneExtra(scene))
            }
            startActivity(intent)
        }
    }

    private val sceneList = listOf(
        Scene("Slide Scene", R.xml.scene01, SceneType.Primary),
        Scene("Color Change Slide Scene", R.xml.scene02, SceneType.Primary),
        Scene("Rotation and Color Change Slide Scene", R.xml.scene03, SceneType.Primary),
        Scene("Position and Color Change Slide Scene", R.xml.scene04, SceneType.Primary),
        Scene("Wavey and Color Change Slide Scene", R.xml.scene05, SceneType.Primary),
        Scene("Fragment Transition", R.xml.scene_fragment_transition, SceneType.FragmentTransition(FragmentScene.LONG_TEXT)),
        Scene("Login Fragment Transition", R.xml.scene_fragment_transition, SceneType.FragmentTransition(FragmentScene.LOGIN)),
        Scene("Youtube Transition", R.xml.scene_youtube, SceneType.YoutubeTransition)
    )

    companion object {
        const val EXTRA_LAYOUT_DESCRIPTION_ID = "layout_description_id"

        data class SceneExtra(val sceneType: Scene) : Serializable
    }
}
