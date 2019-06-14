package com.adrianziolkowski.cats;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //declare variables
    View prev;
    View next;
    TextView text;
    ImageView image;
    int counter = 0;


    //array of strings
    String [] cat_breed_text = new String[] {
            "Persian",
            "Siberian",
            "Siamese",
            "British Shorthair",
            "Norwegian Forest",
            "Japanese Bobtail",
            "Scottish Fold",
            "American Shorthair"
    };


    //array of image index
    int[] cat_breed_image = new int[] {
            R.drawable.persian_cat,
            R.drawable.siberian,
            R.drawable.siamese_cat,
            R.drawable.british_shorthair,
            R.drawable.norwegian,
            R.drawable.japanese_bobtail,
            R.drawable.scottish_fold,
            R.drawable.american_shorthair
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding toolbar to the app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //instantiate object with corresponding id resource
        text = findViewById(R.id.cat_name);
        image = findViewById(R.id.img);


        //setting the resources
        text.setText(cat_breed_text[counter]);
        image.setImageResource(cat_breed_image[counter]);


        //instantiate object with corresponding id resource
        prev = findViewById(R.id.button_prev);
        next = findViewById(R.id.button_next);

        //hide prev button
        prev.setVisibility(View.GONE);

    }

    //onClick method for object next
    public void next(View view) {
        if(counter < cat_breed_image.length-1) {
            prev.setVisibility(View.VISIBLE);
            counter++;
            text.setText(cat_breed_text[counter]);
            image.setImageResource(cat_breed_image[counter]);
        }

        if(counter == cat_breed_image.length-1){
           next.setVisibility(View.GONE);
        }

    }

    //onClick method for object prev
    public void prev(View view) {
        if(counter > 0) {
            next.setVisibility(View.VISIBLE);
            counter--;
            text.setText(cat_breed_text[counter]);
            image.setImageResource(cat_breed_image[counter]);
        }

      if(counter == 0) {
            prev.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        // option closing app
        if (id == R.id.exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
