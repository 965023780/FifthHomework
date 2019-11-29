package com.example.fisrthomework;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AfterLoginActivity extends AppCompatActivity {
    private TextView textViewBack;
    private TextView textViewLable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        setContentView(R.layout.title);
        setStart();

    }

    private void setStart() {
        textViewBack = (TextView) findViewById(R.id.back);
        textViewLable = (TextView) findViewById(R.id.lable);
        textViewLable.setText("红岩版知乎");
        setTextView(textViewBack);
        setTextView(textViewLable);
    }

    private void setTextView(TextView textView) {
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
    }
}
