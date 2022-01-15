package freelancePanda;
import java.io.Serializable;

public class Date implements Serializable{
	private int day;
	private int month;
	private int year;
	public Date()
	{
		day = 1;
		month = 1;
		year = 2000;
	}
	public Date(int day, int month, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public Date(Date other)
	{
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public String toString()		//newly created toString
	{	
		return String.format("%d/%d/%d", day, month, year);
	}
}
