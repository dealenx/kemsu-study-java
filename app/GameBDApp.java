package app;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import dealenx.gameserver.*;
import dealenx.gameserver.backend.*;

public class GameBDApp {

	public static void main(String[] args) {
		try {
			MyFrame frame = new MyFrame();
		} catch(Exception Exception) {
			System.out.println("Error create frame");
		}
	}
}
