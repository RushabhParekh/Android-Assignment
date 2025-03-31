package com.zybooks.assignment_7

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var inputName: EditText
    private lateinit var inputAmount: EditText
    private lateinit var addExpenseButton: Button
    private lateinit var tipButton: Button
    private lateinit var recyclerExpenses: RecyclerView
    private lateinit var expenseList: MutableList<Expense>
    private lateinit var adapter: ExpenseAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputName = findViewById(R.id.inputName)
        inputAmount = findViewById(R.id.inputAmount)
        addExpenseButton = findViewById(R.id.buttonAddExpense)
        tipButton = findViewById(R.id.buttonMoneyTips)
        recyclerExpenses = findViewById(R.id.recyclerExpenseList)

        expenseList = mutableListOf()
        adapter = ExpenseAdapter(expenseList)
        recyclerExpenses.layoutManager = LinearLayoutManager(this)
        recyclerExpenses.adapter = adapter

        addExpenseButton.setOnClickListener {
            val name = inputName.text.toString().trim()
            val amount = inputAmount.text.toString().trim()

            val expense = Expense(name, amount)
            expenseList.add(expense)
            adapter.notifyDataSetChanged()
            updateTotalExpenses()

            inputName.text.clear()
            inputAmount.text.clear()
        }

        tipButton.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.manulife.ca/personal/plan-and-learn/healthy-finances/financial-planning/ten-simple-money-management-tips.html")
            )
            startActivity(intent)
        }

        val headerFragment = HeaderFragment()
        val footerFragment = FooterFragment()

        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction1: FragmentTransaction = fragmentManager.beginTransaction()
        transaction1.add(R.id.header, headerFragment)
        transaction1.commit()

        val transaction2: FragmentTransaction = fragmentManager.beginTransaction()
        transaction2.replace(R.id.footer, footerFragment)
        transaction2.commit()
    }

    private fun updateTotalExpenses() {
        var total = 0.0
        for (expense in expenseList) {
            val amountValue = expense.amount.toDoubleOrNull() ?: 0.0
            total += amountValue
        }
        Log.d("MainActivity", "Total expenses: $$total")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
    }
}
