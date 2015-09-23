package com.example.gridview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {

    int mNum;

    static ViewPagerFragment newInstance(int num) {
        ViewPagerFragment f = new ViewPagerFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.viewpager_list, container, false);

        GridView gridView = (GridView)v.findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(getContext()));



        View noitem = v.findViewById(R.id.empty);
        noitem.setVisibility(View.GONE);

        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("Fragment #" + mNum);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}

