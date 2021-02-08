package com.example.essaysofandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.textView)
    TextView textView;

    @BindString(R.string.butterstring)
    String butterstring;

    @BindViews({R.id.firstNameTextView, R.id.lastNameTextView})
    List<TextView> nameTextView;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        textView.setText("ButterKnife");

        textView.setText(butterstring);


        for(TextView text: nameTextView){
            Log.e(TAG, "onCreate: " + text.getText());
        }

        imageView.setImageDrawable(drawable);


    }

    @OnClick(R.id.button)
    void buttonClick(){
        Toast.makeText(this, "Butter Knife button click", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button)
    void buttonLongClick(){
        Toast.makeText(this, "Butter Knife button long click", Toast.LENGTH_SHORT).show();
    }

    @OnTouch({R.id.textView, R.id.firstNameTextView})
    void onTouch(TextView textView){
        Toast.makeText(this, "Butter Knife On Touch: " + textView.getText(), Toast.LENGTH_SHORT).show();
    }
}