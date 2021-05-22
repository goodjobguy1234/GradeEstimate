package com.example.gradeestimatepageone

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.listlayout.view.*


class MyAdapter(var mcontext:Context , var resorce:Int ,var items:List<subjectData>,var txtview:TextView, var radioItems:MutableList<Int>)
    : ArrayAdapter<subjectData>(mcontext,resorce,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mcontext)
        val view: View = layoutInflater.inflate(resorce, null)
        view.tv_subid.text = items[position].subjectID
        view.tv_subname.text = items[position].subjectName
        if (radioItems.isNotEmpty()){
             if (radioItems.elementAtOrNull(position) != null){
                when(radioItems.elementAt(position)){
                    R.id.rd_one ->{
                        view.rd_group.rd_one.isChecked = true
                    }
                    R.id.rd_two ->{
                        view.rd_group.rd_two.isChecked = true
                    }
                    R.id.rd_three ->{
                        view.rd_group.rd_three.isChecked = true
                    }
                    R.id.rd_four ->{
                        view.rd_group.rd_four.isChecked = true
                    }
                    R.id.rd_five ->{
                        view.rd_group.rd_five.isChecked = true
                    }
                    R.id.rd_six ->{
                        view.rd_group.rd_six.isChecked = true
                    }
                    R.id.rd_seven ->{
                        view.rd_group.rd_seven.isChecked = true
                    }
                    R.id.rd_eight -> {
                        view.rd_group.rd_eight.isChecked = true
                    }
                }
            }
        }

        view.rd_group.setOnCheckedChangeListener { group, checkedId ->
            checkRadioItems(radioItems,position,checkedId)
            when(checkedId){
                R.id.rd_one ->{
//                    checkRadioItems(radioItems,position,checkedId)
                    items[position].score = items[position].subjectCredit * 0

                }
                R.id.rd_two ->{
                    items[position].score = items[position].subjectCredit * 1

                }
                R.id.rd_three ->{
                    items[position].score = items[position].subjectCredit * 1.5

                }
                R.id.rd_four ->{
                    items[position].score = items[position].subjectCredit * 2

                }
                R.id.rd_five ->{
                    items[position].score = items[position].subjectCredit * 2.5

                }
                R.id.rd_six ->{
                    items[position].score = items[position].subjectCredit * 3

                }
                R.id.rd_seven ->{
                    items[position].score = items[position].subjectCredit * 3.5

                }
                R.id.rd_eight ->{
                    items[position].score = items[position].subjectCredit * 4

                }
            }
            txtview.text = calculategrade()
        }

        return view

    }

    fun calculategrade():String{
        var sum = 0.0
        var div = 0.0
        for (i in 0 until items.size){
            sum+= items[i].score
            div+= items[i].subjectCredit
        }
        return String.format("%.2f",sum/div)
    }

    private fun checkRadioItems(items: MutableList<Int>,position: Int,checkedId:Int){
        if (items.elementAtOrNull(position) == null){
            items.add(checkedId)
        }else{
            items.set(position,checkedId)
        }
    }

}