package com.example.mixazp.testandroidnechet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mixazp.testandroidnechet.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Product> model;
    private SQLiteConnector connector;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = findViewById(R.id.recyclerView);

        saveData();
    }

    private void saveData() {
        connector = new SQLiteConnector(getApplicationContext());
        model = new ArrayList<>();
        model = connector.getData();

        mLayoutManagers = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(mLayoutManagers);

        mAdapter = new ModelDataAdapter(getApplication(), model);

        recyclerView.addItemDecoration(new SpacecItemDecoration(getApplication()));
        recyclerView.setAdapter(mAdapter);
    }
}