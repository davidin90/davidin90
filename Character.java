package markdown;

import java.util.ArrayList;

public class Character extends Token{
	private static ArrayList<String> stringlist = null;
	Character(String[] s) {
		super(null);
		// TODO Auto-generated constructor stub
	}
	private Character create(String s){
		stringlist.add(s);
		return this;
	}
	public static String toString(char c) {
		// TODO Auto-generated method stub
		return null;
	}
}
