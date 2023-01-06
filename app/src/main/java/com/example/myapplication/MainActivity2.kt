package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity2 : AppCompatActivity() {

    lateinit var date:String
    lateinit var nickname:String
    lateinit var recyclerview: RecyclerView
    lateinit var weatherAdapter: ListAdapter
    var coordiList=mutableListOf<Coordinates>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        date=intent.getStringExtra("today").toString()
        nickname=intent.getStringExtra("nickname").toString()

        val title=findViewById<TextView>(R.id.title)
        title.text=date

        Toast.makeText(this,"${nickname} 환영합니다", Toast.LENGTH_SHORT).show()
        init()
    }
    fun init(){
        find()
        recyclerview=findViewById(R.id.recyclerView)
        recyclerview.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        weatherAdapter=ListAdapter(coordiList)
        recyclerview.adapter=weatherAdapter


    }
    fun find() {
        var line:BufferedReader?=null
        var info = ""
        try {
            line= BufferedReader(InputStreamReader(resources.openRawResource(R.raw.seoulxy)))
            while (line!=null){
                info=line!!.readLine().toString()
                if(info.equals("end")){
                    break
                }
                var infos=info.split(",")
                coordiList.add(Coordinates(infos[0],infos[1],infos[2]))
            }
        } catch (e:IOException){
            Log.e("CSV read error :",e.toString())
        }
    }
}