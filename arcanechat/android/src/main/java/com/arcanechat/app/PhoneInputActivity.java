package com.arcanechat.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneInputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_input);

        EditText phoneEditText = findViewById(R.id.phone_edit_text);
        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v -> {
            String phone = phoneEditText.getText().toString().trim();
            if (phone.isEmpty()) {
                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "手机号已提交: " + phone, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, com.arcanechat.app.MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
