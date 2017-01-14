package com.yd.pizzamaterialdesign;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaMaterialFragment extends Fragment {


    public PizzaMaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_pizza_material, container, false);

        int pizzaLength = Pizza.mPizzas.length;
        String[] pizzaNames = new String[pizzaLength];
        for(int i=0; i<pizzaLength; i++){
            pizzaNames[i] = Pizza.mPizzas[i].getName();
        }

        int[] pizzaImagesID = new int[pizzaLength];
        for(int i=0; i<pizzaLength; i++){
            pizzaImagesID[i] = Pizza.mPizzas[i].getImageResourceId();
        }

        //set Adapter to RecyclerView
        CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(pizzaNames,pizzaImagesID);
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);
        pizzaRecycler.setAdapter(captionedImagesAdapter);

        //set view\type of RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(linearLayoutManager);
        return pizzaRecycler;

    }

}
