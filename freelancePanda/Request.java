package freelancePanda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Request implements Serializable{
	private String request;
	private double price;
	private Buyer sender;
	private Seller reciever;
	private Date created;
	private boolean accepted;
	private ArrayList<Request> requests;
	public Request()
	{
		requests = new ArrayList<Request>();
	}
	public Request(Buyer buyer, String request, double price)
	{
		requests = new ArrayList<Request>();
		this.sender = buyer;
		this.request = request;
		this.price = price;
		accepted = false;
        int current_year,current_month,current_date;
        current_year = Calendar.getInstance().get(Calendar.YEAR);
        current_month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        current_date = Calendar.getInstance().get(Calendar.DATE);
		created = new Date(current_date, current_month, current_year);
	}
	public void readRequest()
	{
		ArrayList<Request> temp = null;
		File f = new File("requests.txt");
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
			temp = (ArrayList<Request>)objin.readObject();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		for (int i = 0;i < temp.size();i++)
		{
			requests.add(temp.get(i));
		}
	}
	public void writeRequest()
	{
		requests.add(this);
		readRequest();
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("requests.txt");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ObjectOutputStream objout = null;
		try {
			objout = new ObjectOutputStream(fout);
			objout.writeObject(requests);
			objout.close();
			fout.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	public ArrayList<Request> searchActiveOrders(Buyer b) 	//to get all active orders
	{
		ArrayList<Request> rqst = new ArrayList<Request>();
		readRequest();
		for (int i = 0;i < requests.size();i++)
		{
			if (requests.get(i).sender != null && requests.get(i).sender.getUserName().equals(b.getUserName()) && requests.get(i).accepted)
			{
				rqst.add(requests.get(i));
			}
		}
		return rqst;
	}
	public ArrayList<Request> searchActiveOrders(Seller s)
	{
		ArrayList<Request> rqst = new ArrayList<Request>();
		readRequest();
		for (int i = 0;i < requests.size();i++)
		{
			if (requests.get(i).reciever != null && requests.get(i).reciever.getUserName().equals(s.getUserName()) && requests.get(i).accepted)
			{
				rqst.add(requests.get(i));
			}
		}
		return rqst;
	}
	public ArrayList<Request> searchActiveRequests()
	{
		ArrayList<Request> rqst = new ArrayList<Request>();
		readRequest();
		for (int i = 0;i < requests.size();i++)
		{
			if (!(requests.get(i).accepted))
			{
				rqst.add(requests.get(i));
			}
		}
		return rqst;
	}
	public void completeOrder(Buyer b, Seller s, String description)
	{
		readRequest();
		for (int i = 0;i < requests.size();i++)
		{
			if (requests.get(i).accepted && requests.get(i).getSender().getUserName().equals(b.getUserName()) && requests.get(i).getSeller().getUserName().equals(s.getUserName()) && description.equals(requests.get(i).getMessage()))
			{
				requests.remove(i);
				updateRequest();
				break;
			}
		}
	}
	public void updateRequest()
	{
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("requests.txt");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ObjectOutputStream objout = null;
		try {
			objout = new ObjectOutputStream(fout);
			objout.writeObject(requests);
			objout.close();
			fout.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fatal Error!Aborting!","Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	public void modifyRequest(Request o)
	{
		readRequest();
		for (int i = 0;i < requests.size();i++)
		{
			Request r = requests.get(i);
			if (o.getSender().getUserName().equals(r.getSender().getUserName()) && o.getMessage().equals(r.getMessage()))
			{
				requests.set(i, o);
				this.updateRequest();
				return;
			}
		}
	}
	public Buyer getSender()
	{
		return new Buyer(sender);	//deep copy
	}
	public Seller getSeller()
	{
		return new Seller(reciever);
	}
	public double getPrice()
	{
		return price;
	}
	public Date getDate()
	{
		return new Date(created);
	}
	public void setSeller(Seller s)
	{
		reciever = new Seller(s);
	}
	public void setAccepted(boolean flag)
	{
		accepted = flag;
	}
	public String getMessage()
	{
		return this.request;
	}
	public void acceptRequest(Request r, Seller s)
	{
		r.reciever = new Seller(s);
		r.accepted = true;
		modifyRequest(r);
	}
}
