package com.developingstorys.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.include_mutli_state.*

class MultiStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_state)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MultiStateFragment())
            .commit()

        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerViewPad.apply {
            layoutManager = LinearLayoutManager(this@MultiStateActivity)
            adapter = MultiStateAdapter(3)
        }
    }
}
