package med.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CartPage extends AppCompatActivity {

    ImageView AddIcon;
    TextView retrieve;

//    FirebaseDatabase firebaseDatabase;
//    FirebaseAuth auth;
//    FirebaseUser user;
//    DatabaseReference databaseReference;
//
//    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//
//        auth = FirebaseAuth.getInstance();
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        databaseReference = firebaseDatabase.getReference("Cart/"+uid);

//        MedicineList[] medicineLists = new MedicineList[]{
//                new MedicineList("meftal spas","25"),
//                new MedicineList("lakshmi vilas ras","25"),
//                new MedicineList("med2","25"),
//                new MedicineList("sfgs","25"),
//                new MedicineList("meftal spas","25"),
//        };
//        recyclerView = findViewById(R.id.medListOnCheckOut);
//        CartAdapter adapter = new CartAdapter(medicineLists);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

        AddIcon = findViewById(R.id.cartIcon);
        AddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MedList.class));
            }
        });

        retrieve = findViewById(R.id.Retrieve);
        //getData();

    }

//    private void getData(){
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value = snapshot.getValue(String.class);
//                retrieve.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }


}