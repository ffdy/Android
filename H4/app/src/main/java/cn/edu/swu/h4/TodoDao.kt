package cn.edu.swu.h4

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY done ASC, deadline DESC")
    fun getAll(): List<TodoEntity>

    @Query("SELECT * FROM todo WHERE done = 0")
    fun getAllTodo(): List<TodoEntity>

    @Query("SELECT * FROM todo WHERE done = 1")
    fun getAllDone(): List<TodoEntity>

    @Insert
    fun insertOne(todo:TodoEntity)

    @Update
    fun updateOne(todo: TodoEntity)

    @Delete
    fun deleteOne(todo: TodoEntity)

//    @Query("SELECT * FROM todo WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<TodoEntity>
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): TodoEntity
//
//    @Insert
//    fun insertAll(vararg users: User)
//
//    @Delete
//    fun delete(user: User)
}