package com.example.sasensorsproj

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        /*var list = sensorManager.getSensorList(Sensor.TYPE_ALL)

        var myadapter = ArrayAdapter<Sensor>(this,
                android.R.layout.simple_dropdown_item_1line,list)

        mylistView.adapter = myadapter*/

    }
}