package com.example.sharedprfrnss;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // אחזור אלמנטים מה-XML
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        // עבודה עם SharedPreferences
        final SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // קריאת הערך השמור ב-SharedPreferences
        String savedValue = sharedPreferences.getString("user_input", "###");
        textView.setText("Hello " + savedValue);

        // מאזין לכפתור שמירה
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editText.getText().toString();

                // שמירת הערך ב-SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_input", userInput);
                editor.apply();

                // עדכון TextView
                textView.setText("Hello " + userInput);
            }
        });
    }
}
