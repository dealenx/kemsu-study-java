package app;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import dealenx.game.*;
import dealenx.game.backend.*;
import app.example.*;

public class GameApp {

	public static void main(String[] args) {
		try {
			MyFrame frame = new MyFrame();
		} catch(Exception Exception) {
			System.out.println("Error create frame");
		}
	}
}
