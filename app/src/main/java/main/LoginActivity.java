package main;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Import Button
import android.widget.EditText; // Import EditText
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity; // Or your base Activity class

import com.example.keical.R;

public class LoginActivity extends AppCompatActivity{ // Extend AppCompatActivity or Activity

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private TextView forgotPasswordTextView;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.usernameEditText); // Assuming IDs in your XML
        passwordEditText = findViewById(R.id.passwordEditText); // Assuming IDs in your XML
        loginButton = findViewById(R.id.loginButton);           // Assuming IDs in your XML
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        loginButton.setOnClickListener(new View.OnClickListener() {
            private TextView signUpTextView;            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // TODO: Add login logic here (validation, API call, etc.)
            }
        });
    }
}
