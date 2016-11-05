package task.example.taskexpressbank;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * Created by lider on 04/11/2016.
 */

class TestFragmentAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    public static ViewPager mViewPager;

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance();
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position);
    }


    public static final class TestFragment extends Fragment {

        public static TestFragment newInstance() {
            TestFragment fragment = new TestFragment();
            return fragment;
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.welcome_slide1, container, false);
            // initialize Spinner
            MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.spinner);
            spinner.setItems("New York, JFK", "London, Heathrow", "Baku, AZAL", "Berlin, Tegel");

            mViewPager = ((MainActivity) getActivity()).getPager();
            final RippleView rippleView = (RippleView) view.findViewById(R.id.rect);
            rippleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            click();
                        }
                    }, 300);
                }
            });

            return view;
        }


        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }
    }

    private static void click() {
        if(mViewPager.getCurrentItem() == 2){
            mViewPager.setCurrentItem(0);
        }else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
    }
}