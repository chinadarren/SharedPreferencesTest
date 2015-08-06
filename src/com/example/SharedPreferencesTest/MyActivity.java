package com.example.SharedPreferencesTest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Button saveData;
    private Button restoreData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        saveData = (Button) findViewById(R.id.save_data);
        restoreData = (Button) findViewById(R.id.restore_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.commit();
            }
        });
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",
                        MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married",false);
                Log.d("MainActivity","name is "+name);
                Log.d("MainActivity","age is "+age);
                Log.d("MainActivity","married is"+ married);
            }
        });
    }
}
