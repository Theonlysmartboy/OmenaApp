package com.otemainc.omena.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
        private static String PREFERENCE_NAME = "foodfuzzapp";
        private static SharedPreference sharedPreferenceUtil;
        private SharedPreferences preferences;

        private SharedPreference(Context context) {
            PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
            this.preferences = context.getSharedPreferences(PREFERENCE_NAME, context.MODE_PRIVATE);
        }
        //get the instance of the shared preference
        public static SharedPreference getInstance(){
            if(sharedPreferenceUtil == null) {
                sharedPreferenceUtil = new SharedPreference(MyApp.getContext());
            }
            return sharedPreferenceUtil;
        }
        //save the shared string (username)
        public void saveString(String key, String val){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key,val);
            editor.commit();
        }
        public String getString(String key, String defVal){
            return preferences.getString(key,defVal);
        }
        public String getString(String key){
            return preferences.getString(key,"");
        }
    }