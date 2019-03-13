package com.developingstorys.motionlayout.transitionfragment

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.developingstorys.motionlayout.MainActivity
import com.developingstorys.motionlayout.MainActivity.Companion.EXTRA_LAYOUT_DESCRIPTION_ID
import com.developingstorys.motionlayout.R
import com.developingstorys.motionlayout.SceneType
import kotlinx.android.synthetic.main.activity_fragment_transition.*

class FragmentTransitionActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private lateinit var fragment: Fragment
    private var lastProgress = 0f
    private var fragmentRef: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transition)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }

        with(activityFragmentTransaction) {
            val sceneExtra =
                intent?.extras?.getSerializable(EXTRA_LAYOUT_DESCRIPTION_ID) as MainActivity.Companion.SceneExtra
            val (_, layoutDescriptionId, sceneType) = sceneExtra.sceneType
            fragmentRef = (sceneType as? SceneType.FragmentTransition)?.fragmentScene?.fragmentRef

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


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
    }

    override fun onTransitionChange(layout: MotionLayout?, @LayoutRes startLayoutRes: Int, @LayoutRes endLayoutRes: Int, progress: Float) {
        if (progress - lastProgress > 0) {
            val isAtEnd = Math.abs(progress - 1f) < 0.75f
            if (isAtEnd && fragment is MainFragment) {
                fragmentRef?.let {
                    fragment = it
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
                }
            }
        } else {
            val isAtStart = progress < 0.26f
            if (isAtStart && fragment === fragmentRef) {
                fragment = MainFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
    }


}