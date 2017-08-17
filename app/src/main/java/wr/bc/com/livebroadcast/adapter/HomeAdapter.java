package wr.bc.com.livebroadcast.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/15.
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> alist;
    public HomeAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        alist = list;
    }

    @Override
    public Fragment getItem(int position) {

        return alist.get(position);
    }

    @Override
    public int getCount() {
        return alist.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return t;
//    }
}
