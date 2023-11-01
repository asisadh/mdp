package com.example.dinnerdecider

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class AndroidVersionActivity: Activity() {

    private var txtAndroidVersion: EditText? = null
    private var txtAndroidCodeName: EditText? = null
    private var tableLayout: TableLayout? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout)
        tableLayout = findViewById(R.id.tableLayout)
        txtAndroidVersion = findViewById(R.id.android_version_txt)
        txtAndroidCodeName = findViewById(R.id.android_code_name_txt)
        var addButton = findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener{
            checkIfAndroidVersionAndCodeNameAvailable()
        }
    }

    private fun checkIfAndroidVersionAndCodeNameAvailable(){
        val txtVersion = txtAndroidVersion?.text ?: ""
        val txtCodeName = txtAndroidCodeName?.text ?: ""

        if (txtVersion.isNotEmpty() && txtCodeName.isNotEmpty()){
            addAndroidVersionAndCodeName()
        }else{
            Toast.makeText(applicationContext,"Enter Android Version and Code Name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addAndroidVersionAndCodeName(){
        val tableRow = TableRow(applicationContext)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams

        val androidVersionText = TextView(applicationContext)
        androidVersionText.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        androidVersionText.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.purple_200))
        androidVersionText.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
        androidVersionText.text = txtAndroidVersion?.text

        val androidCodeNameText = TextView(applicationContext)
        androidCodeNameText.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        androidCodeNameText.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.teal_200))
        androidCodeNameText.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
        androidCodeNameText.text = txtAndroidCodeName?.text


        tableRow.addView(androidVersionText)
        tableRow.addView(androidCodeNameText)

        tableLayout?.addView(tableRow)
        txtAndroidVersion?.text?.clear()
        txtAndroidCodeName?.text?.clear()
        txtAndroidCodeName?.clearFocus()

    }
}