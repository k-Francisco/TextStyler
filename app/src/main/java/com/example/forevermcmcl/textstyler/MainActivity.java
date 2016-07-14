package com.example.forevermcmcl.textstyler;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    private EditText mEtInput;
    private CheckBox mBold, mItalic;
    private RadioButton mRed, mGreen, mBlue;
    private TextView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mEtInput = (EditText)findViewById(R.id.etInput);
        mBold = (CheckBox)findViewById(R.id.cbBold);
        mItalic = (CheckBox)findViewById(R.id.cbItalic);
        mRed = (RadioButton)findViewById(R.id.rbRed);
        mGreen = (RadioButton)findViewById(R.id.rbGreen);
        mBlue = (RadioButton)findViewById(R.id.rbBlue);
        mDisplay = (TextView)findViewById(R.id.tvDisplay);

        mEtInput.addTextChangedListener(this);
        mBold.setOnCheckedChangeListener(this);
        mItalic.setOnCheckedChangeListener(this);
        mRed.setOnCheckedChangeListener(this);
        mGreen.setOnCheckedChangeListener(this);
        mBlue.setOnCheckedChangeListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mDisplay.setText(mEtInput.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(mBold.isChecked()) {
            if(mItalic.isChecked())
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.BOLD_ITALIC));
            else
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.BOLD));
        }

        if(mItalic.isChecked()){
            if(mBold.isChecked())
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.BOLD_ITALIC));
            else
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.ITALIC));
        }

        if(!mBold.isChecked()){
            if(mItalic.isChecked())
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.ITALIC));
            else
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.NORMAL));
        }

        if(!mItalic.isChecked()){
            if(mBold.isChecked())
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.BOLD));
            else
                mDisplay.setTypeface(Typeface.create(mDisplay.getTypeface(), Typeface.NORMAL));
        }

        if(mRed.isChecked())
            mDisplay.setTextColor(Color.RED);
        else if(mGreen.isChecked())
            mDisplay.setTextColor(Color.GREEN);
        else
            mDisplay.setTextColor(Color.BLUE);




    }
}
