package com.example.android_project


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.widget.Button
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

        val back: Button = findViewById(R.id.vissza)

        back.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



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
            R.drawable.fecske,
            R.drawable.feketehattyu,
            R.drawable.golya,
            R.drawable.hullamospapagaj,
            R.drawable.jegmadar,
            R.drawable.kekszajko,
            R.drawable.nagyfakopancs,
            R.drawable.oszapo,
            R.drawable.seregely,
            R.drawable.tuzestorkukolibri,
            R.drawable.varju

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
            "Macskabagoly",
            "Füstiecske",
            "Fekete hattyú",
            "Gólya",
            "Hullámos papagáj",
            "Jégmadár",
            "Kék szajkó",
            "Nagy fakopáncs",
            "Őszapó",
            "Seregély",
            "Tüzestorkú kolibri",
            "Varjú"

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
            getString(R.string.fecske),
            getString(R.string.hattyu),
            getString(R.string.golya),
            getString(R.string.papagaj),
            getString(R.string.jegmadar),
            getString(R.string.szajko),
            getString(R.string.nagyfakopancs),
            getString(R.string.oszapo),
            getString(R.string.seregely),
            getString(R.string.kolibri),
            getString(R.string.varju)
        )

        hangok = arrayOf(
            R.raw.csuszkaveg,
            R.raw.vereb,
            R.raw.szarka,
            R.raw.poszata,
            R.raw.szencinege,
            R.raw.vorosbegy,
            R.raw.retisas,
            R.raw.solyom,
            R.raw.bagoly,
            R.raw.fecske,
            R.raw.feketehattyu,
            R.raw.golya,
            R.raw.hullamospapagaj,
            R.raw.jegmadar,
            R.raw.szajko,
            R.raw.nagyfakopacs,
            R.raw.oszapo,
            R.raw.seregely,
            R.raw.kolibri,
            R.raw.varju
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