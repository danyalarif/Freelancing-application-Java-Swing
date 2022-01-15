package freelancePanda;


public class Seller extends Person{
	private String degree;
	private int insituteType;	//0 for none 1 for high school 2 for college
	private String insitute;
	private String skills[];
	private String description;
	public Seller()
	{
		super();
	}
	public Seller(String username, String password, String first, String last, String languages[], String degree, int insituteType, String insitute, String skills[], String descp)
	{
		super(username, password, first, last, languages);
		this.degree = degree;
		this.insituteType = insituteType;
		this.insitute = insitute;
		this.skills = new String[skills.length];
		for (int i = 0;i < this.skills.length;i++)
		{
			if (skills[i] == null)
				break;
			else
				this.skills[i] = skills[i];
		}
		this.description = descp;
	}
	public Seller(String username, String password)
	{
		super(username, password);
	}
	public Seller(Seller other)
	{
		super(other);
		this.skills = new String[3];
		this.degree = other.degree;
		this.description = other.description;
		this.insitute = other.insitute;
		this.insituteType = other.insituteType;
		for (int i = 0;i < this.skills.length;i++)
		{
			this.skills[i] = other.skills[i];
		}
	}
	public String getDegree()
	{
		return degree;
	}
	public int getInsituteType()
	{
		return insituteType;
	}
	public String getInsitute()
	{
		return insitute;
	}
	public String[] getSkills()
	{
		return skills;
	}
	public String getDescription()
	{
		return description;
	}
	public String toString()
	{
		return super.toString() + " " + degree + " " + insituteType + " " + description;
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
		return "sellersLogin.txt";
	}
}
