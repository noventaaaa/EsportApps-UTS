package com.example.esportapps_uts.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)

    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>

    @Query("SELECT * FROM user WHERE username= :username AND password=:password")
    fun selectUser(username:String,password:String):User

    @Query("SELECT * FROM user WHERE username= :username")
    fun selectProfile(username:String):User

    @Query("UPDATE user SET first_name =:name, password =:password WHERE iduser=:id")
    fun userUpdate(name:String,password:String,id:Int)

    @Delete
    fun deleteUser(user: User)
}