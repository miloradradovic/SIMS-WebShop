package controller;
import model.Aplikacija;
import view.MainWindow;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Aplikacija app = new Aplikacija();
		MainWindow ww = new MainWindow(app);

	}

}