package com.example.gridview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {

    private String   text;
    private GridView gv;

    public ViewPagerFragment(String text){
        super();
        this.text = text;
    }

    /**
     * 覆盖此函数，先通过inflater inflate函数得到view最后返回
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gridview_item, container, false);

        gv = (GridView)v.findViewById(R.id.gv);

        gv.setAdapter(new GridViewAdapter(getContext()));
        return v;
    }


}
