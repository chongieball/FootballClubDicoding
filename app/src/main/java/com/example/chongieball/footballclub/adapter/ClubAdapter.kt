package com.example.chongieball.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.chongieball.footballclub.DescActivity
import com.example.chongieball.footballclub.R
import com.example.chongieball.footballclub.data.Club
import kotlinx.android.synthetic.main.item_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by chongieball on 02/09/18.
 */
class ClubAdapter (private val context : Context, private val clubs: List<Club>)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(club: Club) {
            itemView.tvName.text = club.name
            Glide.with(itemView.context).load(club.image).into(itemView.ivClub)

            itemView.parentLayout.onClick {
                it?.context?.startActivity<DescActivity>(
                        "name" to club.name,
                        "image" to club.image,
                        "desc" to club.descrip)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_club, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clubs[position])
    }

    override fun getItemCount(): Int = clubs.size
}