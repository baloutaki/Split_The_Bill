package be.ehb.split_the_bill.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import be.ehb.split_the_bill.fragments.InfoFragment;
import be.ehb.split_the_bill.fragments.PrefFragment;
import be.ehb.split_the_bill.fragments.SplitFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {SplitFragment.newInstance(), InfoFragment.newInstance(), PrefFragment.newInstance()};

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Split";
        if(position == 1)
            return "Info";
        return "Settings";
    }
}

