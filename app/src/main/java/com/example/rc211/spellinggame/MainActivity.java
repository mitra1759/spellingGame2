package com.example.rc211.spellinggame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
        TextToSpeech.OnInitListener {

    /** Called when the activity is first created. */
    private TextToSpeech tts;
    EditText wordInput;
    Button enterButton;
    InputStream inputStream;//creates a fileinputstream to load data from the file
    ArrayList dictionary =new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        load();
        tts = new TextToSpeech(this, this);
        wordInput = findViewById(R.id.wordInput);
        enterButton = findViewById(R.id.enterButton);
        // button on click event
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
//                Toast.makeText(getApplicationContext(),dictionary.get((int)(Math.random()*dictionary.size()))+"",Toast.LENGTH_SHORT).show();

                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                enterButton.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {

        CharSequence text = wordInput.getText();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
    }
//    public void load() {//loads the stats
//        try {
//            inputStream = this.getResources().openRawResource(R.raw.dictionary);
//            InputStreamReader inputReader = new InputStreamReader(inputStream);//converts the byte stream to characters
//            BufferedReader bufferedReader = new BufferedReader(inputReader);//acts as a buffer for the info; processes it?
//
//            try {
//                String line = bufferedReader.readLine();//saves the line read to a temp variable to avoid reading next line during check
//                while (line != null) {
//                    dictionary.add(line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}

