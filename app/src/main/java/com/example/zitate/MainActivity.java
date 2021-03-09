package com.example.zitate;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.codeyourapp.zitate.R;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = MainActivity.class.getSimpleName();

    private List<String> mSampleQuoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createQuoteList();
        bindAdapterToListView();

    }

    private void createQuoteList(){
        String[] sampleQuotes = getResources().getStringArray(R.array.sample_quotes);       //hole dir Zitate con arrays.xml
        mSampleQuoteList = new ArrayList<>(Arrays.asList(sampleQuotes));                    //und übergebe sie an einer
    }                                                                                       //ArrayList

    private void bindAdapterToListView(){
        ArrayAdapter<String> quoteArrayAdapter =
                new ArrayAdapter<>(
                        this, // Die aktuelle Umgebung (diese Activity)
                        R.layout.list_row, // Die ID des Zeilenlayouts (der XML-Layout Datei)
                        R.id.quote_text,   // Die ID eines TextView-Elements im Zeilenlayout
                        mSampleQuoteList); // Beispieldaten in einer ArrayList

        ListView quoteListView = (ListView) findViewById(R.id.listview_activity_main);
        quoteListView.setAdapter(quoteArrayAdapter);
    }
}
