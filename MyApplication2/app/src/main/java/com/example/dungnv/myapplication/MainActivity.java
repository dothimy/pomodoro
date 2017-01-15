package com.example.dungnv.myapplication;

import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.SearchEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private ImageView imageView;
    private Spinner spin;
    private Button button;
    private CheckBox checkBox;
    private RadioButton male;
    private RadioButton female;
    private RadioButton undefined;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView textview;
    private SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getImage();
        setUpID();
        addListeners();
    }


    private void getImage() {
        imageView = (ImageView) this.findViewById(R.id.iv_my);
        spin = (Spinner) findViewById(R.id.s_fuit);
        button = (Button) findViewById(R.id.bt_test);
        checkBox = (CheckBox) findViewById(R.id.cb_box);
        male = (RadioButton) findViewById(R.id.rb_male);
        female = (RadioButton) findViewById(R.id.rb_female);
        undefined = (RadioButton) findViewById(R.id.rb_undefined);
        ratingBar = (RatingBar) findViewById(R.id.rtb_ratingbar);
        seekBar = (SeekBar) findViewById(R.id.seek);
        textview = (TextView) findViewById(R.id.textseek);
        search = (SearchView) findViewById(R.id.s_search);
    }

    private void setUpID() {
        imageView.setImageResource(R.drawable.my);
        String[] fuit = new String[]{
                "Apple",
                "Orange",
                "Kiwi",
                "Pinaple"
        };
        ArrayAdapter<String> fuiA = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                fuit
        );
        spin.setAdapter(fuiA);
        male.setChecked(true);
    }

    private void addListeners() {
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("%s %d", "spin.onItemSelected: ", position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "onNothingSelected: ");
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("onCheckedChanged: %s", isChecked));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read
                Log.d(TAG, String.format("%s", checkBox.getId()));
                //write
                checkBox.setChecked(!checkBox.isChecked());
                Log.d(TAG, String.format("onClick: %s", ratingBar.getRating()));
                Log.d(TAG, String.format("onClick: %s", seekBar.getProgress()));
                seekBar.setProgress(seekBar.getProgress() + 10);
                search.clearFocus();
                search.setQuery("",false);
                search.setIconified(true);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, String.format("onProgressChanged: %s,%s", progress, fromUser));
                textview.setText((String.format("%s/%s", progress, seekBar.getMax())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch: ");
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, String.format("onQueryTextChange: %s", newText));
                return false;
            }
        });

    }



}