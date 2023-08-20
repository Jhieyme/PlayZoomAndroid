package com.jennifer.playzoom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jennifer.playzoom.model.ShowEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShowEntity.class}, version = 1)
public abstract class PlayZoomDatabase extends RoomDatabase {
    public abstract ShowDao showDao();
    private static volatile PlayZoomDatabase db;

    public static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static PlayZoomDatabase getInstance(Context context){
        if (db == null){
            synchronized(PlayZoomDatabase.class){
                if (db== null){
                    db = Room.databaseBuilder(context.getApplicationContext(), PlayZoomDatabase.class, "shows-database").build();
                }
            }
        }
        return db;
    }
}
