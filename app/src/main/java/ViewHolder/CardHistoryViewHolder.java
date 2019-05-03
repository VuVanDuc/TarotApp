package ViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tarot.R;

import Interface.ItemClickListener;

public class CardHistoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView dateHistory;
    public ImageView cardView;


    public ItemClickListener listener;
    public CardHistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = (ImageView) itemView.findViewById(R.id.card_history_image);
        dateHistory = (TextView)itemView.findViewById(R.id.date_history);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(),false);
    }
}