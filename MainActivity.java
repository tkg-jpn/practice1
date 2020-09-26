package com.example.sortpractice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] factor=new int[99];
    private String listEnumeration;
    private int[] sortedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Random random=new Random();
        final TextView listText=findViewById(R.id.listText);
        listEnumeration="";

        Button rb =findViewById(R.id.randomButton);
        rb.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View view) {
                        for(int i=0;i<factor.length;i++){
                            factor[i]=random.nextInt(1000);
                            listEnumeration=listEnumeration+":"+String.valueOf(factor[i]);
                        }
                        listText.setText(listEnumeration);
                    }

                }
        );

        Button sc =findViewById(R.id.sortCheck);
        sc.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View view) {
                        Check check=new Check(factor);
                        if(check.result()) {
                            Toast.makeText(MainActivity.this,"ソートに成功しました",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "ソートに失敗しました", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );

        
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.list_menu,menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort1) {
            final TextView listText=findViewById(R.id.listText);
            SimpleSort sort=new SimpleSort(factor);
            sortedItem=sort.getSortItem();
            listEnumeration="単純選択ソート";
            for(int i=0;i<sortedItem.length;i++){
                listEnumeration=listEnumeration+":"+String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);
        }else if(item.getItemId() == R.id.sort2){
            ShakerSort sort=new ShakerSort(factor);
            sortedItem=sort.getSortItem();
            final TextView listText=findViewById(R.id.listText);
            listEnumeration="シェイカーソート";
            for(int i=0;i<sortedItem.length;i++){
                listEnumeration=listEnumeration+":"+String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);

        }else if(item.getItemId() == R.id.sort3){
            QuickSort sort=new QuickSort(factor);
            sortedItem=sort.getSortItem();
            final TextView listText=findViewById(R.id.listText);
            listEnumeration="クイックソート";
            for(int i=0;i<sortedItem.length;i++){
                listEnumeration=listEnumeration+":"+String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);
        }else if(item.getItemId() == R.id.sort4){
            CombSort sort=new CombSort(factor);
            sortedItem=sort.getSortItem();
            final TextView listText=findViewById(R.id.listText);
            listEnumeration="コームソート";
            for(int i=0;i<sortedItem.length;i++){
                listEnumeration=listEnumeration+":"+String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);
        }else if(item.getItemId() == R.id.sort5){
            InsertSort sort=new InsertSort(factor);
            sortedItem=sort.getSortItem();
            final TextView listText=findViewById(R.id.listText);
            listEnumeration="単純挿入ソート";
            for(int i=0;i<sortedItem.length;i++){
                listEnumeration=listEnumeration+":"+String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);
        }else if(item.getItemId() == R.id.sort6) {
            MergeSort sort = new MergeSort(factor);
            sortedItem = sort.getSortItem();
            final TextView listText = findViewById(R.id.listText);
            listEnumeration = "マージソート";
            for (int i = 0; i < sortedItem.length; i++) {
                listEnumeration = listEnumeration + ":" + String.valueOf(sortedItem[i]);
            }
            listText.setText(listEnumeration);
        }
        return true;
    }


}
