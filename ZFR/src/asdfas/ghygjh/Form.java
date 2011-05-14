package asdfas.ghygjh;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Form extends Activity 
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		countryCulture countryInfo = new countryCulture("sdfs "," asdf","sdf ");
		
		LinearLayout MainContainer = (LinearLayout) findViewById(R.id.MainLayout);
		FrameLayout StackContainer = (FrameLayout) findViewById(R.id.Container);
		

		AbsoluteLayout ChooseACountry = (AbsoluteLayout) findViewById(R.id.ChooseACountry);
		final AbsoluteLayout CountryInformaition = (AbsoluteLayout) findViewById(R.id.CountryInformaition);
		AbsoluteLayout CommonPhrases = (AbsoluteLayout) findViewById(R.id.CommonPhrases);
		AbsoluteLayout ChooseGesture = (AbsoluteLayout) findViewById(R.id.ChooseGesture);
		AbsoluteLayout ViewGestureInformation = (AbsoluteLayout) findViewById(R.id.ViewGestureInformation);

		Button PreviousCountry = (Button) findViewById(R.id.PreviousCountry);
		Button NextCountry = (Button) findViewById(R.id.NextCountry);
		Button GoBackToCountry = (Button) findViewById(R.id.GoBackToCountry);
		Button GoBackToCountryFromGesture = (Button) findViewById(R.id.GoBackToCountryFromGesture);
		Button PreviousGesture = (Button) findViewById(R.id.PreviousGesture);
		Button NextGesture = (Button) findViewById(R.id.NextGesture);
		final Spinner Countries = (Spinner) findViewById(R.id.Countries);
		Spinner Gestures = (Spinner) findViewById(R.id.Gestures);
		TextView CountryInfo = (TextView) findViewById(R.id.CountryInfo);
		TextView CommonPhrasesInfo = (TextView) findViewById(R.id.CommonPhrasesInfo);
		TextView GestureName = (TextView) findViewById(R.id.GestureName);
		TextView GestureInformation = (TextView) findViewById(R.id.GestureInformation);
		TextView countryName = (TextView) findViewById(R.id.countryName);
		ImageView CountryPicture = (ImageView) findViewById(R.id.CountryImage);
		ImageView GesturePicture = (ImageView) findViewById(R.id.GestureImage);

		
		
		
		
		
		CountryInfo.setText(countryInfo.getDescription());
		CountryPicture.setImageDrawable(
				Drawable.createFromPath(countryInfo.getPicturePath()));
		countryName.setText(countryInfo.getName());
		CountryInformaition.setVisibility(View.GONE);
		CommonPhrases.setVisibility(View.GONE);
		ChooseGesture.setVisibility(View.GONE);
		ViewGestureInformation.setVisibility(View.GONE);
		ArrayAdapter <CharSequence> adapter =
			  new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//ArrayAdapter adapter = new ArrayAdapter(this, 1);
		for(int i = 0; i<10; i++)
		{
			//TextView text = new TextView(this);
			//text.setText("sdfahghebshf");
			
			adapter.add(countryInfo.getName());
			
		}
		Countries.setAdapter(adapter);
		
	/*	Countries.setOnItemSelectedListener(new this.onItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				// TODO Auto-generated method stub
				
			}
			public void onNothingSelected(AdapterView<?> parentView)
			{
				
			}
		});*/
		
		
		PreviousCountry.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) 
			{

			}
		});

	}

}