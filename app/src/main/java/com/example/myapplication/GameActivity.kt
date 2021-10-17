package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var opt:MainActivity.Option
    private lateinit var i:Intent
    private var trueIndex:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        i =Intent(this@GameActivity,ResultActivity::class.java)
        load()
        binding.time.start()
        clickListeners()
    }


    private fun load(){
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        opt=intent.extras?.get("opt") as MainActivity.Option//get game settings
        trueIndex = Random.nextInt(3)//случайный правильный ответ
        binding.time.base= SystemClock.elapsedRealtime() + (opt.timerSec*1000)+1000 //время таймера, мс
        binding.time.setOnChronometerTickListener {
            if (binding.time.text=="00:00"){
                binding.time.stop()
                startActivity(i)
            }
        }
        if (!opt.timerWork) {
            binding.time.visibility= View.INVISIBLE
            binding.textView7.visibility= View.INVISIBLE
        }
    }

    private fun clickListeners(){
        binding.plasticGlass1.setOnClickListener {
            if (trueIndex==0) i.putExtra("res",true)
            startActivity(i)
            finish()
        }
        binding.plasticGlass2.setOnClickListener {
            if (trueIndex==1) i.putExtra("res",true)
            startActivity(i)
            finish()
        }
        binding.plasticGlass3.setOnClickListener {
            if (trueIndex==2) i.putExtra("res",true)
            startActivity(i)
            finish()
        }
    }
}