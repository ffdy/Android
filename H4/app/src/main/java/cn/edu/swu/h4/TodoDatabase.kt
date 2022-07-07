package cn.edu.swu.h4

import android.content.Context
import android.util.Log
import android.view.View
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.WorkManager
import androidx.work.workDataOf

@Database(entities = [TodoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: TodoDatabase? = null

        fun getInstance(context: MainActivity): TodoDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): TodoDatabase {
            val DATABASE_NAME = "todo.db"
            return Room.databaseBuilder(context, TodoDatabase::class.java, DATABASE_NAME)
//                .addCallback(
//                    object : RoomDatabase.Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
////                            val nowTime = java.util.Date()
////                            Log.d("@@", nowTime.toString())
////                            todoDao.insertOne(TodoEntity(0, "test", null, nowTime))
////
////                            val todos:List<TodoEntity> = todoDao.getAll()
////                            Log.d("@@", todos.toString())
////                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
////                                .setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
////                                .build()
////                            WorkManager.getInstance(context).enqueue(request)
//                        }
//                    }
//                )
                .allowMainThreadQueries()
                .build()
        }
    }
}