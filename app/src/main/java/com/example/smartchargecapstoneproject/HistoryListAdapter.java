package com.example.smartchargecapstoneproject;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.HistoryVH> {
    List<HistoryList> historyListList;

    public HistoryListAdapter(List<HistoryList> historyListList) {
        this.historyListList = historyListList;
    }
    @NonNull
    @Override
    public HistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_expanded_row, parent, false);
        return new HistoryVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HistoryListAdapter.HistoryVH holder, int position) {

        HistoryList historyList = historyListList.get(position);
        holder.history_descriptionTxt.setText(historyList.getHistory_description());
        holder.history_actionTxt.setText(historyList.getHistory_action());


        boolean isExpandable = historyListList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }
    @Override
    public int getItemCount() {
        return historyListList.size();
    }

    public class HistoryVH extends RecyclerView.ViewHolder {

        TextView history_descriptionTxt, history_actionTxt;

        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public HistoryVH(@NonNull View itemView) {
            super(itemView);

            history_descriptionTxt = itemView.findViewById(R.id.historyDescription);
            history_actionTxt = itemView.findViewById(R.id.historyAction);


            linearLayout = itemView.findViewById(R.id.description_linear_layout);
            expandableLayout = itemView.findViewById(R.id.history_expandible_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    HistoryList historyList = historyListList.get(getAdapterPosition());
                    historyList.setExpandable(!historyList.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
