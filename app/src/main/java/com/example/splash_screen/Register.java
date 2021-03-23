package com.example.splash_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText pass;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("user");


    }

    public void Register(View view) {
        String Name = name.getText().toString();
        String Email =email.getText().toString();
        String Password = pass.getText().toString();

        if(Name.isEmpty())
        {
            name.setError("Name is required");
        }
        else if(Email.isEmpty()){
            email.setError("Email is Required");
        }else if(Password.isEmpty()){
            pass.setError("Password is Required");
        }else{
             register(Name,Email,Password);
        }
    }

    private void register(final String Name , final String Email, final String Password) {
        auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String key= auth.getCurrentUser().getUid();
                    user user1 = new user(Name,Email,Password);
                    reference.child(key).setValue(user1);


                    Intent gh = new Intent(Register.this,HomeActivity.class);
                    startActivity(gh);
                }else{
                    Toast.makeText(Register.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
