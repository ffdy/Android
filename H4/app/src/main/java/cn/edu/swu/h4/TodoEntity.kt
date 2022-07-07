package cn.edu.swu.h4

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date

@Entity(tableName = "todo")
@TypeConverters(Converters::class)
data class TodoEntity (
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo var description:String? ,
    @ColumnInfo var deadline: Date? ,
    @ColumnInfo var created:Date? ,
    @ColumnInfo var done:Boolean = false
)