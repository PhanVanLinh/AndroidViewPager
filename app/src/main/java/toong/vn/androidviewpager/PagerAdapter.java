package toong.vn.androidviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private Fragment currentFragment;
    private long mPageId = 0;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mTitles.add(title);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (currentFragment != object) {
            currentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object object) {
        if (mFragments.contains(object)) {
            return mFragments.indexOf(object);
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (position >= getCount()) {
            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();
        }
    }

    public void clearData() {
        if (mFragments != null) {
            mFragments.clear();
        }
        if (mTitles != null) {
            mTitles.clear();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    @Override
    public long getItemId(int position) {
        return mPageId + position;
    }

    public void notifyRefreshTab() {
        mPageId += getCount() + 1;
    }

    public void removeTab(int position) {
        mFragments.remove(position);
        mTitles.remove(position);
    }
}