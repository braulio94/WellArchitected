package com.cassule.braulio.well_architected.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.cassule.braulio.well_architected.database.Word;
import com.cassule.braulio.well_architected.database.WordDao;
import com.cassule.braulio.well_architected.database.WordDatabase;

import java.util.List;

/**
 * Created by Braulio on 3/28/2018.
 **/

public class WordRepository {

   private WordDao wordDao;
   private LiveData<List<Word>> words;

    public WordRepository(Application application) {
        WordDatabase db = WordDatabase.getDatabase(application);
        this.wordDao = db.wordDao();
        this.words = wordDao.getAll();
    }

    public LiveData<List<Word>> getAllWords() {
        return words;
    }

    public void insert(Word word) {
        new InsertAsyncTask(wordDao).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {

        private  WordDao mAsyncTaskDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.mAsyncTaskDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insertAll(words);
            return null;
        }
    }
}
