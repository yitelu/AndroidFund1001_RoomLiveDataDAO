package com.ytl.roomwordssample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Richard Yi-Te Lu on 22,December,2018
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    class WordViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            wordItemView = itemView.findViewById(R.id.textView);

        }
    }


    private final LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {

            Word current = mWords.get(i);
            wordViewHolder.wordItemView.setText(current.getWord());
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords != null){
            return mWords.size();
        } else {
            return 0;
        }
    }



}
