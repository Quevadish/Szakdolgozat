package com.example.android_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.adapter.ErdekessegekAdapter
import com.example.android_project.model.infoviewmodel

class Erdekessegek : AppCompatActivity() {

    private lateinit var newinfoRecyclerView: RecyclerView
    private lateinit var newinfoArrayList: ArrayList<infoviewmodel>
    lateinit var birdfej : Array<String>
    lateinit var birdtartalom : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erdekessegek)


        birdfej = arrayOf(
            "Madarak",
            "Régi madár faj",
            "Emberek számára",
            "Intelligencia",
            "Táplálkozás"
        )

        birdtartalom = arrayOf(
            getString(R.string.madarak),
            getString(R.string.legregebbi),
            getString(R.string.emberek),
            getString(R.string.inteligencia),
            getString(R.string.taplalkozas)
        )

        newinfoRecyclerView=findViewById(R.id.inforecyclerview)
        newinfoRecyclerView.layoutManager = LinearLayoutManager(this)
        newinfoRecyclerView.setHasFixedSize(true)

        newinfoArrayList = arrayListOf<infoviewmodel>()
        getUserData()

    }

    private fun getUserData() {
        for(i in birdfej.indices){
            val birds = infoviewmodel(birdfej[i],birdtartalom[i])
            newinfoArrayList.add(birds)
        }

        newinfoRecyclerView.adapter = ErdekessegekAdapter(newinfoArrayList)
    }
}
