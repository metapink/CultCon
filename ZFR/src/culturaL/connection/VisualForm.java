package culturaL.connection;



import java.io.File;
import java.util.LinkedList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import asdfas.ghygjh.R;

@SuppressWarnings("deprecation")
public class VisualForm extends Activity 
{
	
	
	/** Called when the activity is first created. */
	int currentIndex = 0;
	public void onCreate(Bundle savedInstanceState) 
	{
		
		//
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		
		LinearLayout MainContainer = (LinearLayout) findViewById(R.id.MainLayout);
		FrameLayout StackContainer = (FrameLayout) findViewById(R.id.Container);
		

		final AbsoluteLayout ChooseACountry = (AbsoluteLayout) findViewById(R.id.ChooseACountry);
		final AbsoluteLayout CountryInformaition = (AbsoluteLayout) findViewById(R.id.CountryInformaition);
		final AbsoluteLayout CommonPhrases = (AbsoluteLayout) findViewById(R.id.CommonPhrases);
		final AbsoluteLayout ChooseGesture = (AbsoluteLayout) findViewById(R.id.ChooseGesture);
		final AbsoluteLayout ViewGestureInformation = (AbsoluteLayout) findViewById(R.id.ViewGestureInformation);

		ChooseACountry.setBackgroundDrawable(Drawable.createFromPath("/mnt/sdcard/back.JPG"));
		CountryInformaition.setBackgroundDrawable(Drawable.createFromPath("/mnt/sdcard/back.JPG"));
		CommonPhrases.setBackgroundDrawable(Drawable.createFromPath("/mnt/sdcard/back.JPG"));
		ChooseGesture.setBackgroundDrawable(Drawable.createFromPath("/mnt/sdcard/back.JPG"));
		ViewGestureInformation.setBackgroundDrawable(Drawable.createFromPath("/mnt/sdcard/back.JPG"));
		
		final Button CountryChooser = (Button) findViewById(R.id.CountryChooser);
		final Button GestureChooser = (Button) findViewById(R.id.GestureChooser);
		Button selectedCountry = (Button) findViewById(R.id.GoToSellectedCountry);
		Button GoBackToCountryFromGesture = (Button) findViewById(R.id.GoBackToCountryFromGesture);
		Button GoBackToGesture = (Button) findViewById(R.id.GoBackToGesture);
		Button GoBackToCountryFromPhrase = (Button) findViewById(R.id.GoBackToCountryInformation);
		Button Gestures = (Button) findViewById(R.id.BGestures);
		Button Phrases = (Button) findViewById(R.id.Phrases);
		final Spinner Countries = (Spinner) findViewById(R.id.Countries);
		Spinner ListOfGestures = (Spinner) findViewById(R.id.Gestures);
		final TextView CountryInfo = (TextView) findViewById(R.id.CountryInfo);
		TextView CommonPhrasesInfo = (TextView) findViewById(R.id.CommonPhrasesInfo);
		TextView GestureName = (TextView) findViewById(R.id.GestureName);
		TextView GestureInformation = (TextView) findViewById(R.id.GestureInformation);
		final TextView CountryName = (TextView) findViewById(R.id.countryName);
		final ImageView CountryPicture = (ImageView) findViewById(R.id.CountryImage);
		final ImageView GesturePicture = (ImageView) findViewById(R.id.GestureImage);

		
		CountryInformaition.setVisibility(View.GONE);
		CommonPhrases.setVisibility(View.GONE);
		ChooseGesture.setVisibility(View.GONE);
		ViewGestureInformation.setVisibility(View.GONE);
		final LinkedList <countryCulture> info = new LinkedList <countryCulture>();
		final ArrayAdapter <CharSequence> adapter =
			  new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		final File env = Environment.getExternalStorageDirectory();

	    for (File listOfFile : env.listFiles())
	    {
	    	if (!listOfFile.isDirectory()&& listOfFile.getPath().endsWith(".xml"))
	    	{
	    		final countryCulture countryInfo = 
	    			new countryCulture(listOfFile.toString());
	    		info.add(countryInfo);
	    		adapter.add(countryInfo.getName());
	    	}
	        
	    }

		final int MAX =  adapter.getCount() - 1;
		Countries.setAdapter(adapter);
		System.out.println(Countries.getSelectedItem().toString());		
		
		selectedCountry.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				ChooseACountry.setVisibility(View.GONE);
				CountryPicture.setBackgroundDrawable(Drawable.createFromPath(info.get(Countries.getSelectedItemPosition()).getPicturePath()));
				CountryName.setText(info.get(Countries.getSelectedItemPosition()).getName());
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				CountryInformaition.setVisibility(View.VISIBLE);

			}
		});
		GoBackToGesture.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				ViewGestureInformation.setVisibility(View.GONE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				ChooseGesture.setVisibility(View.VISIBLE);

			}
		});
		GestureChooser.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				ViewGestureInformation.setVisibility(View.VISIBLE);
				GesturePicture.setBackgroundDrawable(Drawable.createFromPath(info.get(Countries.getSelectedItemPosition()).getPicturePath()));
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				ChooseGesture.setVisibility(View.GONE);

			}
		});
		CountryChooser.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				ChooseACountry.setVisibility(View.VISIBLE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				CountryInformaition.setVisibility(View.GONE);

			}
		});
		GoBackToCountryFromGesture.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				CountryInformaition.setVisibility(View.VISIBLE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				ChooseGesture.setVisibility(View.GONE);

			}
		});
		GoBackToCountryFromPhrase.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				CountryInformaition.setVisibility(View.VISIBLE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				CommonPhrases.setVisibility(View.GONE);

			}
		});
		Phrases.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				CommonPhrases.setVisibility(View.VISIBLE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				CountryInformaition.setVisibility(View.GONE);

			}
		});
		Gestures.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{
				
				ChooseGesture.setVisibility(View.VISIBLE);
				CountryInfo.setText(info.get(Countries.getSelectedItemPosition()).getDescription());
				CountryInformaition.setVisibility(View.GONE);

			}
		});

	}
	

}