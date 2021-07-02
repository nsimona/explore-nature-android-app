package com.example.naturalwonders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WonderActivity extends AppCompatActivity {
    TextView attrName;
    ImageView imageView;
    TextView descrTextView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        attrName = (TextView) findViewById(R.id.attr_name);
        imageView = (ImageView) findViewById(R.id.image);
        descrTextView = (TextView) findViewById(R.id.description);
        btn = (Button) findViewById(R.id.mapBtn);
        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("ATTRACTION_NAME");
        int image =  bundle.getInt("ATTRACTION_IMAGE");
        String descr = bundle.getString("ATTRACTION_DESCR");
        String[] coordinates = bundle.getStringArray("ATTRACTION_COORDINATES");
        int color = bundle.getInt("ATTRACTION_COLOR");
        String lat = coordinates[0];
        String lon = coordinates[1];
        attrName.setText(name);
        attrName.setBackgroundColor(color);
        btn.setBackgroundColor(color);
        imageView.setImageResource(image);
        descrTextView.setText(descr);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(("geo:" + lat + ", " + lon)));
                Intent chooser = Intent.createChooser(i, "Launch Maps");
                startActivity(chooser);
            }
        });
    }
}
