package freelancePanda;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;

public class Payments extends JFrame implements ActionListener{
	private Buyer buyer;
	private Seller seller;
	private JPanel contentPane, contentPane1, contentPane2;
	private JTextField textField, textField2;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem i1, i2, i3, i4, i5, i6;
	private JButton button1, button2;
	private JButton button3;
	private JComboBox comboBox;
	private JLabel label2;
	private JLabel label4;
	private JLabel label5;
	private String[] descriptions;
	private JLabel labelHead;
	private JLabel ans;
	private ArrayList<Request> orders;
	private JLabel type;
	private JButton buttondone;

	public Payments(Person p) {
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
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		i1 = new JMenuItem("Home");
		i2 = new JMenuItem("Profile");
		i3 = new JMenuItem("Orders");
		i4 = new JMenuItem("Payments");
		i5 = new JMenuItem("Requests");
		i6 = new JMenuItem("Logout");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.add(i5);
		menu.add(i6);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		if (seller == null)
			i5.setVisible(false);
		screen0();
	}
	public void screen0()
	{
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		type = new JLabel("New label");
		type.setOpaque(true);
		type.setForeground(Color.WHITE);
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBackground(Color.RED);
		contentPane.add(type, "cell 3 8");
		if (buyer == null)
		{
			type.setText("Seller Account");
		}
		else
		{
			type.setText("Buyer Account");
		}
		labelHead = new JLabel("Balance:");
		labelHead.setForeground(Color.WHITE);
		labelHead.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		contentPane.add(labelHead, "cell 65 8,alignx center,aligny center");
		
		ans = new JLabel("New label");
		ans.setOpaque(true);
		ans.setForeground(Color.RED);
		ans.setFont(new Font("Monospaced", Font.PLAIN, 18));
		ans.setBackground(new Color(250, 218, 221));
		contentPane.add(ans, "cell 69 8,alignx center,aligny center");
		if (buyer == null)
		{
			ans.setText(Double.toString(seller.getBalance()) + " dollars");
		}
		else
		{
			ans.setText(Double.toString(buyer.getBalance()) + " dollars");
		}
		button1 = new JButton("Deposit");
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(255, 0, 0));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(button1, "cell 43 34,alignx center,aligny center");
		button1.addActionListener(this);
		
		button2 = new JButton("Pay Seller");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button2.setBackground(new Color(255, 0, 0));
		button2.setForeground(new Color(255, 255, 255));
		contentPane.add(button2, "cell 43 41,alignx center,aligny center");
		button2.addActionListener(this);
		
