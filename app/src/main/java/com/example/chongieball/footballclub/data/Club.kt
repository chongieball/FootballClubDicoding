package com.example.chongieball.footballclub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by chongieball on 02/09/18.
 */
@Parcelize
data class Club (val name: String?, val image: Int?, val descrip: String?) : Parcelable