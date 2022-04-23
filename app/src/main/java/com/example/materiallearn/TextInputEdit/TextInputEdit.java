package com.example.materiallearn.TextInputEdit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.materiallearn.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputEdit extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;        //EditText错误信息

    private TextInputLayout newTextInputLayout;
    private TextInputEditText newTextInputEditText;    //Layout错误信息


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_edit);

        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputEditText = (TextInputEditText) findViewById(R.id.textInputEditText);   //EditText错误信息

        newTextInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout_second);
        newTextInputEditText = (TextInputEditText) findViewById(R.id.textInputEditText_second);  //Layout错误信息

        makerEditText();
        makerLayout();
    }

    //自定义错误信息
    public void makerEditText() {
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (textInputEditText.getText().length() > textInputLayout.getCounterMaxLength()) {
                    textInputEditText.setError("已经超过限定字数了!! 需要重新输入");
                }
            }
        });
    }

    private void makerLayout() {
        newTextInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (newTextInputEditText.getText().length() > newTextInputLayout.getCounterMaxLength()) {
                    newTextInputLayout.setError("超过规定字数！请更改内容");
                } else {
                    newTextInputLayout.setErrorEnabled(false);
                }
            }
        });
    }


}