		button3 = new JButton("Withdraw");
		button3.setBackground(new Color(255, 0, 0));
		button3.setForeground(new Color(255, 255, 255));
		button3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(button3, "cell 43 48,alignx center,aligny center");
		button3.addActionListener(this);
		if (buyer == null)
		{
			button1.setVisible(false);
			button2.setVisible(false);
		}
	}
	public void screen1()
	{
		contentPane.setVisible(false);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(0, 0, 0));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		JLabel label1 = new JLabel("Amount:");
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		contentPane1.add(label1, "cell 19 28,aligny center");
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 218, 221));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane1.add(textField, "cell 22 28,aligny center");
		textField.setColumns(10);
		
	    buttondone = new JButton("Done");
		buttondone.setBackground(new Color(255, 0, 0));
		buttondone.setForeground(new Color(255, 255, 255));
		buttondone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane1.add(buttondone, "cell 22 38,alignx center,aligny center");
		buttondone.addActionListener(this);
		
		labelHead = new JLabel("Balance:");
		labelHead.setForeground(Color.WHITE);
		labelHead.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		contentPane1.add(labelHead, "cell 64 8,alignx center,aligny center");
		
		ans = new JLabel("New label");
		ans.setOpaque(true);
		ans.setForeground(Color.RED);
		ans.setFont(new Font("Monospaced", Font.PLAIN, 18));
		ans.setBackground(new Color(250, 218, 221));
		contentPane1.add(ans, "cell 68 8,alignx center,aligny center");
		if (buyer == null)
		{
			ans.setText(Double.toString(seller.getBalance()) + " dollars");
		}
		else
		{
			ans.setText(Double.toString(buyer.getBalance()) + " dollars");
		}
		
		type = new JLabel("New label");
		type.setOpaque(true);
		type.setForeground(Color.WHITE);
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBackground(Color.RED);
		contentPane1.add(type, "cell 3 8");
		if (buyer == null)
		{
			type.setText("Seller Account");
		}
		else
		{
			type.setText("Buyer Account");
		}
	}
	public void screen2()
	{
		contentPane.setVisible(false);
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(0, 0, 0));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		label5 = new JLabel("None");
		label5.setForeground(new Color(255, 255, 255));
		label5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane2.add(label5, "cell 24 43,alignx center,aligny center");
		
		label2 = new JLabel("Select Seller:");
		label2.setBackground(new Color(255, 0, 0));
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label2.setOpaque(true);
		contentPane2.add(label2, "cell 13 33");
		
		label4 = new JLabel("Order Description:");
		label4.setBackground(new Color(255, 0, 0));
		label4.setForeground(new Color(255, 255, 255));
		label4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label4.setOpaque(true);
		contentPane2.add(label4, "cell 13 43");
		
		JLabel label3 = new JLabel("Amount:");
		label3.setBackground(new Color(255, 0, 0));
		label3.setForeground(new Color(255, 255, 255));
		label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label3.setOpaque(true);
		contentPane2.add(label3, "cell 13 56,aligny center");
		
		textField2 = new JTextField();
		textField2.setBackground(new Color(250, 218, 221));
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane2.add(textField2, "cell 24 56,alignx center,aligny center");
		textField2.setColumns(10);

		JButton buttonsend = new JButton("Send");
		buttonsend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonsend.setForeground(new Color(255, 255, 255));
		buttonsend.setBackground(new Color(255, 0, 0));
		contentPane2.add(buttonsend, "cell 24 67,alignx center,aligny center");
		buttonsend.addActionListener(this);
		
		labelHead = new JLabel("Balance:");
		labelHead.setForeground(Color.WHITE);
		labelHead.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		contentPane2.add(labelHead, "cell 64 8,alignx center,aligny center");
		
		ans = new JLabel("New label");
		ans.setOpaque(true);
		ans.setForeground(Color.RED);
		ans.setFont(new Font("Monospaced", Font.PLAIN, 18));
		ans.setBackground(new Color(250, 218, 221));
		contentPane2.add(ans, "cell 68 8,alignx center,aligny center");
		if (buyer == null)
		{
			ans.setText(Double.toString(seller.getBalance()) + " dollars");
		}
		else
		{
			ans.setText(Double.toString(buyer.getBalance()) + " dollars");
		}
		Request r = new Request();
		orders = r.searchActiveOrders(buyer);
		Seller[] sellers = new Seller[orders.size()];
		descriptions = new String[orders.size()];
		for (int i = 0;i < sellers.length;i++)
		{
			sellers[i] = orders.get(i).getSeller();
			descriptions[i] = orders.get(i).getMessage();
		}
		String names[] = null;
		if (sellers.length > 0)
		{
			names = new String[sellers.length];
			for (int i = 0;i < sellers.length;i++)
			{
				names[i] = sellers[i].getUserName();
			}
			comboBox = new JComboBox(names);
			label5.setText(descriptions[0]);
		}
		else
		{
			String n[] = {"None"};
			comboBox = new JComboBox(n);
		}
		contentPane2.add(comboBox, "cell 24 33,aligny center");
		comboBox.addActionListener(this);
		type = new JLabel("New label");
		type.setOpaque(true);
		type.setForeground(Color.WHITE);
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBackground(Color.RED);
		contentPane2.add(type, "cell 3 8");
		if (buyer == null)
		{
			type.setText("Seller Account");
		}
		else
		{
			type.setText("Buyer Account");
		}
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
		else if (title.equals("Deposit"))
		{
			screen1();
		}
		else if (title.equals("Withdraw"))
		{
			screen1();
			buttondone.setText("Get");
		}
		else if (title.equals("Pay Seller"))
		{
			screen2();
		}
		else if (title.equals("Done"))
		{
			String am = textField.getText().toString();
			boolean valid = validateAmount(am);
			if (!(valid))
			{
				JOptionPane.showMessageDialog(null, "Invalid amount!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double amount = Double.parseDouble(am);
			if (buyer != null)
			{
				buyer.setBalance(buyer.getBalance() + amount);
			}
			else
			{
				seller.setBalance(seller.getBalance() + amount);
			}
			JOptionPane.showMessageDialog(null, "Deposit successfull!","Success", JOptionPane.INFORMATION_MESSAGE);
			screen0();
		}
		else if (title.equals("Get"))
		{
			String am = textField.getText().toString();
			boolean valid = validateAmount(am);
			if (!(valid))
			{
				JOptionPane.showMessageDialog(null, "Invalid amount!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double amount = Double.parseDouble(am);
			if (buyer != null)
			{
				if (amount <= buyer.getBalance())
					buyer.setBalance(buyer.getBalance() - amount);
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient balance!","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else
			{
				if (amount <= seller.getBalance())
					seller.setBalance(seller.getBalance() - amount);
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient balance!","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Withdraw successfull!","Success", JOptionPane.INFORMATION_MESSAGE);
			screen0();
		}
		else if (title.equals("Send"))
		{
			if (orders.size() == 0)
			{
				JOptionPane.showMessageDialog(null, "No sellers found!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String am = textField2.getText().toString();
			boolean valid = validateAmount(am);
			if (!(valid))
			{
				JOptionPane.showMessageDialog(null, "Invalid amount!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double amount = Double.parseDouble(am);
			String user = (String)comboBox.getSelectedItem();
			ReadingWritingPerson r = new ReadingWritingPerson("sellers.txt");
			Seller s = (Seller)r.searchPerson(user);
			if (buyer.getBalance() >= amount)
			{
				buyer.setBalance(buyer.getBalance() - amount);
				s.setBalance(s.getBalance() + amount);
				String desc = descriptions[comboBox.getSelectedIndex()];
				Request rq = new Request();
				rq.completeOrder(buyer, s, desc);
				JOptionPane.showMessageDialog(null, "Order completed!","Success",JOptionPane.INFORMATION_MESSAGE);
				screen0();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Insufficient balance!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		JComboBox temp = null;
		if (e.getSource() instanceof JComboBox)
		{
			temp = (JComboBox)e.getSource();
			label5.setText(descriptions[temp.getSelectedIndex()]);
		}
	}
	private boolean validateAmount(String amount)
	{
		for (int i = 0;i < amount.length();i++)
		{
			if (!(amount.charAt(i) >= '0' && amount.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
}
