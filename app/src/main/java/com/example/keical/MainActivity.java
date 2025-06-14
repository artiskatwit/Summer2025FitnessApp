package com.example.keical;


import android.content.Intent; // Imports the Intent class, used for starting new activities or passing messages.
import android.os.Bundle; // Imports the Bundle class, used for passing data between activities, typically for saving instance state.
import android.view.View; // Imports the View class, the basic building block for user interface components.
import android.widget.TextView; // Imports the TextView class, used to display text to the user.
import android.widget.Button; // Imports the Button class, a UI element that the user can tap to trigger an action.
import androidx.activity.EdgeToEdge; // Imports EdgeToEdge for handling display cutouts and drawing behind system bars.
import androidx.appcompat.app.AppCompatActivity; // Imports AppCompatActivity, a base class for activities that use the Support Library action bar features.

/**
 * MainActivity serves as the primary entry point for the KeiCal application.
 * It displays a welcome message and provides options for users to sign up, log in,
 * or navigate directly to the calorie tracking feature.
 */
public class MainActivity extends AppCompatActivity {



    /**
     * TextView to display the welcome message to the user.
     */
    private TextView welcomeTextView;

    /**
     * Button to navigate the user to the Sign Up screen.
     */
    private Button signUpButton;

    /**
     * Button to navigate the user to the Log In screen.
     */
    private Button logInButton;

    /**
     * Button to navigate the user to the Calorie Tracker screen.
     */
    private Button calorieTrackerButton;

    /**
     * Called when the activity is first created. This is where you should do all of your normal static set up:
     * create views, bind data to lists, etc. This method also provides you with a Bundle containing the activity's
     * previously frozen state, if there was one.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Calls the superclass's onCreate method, essential for Activity lifecycle management.
        super.onCreate(savedInstanceState);

        // Enables edge-to-edge display for the activity, allowing content to be drawn under system bars.
        // Requires appropriate theme setup and handling of insets.
        EdgeToEdge.enable(this);

        // Sets the user interface layout for this activity.
        // The layout is defined in the "R.layout.activity_main" XML file.
        setContentView(R.layout.activity_main);

        // Initialize UI elements by finding them in the layout XML using their IDs.
        // This must be done after setContentView() is called.
        welcomeTextView = findViewById(R.id.welcomeTextView);       // Gets a reference to the TextView with ID "welcomeTextView".
        signUpButton = findViewById(R.id.signUpButton);             // Gets a reference to the Button with ID "signUpButton".
        logInButton = findViewById(R.id.logInButton);               // Gets a reference to the Button with ID "logInButton".
        calorieTrackerButton = findViewById(R.id.calorieTrackerButton); // Gets a reference to the Button with ID "calorieTrackerButton".

        // Set the text for the welcome message TextView.
        welcomeTextView.setText("Welcome to KeiCal");

        // Set up a click listener for the Sign Up button.
        // When the button is clicked, the onClick method will be executed.
        signUpButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when the Sign Up button has been clicked.
             * Navigates the user to the SignUpActivity.
             *
             * @param v The view that was clicked (in this case, the signUpButton).
             */
            @Override
            public void onClick(View v) {
                // Create an Intent to start the SignUpActivity.
                // Intents are used to request an action from another app component.
                // Here, it specifies navigating from MainActivity (this) to SignUpActivity.
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                // Start the SignUpActivity.
                startActivity(intent);
            }
        }); // End of signUpButton OnClickListener

        // Set up a click listener for the Log In button.
        logInButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when the Log In button has been clicked.
             * Navigates the user to the LogInActivity.
             *
             * @param v The view that was clicked (in this case, the logInButton).
             */
            @Override
            public void onClick(View v) {
                // Create an Intent to start the LogInActivity.
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // Start the LogInActivity.
                startActivity(intent);
            }
        }); // End of logInButton OnClickListener

        // Set up a click listener for the Calorie Tracker button.
        calorieTrackerButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when the Calorie Tracker button has been clicked.
             * Navigates the user to the CalorieTrackerActivity.
             *
             * @param v The view that was clicked (in this case, the calorieTrackerButton).
             */
            @Override
            public void onClick(View v) {
                // Create an Intent to start the CalorieTrackerActivity.
                Intent intent = new Intent(MainActivity.this, CalorieTrackerActivity.class);
                // Start the CalorieTrackerActivity.
                startActivity(intent);
            }
        }); // End of calorieTrackerButton OnClickListener

    } // End of onCreate method

    private class SignUpActivity {
    }

    private class LoginActivity {
    }

    private class CalorieTrackerActivity {
    }
} // End of MainActivity class
