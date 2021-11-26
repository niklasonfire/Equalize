package com.nilius.equalize

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.marginBottom
import com.afollestad.materialdialogs.MaterialDialog

import com.afollestad.materialdialogs.input.input
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity()  {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = findViewById<LinearLayout>(R.id.groupContainer)
        val addGroupButton = findViewById<FloatingActionButton>(R.id.addGroupButton)

        addGroupButton.setOnClickListener {

            MaterialDialog(this).show {
                input(hint = "Group Name") { dialog, text ->


                    // create group data here and store in db
                    var groupContainer: MaterialCardView = createGroupContainer(text.toString())
                    container.addView(groupContainer)
                    groupContainer.setOnClickListener{
                        var text :TextView = groupContainer.getChildAt(0) as TextView

                        //Move intent to groupactivity here
                        Log.d("TAG",text.text.toString())
                    }
                }
                positiveButton()
                negativeButton()
            }
        }


    }


    private fun  createGroupContainer(groupName: String): MaterialCardView {

        val l:MaterialCardView = MaterialCardView(this)

        val lParams:LinearLayout.LayoutParams  = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)

        var text:TextView = TextView(applicationContext)
        text.setText(groupName)
        text.setTextSize(24f)
        lParams.setMargins(20,20,20,20)

        l.layoutParams = lParams
        //l.orientation = (LinearLayout.HORIZONTAL)
        l.isClickable = true


        l.addView(text)
        return l
    }


}