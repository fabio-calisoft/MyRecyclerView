package com.example.fabio.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String TAG = "fdlMyAdapter";
    private String[] mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public Button mButton;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.mTextView);
            mButton = itemView.findViewById(R.id.mButton);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Click !!");
                }
            });
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        Log.d(TAG , "onCreateViewHolder viewType:" + viewType);
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Log.d(TAG , "onBindViewHolder position:" + position);
        holder.mTextView.setText(mDataset[position]);
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position, @NonNull List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d(TAG , "onBindViewHolder 2 position:" + position);
        holder.mTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        int count = mDataset.length;
        Log.d(TAG , "getItemCount count:" + count);
        return count;
    }


}
