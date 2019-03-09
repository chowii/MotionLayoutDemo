package com.developingstorys.motionlayout.transitionfragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.developingstorys.motionlayout.R
import com.developingstorys.motionlayout.simple.SimpleSceneActivity.Companion.EXTRA_LAYOUT_DESCRIPTION_ID
import kotlinx.android.synthetic.main.activity_fragment_transition.*

class FragmentTransitionActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private lateinit var fragment: Fragment
    private var lastProgress = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transition)

        with(activityFragmentTransaction) {
            val layoutDescriptionId = intent?.extras?.getInt(EXTRA_LAYOUT_DESCRIPTION_ID) ?: 0
            if (layoutDescriptionId != 0) {
                activityFragmentTransaction?.loadLayoutDescription(layoutDescriptionId)
                setTransitionListener(this@FragmentTransitionActivity)
                fragment = MainFragment.newInstance().also {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, it)
                        .commitNow()
                }
            }
        }
    }


    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
    }

    override fun onTransitionChange(
        p0: MotionLayout?,
        @LayoutRes startLayoutRes: Int,
        @LayoutRes endLayoutRes: Int,
        progress: Float
    ) {
        if (progress - lastProgress > 0) {
            val isAtEnd = Math.abs(progress - 1f) < 0.75f
            if (isAtEnd && fragment is MainFragment) {
                fragment = SecondFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
        } else {
            val isAtStart = progress < 0.25f
            if (isAtStart && fragment is SecondFragment) {
                fragment = MainFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
    }


}