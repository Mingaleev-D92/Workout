package com.example.workout.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 2/02/2023
 */

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {

   abstract fun historyDao(): HistoryDao

   companion object {
      @Volatile
      private var INSTANCE: HistoryDatabase? = null

      fun getInstance(context: Context): HistoryDatabase {

         synchronized(this) {

            var instance = INSTANCE

            if (instance == null) {
               instance = Room.databaseBuilder(
                   context.applicationContext,
                   HistoryDatabase::class.java,
                   "history_database"
               ).fallbackToDestructiveMigration()
                  .build()
            }
            return instance
         }
      }
   }
}