package com.example.sqlite

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Pooja on 02-02-2018.
 */

@Entity
class Mobile {
    @PrimaryKey
    var mbId : Long? = null
    @ColumnInfo(name = "mob_typ")
    var typ : String? = null
    @ColumnInfo(name="mob_mnfr")
    var mnFr : String? = null
    @ColumnInfo(name="is_qwerty")
    var isQw : Boolean? = null
}