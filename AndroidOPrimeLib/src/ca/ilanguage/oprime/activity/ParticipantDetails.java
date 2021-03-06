package ca.ilanguage.oprime.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Toast;
import ca.ilanguage.oprime.R;
import ca.ilanguage.oprime.content.OPrime;
import ca.ilanguage.oprime.content.OPrimeApp;

public class ParticipantDetails extends PreferenceActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getPreferenceManager().setSharedPreferencesMode(MODE_PRIVATE);
    getPreferenceManager().setSharedPreferencesName(
        ((OPrimeApp) getApplication()).PREFERENCE_NAME);

    // Load the preferences from an XML resource
    addPreferencesFromResource(R.xml.preferences);

  }

  public void onDialogClosed(boolean positiveResult) {
    if (positiveResult) {
      SharedPreferences prefs = getSharedPreferences(OPrimeApp.PREFERENCE_NAME,
          MODE_PRIVATE);
      SharedPreferences.Editor editor = prefs.edit();
      // editor.remove(PreferenceConstants.PREFERENCE_LEVEL_ROW);

      editor.commit();
      Toast.makeText(this, "Dialog was closed", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onBackPressed() {
    Intent i = new Intent(getBaseContext(), HTML5GameActivity.class);
    i.putExtra(OPrime.EXTRA_PLEASE_PREPARE_EXPERIMENT, true);
    i.putExtra(OPrime.EXTRA_DEBUG_MODE, OPrimeApp.D);
    i.putExtra(OPrime.EXTRA_TAG, OPrimeApp.TAG);
    startActivity(i);

    super.onBackPressed();
  }

}
