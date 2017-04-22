package com.example.notebook;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	    
	
	Bundle b;
    //String index;
    int ind;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    ImageButton addnotebutton;
    String test_note;
    TextView testnote1, testnote2, testnote3, testnote4, testnote5 ;
    String DBNAME = LoginActivity.DBNAME;
    String TABLE = LoginActivity.TABLE;
    Button testbutton;
    SQLiteDatabase  db= LoginActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testnote1= (TextView) findViewById(R.id.Note1);
        testnote2= (TextView) findViewById(R.id.Note2);
        testnote3= (TextView) findViewById(R.id.Note3);
        testnote4= (TextView) findViewById(R.id.Note4);
        testnote5= (TextView) findViewById(R.id.Note5);
        testbutton= (Button) findViewById(R.id.button1);
        addnotebutton=(ImageButton) findViewById(R.id.addnote);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        
        b=getIntent().getExtras();
		
       /* Remove comment if can't implement using sqlite
        * 
        if(b!=null)
			test_note = b.getString("title");
        testnote.setText(test_note);
        */
        testbutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
		Cursor allrows  = db.rawQuery("SELECT * FROM "+ TABLE, null);
		
		String abc[]=new String[50];
		int x=1;
		
        if(allrows.moveToFirst()){
        	do
        	{
        		abc[x]=allrows.getString(1);
        		x++;
          	} while(allrows.moveToNext());
        }
        
        //TO CHECK IF PRESENT IN DATABASE
        
       // for(int i=1;i<x;i++)
        //Toast.makeText(getApplicationContext(), abc[i], Toast.LENGTH_SHORT).show();
        
        
		for(int i=1;i<=x;i++)
		{
			if(i==1) testnote1.setText(abc[1]);
			if(i==2) testnote2.setText(abc[2]);
			if(i==3) testnote3.setText(abc[3]);
			if(i==4) testnote4.setText(abc[4]);
			if(i==5) testnote5.setText(abc[5]);
			
		}
			}});
		
        
        addnotebutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainActivity.this, NewNote.class);
				startActivity(i);
			}
        	
        });
        

        
        //USE LISTVIEW IF POSSIBLE INSTEAD OF TEXTVIEWS 
        
        
        testnote1.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Edit the existing note
				Intent i= new Intent(MainActivity.this, NoteActivity.class);
				ind=1;
				i.putExtra("index", ind);
				startActivity(i);
			}
        	
        });
        
        testnote2.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Edit the existing note
				ind=2;
				Intent i= new Intent(MainActivity.this, NoteActivity.class);
				i.putExtra("index", ind);
				startActivity(i);
			}
        	
        });
        
        testnote3.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Edit the existing note
				ind=3;
				Intent i= new Intent(MainActivity.this, NoteActivity.class);
				i.putExtra("index", ind);
				startActivity(i);
			}
        	
        });
        
        testnote4.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Edit the existing note
				ind=4;
				Intent i= new Intent(MainActivity.this, NoteActivity.class);
				i.putExtra("index", ind);
				startActivity(i);
			}
        	
        });
        
        testnote5.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Edit the existing note
				ind=5;
				Intent i= new Intent(MainActivity.this, NoteActivity.class);
				i.putExtra("index", ind);
				startActivity(i);
			}
        	
        });
         
        
        
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }
    
//Assign tasks to each Fragment
    
    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
            	mTitle = getString(R.string.title_section6);
            	Intent i= new Intent(MainActivity.this, Help.class);
            	startActivity(i);
                break;
            case 3:
            	mTitle = getString(R.string.title_section7);
            	i= new Intent(MainActivity.this, About.class);
            	startActivity(i);
                break;
            case 4:
            	i= new Intent(MainActivity.this, LoginActivity.class);
            	startActivity(i);
                break;
            	
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	
        	//Settings
        	Intent i = new Intent(MainActivity.this, SettingsActivity.class);
			startActivity(i);
        	//Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
