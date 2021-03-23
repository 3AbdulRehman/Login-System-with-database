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

public class Login extends AppCompatActivity {
    EditText email;
    EditText pass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        auth= FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String  Email = email.getText().toString();
        String Password = pass.getText().toString();

        if(Email.isEmpty()){
            email.setError("Email is Required");
        }
        else if(Password.isEmpty()){
            pass.setError("Password is Required");
        }else {
            info(Email,Password);
        }
    }

    private void info(String Email,String Password) {
        auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Intent intent=new Intent(Login.this,HomeActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(Login.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }

            }
        });
    }

    public void Register(View view) {
        Intent gh = new Intent(Login.this,Register.class);
        startActivity(gh);
    }
}
