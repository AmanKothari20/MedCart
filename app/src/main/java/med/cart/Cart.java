package med.cart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Cart extends AppCompatActivity {

//    private TextView ret;
    ImageView AddMeds;
    RecyclerView MedListCheckout;
    Button order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        MedListCheckout = findViewById(R.id.medListCheckOut);
        MedListCheckout.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        MedListCheckout.setHasFixedSize(true);

        order = findViewById(R.id.orderBtn);



        AddMeds = findViewById(R.id.AddIcon);
        AddMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),MedList.class));
            }
        });


        DatabaseActivity();

    }

    private void DatabaseActivity(){

        CartAdapter adapter = new CartAdapter(new ArrayList<MedicineList>());
        MedListCheckout.setAdapter(adapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MedicineList medicines = new MedicineList();
//                medicines.setName(snapshot.child("name").getValue().toString());
//                medicines.setPrice(snapshot.child("price").getValue().toString());
//                medicines.setUserId(snapshot.child("userId").getValue().toString());

                Log.e("cart", String.valueOf(snapshot.child("name").getValue()));
                String name = String.valueOf(snapshot.child("name").getValue());
                String price = String.valueOf(snapshot.child("price").getValue());
                String Uid = String.valueOf(snapshot.child("userId").getValue());

                medicines.setName(name);
                medicines.setPrice(price);
                medicines.setUserId(Uid);

                DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("Order/"+Uid+"/"+name);
                databaseReference1.setValue(medicines);
                Toast.makeText(Cart.this, "medicines Ordered", Toast.LENGTH_SHORT).show();
                ((CartAdapter) Objects.requireNonNull(MedListCheckout.getAdapter())).setValues(medicines);


//                Log.e("cart",medicines.getName());
                order.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        MedicineList medicines = new MedicineList();
//                        String name = String.valueOf(snapshot.child("name").getValue());
//                        String price = String.valueOf(snapshot.child("price").getValue());
//                        String Uid = String.valueOf(snapshot.child("userId").getValue());
//                        medicines.setName(name);
//                        medicines.setPrice(price);
//                        medicines.setUserId(Uid);

                    }
                });
            }



            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }


}