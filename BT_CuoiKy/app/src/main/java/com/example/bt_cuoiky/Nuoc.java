package com.example.bt_cuoiky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class Nuoc extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    FloatingActionButton floatingActionButton;
    NuocAdapter nuocAdapter;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhac);

        recyclerView = (RecyclerView) findViewById(R.id.rcv_covu);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        searchView = (SearchView) findViewById(R.id.search_view);
        back = (LinearLayout) findViewById(R.id.back);
        searchView.clearFocus();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<NuocModel> options =
                new FirebaseRecyclerOptions.Builder<NuocModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("nuoc"), NuocModel.class)
                        .build();
        nuocAdapter = new NuocAdapter(options, this);
        recyclerView.setAdapter(nuocAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Nuoc.this, GiaoDienChinh.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });

    }

    protected void onStart() {
        super.onStart();
        nuocAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        nuocAdapter.stopListening();
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<NuocModel> options =
                new FirebaseRecyclerOptions.Builder<NuocModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("nuoc").orderByChild("ten").startAt(str).endAt(str+"~"), NuocModel.class)
                        .build();
        nuocAdapter = new NuocAdapter(options, this);
        nuocAdapter.startListening();
        recyclerView.setAdapter(nuocAdapter);
    }

}