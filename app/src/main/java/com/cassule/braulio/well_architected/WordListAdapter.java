package com.cassule.braulio.well_architected;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cassule.braulio.well_architected.database.Word;

import java.util.List;

/**
 * Created by Braulio on 3/29/2018.
 **/

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater inflater;
    private List<Word> words;

    public WordListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (words != null){
            Word word = words.get(position);
            holder.wordItemView.setText(word.getmWord());
        } else {
            holder.wordItemView.setText("NO WORDS TO DISPLAY");
        }
    }

    @Override
    public int getItemCount() {
        if (words != null)
            return words.size();
        else return 0;
    }

    public void setWords(List<Word> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
