package com.example.wil.a93;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements BlankFragment.OnFragmentInteractionListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bundle arguments = new Bundle();

        String param1, param2 ;
        param1 = "param1";
        param2 = "param2";
        // arguments.putString(BlankFragment.ARG_PARAM1, param1)
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        BlankFragment fragment1 = BlankFragment.newInstance(param1,param2) ;
        ft.replace(R.id.topic_detail_container_1,fragment1);
        BlankFragment fragment2 = BlankFragment.newInstance(param1,param2) ;
        ft.replace(R.id.topic_detail_container_2,fragment2);
        ft.commit();


    }
    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
