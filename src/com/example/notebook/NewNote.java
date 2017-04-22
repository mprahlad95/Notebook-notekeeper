package com.example.notebook;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNote extends Activity {
    
	String DBNAME = LoginActivity.DBNAME;
    String TABLE = LoginActivity.TABLE;
	Button addnotebutton, testbutton;
	EditText notetitle, notecontent;
	Bundle b= new Bundle();	
	SQLiteDatabase  db= LoginActivity.db;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_note);
		addnotebutton=(Button) findViewById(R.id.note_addbutton);
		notetitle=(EditText) findViewById(R.id.note_title_content);
		notecontent=(EditText) findViewById(R.id.note_content);
		testbutton=(Button) findViewById(R.id.button1);
		
		//notecontent.setFocusable(false);
		//notecontent.setFocusableInTouchMode(false);
		//notecontent.setClickable(false);
		
		//notecontent.getBackground().setColorFilter(Color.LTGRAY, null);
		
	       
		addnotebutton.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				String note_note=notecontent.getText().toString();
				String note_new= notetitle.getText().toString();
				
				//Add note contents to database 
				
				db.execSQL("INSERT INTO " + TABLE + "(index_no, title, note) VALUES('"+LoginActivity.index_of_note+"','"+note_new+"','"+note_note+"')");

				LoginActivity.index_of_note++;
				
				Toast.makeText(getApplicationContext(), "Note Added Successfully!", Toast.LENGTH_SHORT).show();

				//db.close();
				
				Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i1);
				
			}});
				
			}
}
