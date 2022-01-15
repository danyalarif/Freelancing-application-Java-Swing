package freelancePanda;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Buyer extends Person{
	public Buyer()
	{
		super();
	}
	public Buyer(String username, String password, String first, String last, String languages[])
	{
		super(username, password,first,last,languages);
	}
	public Buyer(String user, String pass)
	{
		super(user, pass);
	}
	public Buyer(Buyer other)
	{
		super(other);
	}
	@Override
	public void writeData()
	{
		ReadingWritingPerson r = new ReadingWritingPerson(this);
		r.writePerson();
		this.writeLogin();
	}
	@Override
	public String getFileName()
	{
		return "buyersLogins.txt";
	}
}
