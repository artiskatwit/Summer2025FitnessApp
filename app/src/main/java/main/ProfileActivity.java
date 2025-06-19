package main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keical.R;


public class ProfileActivity extends AppCompatActivity {

    private UserProfileManager userProfileManager;
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private Spinner genderSpinner;
    private EditText dailyCalorieGoalEditText;
    private Button saveProfileButton;
    //TextViews to display current data
    private TextView currentWeightTextView;
    private TextView currentHeightTextView;
    private TextView currentAgeTextView;
    private TextView currentGenderTextView;
    private TextView currentCalorieGoalTextView;
    // gender options for the spinner
    private static final String[] GENDER_OPTIONS = {"Select Gender", " Male", "Female", "Other", "Prefer not to say"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);

        userProfileManager = new UserProfileManager(this);
        //Intialize UI Elements
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderSpinner = findViewById(R.id.genderSpinner);
        dailyCalorieGoalEditText = findViewById(R.id.dailyCalorieGoalEditText);
        saveProfileButton = findViewById(R.id.saveProfileButton);

        currentWeightTextView = findViewById(R.id.currentWeightTextView);
        currentHeightTextView = findViewById(R.id.currentHeightTextView);
        currentAgeTextView = findViewById(R.id.currentAgeTextView);
        currentGenderTextView = findViewById(R.id.currentGenderTextView);
        currentCalorieGoalTextView = findViewById(R.id.currentCalorieGoalTextView);
        setUpGenderSpinner();

        //Load current profile data
        loadCurrentProfileData();
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });
    }

    private void setUpGenderSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GENDER_OPTIONS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);


    }

    private void loadCurrentProfileData() {
        float weight = userProfileManager.getWeightKg(); // Assuming getWeight() exists in UserProfileManager
        int height = userProfileManager.getHeightCm();   // Assuming getHeight() exists and corrected variable declaration
        int age = userProfileManager.getAge();         // Assuming getAge() exists
        String gender = userProfileManager.getGender(); // Assuming getGender() exists
        int calorieGoal = userProfileManager.getDailyCalorieGoal(); // Assuming getDailyCalorieGoal() exists

        // Assuming UserProfileManager has these default constants defined
        if (weight != UserProfileManager.DEFAULT_WEIGHT_KG) {
            weightEditText.setText(String.valueOf(weight));
            currentWeightTextView.setText("Weight: " + weight + " kg");
        } else {
            weightEditText.setText(""); // Clear field if default
            currentWeightTextView.setText("Weight: N/A");
        }
        if (height != UserProfileManager.DEFAULT_HEIGHT_CM) {
            heightEditText.setText(String.valueOf(height));
            currentHeightTextView.setText("Height: " + height + " cm");
        } else {
            heightEditText.setText(""); // Clear field if default
            currentHeightTextView.setText("Height: N/A");
        }
        if (age != UserProfileManager.DEFAULT_AGE) {
            ageEditText.setText(String.valueOf(age));
            currentAgeTextView.setText("Age: " + age);
        } else {
            ageEditText.setText(""); // Clear field if default
            currentAgeTextView.setText("Age: N/A");
        }
        if (gender != null && !gender.equals(UserProfileManager.DEFAULT_GENDER)) {
            for (int i = 0; i < GENDER_OPTIONS.length; i++) {
                // Trim the GENDER_OPTIONS[i] if it might have spaces, or ensure no spaces in array
                if (GENDER_OPTIONS[i].trim().equalsIgnoreCase(gender.trim())) {
                    genderSpinner.setSelection(i);
                    break;
                }
            }
            currentGenderTextView.setText("Gender: " + gender);
        } else {
            genderSpinner.setSelection(0); //"Select Gender"
            currentGenderTextView.setText("Gender: N/A");
        }
        if (calorieGoal != UserProfileManager.DEFAULT_DAILY_CALORIE_GOAL) {
            dailyCalorieGoalEditText.setText(String.valueOf(calorieGoal));
            currentCalorieGoalTextView.setText("Daily Calorie Goal: " + calorieGoal + " calories");
        } else {
            dailyCalorieGoalEditText.setText(""); // Clear field if default
            currentCalorieGoalTextView.setText("Daily Calorie Goal: N/A");
        }
    }

    private void saveProfile() {
        String weightStr = weightEditText.getText().toString().trim();
        String heightStr = heightEditText.getText().toString().trim();
        String ageStr = ageEditText.getText().toString().trim();
        String gender = genderSpinner.getSelectedItem().toString();
        String calorieGoalStr = dailyCalorieGoalEditText.getText().toString().trim();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(calorieGoalStr) || genderSpinner.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return; // Exit if validation fails
        }

        float weight = -1f;
        int height = -1;
        int age = -1;
        int calorieGoal = -1;

        try {
            weight = Float.parseFloat(weightStr);
            height = Integer.parseInt(heightStr);
            age = Integer.parseInt(ageStr);
            calorieGoal = Integer.parseInt(calorieGoalStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input for weight, height, age, or calorie goal", Toast.LENGTH_SHORT).show();
            return; // Exit if parsing fails
        }

        // End Validation (this comment can be removed)

        userProfileManager.saveBasicProfile(weight, height, age, gender, calorieGoal);
        // update the display textviews
        currentWeightTextView.setText("Weight: " + weight + " kg");
        currentHeightTextView.setText("Height: " + height + " cm");
        currentAgeTextView.setText("Age: " + age);
        currentGenderTextView.setText("Gender: " + gender);
        currentCalorieGoalTextView.setText("Daily Calorie Goal: " + calorieGoal + " calories");
        Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
    }

    //Clear profile method
    private void clearProfileFieldsAndSavedData() {
        userProfileManager.clearUserProfileData();
        weightEditText.setText("");
        heightEditText.setText("");
        ageEditText.setText("");
        genderSpinner.setSelection(0);
        dailyCalorieGoalEditText.setText("");

        currentWeightTextView.setText("Weight: N/A");
        currentHeightTextView.setText("Height: N/A");
        currentAgeTextView.setText("Age: N/A");
        currentGenderTextView.setText("Gender: N/A");
        currentCalorieGoalTextView.setText("Daily Calorie Goal: N/A");
        Toast.makeText(this, "Profile cleared successfully", Toast.LENGTH_SHORT).show();
    }



       }
