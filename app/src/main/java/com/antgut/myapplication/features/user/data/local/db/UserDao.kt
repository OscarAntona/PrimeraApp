package com.antgut.myapplication.features.user.data.local.db

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(vararg user: UserEntity)

    @Query("DELETE FROM $TABLE_NAME WHERE id IS NOT NULL")
    fun deleteAllUser()

    @Query("DELETE FROM $TABLE_NAME WHERE id = :userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserEntity?

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAllUser(): List<UserEntity>
}