package com.example.myapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.myapplication.R;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    /* logic to make the navigation drawer work  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /* Button that opens the Depositar activity where the QR code will be displayed */
        Button buttonDeposit = findViewById(R.id.buttonDeposit);
            buttonDeposit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent depositarIntent = new Intent(getApplicationContext(), Depositar.class);
                    startActivity(depositarIntent);
                }
            });

        /* Opens a new WhatsApp message with red_'s business account */
            Button whatsappButton = findViewById(R.id.whatsappButton);
            whatsappButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "https://wa.me/573135581129";

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*I commented out the below to remove the three dot action bar menu on the right as we do not currently need it*/

   /* @Override
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
*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        /* Handle navigation view item clicks here.
         *      First opens Guardar activity
         *      Second opens Recuperar activity
         *      Third again opens a new WhatsApp message with red_'s business account
          * */

        int id = item.getItemId();

        if (id == R.id.nav_guardar) {
           Intent guardarIntent = new Intent(getApplicationContext(), Guardar.class );
           startActivity(guardarIntent);

        } else if (id == R.id.nav_recuperar) {
            Intent recuperarIntent = new Intent(getApplicationContext(), Recuperar.class);
            startActivity(recuperarIntent);

        } else if (id == R.id.nav_contáctanos) {
            String url = "https://wa.me/573135581129";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
