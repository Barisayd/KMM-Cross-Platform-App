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

        val userId: TextView = itemView.userIdView
        val id: TextView = itemView.IdView

        val title: TextView = itemView.titleView
        val body: TextView = itemView.bodyView

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataClass[position]

        holder.title.text = currentItem.title
        holder.body.text = currentItem.body

        holder.userId.text = currentItem.userId
        holder.id.text = currentItem.id
    }
}


class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userId: TextView = itemView.userIdView
    val id: TextView = itemView.IdView

    val title: TextView = itemView.titleView
    val body: TextView = itemView.bodyView

    fun bindView(dataClass: DataClass){
        userId.text = dataClass.userId
        id.text = dataClass.id
        title.text = dataClass.title
        body.text = dataClass.body
    }
}
