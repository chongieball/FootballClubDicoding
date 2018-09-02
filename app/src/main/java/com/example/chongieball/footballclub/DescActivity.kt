package com.example.chongieball.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by chongieball on 02/09/18.
 */
class DescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name")
        val image = intent.getIntExtra("image", 0)
        val desc = intent.getStringExtra("desc")

        verticalLayout {
            padding = dip(10)

            val ivImage = imageView(R.drawable.mu)
                    .lparams(dip(100), dip(100)) {
                        margin = dip(10)
                        gravity = Gravity.CENTER
                    }

            Glide.with(this).load(image).into(ivImage)

            textView {
                textSize = 20f
                text = name
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
            }


            textView {
                textSize = 17f
                text = desc
            }
        }
    }
}