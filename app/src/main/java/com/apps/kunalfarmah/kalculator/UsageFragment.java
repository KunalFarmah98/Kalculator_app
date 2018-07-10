package com.apps.kunalfarmah.kalculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;



/**
 * A simple {@link Fragment} subclass.
 */
public class UsageFragment extends Fragment {

    MainActivity var;
    RecyclerView rec;

    FrameLayout frag;
    Button extra;

    public UsageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usage, container, false);

        getActivity().setTitle("USAGE TIPS");

        rec = view.findViewById(R.id.Rv);
        RecyclerAdapter rvadapter = new RecyclerAdapter();

        rec.setAdapter(rvadapter);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        frag = getActivity().findViewById(R.id.frag);
        extra = getActivity().findViewById(R.id.sci1);

        if (extra != null)
            extra.setVisibility(View.GONE);


    }


    @Override
    public void onPause() {
        super.onPause();
        frag.setVisibility(View.GONE);
        extra.setVisibility(View.VISIBLE);
        getActivity().setTitle(R.string.app_name);

    }
}
