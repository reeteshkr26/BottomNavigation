package com.example.hp.bottomnavigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    ImageView slideImageView;
    TextView slideHeading;
    TextView slideDescription;

    //Array
    public int[] slide_images={
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon,
            R.drawable.warning
    };
    public String[] slide_headings={
            "EAT",
            "SLEEP",
            "CODE",
            "WARNING"
    };
    public String[] slide_descs={
            " to take in through the mouth as food : ingest, chew, and swallow in " ,

            "Sleep is a naturally recurring state of mind and body, characterized by altered consciousness",


            "Converting a message or text from one symbolic into another, usually in an encoded or unreadable form.",

            "A warning is an advance notice of something that will happen, often "

    };

    public SlideAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        slideImageView =(ImageView) view.findViewById(R.id.slide_image);
        slideHeading =(TextView) view.findViewById(R.id.slide_heading);
        slideDescription=(TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }
}
