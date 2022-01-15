package freelancePanda;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class Orders extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem i1, i2, i3, i4, i5, i6;
	private Buyer buyer;
	private Seller seller;
	private JLabel label1;
	private JLabel label2;
	private JLabel lblSelectOrder;
	private JComboBox comboBox;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel ans1;
	private JLabel ans2;
	private JLabel ans3;
	private JLabel ans4;
	private JLabel ans5;
	private ArrayList<Request> rqsts;
	private JLabel label8;
	private JLabel ans6;
	private JButton button1;
	private JPanel contentPane2;
	private JTextField inp2;
	private JTextArea inp1;
	private JButton button2;
	private JLabel type;
	
	public Orders(Person p) {
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
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		type = new JLabel("New label");
		type.setOpaque(true);
		type.setForeground(Color.WHITE);
		type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		type.setBackground(Color.RED);
		contentPane.add(type, "cell 5 14");
		if (buyer == null)
		{
			type.setText("Seller Account");
		}
		else
		{
			type.setText("Buyer Account");
		}
		
		button1 = new JButton("Send Request");
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(255, 0, 0));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(button1, "cell 31 14,alignx center,aligny center");
		button1.addActionListener(this);
		
		if (buyer == null)
			button1.setVisible(false);
		
		label1 = new JLabel("Active Orders:");
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label1, "cell 5 26,aligny center");
			
		label2 = new JLabel("0");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label2, "cell 11 26,aligny center");
		
		lblSelectOrder = new JLabel("Select Order:");
		lblSelectOrder.setForeground(new Color(255, 255, 255));
		lblSelectOrder.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblSelectOrder, "cell 5 38");
		
		rqsts = null;
		Request r = new Request();
		if (buyer != null)
		{
			rqsts = r.searchActiveOrders(buyer);
		}
		else
		{
			rqsts = r.searchActiveOrders(seller);
		}
		String[] temp = null;
		if (rqsts.size() == 0)
		{
			temp = new String[1];
			temp[0] = "None";
		}
		else
		{
			temp = new String[rqsts.size()];
			label2.setText(Integer.toString(rqsts.size()));
			for (int i = 0;i < temp.length;i++)
			{
				temp[i] = "Order " + (i + 1);
			}
		}
		
		comboBox = new JComboBox(temp);
		comboBox.addActionListener(this);
		contentPane.add(comboBox, "cell 11 38,aligny center");
		
		label3 = new JLabel("Order#");
		label3.setBackground(new Color(255, 0, 0));
		label3.setForeground(new Color(255, 255, 255));
		label3.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label3.setOpaque(true);
		contentPane.add(label3, "cell 7 54,aligny center");
		
		label4 = new JLabel("Sent By");
		label4.setBackground(new Color(255, 0, 0));
		label4.setForeground(new Color(255, 255, 255));
		label4.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label4.setOpaque(true);
		contentPane.add(label4, "cell 11 54,aligny center");
		
		label5 = new JLabel("Accepted By");
		label5.setBackground(new Color(255, 0, 0));
		label5.setForeground(new Color(255, 255, 255));
		label5.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label5.setOpaque(true);
		contentPane.add(label5, "cell 16 54,aligny center");
		
		label6 = new JLabel("Price");
		label6.setBackground(new Color(255, 0, 0));
		label6.setForeground(new Color(255, 255, 255));
		label6.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label6.setOpaque(true);
		contentPane.add(label6, "cell 21 54,aligny center");
		
		label7 = new JLabel("Status");
		label7.setBackground(new Color(255, 0, 0));
		label7.setForeground(new Color(255, 255, 255));
		label7.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label7.setOpaque(true);
		contentPane.add(label7, "cell 26 54,aligny center");
		
		label8 = new JLabel("Date Created");
		label8.setBackground(new Color(255, 0, 0));
		label8.setForeground(new Color(255, 255, 255));
		label8.setFont(new Font("Sitka Display", Font.BOLD, 22));
		label8.setOpaque(true);
		contentPane.add(label8, "cell 31 54");
		
		ans1 = new JLabel("none");
		ans1.setForeground(new Color(255, 255, 255));
		ans1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans1, "cell 7 61,aligny center");
		
		ans2 = new JLabel("none");
		ans2.setForeground(new Color(255, 255, 255));
		ans2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans2, "cell 11 61,aligny center");
		
		ans3 = new JLabel("none");
		ans3.setForeground(new Color(255, 255, 255));
		ans3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans3, "cell 16 61,aligny center");
		
		ans4 = new JLabel("none");
		ans4.setForeground(new Color(255, 255, 255));
		ans4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans4, "cell 21 61,aligny center");
		
		ans5 = new JLabel("none");
		ans5.setForeground(new Color(255, 255, 255));
		ans5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans5, "cell 26 61,aligny center");
		
		ans6 = new JLabel("none");
		ans6.setForeground(new Color(255, 255, 255));
		ans6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(ans6, "cell 31 61,aligny center");
		
		if (rqsts.size() > 0)
		{
			ans1.setText(Integer.toString(1));
			ans2.setText(rqsts.get(0).getSender().getUserName());
			ans3.setText(rqsts.get(0).getSeller().getUserName());
			ans4.setText(Double.toString(rqsts.get(0).getPrice()));
			ans5.setText("In Progress");
			ans6.setText(rqsts.get(0).getDate().toString());
		}
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
		else if (title.equals("Send Request"))
		{
			contentPane.setVisible(false);
			screen2();
		}
		else if (title.equals("Send"))
		{
			String msg = inp1.getText().toString();
			String tempAmount = inp2.getText().toString();
			if (msg.length() < 7)
			{
				JOptionPane.showMessageDialog(null, "Description too short!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!(validateAmount(tempAmount)))
			{
				JOptionPane.showMessageDialog(null, "Invalid Amount!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			double amount = Double.parseDouble(tempAmount);
			Request r = new Request(buyer, msg, amount);
			r.writeRequest();
			contentPane2.setVisible(false);
			contentPane.setVisible(true);
			setContentPane(contentPane);
			JOptionPane.showMessageDialog(null, "Request Sent!","Success", JOptionPane.INFORMATION_MESSAGE);
		}
		JComboBox temp = null;
		if (e.getSource() instanceof JComboBox)
		{
			temp = (JComboBox)e.getSource();
			int index = temp.getSelectedIndex();
			ans1.setText(Integer.toString(index + 1));
			ans2.setText(rqsts.get(index).getSender().getUserName());
			ans3.setText(rqsts.get(index).getSeller().getUserName());
			ans4.setText(Double.toString(rqsts.get(index).getPrice()));
			ans5.setText("In Progress");
			ans6.setText(rqsts.get(index).getDate().toString());
		}
	}
	public void screen2()
	{
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(0, 0, 0));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setVisible(true);
		setContentPane(contentPane2);
		contentPane2.setLayout(new MigLayout("", "[][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel label1 = new JLabel("Request:");
		label1.setBackground(new Color(255, 0, 0));
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label1.setOpaque(true);
		contentPane2.add(label1, "cell 6 18,aligny center");
		
		inp1 = new JTextArea();
		inp1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		inp1.setBackground(new Color(250, 218, 221));
		inp1.setLineWrap(true);
		inp1.setColumns(20);
		contentPane2.add(inp1, "cell 9 18");
		
		JLabel label2 = new JLabel("Price:");
		label2.setBackground(new Color(255, 0, 0));
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label2.setOpaque(true);
		contentPane2.add(label2, "cell 6 27,aligny center");
		
		inp2 = new JTextField();
		inp2.setBackground(new Color(250, 218, 221));
		inp2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inp2.setColumns(4);
		contentPane2.add(inp2, "cell 9 27");
		
		button2 = new JButton("Send");
		button2.setForeground(new Color(255, 255, 255));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button2.setBackground(new Color(255, 0, 0));
		button2.addActionListener(this);
		contentPane2.add(button2, "cell 7 40,aligny center");
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
