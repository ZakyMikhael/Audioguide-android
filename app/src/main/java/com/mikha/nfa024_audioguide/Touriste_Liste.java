package com.mikha.nfa024_audioguide;

import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class Touriste_Liste extends AppCompatActivity {

    double lat;
    double lng;
    String tour = "";
    static MediaPlayer media;
    static String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touriste__liste);

        String[] tourListe = {"Tour Eiffel", "Sacre Coeur", "Notre Dame", "Bibliothèque F.M.", "Champs-Elysée"};
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tourListe);
        final ListView Tliste = (ListView) findViewById(R.id.tliste);
        Tliste.setAdapter(listAdapter);

        Tliste.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                        tour = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Touriste_Liste.this, tour, Toast.LENGTH_LONG).show();
                        if (tour == "Tour Eiffel"){
                            lat = 48.8583700;
                             lng = 2.2944810;
                            LatLng mlatLng = new LatLng(lat, lng);
                            //Mediaestencours(media);
                            media = MediaPlayer.create(Touriste_Liste.this, R.raw.tour);
                            filename = "tour.txt";
                            getTour(mlatLng);
                        } else if (tour == "Sacre Coeur"){
                            lat = 48.886929;
                            lng = 2.343020;
                            LatLng mlatLng = new LatLng(lat, lng);
                            media = MediaPlayer.create(Touriste_Liste.this, R.raw.scoeur);
                            filename = "scoeur.txt";
                            getTour(mlatLng);
                        } else if (tour == "Notre Dame"){
                            lat = 48.853201;
                            lng = 2.349859;
                            LatLng mlatLng = new LatLng(lat, lng);
                            media = MediaPlayer.create(Touriste_Liste.this, R.raw.ndame);
                            filename = "ndame.txt";
                            getTour(mlatLng);
                        } else if (tour == "Bibliothèque F.M.") {
                            lat = 48.831008;
                            lng = 2.377399;
                            LatLng mlatLng = new LatLng(lat, lng);
                            media = MediaPlayer.create(Touriste_Liste.this, R.raw.biblio);
                            filename = "bf.txt";
                            getTour(mlatLng);
                        }else if (tour == "Champs-Elysée") {
                            lat = 48.871851;
                            lng = 2.301658;
                            LatLng mlatLng = new LatLng(lat, lng);
                            media = MediaPlayer.create(Touriste_Liste.this, R.raw.champs);
                            filename = "ch.txt";
                            getTour(mlatLng);
                        }
                        }

                }
        );
    }

    public LatLng  getTour(LatLng latLng) {

        Intent mapintent = new Intent(Touriste_Liste.this, Tourist.class);
        mapintent.putExtra("Latitude", lat);
        mapintent.putExtra("Longitude", lng);
        latLng = new LatLng(lat, lng);
        startActivity(mapintent);
        return (latLng);
    }


}