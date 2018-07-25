package org.espeakng.jeditor.gui;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.io.File;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CompileMenuItemTest {

	static MainWindow cs;
	private static FrameFixture fixture;
	private static MainWindow mainW;
	private static Logger logger = Logger.getLogger(CompileMenuItemTest.class);
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mainW = GuiActionRunner.execute(new Callable<MainWindow>() {
			@Override
			public MainWindow call() throws Exception {
				return MainWindow.getMainWindow();
			}
		});
		
		fixture = new FrameFixture(mainW);
		fixture.show();
		mainW.setSize(new Dimension(1000, 600));
	}

	@Test
	public void compileTest() {
		fixture.menuItem(mainW.mntmCompileDictionary.getText()).click();
		File selectedFile = new File("../espeak-ng/dictsource/en_list");
		assertTrue("English list file not found", selectedFile.exists());
		fixture.fileChooser().selectFile(selectedFile);
		fixture.fileChooser().approve();
	}
	
	@Test
	public void compileDebugTest() {
		fixture.menuItem(mainW.mntmCompileDictionarydebug.getText()).click();
		File selectedFile = new File("../espeak-ng/dictsource/ru_list");
		assertTrue("Russian list file not found", selectedFile.exists());
		fixture.fileChooser().selectFile(selectedFile);
		fixture.fileChooser().approve();
	}
	
	@Test
	public void compilePhonemeTest() {
		fixture.menuItem(mainW.mntmCompilePhonemeData.getText()).click();
	}
	
	@Test
	public void compileMbrolaTest() {
		fixture.menuItem(mainW.mntmCompileMbrolaPhonemes.getText()).click();
		File selectedFile = new File("../espeak-ng/phsource/mbrola/en1");
		assertTrue("English mbrola file not found", selectedFile.exists());
		fixture.fileChooser().selectFile(selectedFile);
		fixture.fileChooser().approve();
	}
	
	@Test
	public void compileIntonationTest() {
		fixture.menuItem(mainW.mntmCompileIntonationData.getText()).click();
	}

}
