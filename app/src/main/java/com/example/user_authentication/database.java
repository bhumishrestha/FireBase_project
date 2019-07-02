package com.example.user_authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class database extends AppCompatActivity {
EditText userid,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        userid=findViewById(R.id.user_id);
        username=findViewById(R.id.name);


    }
    public void savedata(View view)
    {
        String id=userid.getText().toString();
        String uname=username.getText().toString();

        Map<String,String> data=new HashMap<>();
        data.put("userid",id);
        data.put("username",uname);
        FirebaseFirestore ref=FirebaseFirestore.getInstance();
        ref.collection("User")
                .document(id)
                .set(data);
    }
}
