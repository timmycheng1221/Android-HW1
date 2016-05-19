package timmycheng.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.logo);

        initViews();
        setListener();
    }

    private Button button_start;
    private TextView show_result;

    private void initViews() {
        button_start = (Button) findViewById(R.id.submit);
        show_result = (TextView) findViewById(R.id.result);
    }

    // Listen for button clicks
    private void setListener() {
        button_start.setOnClickListener(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_about:
                author();
            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void author() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,AuthorActivity.class);
        finish();
        startActivity(intent);
    }

    private Button.OnClickListener start = new Button.OnClickListener() {
        public void onClick(View v) {
            Random rand = new Random();
            int lucnum = rand.nextInt(9) + 1;
            show_result.setText(Integer.toString(lucnum));
            Toast.makeText(MainActivity.this, getText(R.string.lucnum_result) + Integer.toString(lucnum), Toast.LENGTH_SHORT).show();
        }
    };
}
