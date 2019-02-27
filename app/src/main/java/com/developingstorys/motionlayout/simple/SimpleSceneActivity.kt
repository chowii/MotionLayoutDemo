package com.developingstorys.motionlayout.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developingstorys.motionlayout.R
import kotlinx.android.synthetic.main.activity_scene.*

class SimpleSceneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene)
        val layoutDescriptionId = intent?.extras?.getInt(EXTRA_LAYOUT_DESCRIPTION_ID) ?: 0
        motion_layout?.loadLayoutDescription(layoutDescriptionId)
    }


    companion object {
        const val EXTRA_LAYOUT_DESCRIPTION_ID = "layout_description_id"
    }
}