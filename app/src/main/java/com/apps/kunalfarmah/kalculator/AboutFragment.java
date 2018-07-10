package com.apps.kunalfarmah.kalculator;



import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import static android.view.View.GONE;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    MainActivity var;

    FrameLayout frag;
    Button extra;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("ABOUT ME");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        frag = getActivity().findViewById(R.id.frag);
        extra = getActivity().findViewById(R.id.sci1);

        extra.setVisibility(View.GONE);

        super.onCreate(savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    @Override
    public void onPause() {
        super.onPause();
        frag.setVisibility(GONE);
        extra.setVisibility(View.VISIBLE);
        getActivity().setTitle(R.string.app_name);

    }
}
