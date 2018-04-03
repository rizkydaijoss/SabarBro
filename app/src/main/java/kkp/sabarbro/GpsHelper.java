package kkp.sabarbro;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
/**
 * Created by rizky on 12/06/2017.
 */

public class GpsHelper implements LocationListener {

    protected LocationManager locationManager;
    Context context;

    //at constructor, context is passed from FragmentMap.java and context will be used by GpsHelperClass throughout.
    public GpsHelper(Context context) {
        this.context = context;
    }

    public boolean isGpsReadyToUse() {
        //this.context.getSystemService is required if we want to use in separate class
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //We cannot enable GPS via program.
            //Still need user input to enable for good reason.
            getUserInputToEnableGPS();
        }

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    private void getUserInputToEnableGPS() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Pengaturan GPS");

        // Setting Dialog Message
        alertDialog.setMessage("GPS tidak aktif. Apakah anda ingin menuju ke menu pengaturan dan mengaktifkan GPS?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Pengaturan", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                //Settings.ACTION_LOCATION_SOURCE_SETTINGS == Activity Action: Show settings to allow configuration of current location sources.
                // The Settings provider contains global system-level device preferences.
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);

                //Every Activity is invoked by an Intent. therefore, we are going to start activity which allow to set location
                context.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
