package Adaptors

import Models.Gmail
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewassignment.R
import kotlin.random.Random

class GmailAdaptor(val gmails: List<Gmail>) : RecyclerView.Adapter<GmailAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCircleName = view.findViewById<TextView>(R.id.circle_name)
        val textViewSender = view.findViewById<TextView>(R.id.gmail_sender)
        val textViewTime = view.findViewById<TextView>(R.id.gmail_time)
        val textViewContent = view.findViewById<TextView>(R.id.gmail_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.gmail_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gmails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gmail: Gmail = gmails[position]

        holder.textViewCircleName.text = gmail.sender[0].toString()
        val drawable = holder.textViewCircleName.background
        drawable.setColorFilter(-Random.nextInt(-Color.BLACK), PorterDuff.Mode.SRC)
        holder.textViewCircleName.background = drawable

        holder.textViewSender.text = gmail.sender
        holder.textViewTime.text = gmail.time
        holder.textViewContent.text = gmail.content
    }
}
