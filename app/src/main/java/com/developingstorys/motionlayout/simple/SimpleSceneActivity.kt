package com.developingstorys.motionlayout.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developingstorys.motionlayout.MainActivity
import com.developingstorys.motionlayout.MainActivity.Companion.EXTRA_LAYOUT_DESCRIPTION_ID
import com.developingstorys.motionlayout.R
import kotlinx.android.synthetic.main.activity_motion.*

class SimpleSceneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
        val sceneExtra = intent?.extras?.getSerializable(EXTRA_LAYOUT_DESCRIPTION_ID) as MainActivity.Companion.SceneExtra
        val scene = sceneExtra.sceneType
        motion_layout?.loadLayoutDescription(scene.layoutDescriptionRes)

        checkbox.setOnCheckedChangeListener { _, isChecked ->
            motion_layout.setDebugMode(if (isChecked) 2 else 0)
        }
    }

}