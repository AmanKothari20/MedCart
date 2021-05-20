package med.cart;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
    RecyclerView recyclerView;
    private MedicineList[] listdata;

    FusedLocationProviderClient mFusedLocationClient;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    MedicineList medicineList;

    public MedicineAdapter(MedicineList[] medicineLists) {
        this.listdata = medicineLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.medicine_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MedicineList myListData = listdata[position];
        holder.Name.setText(listdata[position].getName());
        holder.Price.setText(listdata[position].getPrice());

        firebaseDatabase = FirebaseDatabase.getInstance();
        medicineList = new MedicineList();
        auth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();



        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"added to cart"+myListData.getName(),Toast.LENGTH_LONG).show();
                databaseReference = firebaseDatabase.getReference("Cart/"+uid+"/"+myListData.getName());
                addDatabaseToFireBase(uid,myListData.getName(),myListData.getPrice());
            }
        });


    }

    private void addDatabaseToFireBase(String Uid,String name,String price){
        medicineList.setUserId(Uid);
        medicineList.setName(name);
        medicineList.setPrice(price);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(medicineList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView Price;
        public RelativeLayout relativeLayout;
        public ImageView addToCart;
        public ViewHolder(View ItemView){
            super(ItemView);
            this.Name = (TextView) ItemView.findViewById(R.id.medicineName);
            this.Price = (TextView) ItemView.findViewById(R.id.medicinePrice);
            this.addToCart = (ImageView) ItemView.findViewById(R.id.addToCart);
            relativeLayout = (RelativeLayout) ItemView.findViewById(R.id.relativeLayout);

        }
    }
}
