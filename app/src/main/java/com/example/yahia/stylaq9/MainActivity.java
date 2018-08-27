package com.example.yahia.stylaq9;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private void setMenuCounter(int itemId, int count) {
        if(count > 0){
        ((NavigationView) findViewById(R.id.nav_view)).getMenu().findItem(itemId).setActionView(R.layout.menu_counter);
        TextView view = (TextView) ((NavigationView) findViewById(R.id.nav_view)).getMenu().findItem(itemId).getActionView();
        view.setText(String.valueOf(count));}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View v = navigationView.getHeaderView(0);
        TextView logout = (TextView) v.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Log Out", Toast.LENGTH_LONG).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imag);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        Button support = (Button) findViewById(R.id.support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Support", Toast.LENGTH_LONG).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        TextView terms = (TextView) findViewById(R.id.terms);
        terms.setText("Terms & Conditions");
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Terms & Conditions", Toast.LENGTH_LONG).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        setMenuCounter(R.id.my_fav, 12);
        setMenuCounter(R.id.noti, 0);
        setMenuCounter(R.id.cart, 9);

    }

    @Override
    protected void onResume() {
        super.onResume();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();




        if (id == R.id.home) {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
        } else if (id == R.id.cat) {
            Toast.makeText(getApplicationContext(), "Category", Toast.LENGTH_LONG).show();
        } else if (id == R.id.my_fav) {
            Toast.makeText(getApplicationContext(), "Favourits", Toast.LENGTH_LONG).show();
        } else if (id == R.id.noti) {
            Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_LONG).show();
        } else if (id == R.id.blog) {
            Toast.makeText(getApplicationContext(), "Blog", Toast.LENGTH_LONG).show();
        } else if (id == R.id.cart) {
            Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.edit) {
            Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
