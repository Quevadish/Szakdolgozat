package com.example.android_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
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

        val visszagomb: Button = findViewById(R.id.back)

        visszagomb.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        birdfej = arrayOf(
            "Madarak",
            "Legrégebbi madár faj",
            "Emberek számára",
            "Intelligencia",
            "Táplálkozás",
            "Tüdő",
            "Fehérvérsejt",
            "Bélrendszer",
            "Evolúció",
            "Vese",
            "Hasnyálmirigy",
            "Nünüke",
            "Hidra",
            "Lucy",
            "Szivverés és a víz",
            "Nincs fókuszban",
            "Láb és az alkar",
            "Kamikaze hangyák",
            "Gomba"
        )

        birdtartalom = arrayOf(
            getString(R.string.madarak),
            getString(R.string.legregebbi),
            getString(R.string.emberek),
            getString(R.string.inteligencia),
            getString(R.string.taplalkozas),
            getString(R.string.tudo),
            getString(R.string.feherversejt),
            getString(R.string.belrendszer),
            getString(R.string.evoluvio),
            getString(R.string.vese),
            getString(R.string.hasnyalmirigy),
            getString(R.string.nunuke),
            getString(R.string.hidra),
            getString(R.string.lucy),
            getString(R.string.szivveres),
            getString(R.string.agyor),
            getString(R.string.alkar),
            getString(R.string.kamikaze),
            getString(R.string.gomba)
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
