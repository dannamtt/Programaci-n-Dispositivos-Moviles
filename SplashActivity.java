/*
*   NOMBRE: Danna Paola Muñoz Tenorio
*   MATERIA: Programación de Dispositivos Móviles
*   ARCHIVO: Pantalla de Splash -- se muestra antes de iniciar la app
*/

package com.idealabs.fadesserts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // 3 segundos de duración

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Espera 3 segundos y cambia a la pantalla principal
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Para que no se mantenga estático y/o regrese
        }, SPLASH_TIME_OUT);
    }
}
