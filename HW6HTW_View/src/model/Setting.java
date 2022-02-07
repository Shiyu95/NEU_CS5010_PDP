package model;

public class Setting {
	
	public int rows=6;
	public int columns=6;
	public int arrow =3;
	public int pits=1;
	public int bats=1;
	public int startx=0;
	public int starty=0;
	public int wpx=4;
	public int wpy=5;
	public int remainwall = 7;
	public String mazeType="Room";
	
	private static Setting ins;
	
	public static Setting getInstance() {
		
		if(ins==null)ins=new Setting();
		return ins;
	}
}
