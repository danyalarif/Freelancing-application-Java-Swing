package freelancePanda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import files.Account;

public class ReadingWritingPerson {
	private Buyer buyer;
	private Seller seller;
	private String fname;
	private ArrayList<Person> persons;
	public ReadingWritingPerson(String fname)
	{
		this.fname = fname;
		persons = new ArrayList<Person>();
	}
	public ReadingWritingPerson(Person p)
	{
		persons = new ArrayList<Person>();
		if (p instanceof Buyer)
		{
			buyer = (Buyer)p;
			seller = null;
			fname = "buyers.txt";
		}
		else
		{
			seller = (Seller)p;
			buyer = null;
			fname = "sellers.txt";
		}
	}
	public Person LoadItem()
	{
		readPerson();
		Person p;
		if (buyer != null)
			p = buyer;
		else
			p = seller;
		for (int i = 0;i < persons.size();i++)
		{
			if (persons.get(i).getUserName().equals(p.getUserName()) && persons.get(i).getPassword().equals(p.getPassword()))
				p = persons.get(i);
		}
		if (buyer != null)
			buyer = (Buyer)p;
		else
			seller = (Seller)p;
		return p;
	}
	public void writePerson()
	{
		if (buyer != null)
			persons.add(buyer);
		else
			persons.add(seller);
		readPerson();
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fname);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ObjectOutputStream objout = null;
		try {
			objout = new ObjectOutputStream(fout);
			objout.writeObject(persons);
			objout.close();
			fout.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	public void readPerson()
	{
		ArrayList<Person> temp = null;
		Person p = null;
		File f = new File(fname);
		if (!(f.exists()))
			return;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ObjectInputStream objin;
		try {
			objin = new ObjectInputStream(fin);
			temp = (ArrayList<Person>)objin.readObject();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		for (int i = 0;i < temp.size();i++)
		{
			persons.add(temp.get(i));
		}
	}
	public Person searchPerson(String user)
	{
		readPerson();
		if (persons.size() == 0)
		{
			return null;
		}
		for (int i = 0;i < persons.size();i++)
		{
			Person p = null;
			if (persons.get(i) instanceof Buyer)
				p = (Buyer)persons.get(i);
			else
				p = (Seller)persons.get(i);
			if (p.getUserName().equals(user))
				return p;
		}
		return null;
	}
	private void updatePerson()
	{
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fname);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ObjectOutputStream objout = null;
		try {
			objout = new ObjectOutputStream(fout);
			objout.writeObject(persons);
			objout.close();
			fout.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	public void modifyPerson(Person o)
	{
		readPerson();
		Person p = null;
		Person temp = null;
		if (o instanceof Buyer)
		{
			p = (Buyer)o;
		}
		else
		{
			p = (Seller)o;
		}
		for (int i = 0;i < persons.size();i++)
		{
			if (persons.get(i) instanceof Buyer)
				temp = (Buyer)persons.get(i);
			else
				temp = (Seller)persons.get(i);
			if (temp.getUserName().equals(p.getUserName()))
			{
				persons.set(i, p);
				this.updatePerson();
				return;
			}
		}
	}
	public Seller[] getSellers()
	{
		int count = 0;
		readPerson();
		if (persons == null)
			return null;
		for (int i = 0;i < persons.size();i++)
		{
			if (persons.get(i) instanceof Seller)
				count++;
		}
		Seller[] sellers = new Seller[count];
		int i = 0;
		while (i < sellers.length)
		{
			if (persons.get(i) instanceof Seller)
			{
				sellers[i] = (Seller)persons.get(i);
				i++;
			}
		}
		return sellers;
	}
	public Buyer[] getBuyers()
	{
		int count = 0;
		readPerson();
		if (persons == null)
			return null;
		for (int i = 0;i < persons.size();i++)
		{
			if (persons.get(i) instanceof Buyer)
				count++;
		}
		Buyer[] buyers = new Buyer[count];
		int i = 0;
		while (i < buyers.length)
		{
			if (persons.get(i) instanceof Buyer)
			{
				buyers[i] = (Buyer)persons.get(i);
				i++;
			}
		}
		return buyers;
	}
}
