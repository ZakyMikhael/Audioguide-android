package com.mikha.nfa024_audioguide;

/**
 * Created by Mikhael on 17/12/2017.
 */

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import com.mikha.nfa024_audioguide.Route;


public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}