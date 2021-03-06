package com.tunjid.androidbootstrap.test.idlingresources;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Idling resource that waits for a fragment to be visible.
 * <p>
 * Created by tj.dahunsi on 4/29/17.
 */
public class FragmentVisibleIdlingResource extends BaseFragmentIdlingResource {
    public FragmentVisibleIdlingResource(AppCompatActivity activity, String fragmentTag, boolean unregisterSelf) {
        super(activity, fragmentTag, unregisterSelf);
    }

    public FragmentVisibleIdlingResource(FragmentManager fragmentManager, String fragmentTag, boolean unregisterSelf) {
        super(fragmentManager, fragmentTag, unregisterSelf);
    }

    @Override
    public boolean isIdleNow() {
        Fragment fragment = findFragmentByTag();

        // Wait until fragment manager has fragment
        boolean isIdle = fragment != null && fragment.isVisible();

        return super.handleIsIdle(isIdle);
    }
}
