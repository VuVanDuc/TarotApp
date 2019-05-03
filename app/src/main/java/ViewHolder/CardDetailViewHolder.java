package ViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.example.tarot.R;

public class CardDetailViewHolder extends RecyclerView.ViewHolder{
    public ImageView cardView;
    public TextView contentCard;
    public CardDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = (ImageView) itemView.findViewById(R.id.card_image);
        contentCard = (TextView)itemView.findViewById(R.id.content_card);
    }
}