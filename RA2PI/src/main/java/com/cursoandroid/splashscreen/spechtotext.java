package com.cursoandroid.splashscreen;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class spechtotext extends AppCompatActivity {
    TextView grabar;

    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.spechtotext);
        grabar = (TextView) findViewById(R.id.txtGrabarVoz);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList <String> speech = data
                            .getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);

                    grabar.setText(strSpeech2Text);
                }

                break;
            default:

                break;
        }
    }
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                    Intent intentActionRecognizeSpeech = new Intent(
                            RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                    intentActionRecognizeSpeech.putExtra(
                            RecognizerIntent.EXTRA_LANGUAGE_MODEL, " Portuguese (Brazil)");
                    try {
                        startActivityForResult(intentActionRecognizeSpeech,
                                RECOGNIZE_SPEECH_ACTIVITY);
                    } catch (ActivityNotFoundException a) {
                        Toast.makeText(getApplicationContext(),
                                "Tú dispositivo no soporta el reconocimiento por voz",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    Intent voltar = new Intent(this,MainActivity.class);
                    startActivity(voltar);

                }
                return true;

            default:
                return super.dispatchKeyEvent(event);
        }
    }

   /*private void siguiente( Intent siguiente ) {

        startActivity( siguiente );

    }
    //private void anterior( Intent anterior ) {

       // startActivity( anterior );
    }

*/



   // public void onClickImgBtnHablar( View v) {

        //Intent intentActionRecognizeSpeech = new Intent(
           //     RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Configura el Lenguaje (Español-México)





}


