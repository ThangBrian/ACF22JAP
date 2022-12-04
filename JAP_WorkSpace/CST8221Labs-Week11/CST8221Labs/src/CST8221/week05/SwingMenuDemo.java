package CST8221.week05;

/**CST8221 - JAP, Unit 5
 * MenuDemo.java
 * Author: Sv. Ranev
 * Version: 1.19.1
 * Demonstrates how to build a menu bar with menu items and popup menu.
 * using Swing API
 */
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Swing Menu sample.
 * @author sousap
 *
 */
public class SwingMenuDemo extends JFrame implements ActionListener, MenuListener {

	/**
	 * Private ID.
	 */
	private static final long serialVersionUID = 8348263044558661477L;

	/**
	 * Menu item for save.
	 */
	private JMenuItem saveItem;

	/**
	 * Menu item for save as.
	 */
	private JMenuItem saveAsItem;

	/**
	 * Menu item for exit.
	 */
	private JMenuItem exitItem;

	/**
	 * Check box for item.
	 */
	private JCheckBoxMenuItem readonlyItem;

	/**
	 * Pop up menu.
	 */
	private JPopupMenu popup;

	/**
	 * Default constructor
	 */
	@SuppressWarnings("deprecation")
	public SwingMenuDemo() {
		setTitle("Menu Demo");

		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);

		// demonstrates how to enabled/disabled items
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		fileMenu.addMenuListener(this);

		// demonstrates how to add accelerators
		JMenuItem openItem = new JMenuItem("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		saveItem = new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		saveAsItem = new JMenuItem("Save As");
		saveAsItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));
		exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		mbar.add(buildMenu(fileMenu, new Object[] { "New", openItem, null, saveItem, saveAsItem, null, exitItem, },
				this));

		// demonstrate check box and radio button menus

		readonlyItem = new JCheckBoxMenuItem("Read-only");
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		group.add(insertItem);
		group.add(overtypeItem);

		// buid submenu
		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		// demonstrate icons and nested menus

		mbar.add(buildMenu("Edit",
				new Object[] { new JMenuItem("Cut", new ImageIcon(getClass().getResource("images/cut.gif"))),
						new JMenuItem("Copy", new ImageIcon(getClass().getResource("images/copy.gif"))),
						new JMenuItem("Paste", new ImageIcon(getClass().getResource("images/paste.gif"))), null,
						optionMenu,
				/*
				 * buildMenu("Options", new Object[] { readonlyItem, null, insertItem,
				 * overtypeItem }, this)
				 */
				}, this));

		// demonstrate mnemonics

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		// The line below will move Help to the right-most position on the menu bar
		// mbar.add(Box.createHorizontalGlue());
		mbar.add(buildMenu(helpMenu, new Object[] { new JMenuItem("Index", 'I'), new JMenuItem("About", 'A') }, this));

		// demonstrate pop-ups

		popup = makePopupMenu(new Object[] { "Cut", "Copy", "Paste" }, this);

		/*
		 * Attach the pop-up menu to the content pane. If you want to attach it to a
		 * specific component (i.e. JTextArea) add the mouse listener to that specific
		 * component and use it in the show method.
		 */
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent evt) {
				if (evt.isPopupTrigger())// In Windows the pop-up triger is right mouse button
					popup.show(evt.getComponent(), evt.getX(), evt.getY());
			}
		});
	}

	/**
	 * Action performed.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String arg = evt.getActionCommand();
		System.out.println(arg);
		if (arg.equals("Exit")) {
			this.dispose();
			///System.exit(0);
		}
	}

	/**
	 * Menu selection
	 */
	@Override
	public void menuSelected(MenuEvent evt) {
		saveItem.setEnabled(!readonlyItem.isSelected());
		saveAsItem.setEnabled(!readonlyItem.isSelected());
	}

	/**
	 * Menu deselection
	 */
	@Override
	public void menuDeselected(MenuEvent evt) {
		System.out.println("File menu item is deselected");
	}

	/**
	 * Cancel menu.
	 */
	@Override
	public void menuCanceled(MenuEvent evt) {
		System.out.println("File menu is canceled");
	}

	/**
	 * Creates a menu with menu items.
	 * 
	 * @param parent       if the parent is a instance of JMenu it adds items to the
	 *                     menu. if the parent is a string it creates the menu and
	 *                     then adds items to the menu.
	 * @param items        list of references to menu items names (strings). If the
	 *                     references null, a separator is added.
	 * @param eventHandler event handler for the menu items.
	 * @returns a reference to JMenu with optional menu items. null if parent is not
	 *          an instance of String or JMenu, or items is null
	 * 
	 */
	private JMenu buildMenu(Object parent, Object[] items, Object eventHandler) {
		JMenu m = null;
		if (parent instanceof JMenu)
			m = (JMenu) parent;
		else if (parent instanceof String)
			m = new JMenu((String) parent);
		else
			return null;
		if (items == null)
			return null;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null)
				m.addSeparator();
			else
				m.add(buildMenuItem(items[i], eventHandler));
		}

		return m;
	}

	/**
	 * Creates a menu item.
	 * 
	 * @param parent       if the parent is a instance of JMenuItem it adds an event
	 *                     handler. if the parent is a string it creates the menu
	 *                     and then adds an event handler.
	 * @param eventHandler event handler for the menu items. Must be of type
	 *                     ActionListener
	 * @returns a reference to JMenuItem. null if parent is not an instance of
	 *          String or JMenuItem, or the event handler is an instance of
	 *          ActionListener
	 * 
	 */
	private JMenuItem buildMenuItem(Object item, Object eventHandler) {
		JMenuItem r = null;
		if (item instanceof String)
			r = new JMenuItem((String) item);
		else if (item instanceof JMenuItem)
			r = (JMenuItem) item;
		else
			return null;

		if (eventHandler instanceof ActionListener)
			r.addActionListener((ActionListener) eventHandler);
		else
			return null;
		return r;
	}

	/**
	 * Creates a pop-up menu.
	 * 
	 * @param items        list of references to menu item names (strings). If the
	 *                     references null, a separator is added.
	 * @param eventHandler event handler for the menu items
	 * @returns a reference to JPopupItem. null if or items is null
	 * 
	 */
	private JPopupMenu makePopupMenu(Object[] items, Object eventHandler) {
		JPopupMenu m = new JPopupMenu();

		if (items == null)
			return null;
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null)
				m.addSeparator();
			else
				m.add(buildMenuItem(items[i], eventHandler));
		}

		return m;
	}

	/**
	 * Execute method.
	 */
	public void execute() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SwingMenuDemo();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(300, 200);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}// end main
}// end class
