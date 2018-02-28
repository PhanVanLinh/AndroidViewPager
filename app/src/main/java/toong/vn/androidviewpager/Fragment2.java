package toong.vn.androidviewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends BaseFragment {
    private String TAG = getClass().getSimpleName();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilder2 = new StringBuilder();
    private StringBuilder stringBuilder3 = new StringBuilder();
    List<String> stringList = new ArrayList<>();

    public static Fragment2 newInstance() {
        Bundle args = new Bundle();
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);
        return rootView;
    }
}