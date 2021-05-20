package med.cart;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     ArrayList<MedicineList> listData;
    public CartAdapter(ArrayList<MedicineList> medicineLists) {
        this.listData = medicineLists;
    }

    void setValues(MedicineList medicList){
        listData.add(medicList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.medicine_cart_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        MedicineList myListData = listData.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.Name.setText(listData.get(position).getName());
        viewHolder.Price.setText(listData.get(position).getPrice());


    }





    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView Price;
        public RelativeLayout relativeLayout;
        public ImageView RemoveFromCart;
        public ViewHolder(View ItemView){
            super(ItemView);
            this.Name = ItemView.findViewById(R.id.medicineNameCheckout);
            this.Price = ItemView.findViewById(R.id.medicinePriceCheckout);
            this.RemoveFromCart = ItemView.findViewById(R.id.remove);
            this.relativeLayout = ItemView.findViewById(R.id.relativeLayoutCheckout);
        }
    }
}
