package freelancePanda;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Main extends JFrame implements ActionListener{
	private Person p;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField textField1;
	private JButton button1;
	private JButton loginButton;
	private JButton signupButton;
	private Buyer buyer;
	private Seller seller;
	private JPasswordField passwordField;
	private boolean b;
	private JLabel lblNewLabel;
	private JLabel type;
	private JButton forgotButton, button2;
	private JLabel label3, label2, label1;
	
	public static void main(String[] args) 
	{
		Main frame = new Main(false);
		frame.setVisible(true);
	}

	public Main(boolean b) {
		this.b = b;
		setTitle("Freelance Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		setContentPane(contentPane);
		
		button1 = new JButton("Login as Buyer");
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(255, 0, 0));
		button1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		button1.addActionListener(this);
		
		lblNewLabel = new JLabel("FREELANCE PANDA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel, "cell 22 13,alignx center,aligny center");
		button1.setFocusable(false);
		contentPane.add(button1, "cell 22 45,alignx center,aligny center");
		button2 = new JButton("Login as Seller");
		button2.setForeground(new Color(255, 255, 255));
		button2.setBackground(new Color(255, 0, 0));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		button2.addActionListener(this);
		button2.setFocusable(false);
		contentPane.add(button2, "cell 22 56,alignx center,aligny center");
		screen2();

	}
	public void actionPerformed(ActionEvent e)
	{
		String title = e.getActionCommand();
		if (title.equals("Login as Buyer"))
		{
			b = true;
			contentPane.setVisible(false);
			contentPane2.setVisible(true);
			setContentPane(contentPane2);
			type.setText("Buyer Login");
		}
		if (title.equals("Login as Seller"))
		{
			contentPane.setVisible(false);
			contentPane2.setVisible(true);
			setContentPane(contentPane2);
			type.setText("Seller Login");
		}
		else if (title.equals("Sign Up"))
		{
			contentPane2.setVisible(false);
			setVisible(false);				//set frame false
			Registration reg = new Registration(b);
			reg.setVisible(true);
		}
		else if (title.equals("Login"))
		{
			boolean res;
			String user, pass;
			user = textField1.getText().toString();
			pass = new String(passwordField.getPassword());
			if (b)
			{
				buyer = new Buyer(user, pass);
				res = buyer.validateLogin();
				if (res)
				{
					setVisible(false);
					buyer.LoadPerson();
				}
				else
					JOptionPane.showMessageDialog(this, "Invalid Username or Password!","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				seller = new Seller(user,pass);
				res = seller.validateLogin();
				if (res)
				{
					setVisible(false);
					seller.LoadPerson();
				}
				else
					JOptionPane.showMessageDialog(this, "Invalid Username or Password!","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (title.equals("Click here"))
		{
			textField1.setText("");
			label2.setVisible(false);
			label3.setVisible(false);
			passwordField.setVisible(false);
			signupButton.setVisible(false);
			loginButton.setText("Search");
			forgotButton.setText("Go back");
			JOptionPane.showMessageDialog(this, "Enter your username!","Info", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (title.equals("Search"))
		{
			String user = textField1.getText().toString();
			ReadingWritingPerson r = null;
			if (b)
				r = new ReadingWritingPerson("buyers.txt");
			else
				r = new ReadingWritingPerson("sellers.txt");
			p = r.searchPerson(user);
			if (p == null)
			{
				JOptionPane.showMessageDialog(this, "Username not found!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			textField1.setText("");
			JOptionPane.showMessageDialog(this, "Enter your new password!","Success", JOptionPane.INFORMATION_MESSAGE);
			label1.setText("Password");
			loginButton.setText("Save");
		}
		else if (title.equals("Go back"))
		{
			setVisible(false);
			Main m = new Main(b);
			m.setVisible(true);
			m.setScreen2();
		}
		else if (title.equals("Save"))
		{
			String pass = textField1.getText().toString();
			Person temp = new Buyer("None",pass);
			boolean res = temp.validatePassword();
			if (!(res))
			{
				JOptionPane.showMessageDialog(this, "Invalid Password!Create a strong password!","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (b)
				buyer.setPassword(pass);
			else
				seller.setPassword(pass);
			setVisible(false);
			Main m = new Main(b);
			m.setVisible(true);
			m.setScreen2();
			JOptionPane.showMessageDialog(this, "Password updated successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void screen2()
	{
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(0, 0, 0));
		contentPane2.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][grow][][grow][][][][][][][][][][][][pref!,grow,center][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		type = new JLabel("New label");
		type.setBackground(new Color(255, 0, 0));
		type.setForeground(new Color(255, 255, 255));
		type.setFont(new Font("Tahoma", Font.PLAIN, 20));
		type.setOpaque(true);
		contentPane2.add(type, "cell 16 15,alignx center,aligny center");
		//setContentPane(contentPane2);
		
		label1 = new JLabel("Username:");
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(label1, "cell 13 31,alignx right");
		
		textField1 = new JTextField();
		textField1.setBackground(new Color(250, 218, 221));
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField1.setColumns(10);
		contentPane2.add(textField1, "cell 17 31,alignx center,aligny center");
		
		label2 = new JLabel("Password:");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(label2, "cell 13 41,alignx right");
		
		loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 0, 0));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(250, 218, 221));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setColumns(10);
		contentPane2.add(passwordField, "cell 17 41,alignx center,aligny center");
		contentPane2.add(loginButton, "cell 16 54,alignx center,aligny center");
		
		signupButton = new JButton("Sign Up");
		signupButton.setForeground(new Color(255, 255, 255));
		signupButton.setBackground(new Color(255, 0, 0));
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(this);
		contentPane2.add(signupButton, "cell 16 64,alignx center,aligny center");
		
		label3 = new JLabel("Forgot Password?");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane2.add(label3, "cell 13 74");
		
		forgotButton = new JButton("Click here");
		forgotButton.setForeground(Color.WHITE);
		forgotButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		forgotButton.setBackground(Color.RED);
		contentPane2.add(forgotButton, "cell 13 80,alignx center,aligny center");
		forgotButton.addActionListener(this);
		if (b)
		{
			type.setText("Buyer Login");
		}
		else
		{
			type.setText("Seller Login");
		}
	}
	public void setScreen2()
	{
		screen2();
		setContentPane(contentPane2);
	}
}
