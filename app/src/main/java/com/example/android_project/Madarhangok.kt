package com.example.android_project


import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.adapter.CustomAdapter
import com.example.android_project.model.ItemsViewModel
import java.util.*
import kotlin.collections.ArrayList

class Madarhangok : AppCompatActivity(){


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    private lateinit var tempArrayList: ArrayList<ItemsViewModel>
    lateinit var birdimage: Array<Int>
    lateinit var birdtext : Array<String>
    lateinit var tartalmak : Array<String>
    lateinit var hangok : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_madarhangok)




        birdimage = arrayOf(
            R.drawable.csuszka,
            R.drawable.hazivereb,
            R.drawable.szarka,
            R.drawable.mezeiposzata,
            R.drawable.szencinege,
            R.drawable.vorosbegy,
            R.drawable.retisas,
            R.drawable.solyom,
            R.drawable.bagoly,
            R.drawable.fecske

        )

        birdtext = arrayOf(
            "Csuszka",
            "Háziveréb",
            "Szarka",
            "Mezeiposzáta",
            "Széncinege",
            "Vörösbegy",
            "Rétisas",
            "Sólyom",
            "Bagoly",
            "Fecske"

        )



        tartalmak = arrayOf(
            getString(R.string.csuszkaszoveg),
            getString(R.string.verebszoveg),
            getString(R.string.szarkaszoveg),
            getString(R.string.poszataszoveg),
            getString(R.string.cinegeszoveg),
            getString(R.string.vorosbegyszoveg),
            getString(R.string.retisas),
            getString(R.string.solyom),
            getString(R.string.bagoly),
            getString(R.string.fecske)
        )

        hangok = arrayOf(
            R.raw.csuszkaveg,
            R.raw.vorosbegy,
            R.raw.szencinege,
            R.raw.szarka,
            R.raw.csuszkaveg,
            R.raw.csuszkaveg,
            R.raw.csuszkaveg,
            R.raw.csuszkaveg,
            R.raw.csuszkaveg,
            R.raw.csuszkaveg
        )




        newRecyclerView=findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ItemsViewModel>()
        tempArrayList = arrayListOf<ItemsViewModel>()
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

                    newArrayList.forEach{
                        if (it.text.lowercase(Locale.getDefault()).contains(searchText))      {

                            tempArrayList.add(it)

                        }
                    }
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }

                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }



    private fun getUserData() {
        for(i in birdimage.indices){
            val birds = ItemsViewModel(birdimage[i],birdtext[i],tartalmak[i],hangok[i])
            newArrayList.add(birds)
        }



        tempArrayList.addAll(newArrayList)
        var adapter = CustomAdapter(tempArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val mediaPlayer = MediaPlayer.create(this@Madarhangok, hangok[position])
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener { mp ->
                    mp.release()
                }
            }

        })
    }
}