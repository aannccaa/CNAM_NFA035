package ex2;

import javax.swing.SwingUtilities;

public class Q1_controller {
	Q1_model model;
	Q1_view view;
	
	public Q1_controller() {
		this.model = new Q1_model();
		this.view = new Q1_view();
		activate();
	}
	
	public void activate() {
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				Q1_controller app = new Q1_controller();
			}
		});

	}

}
