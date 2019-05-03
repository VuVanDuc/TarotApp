package ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarot.R;

import Interface.ItemClickListener;

public class TarotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView nameTarot, dateTarot;
    public ImageView tarotView;


    public ItemClickListener listener;
    public TarotViewHolder(@NonNull View itemView) {
        super(itemView);
        tarotView = (ImageView) itemView.findViewById(R.id.tarot_image);
        nameTarot = (TextView)itemView.findViewById(R.id.tarot_name);
        dateTarot = (TextView)itemView.findViewById(R.id.tarot_date);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(),false);
    }
}