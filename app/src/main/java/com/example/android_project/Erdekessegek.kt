package com.example.android_project

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.adapter.ErdekessegekAdapter
import com.example.android_project.model.infoviewmodel
import java.util.*
import kotlin.collections.ArrayList

class Erdekessegek : AppCompatActivity() {

    private lateinit var newinfoRecyclerView: RecyclerView
    private lateinit var newinfoArrayList: ArrayList<infoviewmodel>
    private lateinit var tempArrayList: ArrayList<infoviewmodel>
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
        tempArrayList= arrayListOf<infoviewmodel>()
        getUserData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_item,menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                
                tempArrayList.clear()
                val  searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){

                    newinfoArrayList.forEach{
                        if (it.FEJ.lowercase(Locale.getDefault()).contains(searchText))      {

                            tempArrayList.add(it)

                        }
                    }
                    newinfoRecyclerView.adapter!!.notifyDataSetChanged()
                }else{
                          tempArrayList.clear()
                    tempArrayList.addAll(newinfoArrayList)
                    newinfoRecyclerView.adapter!!.notifyDataSetChanged()
                }
                
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserData() {
        for(i in birdfej.indices){
            val birds = infoviewmodel(birdfej[i],birdtartalom[i])
            newinfoArrayList.add(birds)
        }

        tempArrayList.addAll(newinfoArrayList)

        newinfoRecyclerView.adapter = ErdekessegekAdapter(tempArrayList)
    }
}
