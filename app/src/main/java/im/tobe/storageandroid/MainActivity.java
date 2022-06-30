package im.tobe.storageandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import im.tobe.storageandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_ID = "MESSAGE_ID";
    private static final String DATA_KEY_MSG = "msg";

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // get data from disk
        SharedPreferences getSharedData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String msgInStorage = getSharedData.getString(DATA_KEY_MSG, "Nothing yet");
        Log.d("MAIN", "MsgInStorage: "+msgInStorage);
    }

    public void onSubmitBtnClicked(View view) {
        Log.d("MAIN", "onSubmitBtnClicked");
        String msg = binding.msgInput.getText().toString().trim();

        // saving to disk
        SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATA_KEY_MSG, msg);
        editor.apply();
    }
}