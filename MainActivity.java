/*
 *   NOMBRE: Danna Paola Muñoz Tenorio
 *   MATERIA: Programación de Dispositivos Móviles
 *   ARCHIVO: Pantalla Principal -- muestra el catálogo, el contacto y el mapa de ubicación
 */

package com.idealabs.fadesserts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    private LinearLayout productContainer;
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);

        productContainer = findViewById(R.id.productContainer);
        map = findViewById(R.id.map);

        Button btnInstagram = findViewById(R.id.btnInstagram);
        btnInstagram.setOnClickListener(v -> {
            String url = "https://www.instagram.com/fadesserts/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // se abre en la app de instagram
            intent.setPackage("com.instagram.android");
            try {
                startActivity(intent);
            } catch (Exception e) {
                // si no tiene instagram, se abre en el navegador
                intent.setPackage(null);
                startActivity(intent);
            }
        });

        loadCatalog();
        setupMap();
    }

    private void loadCatalog() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT name, price, image FROM products", null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            int price = cursor.getInt(1);
            String imageName = cursor.getString(2);

            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(0, 12, 0, 12);

            ImageView imageView = new ImageView(this);
            int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            imageView.setImageResource(imageResId);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            TextView textView = new TextView(this);
            textView.setText(name + "\nPrecio: $" + price);
            textView.setTextSize(16);
            textView.setPadding(20, 0, 0, 0);

            itemLayout.addView(imageView);
            itemLayout.addView(textView);

            productContainer.addView(itemLayout);
        }

        cursor.close();
    }

    private void setupMap() {
        map.setMultiTouchControls(true);
        map.getController().setZoom(17.0);
        GeoPoint upaep = new GeoPoint(19.0433, -98.2062);
        map.getController().setCenter(upaep);

        Marker marker = new Marker(map);
        marker.setPosition(upaep);
        marker.setTitle("UPAEP Campus Central");
        map.getOverlays().add(marker);
    }
}
