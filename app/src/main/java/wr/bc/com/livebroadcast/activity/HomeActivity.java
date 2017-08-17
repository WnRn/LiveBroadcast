package wr.bc.com.livebroadcast.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import wr.bc.com.livebroadcast.R;
import wr.bc.com.livebroadcast.activity.base.BaseActivity;
import wr.bc.com.livebroadcast.adapter.HomeAdapter;
import wr.bc.com.livebroadcast.fragment.HomeFragment;
import wr.bc.com.livebroadcast.fragment.MoreFragment;

public class HomeActivity extends BaseActivity {

    private ViewPager vp_home;
    private RadioGroup rg_home;
    private RadioButton rb_home_live;
    private ImageView iv_home_photo;
    private RadioButton rb_home_more;
    private HomeFragment homeFragment;
    private MoreFragment moreFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        //初始化控件
        initView();

        //初始化数据
        initData();
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    private void initData() {
        //获取管理工具
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        //实例化fragment
        homeFragment = new HomeFragment();
        moreFragment = new MoreFragment();

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(homeFragment);
        list.add(moreFragment);

        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_home_live:
                        vp_home.setCurrentItem(0);
                        break;
                    case R.id.rb_home_more:
                        vp_home.setCurrentItem(1);
                        break;
                }
            }
        });

        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(), list);
        vp_home.setAdapter(homeAdapter);

        rg_home.check(R.id.rb_home_live);

        vp_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rg_home.check(R.id.rb_home_live);
                        break;
                    case 1:
                        rg_home.check(R.id.rb_home_more);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        vp_home = (ViewPager) findViewById(R.id.vp_home);
        rg_home = (RadioGroup) findViewById(R.id.rg_home);
        rb_home_live = (RadioButton) findViewById(R.id.rb_home_live);
        iv_home_photo = (ImageView) findViewById(R.id.iv_home_photo);
        rb_home_more = (RadioButton) findViewById(R.id.rb_home_more);
    }

    @Override
    public int getContentResId() {
        return R.layout.activity_home;
    }
}
