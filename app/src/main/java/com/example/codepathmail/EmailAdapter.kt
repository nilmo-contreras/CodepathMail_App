package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails:List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Creates member variables for any view that will be set
        // as you render a row.
        val senderTv: TextView
        val titleTv: TextView
        val summaryTv: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores each of the layout's views into
            // the public final member variables created above
            senderTv = itemView.findViewById(R.id.senderTv)
            titleTv = itemView.findViewById(R.id.titleTv)
            summaryTv = itemView.findViewById(R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.email_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]

        holder.senderTv.text = email.sender
        holder.titleTv.text = email.title
        holder.summaryTv.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}