package com.example.pokemanapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemanapi.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val quotesApi = RetrofitBuilder.getInstance().create(BerryApi::class.java)
        // launching a new coroutine

            GlobalScope.launch {
            val result = quotesApi.getBerries()
            if (result != null)
            {
                withContext(Dispatchers.Main){
                    populateRecylerView(result.berry)

                }
            }


        }



    }

    private fun populateRecylerView(berry: ArrayList<Berry>) {
        binding.recyclerBerries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            val adpt = BerryAdapter()
            adpt.submitList(berry)

            adapter = adpt

        }    }

    private fun getBerries() = mutableListOf<Berry>().apply {
        add(Berry("One","1"))
        add(Berry("Two","2"))
        add(Berry("Three","3"))
        add(Berry("Four","4"))
    }

    }









