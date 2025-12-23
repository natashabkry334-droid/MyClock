package com.example.clockapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView clockText;
    private TextView dateText;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تصميم الواجهة مباشرة بالكود
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(android.view.Gravity.CENTER);

        clockText = new TextView(this);
        clockText.setTextSize(40);
        clockText.setText("00:00:00");

        dateText = new TextView(this);
        dateText.setTextSize(20);
        dateText.setText("yyyy/MM/dd");

        layout.addView(clockText);
        layout.addView(dateText);

        setContentView(layout);

        // كود تحديث الساعة والتاريخ كل ثانية
        runnable = new Runnable() {
            @Override
            public void run() {
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                        .format(new Date());
                String currentDate = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
                        .format(new Date());

                clockText.setText(currentTime);
                dateText.setText(currentDate);

                handler.postDelayed(this, 1000); // يحدث كل ثانية
            }
        };

        handler.post(runnable);
    }
}
إضافة الكود الأساسي للتطبيق
