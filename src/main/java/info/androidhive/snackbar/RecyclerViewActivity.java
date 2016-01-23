package info.androidhive.snackbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> list = new ArrayList<String>();
        for(int i=1 ; i <= 20 ; i++){
            list.add("Title: "+ i);
        }

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(RecyclerViewActivity.this,list);
        recyclerView.setAdapter(adapter);
    }
}
