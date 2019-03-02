package com.developingstorys.motionlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.developingstorys.motionlayout.simple.SimpleSceneActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.apply {
            adapter = SceneAdapter(sceneList, onSceneTypeClicked())
            layoutManager = GridLayoutManager(this@MainActivity, 3)
        }
    }

    private fun onSceneTypeClicked(): (Int) -> Unit {
        return { sceneRes ->
            val intent = Intent(this, SimpleSceneActivity::class.java).apply {
                putExtra(SimpleSceneActivity.EXTRA_LAYOUT_DESCRIPTION_ID, sceneRes)
            }
            startActivity(intent)
        }
    }

    private val sceneList = listOf(
        SceneType("Slide Scene", R.xml.scene01),
        SceneType("Color Change Slide Scene", R.xml.scene02),
        SceneType("Rotation and Color Change Slide Scene", R.xml.scene03),
        SceneType("Position and Color Change Slide Scene", R.xml.scene04),
        SceneType("Wavey and Color Change Slide Scene", R.xml.scene05))
}
