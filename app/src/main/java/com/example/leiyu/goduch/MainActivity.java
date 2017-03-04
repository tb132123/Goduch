package com.example.leiyu.goduch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(v->{
            EditText ed1=(EditText)findViewById(R.id.editText1);
            EditText ed2=(EditText)findViewById(R.id.editText2);
            String total_mon=ed1.getText().toString().trim(),total_pe=ed2.getText().toString().trim();
            if(total_mon.length()==0){
                Toast.makeText(this,"The total money can't be null",Toast.LENGTH_LONG).show();
                return;
            }
            if(total_pe.length()==0){
                Toast.makeText(this,"The total Person can't be null",Toast.LENGTH_LONG).show();
                return;
            }
            else if(Float.parseFloat(total_pe)<=0){
                Toast.makeText(this,"The total Person can't be 0",Toast.LENGTH_LONG).show();
                return ;
            }
            else {
                TextView tt = (TextView) findViewById(R.id.textView2);
                String str = tt.getText().toString().split(":")[0];
                str = str +":"+ (Float.parseFloat(total_mon) / Float.parseFloat(total_pe));
                tt.setText(str);
                return;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
