package com.example.gradeestimatepageone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list = mutableListOf<subjectData>()
    var radioValue = mutableListOf<Int>()
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //change page.

        val changePage = Intent(this, gradeEstimatePageTwo::class.java)

        btn_add.setOnClickListener {
            startActivityForResult(changePage,1)
        }

//        val myAdapter = MyAdapter(this,R.layout.listlayout,list,tv_grade)
//        listview.adapter = myAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && data != null){
            if(resultCode == Activity.RESULT_OK){
                val subid = data.getStringExtra("txtID")
                val subName = data.getStringExtra("txtName")
                val subCredit = data.getStringExtra("txtCredit")
                list.add(subjectData(subid,subName,subCredit.toDouble(),0.0))
                myAdapter = MyAdapter(this,R.layout.listlayout,list,tv_grade,radioValue)
                listview.adapter = myAdapter
            }
        }
    }


}


