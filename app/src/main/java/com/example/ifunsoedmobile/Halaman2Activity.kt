package com.example.ifunsoedmobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.ifunsoedmobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHalaman2Binding
    private val latitude = "-7.429427"
    private val longitude = "109.338082"
    private val gMapsUrl = "http://maps.google.com/maps?q=loc:"
    private val packageMaps = "com.google.com.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout(){
        binding.layoutLocation.let{
            it.imgIcon.setImageResource(R.drawable.ic_location)
            it.tvLayout.setText(R.string.alamat)
        }
        binding.layoutEmail.let{
            it.imgIcon.setImageResource(R.drawable.ic_email)
            it.tvLayout.setText(R.string.email)
        }
        binding.layoutIg.let{
            it.imgIcon.setImageResource(R.drawable.ic_himpunan)
            it.tvLayout.setText(R.string.ig_himpunan)
        }
        binding.layoutPhone.let{
            it.imgIcon.setImageResource(R.drawable.ic_phone)
            it.tvLayout.setText(R.string.telepon)
        }

    }

    private fun initListener() {
        binding.layoutLocation.root.setOnClickListener {
            val gMapsIntentUri = "$gMapsUrl$latitude,$longitude".toUri()
            // FIX: Call Intent constructor without named arguments if it's a Java constructor.
            //      However, for many common Intent constructors, Kotlin can map them.
            //      The one you used (action, uri) is often okay.
            //      The MOST LIKELY culprit is `startActivity(intent = ...)`
            val mapIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri) // Assumed correct order
            mapIntent.setPackage(packageMaps) // Call setPackage separately if it causes issues as a named arg

            // FIX: Call startActivity without the 'intent =' named argument
            startActivity(mapIntent)
        }

        binding.layoutIg.root.setOnClickListener {
            // FIX: Call Intent constructor without named argument if it's the issue
            val intent = Intent(Intent.ACTION_VIEW)
            // FIX: Call getString without the 'resid =' named argument
            intent.data = getString(R.string.ig_himpunan).toUri()
            startActivity(intent) // No named argument here either
        }

        binding.layoutEmail.root.setOnClickListener {
            // FIX: Call Intent constructor without named argument if it's the issue
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                // FIX: Call getString without the 'resid =' named argument
                data = "mailto:${getString(R.string.email)}".toUri()
            }
            startActivity(intent) // No named argument
        }

        binding.layoutPhone.root.setOnClickListener {
            // FIX: Call Intent constructor without named argument if it's the issue
            val intent = Intent(Intent.ACTION_DIAL).apply {
                // FIX: Call getString without the 'resid =' named argument
                data = "tel:${getString(R.string.telepon)}".toUri()
            }
            startActivity(intent) // No named argument
        }

        binding.btnBack.setOnClickListener {
            finish() // finish() typically doesn't take arguments
        }
    }

}