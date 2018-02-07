package com.example.mixazp.testandroidnechet;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mixazp.testandroidnechet.model.Product;
import com.example.mixazp.testandroidnechet.model.Products;
import com.example.mixazp.testandroidnechet.model.XML;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity{

    private String API_BASE_URL = "http://ainsoft.pro/";

    private Button btnSave;
    private Button btnNext;

    private RecyclerView recyclerView1;
    private List<Product> model;
    private Product product;
    private ModelDataAdapter adapter;
    private SQLiteConnector connector;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        btnSave = findViewById(R.id.btnSave);

        recyclerView1 = findViewById(R.id.recyclerView1);
        connector = new SQLiteConnector(this);

        model = new ArrayList<>();
        product = new Product();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);

            }
        });
    }

    private void saveData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        final ProductAPI api = retrofit.create(ProductAPI.class);

        Call<XML> call = api.getProducts();

        call.enqueue(new Callback<XML>() {
            @Override
            public void onResponse(Call<XML> call, Response<XML> response) {
                ArrayList<Products> products;

                products = response.body().getMyProducts();

                for(int i=0; i<products.size(); i++){
                    model = products.get(i).getProducts();
                    for (int y=0; y<model.size(); y++){
                        product = model.get(y);
                        connector.insert(product);
                    }
                }
                Toast.makeText(getApplication(), "Данные загруженны", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<XML> call, Throwable t) {
                Log.d("LOL", "onFailure CALL" + call.toString());
                Log.d("LOL", "onFailure T" + t.toString());
            }
        });
    }
}
