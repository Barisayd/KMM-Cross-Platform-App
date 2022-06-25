package com.example.ps_eis.android



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_eis.DataClass
import kotlinx.android.synthetic.main.greeting_item.view.*


class ListAdapter(val dataClass: ArrayList<DataClass>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val ItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.greeting_item, parent, false)

        return ViewHolder(ItemView)
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataClass.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val formatView: TextView = itemView.greeting_view
        val langView: TextView = itemView.lang_id

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataClass[position]

        holder.formatView.text =currentItem.format_view
        holder.langView.text = currentItem.lang_view
    }
}


class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val formatView: TextView = itemView.greeting_view
    val langView: TextView = itemView.lang_id

    fun bindView(dataClass: DataClass){
        formatView.text = dataClass.format_view
        langView.text = dataClass.lang_view
    }
}
