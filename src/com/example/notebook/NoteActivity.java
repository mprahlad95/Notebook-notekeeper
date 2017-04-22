package com.example.notebook;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends Activity {
	
	Bundle b;
	EditText notej;
	TextView titlej;
	SQLiteDatabase db= LoginActivity.db;
	String DBNAME = LoginActivity.DBNAME;
	String TABLE = LoginActivity.TABLE;
	String titlecontent, notecontent;
	int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		notej=(EditText) findViewById(R.id.note);
		titlej=(TextView) findViewById(R.id.title);
		
		notej.setFocusable(false);
		notej.setFocusableInTouchMode(false);
		notej.setClickable(false);
		
		b=getIntent().getExtras();
		
		if(b!=null)
		{
			index= b.getInt("index");
			//System.out.println(index);
			//Toast.makeText(getApplicationContext(), String.valueOf(index), Toast.LENGTH_LONG).show();
		}
		Cursor allrows= db.rawQuery("SELECT title, note FROM "+TABLE+" WHERE index_no='"+index+"'", null);
		
		 if(allrows.moveToFirst()){
	        	do
	        	{
	        		titlecontent=allrows.getString(0);
	        		notecontent=allrows.getString(1);
	          	} while(allrows.moveToNext());
	        }
		System.out.println(titlecontent);
		System.out.println(notecontent);
		 //Toast.makeText(getApplicationContext(), titlecontent, Toast.LENGTH_LONG).show();
		 titlej.setText(titlecontent);
		 notej.setText(notecontent);
		 
	}
}
