package com.example.claseihc1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_settings.*
import java.util.*

class settings : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration

        if (conf.locale.language.equals("es")) {
            switch1.isChecked = true
        }

        switch1.setOnClickListener() {
            if (switch1.isChecked) {
                conf.setLocale(Locale("es"))
            } else {
                conf.setLocale(Locale("en"))
            }
            res.updateConfiguration(conf, dm)
            this.recreate();
        }

    }


}
