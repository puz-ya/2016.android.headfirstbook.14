package com.yd.pizzamaterialdesign;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by YD on 14.01.2017.
 */

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] mCaptions;
    private int[] mImagesIDs;

    //constructor for incoming data
    public CaptionedImagesAdapter(String[] strings, int[] ints){
        mCaptions = strings;
        mImagesIDs = ints;
    }

    //link to Views in RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //what data will be in use?
        CardView mCardView;
        public ViewHolder(CardView cardView){
            super(cardView);        //need superclass for some metadata
            mCardView = cardView;
        }
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //new View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardView cardView = (CardView) layoutInflater.inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        //filling Views with Data
        CardView cardView = holder.mCardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image_pizza);
        Drawable drawable = cardView.getResources().getDrawable(mImagesIDs[position]);

        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(mCaptions[position]);

        TextView textView = (TextView) cardView.findViewById(R.id.text_pizza);
        textView.setText(mCaptions[position]);
    }

    @Override
    public int getItemCount(){
        //return number of variants
        return mCaptions.length;
    }
}
