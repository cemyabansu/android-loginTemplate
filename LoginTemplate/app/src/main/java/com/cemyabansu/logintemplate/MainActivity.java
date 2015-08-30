package com.cemyabansu.logintemplate;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();
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

    public void Login_Click(final View view) throws InterruptedException {
        final ProgressDialog myProgressDialog = ProgressDialog.show(this, "Please Wait", "Trying to login..", true);

        // start async task to wait for 5 second that update the view
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                myProgressDialog.hide();
                StartLoginTemplate();
            }
        };
        task.execute((Void[]) null);
    }

    public void StartLoginTemplate(){
        Intent intent = new Intent(this, LoginTemplate.class);

        String usernmae = ((EditText) findViewById(R.id.et_userName)).getText().toString();
        intent.putExtra("username",usernmae);

        ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent);

        //finish the activity. When user click back button doesn't come back this activity
        finish();
    }
}
