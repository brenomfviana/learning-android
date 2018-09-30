package br.ufrn.edu.brenov.homework5.exercise2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.edu.brenov.homework5.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<String> dataset;

    public ListAdapter() {
        this.dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            this.dataset.add(String.valueOf(i + 1));
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linear = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);
        ListViewHolder vh = new ListViewHolder(linear);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int i) {
        holder.mTextView.setText(this.dataset.get(i));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public Button mButton;
        public ListViewHolder(final LinearLayout linear) {
            super(linear);
            mTextView = linear.findViewById(R.id.text);
            mButton = linear.findViewById(R.id.button);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(linear.getContext(),
                            "Ŷou clicked on number " + mTextView.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
