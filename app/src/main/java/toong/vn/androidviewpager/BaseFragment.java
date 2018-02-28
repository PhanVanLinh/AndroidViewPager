package toong.vn.androidviewpager;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by PhanVanLinh on 26/02/2018.
 * phanvanlinh.94vn@gmail.com
 */

public class BaseFragment extends Fragment{

    private String TAG = getClass().getSimpleName();

    @Override
    public void onStart() {
        super.onStart();
        if(isVisible()){
            Log.i(TAG, "visible " + isVisible());
        }
    }
}
