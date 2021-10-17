package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityAboutBinding
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri


class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.version.text = BuildConfig.VERSION_NAME
        binding.versionCode.text = BuildConfig.VERSION_CODE.toString()
        binding.bOk.setOnClickListener { finish() }
        binding.imageView.setOnClickListener {
            val i = Intent(Intent(ACTION_VIEW,Uri.parse(getString(R.string.myLinc))))
            startActivity(i)
        }
    }
}