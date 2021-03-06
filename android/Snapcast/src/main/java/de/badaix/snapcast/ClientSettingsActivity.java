package de.badaix.snapcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by johannes on 11.01.16.
 */
public class ClientSettingsActivity extends AppCompatActivity {
    private ClientSettingsFragment clientSettingsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clientSettingsFragment = new ClientSettingsFragment();
        clientSettingsFragment.setArguments(getIntent().getExtras());

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, clientSettingsFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("client", clientSettingsFragment.getClient().toJson().toString());
        intent.putExtra("clientOriginal", clientSettingsFragment.getOriginalClientInfo().toJson().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
//        super.onBackPressed();
    }
}
