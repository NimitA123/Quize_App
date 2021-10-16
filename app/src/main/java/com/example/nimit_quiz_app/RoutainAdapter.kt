package com.example.nimit_quiz_app


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RoutineAdapter(
    val context: Context,
    val routineList: MutableList<RoutainModel>,

) : RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.routine_item_row, parent, false)
        return RoutineViewHolder(view1)

    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val routain = routineList.get(position)
        return holder.setData(routain)




    }
    override fun getItemCount(): Int {
        return routineList.size
    }


    class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val optionA = itemView.findViewById<RadioButton>(R.id.optionA)
        val optionB = itemView.findViewById<RadioButton>(R.id.optionB)
        val optionC = itemView.findViewById<RadioButton>(R.id.optionC)
        val optionD = itemView.findViewById<RadioButton>(R.id.optionD)

        fun setData(routineList: RoutainModel){
            textView.text = routineList.Question
            optionA.text = routineList.OptionA
            optionB.text = routineList.OptionB
            optionC.text = routineList.OptionC
            optionD.text = routineList.OptionD
        }
    }
}