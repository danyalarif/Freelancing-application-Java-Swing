package freelancePanda;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class Person implements Serializable{
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String languages[];
	private Date join;		//joining date
	private double balance;
	private static int totalAccounts = 0;
	public Person()
	{
		super();
	}
	public Person(String username, String password, String first, String last, String languages[])
	{
		this.languages = new String[3];
		this.username = username;
		this.password = password;
		this.firstName = first;
		this.lastName = last;
		if (languages == null)
		{
			this.languages = null;
		}
		else
		{
		for (int i = 0; i < languages.length;i++)
		{
			if (languages[i] == null)
				this.languages[i] = "none";
			else
				this.languages[i] = languages[i];
		}
		}
		this.balance = 0;
        int current_year,current_month,current_date;
        current_year = Calendar.getInstance().get(Calendar.YEAR);
        current_month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        current_date = Calendar.getInstance().get(Calendar.DATE);
		join = new Date(current_date, current_month, current_year);
		totalAccounts++;
	}
	public Person(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	public Person(Person other)		//copy constructor
	{
		this.languages = new String[3];
		this.username = other.username;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.password = other.password;
		this.balance = other.balance;
		this.join = new Date(other.join);
		for (int i = 0;i < other.languages.length;i++)
		{
			this.languages[i] = other.languages[i];
		}
	}
	public String toString()
	{
		return username + " " + password + " " + firstName + " " + lastName + " " + Arrays.toString(languages) + " " + balance;
	}
	//abstract methods
	public abstract void writeData();
	public abstract String getFileName();
	public void LoadPerson()
	{
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		Person p = r.LoadItem();
		Home home = new Home(p);
		home.setVisible(true);
	}
	public boolean validateLogin()		//i have done this so we dont have to do serialization just for reading/writing the login
	{
		boolean found = false;
		String user, pass;
		Scanner scan = null;
		File f = new File(getFileName());
		if (!(f.exists()))
		{
			JOptionPane.showMessageDialog(null, "No accounts exist!","Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		FileReader fin = null;
		try {
			fin = new FileReader(f);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		BufferedReader reader = new BufferedReader(fin);
		scan = new Scanner(reader);
		while(scan.hasNextLine())
		{
			user = scan.next();
			pass = scan.next();
			if (username.equals(user) && pass.equals(password))
				found = true;
			scan.nextLine();
		}
		scan.close();
		try {
			reader.close();
			fin.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if (found)
			return true;
		else
			return false;
	}
	public void writeLogin()
	{
		File f = new File(getFileName());
		FileWriter fout = null;
		try {
			fout = new FileWriter(f,true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		BufferedWriter writer = new BufferedWriter(fout);
		try {
			writer.write(username);
			writer.write(' ');
			writer.write(password);
			writer.write("\n");
			writer.flush();
			writer.close();
			fout.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	public boolean uniqueUserName()
	{
		boolean found = false;
		String user, pass;
		Scanner scan = null;
		File f = new File(getFileName());
		if (!(f.exists()))
			return true;
		FileReader fin = null;
		try {
			fin = new FileReader(f);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		BufferedReader reader = new BufferedReader(fin);
		scan = new Scanner(reader);
		while(scan.hasNextLine())
		{
			user = scan.next();
			pass = scan.next();
			if (username.equals(user))
				found = true;
			scan.nextLine();
		}
		scan.close();
		try {
			reader.close();
			fin.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if (!(found))
			return true;
		else
			return false;
	}
	public boolean validateUserName()
	{
		boolean flag1, flag2, flag3;
		flag1 = flag2 = flag3 = false;
		if (username.length() < 7)
			return false;
		for (int i = 0; i < username.length(); i++)
		{
			if ((username.charAt(i) >= 'A' && username.charAt(i) <= 'Z') || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z'))
				flag1 = true;
			else if (username.charAt(i) >= '0' && username.charAt(i) <= '9')
				flag2 = true;
			if (flag1 && flag2)
				return true;
		}
		return false;
	}
	public boolean validatePassword()
	{
		boolean flag1, flag2, flag3;
		flag1 = flag2 = flag3 = false;
		if (password.length() < 7)
			return false;
		for (int i = 0; i < password.length();i++)
		{
			if ((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') || (password.charAt(i) >= 'a' && password.charAt(i) <= 'z'))
				flag1 = true;
			else if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
				flag2 = true;
			else if ((password.charAt(i) >= '!' && password.charAt(i) <= '/') || (password.charAt(i) >= ':' && password.charAt(i) <= '@') || (password.charAt(i) >= '[' && password.charAt(i) <= '`') || (password.charAt(i) >= '{' && password.charAt(i) <= '~'))
				flag3 = true;
			if (flag1 && flag2 && flag3)
				return true;
		}
		return false;
	}
	public boolean validateFirstName()
	{
		if (firstName.length() <= 0)
		{
			return false;
		}
		for (int i = 0;i < firstName.length();i++)
		{
			if (!((firstName.charAt(i) >= 'A' && firstName.charAt(i) <= 'Z') || (firstName.charAt(i) >= 'a' && firstName.charAt(i) <= 'z')))
				return false;
		}
		return true;
	}
	public boolean validateLastName()
	{
		if (lastName.length() <= 0)
		{
			return false;
		}
		for (int i = 0;i < lastName.length();i++)
		{
			if (!((lastName.charAt(i) >= 'A' && lastName.charAt(i) <= 'Z') || (lastName.charAt(i) >= 'a' && lastName.charAt(i) <= 'z')))
				return false;
		}
		return true;
	}
	public String getUserName()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String[] getLanguages()
	{
		return languages;
	}
	public Date getDate()
	{
		return new Date(join);
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double amount)
	{
		balance = amount;
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public void setPassword(String password)
	{
		this.password = password;
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public void setFirstName(String name)
	{
		this.firstName = name;
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public void setLastName(String name)
	{
		this.lastName = name;
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public void setUserName(String name)
	{
		this.username = name;
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public void setLanguages(String langs[])
	{
		for (int i = 0;i < 3;i++)
		{
			if (langs[i] == null)
				this.languages[i] = "none";
			else
				this.languages[i] = langs[i];
		}
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.modifyPerson(this);
	}
	public static int getActiveAccounts()
	{
		return totalAccounts;
	}
}
