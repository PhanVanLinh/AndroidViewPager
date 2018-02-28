package toong.vn.androidviewpager;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOffscreenPageLimit(3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pagerAdapter.addFragment(new Fragment1());
                pagerAdapter.addFragment(new Fragment2());
                pagerAdapter.addFragment(new Fragment1());

                pagerAdapter.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setAdapter(pagerAdapter);
                    }
                }, 500);

            }
        }, 2000);



//        viewPager.setAdapter(pagerAdapter);



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                viewPager.setAdapter(pagerAdapter);
//            }
//        }, 20);


       // viewPager.setCurrentItem(1);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                viewPager.setCurrentItem(1);
//            }
//        }, 20);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                viewPager.setAdapter(pagerAdapter);
//            }
//        }, 20);
        //        viewPager.setAdapter(pagerAdapter);

        //        new Handler().postDelayed(new Runnable() {
        //            @Override
        //            public void run() {
        //                viewPager.setAdapter(pagerAdapter);
        //            }
        //        }, 100);

    }
}
