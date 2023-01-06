package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
        getDate()
    }
    fun login(){
        val nickname=findViewById<TextView>(R.id.name)
        val nicknameText=findViewById<EditText>(R.id.input)
        val image = findViewById<ImageView>(R.id.imageView)
        val btn1= findViewById<Button>(R.id.change)
        val btn2= findViewById<Button>(R.id.search)

        btn1.setOnClickListener{
            nickname.text=nicknameText.text.toString()
            image.setImageResource(R.drawable.ic_baseline_back_hand_24)
        }
        btn2.setOnClickListener {
            Toast.makeText(this, "반갑습니다",Toast.LENGTH_SHORT).show()
            val i = Intent(this,MainActivity2::class.java)
            i.putExtra("today",getDate())
            i.putExtra("nickname",nickname.text.toString())
            startActivity(i)

        }
    }

    fun getDate():String{
        val now=System.currentTimeMillis()
        val date= Date(now)
        val simpleformat=SimpleDateFormat("yyyy년 MM월 dd일의 날씨")
        val str=simpleformat.format(date).toString()
        Toast.makeText(this,"오늘 날짜는:${str}",Toast.LENGTH_SHORT).show()
        return str
    }
}