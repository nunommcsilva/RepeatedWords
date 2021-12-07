package com.example.admin.adentis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Button buttonRep;
    public String phrase;
    private EditText inputPhrase;
    public TextView resultOutput, resultValues;
    String uniqueString;
    List<Integer> quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPhrase = (EditText) findViewById(R.id.inputPhrase);
        resultOutput = (TextView) findViewById(R.id.resultOutput);
        resultValues = (TextView) findViewById(R.id.resultValues);

        buttonRep = (Button) findViewById(R.id.buttonRep);
        buttonRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRepetitions();
            }
        });
    }

    private void showResult() {
        resultOutput.setText("Palavras: [" + uniqueString + "]");
        resultValues.setText("Quantidades: " + quantity);
    }

    private void calculateRepetitions() {
        phrase = inputPhrase.getText().toString();
        repetitions(phrase);
        showResult();
    }

    public void repetitions(String phraseRep) {
        Map<String, Integer> unique = new LinkedHashMap<String, Integer>();
        for (String string : phraseRep.split(" ")) {
            if (unique.get(string) == null)
                unique.put(string, 1);
            else
                unique.put(string, unique.get(string) + 1);
        }
        uniqueString = join(unique.keySet(), ", ");
        quantity = new ArrayList<Integer>(unique.values());
    }

    public static String join(Collection<String> s, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iter = s.iterator();
        while (iter.hasNext()) {
            buffer.append(iter.next());
            if (iter.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }


}