package com.zybooks.assignment_7

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var inputExpenseName: EditText
    private lateinit var inputExpenseAmount: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var expenseRecycler: RecyclerView
    private val expenseList = ArrayList<ExpenseData>()
    private lateinit var expenseAdapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputExpenseName = findViewById(R.id.editExpenseName)
        inputExpenseAmount = findViewById(R.id.editExpenseAmount)
        buttonSubmit = findViewById(R.id.btnAddExpense)
        expenseRecycler = findViewById(R.id.recyclerExpenseList)

        expenseAdapter = ExpenseAdapter(expenseList)
        expenseRecycler.layoutManager = LinearLayoutManager(this)
        expenseRecycler.adapter = expenseAdapter

        buttonSubmit.setOnClickListener {
            val name = inputExpenseName.text.toString()
            val amount = inputExpenseAmount.text.toString().toDoubleOrNull()
            if (name.isNotEmpty() && amount != null) {
                expenseList.add(ExpenseData(name, amount))
                expenseAdapter.notifyItemInserted(expenseList.size - 1)
                inputExpenseName.text.clear()
                inputExpenseAmount.text.clear()
            }
        }
    }
}
