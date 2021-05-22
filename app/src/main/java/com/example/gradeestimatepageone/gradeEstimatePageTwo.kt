package com.example.gradeestimatepageone



import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_grade_estimate_page_two.*

class gradeEstimatePageTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_estimate_page_two)
        val changePageOne = Intent()
        btn_done.setOnClickListener {
            var txtId = ed_id.text.toString()
            var txtName = ed_name.text.toString()
            var txtCredit = ed_credit.text.toString()
            if (!txtId.isNullOrEmpty() && !txtName.isNullOrEmpty() && !txtCredit.isNullOrEmpty() && txtCredit.toDouble() > 0){
                changePageOne.putExtra("txtID",txtId)
                changePageOne.putExtra("txtName",txtName)
                changePageOne.putExtra("txtCredit",txtCredit)
                setResult(Activity.RESULT_OK,changePageOne)

            }
            finish()


        }

    }


}

