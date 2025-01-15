package com.example.fishbd;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Products extends AppCompatActivity {
    private ListView listViewProducts;
    private DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        listViewProducts = findViewById(R.id.list_view_products);
        databaseHelper = new DataBaseHelper(this);
        displayProducts();
        Button btn_buy = findViewById(R.id.btn_buy_now);

        btn_buy.setOnClickListener(v->{
            Toast.makeText(this, "Thank you, Product Added to the cart!!!", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the displayed products
        displayProducts();
    }

    private void displayProducts() {
        Cursor cursor = databaseHelper.getAllProducts();
        ProductAdapter adapter = new ProductAdapter(this, cursor, 0);
        listViewProducts.setAdapter(adapter);
    }

}
