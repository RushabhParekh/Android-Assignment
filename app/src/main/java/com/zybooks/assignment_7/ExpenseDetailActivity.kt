package com.zybooks.assignment_7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_detail)

        val title = intent.getStringExtra("title")
        val amount = intent.getDoubleExtra("amount", 0.0)

        findViewById<TextView>(R.id.detailTitle).text = title
        findViewById<TextView>(R.id.detailAmount).text = "$%.2f".format(amount)
    }
}
