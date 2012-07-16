package edu.fsu.cs.mobile.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogExample extends Activity {
    
	static final int DIALOG_EXIT_ID = 0;
	
	Button alertButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        alertButton = (Button) findViewById(R.id.alert_dialog_button);
        
        alertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				showDialog(DIALOG_EXIT_ID);
				
			}
		});
       
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch(id) {
        case DIALOG_EXIT_ID:

        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	builder.setMessage("Do you want to exit?");
        	builder.setCancelable(true);
        	
        	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        		
        		@Override
        		public void onClick(DialogInterface dialog, int id) {
			        
        			AlertDialogExample.this.finish();
			        
        		}
        	});
        	
        	builder.setNeutralButton("I don't know", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					Toast.makeText(getApplicationContext(), 
							"If you're not sure, then who is?", Toast.LENGTH_LONG).show();
					
				}
			});
        	
        	builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        		
        		@Override
        		public void onClick(DialogInterface dialog, int id) {
        			dialog.cancel();
        		}
        	});
        	
        	AlertDialog alert = builder.create();
        	dialog = builder.create();
        	
            break;
        }
        return dialog;
    }
}