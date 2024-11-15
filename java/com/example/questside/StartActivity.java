package com.example.questside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class StartActivity extends AppCompatActivity {
    private Button itemTrade;
    private Button jobs;
    private Button documents;
    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        itemTrade = findViewById(R.id.itemTrade);
        itemTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ItemTrade.class);
                startActivity(intent);
            }
        });

        jobs = findViewById(R.id.jobs);
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, jobPost.class);
                startActivity(intent);
            }
        });

        documents = findViewById(R.id.documents);
        documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, documents.class);
                startActivity(intent);
            }
        });
        //code for for you page
        TextView foryou = findViewById(R.id.foryou);
        foryou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, feed.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("@null")
                        .commit();
            }
        });
        //code for friends page
        TextView friends = findViewById(R.id.friends);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, friends.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("@null")
                        .commit();
            }
        });
        //code for new post page
        TextView newpost = findViewById(R.id.newpost);
        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, newpost.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("@null")
                        .commit();
            }
        });

        //main menu


    }
}