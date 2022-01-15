package freelancePanda;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class Home extends JFrame implements ActionListener{
	private Buyer buyer;
	private Seller seller;
	private JPanel contentPane;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JLabel lblNewLabel;
	private JLabel type;


	public Home(Person p) 
	{
		if (p instanceof Buyer)
		{
			buyer = (Buyer)p;
			seller = null;
		}
		else
		{
			seller = (Seller)p;
			buyer = null;
		}
		setTitle("Freelance Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		button1 = new JButton("Home");
		button1.setForeground(new Color(255, 0, 0));
		button1.setBackground(new Color(250, 218, 221));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button1.addActionListener(this);
		contentPane.add(button1, "cell 0 0,alignx right");
		
		button2 = new JButton("Profile");
		button2.setForeground(Color.RED);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button2.setBackground(new Color(250, 218, 221));
		button2.addActionListener(this);
		contentPane.add(button2, "cell 1 0,alignx left");
		
		button3 = new JButton("Orders");
		button3.setForeground(Color.RED);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button3.setBackground(new Color(250, 218, 221));
		button3.addActionListener(this);
		contentPane.add(button3, "cell 2 0,alignx left");
		
		button4 = new JButton("Payments");
		button4.setForeground(Color.RED);
		button4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button4.setBackground(new Color(250, 218, 221));
		button4.addActionListener(this);
		contentPane.add(button4, "cell 3 0,alignx right");
		
		button5 = new JButton("Logout");
		button5.setForeground(Color.RED);
		button5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button5.setBackground(new Color(250, 218, 221));
		button5.addActionListener(this);
		contentPane.add(button5, "cell 4 0,alignx right");
		
		button6 = new JButton("Requests");
		button6.setForeground(Color.RED);
		button6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button6.setBackground(new Color(250, 218, 221));
		button6.addActionListener(this);
		contentPane.add(button6, "cell 5 0,alignx right");
		
		lblNewLabel = new JLabel("FREELANCE PANDA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lblNewLabel, "cell 0 8,alignx left");
		
		type = new JLabel("New label");
		type.setBackground(new Color(255, 0, 0));
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setForeground(new Color(255, 255, 255));
		type.setOpaque(true);
		contentPane.add(type, "cell 0 14,alignx left,aligny center");
		
		if (buyer == null)
		{
			type.setText("Seller Account");
		}
		else
		{
			type.setText("Buyer Account");
		}
		label1 = new JLabel("User name");
		label1.setBackground(new Color(255, 0, 0));
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		contentPane.add(label1, "cell 0 19,alignx center,aligny center");
		label1.setOpaque(true);
		label1.setText(p.getUserName());
		
		label2 = new JLabel("New label");
		label2.setForeground(new Color(255, 255, 255));
		label2.setBackground(new Color(255, 0, 0));
		label2.setOpaque(true);
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(label2, "cell 0 53");
		
		String s = "";
		if (buyer != null)
		{
			label2.setText("Available Sellers");
			ReadingWritingPerson r = new ReadingWritingPerson("sellers.txt");
			Seller[] sellers = r.getSellers();
			for (int i = 0;i < sellers.length;i++)
			{
				if (i != 0)
					s += ", ";
				s += sellers[i].getUserName();
			}
		}
		else
		{
			label2.setText("Available Buyers");
			ReadingWritingPerson r = new ReadingWritingPerson("buyers.txt");
			Buyer[] buyers = r.getBuyers();
			for (int i = 0;i < buyers.length;i++)
			{
				if (i != 0)
					s += ", ";
				s += buyers[i].getUserName();
			}
		}
		label3 = new JLabel("New label");
		label3.setForeground(new Color(255, 255, 255));
		label3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contentPane.add(label3, "cell 0 56");
		label3.setText(s);
		if (seller == null)
			button6.setVisible(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		Person p = null;
		if (buyer != null)
		{
			p = buyer;
		}
		else
		{
			p = seller;
		}
		String title = e.getActionCommand();
		if (title.equals("Home"))
		{
			setVisible(false);
			Home home = new Home(p);
			home.setVisible(true);
		}
		else if (title.equals("Profile"))
		{
			setVisible(false);
			Profile pf = new Profile(p);
			pf.setVisible(true);
		}
		else if (title.equals("Orders"))
		{
			setVisible(false);
			Orders o = new Orders(p);
			o.setVisible(true);
		}
		else if (title.equals("Payments"))
		{
			setVisible(false);
			Payments pay = new Payments(p);
			pay.setVisible(true);
		}
		else if (title.equals("Requests"))
		{
			setVisible(false);
			ViewRequests view = new ViewRequests(seller);
			view.setVisible(true);
		}
		else if (title.equals("Logout"))
		{
			setVisible(false);
			Main mn = new Main(false);
			mn.setVisible(true);
		}
	}
}
