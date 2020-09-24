package com.brinkley.criminalintent;

import androidx.fragment.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {
    /*
        public static final String EXTRA_CRIME_ID = "com.brinkley.criminalintent.crime_id";

        public static Intent newIntent(Context packageContext, UUID crimeId) {
            Intent intent = new Intent(packageContext, MainActivity.class);
            intent.putExtra(EXTRA_CRIME_ID, crimeId);
            return intent;
        }

        @Override
        protected CrimeListFragment createFragment() {
            return new CrimeFragment();
        }*/
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    //onCreate is taken from Singleton class
}
