package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView



class ListAdapter(val weatherList:List<Coordinates>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var ku: TextView
        var soup: TextView
        var han: TextView

        init {
            image = view.findViewById(R.id.cloud)
            ku = view.findViewById(R.id.ku)
            soup = view.findViewById(R.id.soup)
            han = view.findViewById(R.id.han)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.weather, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
        holder.ku.text = weatherList[position].place
        holder.soup.text = weatherList[position].x
        holder.han.text = weatherList[position].y
    }
}