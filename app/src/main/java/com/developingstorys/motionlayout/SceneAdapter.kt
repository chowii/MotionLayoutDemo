package com.developingstorys.motionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SceneAdapter(
    private val sceneList: List<Scene>,
    private val onSceneTypeClicked: (Int, SceneType) -> Unit
) : RecyclerView.Adapter<SceneAdapter.SceneViewHolder>() {

    override fun getItemCount(): Int = sceneList.size

    override fun getItemViewType(position: Int): Int = R.layout.item_scene_type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SceneViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return SceneViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SceneViewHolder, position: Int) {
        val (sceneName, sceneRes, sceneType) = sceneList[position]
        with(holder) {
            bind(sceneName)
            itemView.setOnClickListener { onSceneTypeClicked(sceneRes, sceneType) }
        }
    }

    class SceneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sceneName: String) {
            itemView.findViewById<Button>(R.id.scene_button).text = sceneName
        }
    }
}