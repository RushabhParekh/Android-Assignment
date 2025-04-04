package com.zybooks.assignment_7.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zybooks.assignment_7.R
import com.zybooks.assignment_7.model.Expense

class ExpenseAdapter(
    private val expenseList: MutableList<Expense>,
    private val saveData: () -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.findViewById(R.id.name)
        val amountView: TextView = itemView.findViewById(R.id.totalAmount)
        val convertedCostView: TextView = itemView.findViewById(R.id.converted_cost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.nameView.text = expense.name
        holder.amountView.text = expense.totalAmount
        holder.convertedCostView.text = expense.convertedCost.toString()
    }

    override fun getItemCount(): Int = expenseList.size
}
