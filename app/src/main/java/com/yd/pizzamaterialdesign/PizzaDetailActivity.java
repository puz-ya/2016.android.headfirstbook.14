package com.yd.pizzamaterialdesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PizzaDetailActivity extends Activity {

    private ShareActionProvider mShareActionProvider;
    public static final String EXTRA_MESSAGE = "pizzaNum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        if(getActionBar() != null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //get all info about pizza with number
        int pizzaN = getIntent().getExtras().getInt(EXTRA_MESSAGE,0);

        String pizzaName = Pizza.mPizzas[pizzaN].getName();
        TextView textView = (TextView) findViewById(R.id.detail_text);
        textView.setText(pizzaName);

        int pizzaImage = Pizza.mPizzas[pizzaN].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        imageView.setImageResource(pizzaImage);
        imageView.setContentDescription(pizzaName);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //name of pizza in Share buttonn
        TextView tv = (TextView) findViewById(R.id.detail_text);
        String textTV = tv.getText().toString();

        //new intent to Order
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(EXTRA_MESSAGE, textTV);

        //add to Menu
        MenuItem menuItem = menu.findItem(R.id.action_share);

        mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        mShareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.action_create_order :
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
