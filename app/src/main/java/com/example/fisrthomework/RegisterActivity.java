package com.example.fisrthomework;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewRegister;
    private TextView textViewLable;
    private TextView textViewBack;
    private EditText editTextName;
    private EditText editTextSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        setStart();
    }

    private void setStart() {
        textViewRegister = (TextView) findViewById(R.id.but_register);
        textViewBack = (TextView) findViewById(R.id.back);
        textViewLable = (TextView) findViewById(R.id.lable);
        textViewLable.setText("注册");
        textViewLable.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        textViewBack.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        editTextName = (EditText) findViewById(R.id.register_name);
        editTextSecret = (EditText) findViewById(R.id.register_secret);
        editTextSecret.setTransformationMethod(PasswordTransformationMethod.getInstance());
        setEditText(editTextName);
        setEditText(editTextSecret);
        setTextView(textViewRegister);
    }

    private void setTextView(TextView textView) {
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        textView.setOnClickListener(this);
    }

    private void setEditText(EditText editText) {
        editText.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        editText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_register:
                String inputName = editTextName.getText().toString();
                String inputSecret = editTextSecret.getText().toString();
                if (checkInput(inputName, inputSecret)) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.register_name:
                editTextName.setText("");
                break;
            case R.id.register_secret:
                editTextSecret.setText("");
        }
    }

    private boolean checkInput(String inputName, String inputSecret) {
        if (inputName.length() > 10 || inputName.length() < 4) {
            Toast.makeText(getApplicationContext(), "用户名长度应为4—10", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (inputSecret.length() <= 6) {
            Toast.makeText(getApplicationContext(), "密码过短，长度应大于6", Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean cnt[] = {false, false, false};
        for (int i = 0; i < inputSecret.length(); i++) {
            char word = inputSecret.charAt(i);
            if (word >= '0' && word <= '9')
                cnt[0] = true;
            else if ((word >= 'a' && word <= 'z') || (word >= 'A' && word <= 'Z'))
                cnt[1] = true;
            else
                cnt[2] = true;
        }
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == false) {
                Toast.makeText(getApplicationContext(), "密码过简单，应包含数字、字母和其他字符", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        MainActivity.name = inputName;
        MainActivity.secret = inputSecret;
        Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
        return true;
    }
}
