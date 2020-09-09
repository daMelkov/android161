package com.astra.melkovhw161;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        /* EditText 'Search' */
        final EditText edtSearch = findViewById(R.id.edtSearch);

        /* Button 'Search' */
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String request = edtSearch.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);

                if(IsCoordinates(request)) {
                    /* Coordinate request, eg: "55.704968, 37.625206" */
                    intent.setData(Uri.parse("geo:" + request));
                } else {
                    /* Address request, eg: "Roma" */
                    intent.setData(Uri.parse("geo:?q=" + request));
                }

                startActivity(intent);
            }
        });
    }

    /* check: request is coordinates */
    private boolean IsCoordinates(String request) {
        return !Pattern.compile("[a-zA-Z]").matcher(request).find();
    }
}