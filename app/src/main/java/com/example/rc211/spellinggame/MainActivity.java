package com.example.rc211.spellinggame;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.speech.tts.TextToSpeech.*;

public class MainActivity extends Activity implements OnInitListener {

    /** Called when the activity is first created. */
    private TextToSpeech tts;
    EditText wordInput;
    Button enterButton;
//    ArrayList dictionary =new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
        wordInput = findViewById(R.id.wordInput);
        enterButton = findViewById(R.id.enterButton);
        // button on click event
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

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

        if (status == SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == LANG_MISSING_DATA
                    || result == LANG_NOT_SUPPORTED) {
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

        tts.speak(text, QUEUE_FLUSH, null,"id1");
    }
}


