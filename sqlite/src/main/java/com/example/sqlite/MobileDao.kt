package com.example.sqlite

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Pooja on 02-02-2018.
 */
@Dao
interface MobileDao {

    @Insert
    fun saveMobile(mob: Mobile)
    @Query("select * from mobile")
    fun mobiles() : List<Mobile>
}