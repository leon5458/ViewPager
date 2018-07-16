package com.hly.viewpager;


import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends android.support.v7.app.AppCompatActivity{
    private TextView view_one;
    private TextView view_two;
    private TextView view_three;
    private TextView view_four;
    private TextView view_five;
    private TextView view_six;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_one = findViewById(R.id.view_one);
        view_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewPagerOneAcitivity.class));
            }
        });

        view_two = findViewById(R.id.view_two);
        view_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPageTwoActivity.class));
            }
        });

        view_three =findViewById(R.id.view_three);
        view_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPagerThreeActivity.class));
            }
        });
        view_four = findViewById(R.id.view_four);
        view_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPagerFourActivity.class));
            }
        });
        view_five = findViewById(R.id.view_five);
        view_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPagerFiveActivity.class));
            }
        });
        view_six = findViewById(R.id.view_six);
        view_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewPagerSixActivity.class));
            }
        });
    }
}
