package com.tunjid.androidbootstrap.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tunjid.androidbootstrap.R;
import com.tunjid.androidbootstrap.baseclasses.AppBaseFragment;
import com.tunjid.androidbootstrap.view.animator.ViewHider;

/**
 * Fragment showing a static list of images
 * <p>
 * Created by tj.dahunsi on 5/6/17.
 */

public class HidingViewFragment extends AppBaseFragment
        implements View.OnClickListener {

    private ViewHider leftHider;
    private ViewHider topHider;
    private ViewHider rightHider;
    private ViewHider bottomHider;

    public static HidingViewFragment newInstance() {
        HidingViewFragment fragment = new HidingViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hiding_view, container, false);

        View leftButton = rootView.findViewById(R.id.left_button);
        View topButton = rootView.findViewById(R.id.top_button);
        View rightButton = rootView.findViewById(R.id.right_button);
        View bottomButton = rootView.findViewById(R.id.bottom_button);

        leftButton.setOnClickListener(this);
        topButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        bottomButton.setOnClickListener(this);
        rootView.findViewById(R.id.reset).setOnClickListener(this);

        leftHider = ViewHider.of(leftButton).setDirection(ViewHider.LEFT).build();
        topHider = ViewHider.of(topButton).setDirection(ViewHider.TOP).build();
        rightHider = ViewHider.of(rightButton).setDirection(ViewHider.RIGHT).build();
        bottomHider = ViewHider.of(bottomButton).setDirection(ViewHider.BOTTOM).build();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_button:
                leftHider.hide();
                break;
            case R.id.top_button:
                topHider.hide();
                break;
            case R.id.right_button:
                rightHider.hide();
                break;
            case R.id.bottom_button:
                bottomHider.hide();
                break;
            case R.id.reset:
                leftHider.show();
                topHider.show();
                rightHider.show();
                bottomHider.show();
                break;
        }
    }
}
