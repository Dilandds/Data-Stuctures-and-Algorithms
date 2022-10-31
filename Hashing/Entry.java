//class to hold value and key
public class Entry{
	private int key;
	private String value;

	public Entry ( int key, String value){ //constructor
       this.key = key;
       this .value=value;

	}
	public int getKey(){ //to get the key
       return key;
	}
	public String getValue(){ //to get the value
	   return value;
	}

} 