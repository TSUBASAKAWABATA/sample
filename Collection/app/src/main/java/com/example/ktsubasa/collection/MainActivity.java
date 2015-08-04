package com.example.ktsubasa.collection;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.WindowManager;


public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //��������
        CustomPagerAdapter adapter=new CustomPagerAdapter(this);  //CustomPagerAdapter
        WindowManager wm=getWindowManager();
        Display disp=wm.getDefaultDisplay();
        adapter.add(Color.BLACK,disp.getWidth());
        adapter.add(Color.RED,disp.getWidth());
        adapter.add(Color.GREEN,disp.getWidth());
        adapter.add(Color.BLUE,disp.getWidth());
        adapter.add(Color.CYAN,disp.getWidth());
        adapter.add(Color.MAGENTA,disp.getWidth());
        adapter.add(Color.YELLOW,disp.getWidth());
        adapter.add(Color.BLACK,disp.getWidth());
        adapter.add(Color.RED,disp.getWidth());

        ViewPager viewPager=new ViewPager(this);
        viewPager.setAdapter(adapter);



        setContentView(viewPager);
    }



}
