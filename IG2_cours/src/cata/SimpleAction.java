package cata;

public class SimpleAction {
	private String name;
	private String text;
	
	public  SimpleAction(String name, String text) {
		this.setText(text);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
