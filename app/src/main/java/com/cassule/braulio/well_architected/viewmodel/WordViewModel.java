package com.cassule.braulio.well_architected.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.cassule.braulio.well_architected.database.Word;
import com.cassule.braulio.well_architected.repository.WordRepository;

import java.util.List;

/**
 * Created by Braulio on 3/29/2018.
 **/

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> words;

    public WordViewModel(Application application) {
        super(application);
        this.wordRepository = new WordRepository(application);
        this.words = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return words;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }
}
