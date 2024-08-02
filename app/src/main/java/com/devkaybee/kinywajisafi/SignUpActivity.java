package com.devkaybee.kinywajisafi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    public EditText roleLevel, signupEmail, signupPassword;
    public Button signupButton;
    public FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        roleLevel = findViewById(R.id.editTextName);
        signupEmail = findViewById(R.id.editTextEmail);
        signupPassword = findViewById(R.id.editTextPassword);

        auth = FirebaseAuth.getInstance();

        }

        private void PerfomSignUp(){
            String role = roleLevel.getText().toString().trim();
            String email = signupEmail.getText().toString().trim();
            String password = signupPassword.getText().toString().trim();

            if(role.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task ->{
                            if(task.isSuccessful()){
                                FirebaseUser currentUser = auth.getCurrentUser();
                                String userId = null;

                                if(currentUser != null){
                                    userId = currentUser.getUid();
                                }

                                reference = FirebaseDatabase.getInstance().getReference("users").child(role).child(userId);

                            }
                    });

    }

}


