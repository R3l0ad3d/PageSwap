package com.example.r3l0ad3d.newapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.r3l0ad3d.newapp.databinding.LayoutChangerBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r3l0ad3d on 5/25/17.
 */

public class FragmentPageAdapter extends PagerAdapter {

    private Context context;
    private List<String> data = new ArrayList<>();

    public FragmentPageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }


    //View generate and populate
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_changer,container,false);
        LayoutChangerBinding binding = DataBindingUtil.bind(view);

        binding.tvTest.setText(data.get(position));

        view.setTag(data.get(position));

        container.addView(view);

        return view;
    }

    //item count
    @Override
    public int getCount() {
        return data.size();
    }

    //is view avail avail
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object==view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    //get item position
    @Override
    public int getItemPosition(Object object) {
        String s = (String) ((View)object).getTag();
        int i = data.indexOf(s);
        if(i>=0) return i;
        else return POSITION_NONE;
    }
}

