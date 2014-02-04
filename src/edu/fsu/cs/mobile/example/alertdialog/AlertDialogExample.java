package edu.fsu.cs.mobile.example.alertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlertDialogExample extends Activity {
    
	static final String DIALOG_TAG = "MYALERTDIALOG";
	
	Button alertButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        alertButton = (Button) findViewById(R.id.alert_dialog_button);
        
        alertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MyDialogFragment alertFragment = MyDialogFragment.newInstance("Exit", "Are your sure?");
				alertFragment.show(getFragmentManager(), DIALOG_TAG);
			}
		});
       
    }
}