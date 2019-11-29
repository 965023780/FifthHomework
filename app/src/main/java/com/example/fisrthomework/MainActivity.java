package com.example.fisrthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textViewLoad;
    private TextView textViewSina;
    private TextView textViewTencrnt;
    private TextView textViewRegister;
    public static String name;
    public static String secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStart();
    }

    private void setStart(){
        textViewLoad=(TextView)findViewById(R.id.login_user);
        textViewSina=(TextView)findViewById(R.id.login_sina);
        textViewTencrnt=(TextView)findViewById(R.id.login_tencent);
        textViewRegister=(TextView)findViewById(R.id.login_register);
        setTextView(textViewLoad);
        setTextView(textViewSina);
        setTextView(textViewTencrnt);
        setTextView(textViewRegister);
    }

    private void setTextView(TextView textView){
        textView.setTypeface(Typeface.createFromAsset(getAssets(),"FZLBJW.TTF"));
        textView.setOnClickListener(this);
    }

        @Override
        public void onClick(View view){
            switch (view.getId()) {
                case R.id.login_user:
                    Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                    break;
                case R.id.login_sina:
                    Toast.makeText(getApplicationContext(),"新浪终止了与红岩的合作", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.login_tencent:
                    Toast.makeText(getApplicationContext(),"腾讯终止了与红岩的合作",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.login_register:
                    Intent intentRegister = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intentRegister);
            }
        }
}
