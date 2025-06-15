package main;
import android.content.Context;
import android.content.SharedPreferences;

public class UserProfileManager {
    private static final String PREFERENCES_FIlE_NAME = "user_profile_prefs";
    private SharedPreferences sharedPreferences;

    //define keys for your preferences
    private static final String KEY_WEIGHT_KG = "weight_kg";
    private static final String KEY_HEIGHT_CM = "height_cm";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_DAILY_CALORIE_GOAL = "daily_calorie_goal";
    // Default Values if no input
    private static final float DEFAULT_WEIGHT_KG = -1f;
    private static final int DEFAULT_HEIGHT_CM = -1;
    private static final int DEFAULT_AGE = -1;
    private static final String DEFAULT_GENDER = "Unknown";
    private static final int DEFAULT_DAILY_CALORIE_GOAL = -1;

    public UserProfileManager(Context context) {
        //Initialize SharedPreferences
        //Content.MODE_PPrivate means the file can only be accessed by calling application
        sharedPreferences = context.getSharedPreferences(PREFERENCES_FIlE_NAME, Context.MODE_PRIVATE);
    }
        /**
 * Saves the user's weight
 * @param weightKg The user's weight in kilograms
 */
        public void saveWeightKg ( float weightKg){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat(KEY_WEIGHT_KG, weightKg);
            editor.apply();
        }
/**
 * Saves the user's height
 * @param heightCm The user's height in centimeters
 */
        public void saveHeightCm ( int heightCm){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(KEY_HEIGHT_CM, heightCm);
            editor.apply();
        }
/**
 * Saves the user's age
 * @param age The user's age
 */
        public void saveAge (int age){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(KEY_AGE, age);
            editor.apply();
        }
/**
 * Saves the user's gender
 * @param gender The user's gender
 */
        public void saveGender (String gender){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GENDER, gender);
            editor.apply();
        }
/**
 * Saves the user's daily calorie goal
 * @param dailyCalorieGoal The user's daily calorie goal
 */
        public void saveDailyCalorieGoal ( int dailyCalorieGoal){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(KEY_DAILY_CALORIE_GOAL, dailyCalorieGoal);
            editor.apply();
        }
/**
 * Retrieves the user's weight
 * @return The user's weight in kilograms
 */

        public float getWeightKg () {
            return sharedPreferences.getFloat(KEY_WEIGHT_KG, DEFAULT_WEIGHT_KG);

        }
/**
 * Retrieves the user's height
 * @return The user's height in centimeters
 */
        public int getHeightCm () {
            return sharedPreferences.getInt(KEY_HEIGHT_CM, DEFAULT_HEIGHT_CM);
        }
/**
 * Retrieves the user's age
 * @return The user's age
 */
        public int getAge () {
            return sharedPreferences.getInt(KEY_AGE, DEFAULT_AGE);
        }
/**
 * Retrieves the user's gender
 * @return The user's gender
 */
        public String getGender () {
            return sharedPreferences.getString(KEY_GENDER, DEFAULT_GENDER);
        }
/**
 * Retrieves the user's daily calorie goal
 * @return The user's daily calorie goal
 */
        public int getDailyCalorieGoal () {
            return sharedPreferences.getInt(KEY_DAILY_CALORIE_GOAL, DEFAULT_DAILY_CALORIE_GOAL);
        }

/**
 * Saves all basic profile information at once.
 * @param weightKg The user's weight in kilograms.
 * @param heightCm The user's height in centimeters.
 * @param age The user's age.
 * @param gender The user's gender.
 * @param dailyCalorieGoal The user's daily calorie goal.
 */
        public void saveBasicProfile ( float weightKg, int heightCm, int age, String gender,
        int dailyCalorieGoal){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat(KEY_WEIGHT_KG, weightKg);
            editor.putInt(KEY_HEIGHT_CM, heightCm);
            editor.putInt(KEY_AGE, age);
            editor.putString(KEY_GENDER, gender);
            editor.putInt(KEY_DAILY_CALORIE_GOAL, dailyCalorieGoal);
            editor.apply();
        }


        /**
         * Clears all user profile data from SharedPreferences.
         *
         */
        public void clearUserProfileData() {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

        }
    }
































