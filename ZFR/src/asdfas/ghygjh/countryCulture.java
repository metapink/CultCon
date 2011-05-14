/**
 * 
 */
package asdfas.ghygjh;

/**
 * @author BASSman
 *
 */
public class countryCulture 
{
	
	private String countryName;
	private String picturePathName;
	private String theDescription;
	public countryCulture( String countryN,
			String description,  String picturePath)
	{
		countryName = countryN;
		theDescription = description;		
		picturePathName = picturePath;	
				
	}
	public String getDescription()
	{
		return theDescription;
	}
	public String getName()
	{
		return countryName;
	}
	public String getPicturePath()
	{
		return picturePathName;
	}
	


}
