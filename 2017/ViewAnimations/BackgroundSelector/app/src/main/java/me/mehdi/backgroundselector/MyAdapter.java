package me.mehdi.backgroundselector;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;

    private final String[] ITEMS = {
            "Eins", "Zwei" , "Drei",
            "Vier", "Funf", "Sechs",
            "Sieben", "Acht", "Neun"
    } ;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemText.setText(ITEMS[position]);
    }

    @Override
    public int getItemCount() {
        return ITEMS.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemText;
        public ViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.myText);
        }
    }
    public MyAdapter(Context context) {
        mContext = context;
    }
}
