package com.jennifer.playzoom.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jennifer.playzoom.model.ShowEntity;

import java.util.List;

public class ShowsRepository {

    private ShowDao dao;
    private PlayZoomDatabase db;

    public ShowsRepository(Application application) {
        db = PlayZoomDatabase.getInstance(application);
        dao = db.showDao();
    }

    public void addShow(ShowEntity showEntity){
        PlayZoomDatabase.dataBaseWriteExecutor.execute(() ->
                dao.addShow(showEntity));
    }

    public LiveData<List<ShowEntity>> getAll(){
        return dao.getAll();
    }
}
