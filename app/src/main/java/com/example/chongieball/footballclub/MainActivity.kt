package com.example.chongieball.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.chongieball.footballclub.adapter.ClubAdapter
import com.example.chongieball.footballclub.data.Club
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var clubs: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainActivityUI(clubs).setContentView(this)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)
        clubs.clear()

        for (i in name.indices) {
            clubs.add(Club(name[i], image.getResourceId(i,0), desc[i]))
        }

        image.recycle()
    }

    class MainActivityUI(private val clubs: MutableList<Club>) : AnkoComponent<MainActivity> {

        private lateinit var clubAdapter: ClubAdapter

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            clubAdapter = ClubAdapter(ctx, clubs)

            verticalLayout {
                lparams(width = matchParent, height = wrapContent)

                recyclerView {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
                    adapter = clubAdapter
                }.lparams(matchParent, wrapContent)
            }
        }
    }
}
