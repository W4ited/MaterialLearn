package com.example.materiallearn.AutoFitTextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.materiallearn.R;

public class AutoFitTextView extends AppCompatActivity {

    private TextView mOutput, mAutofitOutput;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autofit_text_view2);

        mOutput = (TextView)findViewById(R.id.output);
        mAutofitOutput = (TextView)findViewById(R.id.output_autofit);
        editText = (EditText) findViewById(R.id.input);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAutofitOutput.setText(s);
                mOutput.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}