package com.example.fisrthomework;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewRegister;
    private TextView textViewLable;
    private TextView textViewBack;
    private EditText editTextName;
    private EditText editTextSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        setStart();
    }

    private void setStart() {
        textViewRegister = (TextView) findViewById(R.id.but_login);
        textViewBack = (TextView) findViewById(R.id.back);
        textViewLable = (TextView) findViewById(R.id.lable);
        textViewLable.setText("用户名登录");
        textViewLable.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        textViewBack.setTypeface(Typeface.createFromAsset(getAssets(), "FZLBJW.TTF"));
        editTextName = (EditText) findViewById(R.id.login_name);
        editTextSecret = (EditText) findViewById(R.id.login_secret);
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
            case R.id.but_login:
                String inputName = editTextName.getText().toString();
                String inputSecret = editTextSecret.getText().toString();
                checkInput(inputName, inputSecret);
                break;
            case R.id.login_name:
                editTextName.setText("");
                break;
            case R.id.login_secret:
                editTextSecret.setText("");
        }
    }

    private void checkInput(String inputName, String inputSecret) {
        if (!inputName.equals(MainActivity.name)) {
            Toast.makeText(getApplicationContext(), "用户名错误", Toast.LENGTH_SHORT).show();
        } else if (!inputSecret.equals(MainActivity.secret)) {
            Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
            //  Intent intent=new Intent(LoginActivity.this,AfterLoginActivity.class);
            //startActivity(intent);
        }
    }

}
