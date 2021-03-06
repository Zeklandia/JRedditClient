package zeklandia.desktop.reddit;

import com.omrlnr.jreddit.User;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import zeklandia.desktop.logger.JLogger;
import static zeklandia.desktop.reddit.RedditMain.app;
import static zeklandia.desktop.reddit.RedditMain.time;
import zeklandia.desktop.reddit.client.RedditClientMain;

public class RedditAuth extends javax.swing.JDialog {

	private static final String classname = "RedditAuth";
	private static final String padding = "       ";

	public RedditAuth(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        inputPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        checkboxRememberLogin = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setModal(true);
        setResizable(false);

        jLabel1.setBackground(null);
        jLabel1.setFont(null);
        jLabel1.setForeground(null);
        jLabel1.setText("Please enter your reddit username and password.");

        inputUsername.setBackground(null);
        inputUsername.setFont(null);
        inputUsername.setForeground(null);
        inputUsername.setToolTipText("Enter your username");

        buttonLogin.setBackground(null);
        buttonLogin.setFont(null);
        buttonLogin.setForeground(null);
        buttonLogin.setText("Login");
        buttonLogin.setToolTipText("Login as this user");
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonLogin.setName("login"); // NOI18N
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });

        buttonCancel.setBackground(null);
        buttonCancel.setFont(null);
        buttonCancel.setForeground(null);
        buttonCancel.setText("Cancel");
        buttonCancel.setToolTipText("Cancel");
        buttonCancel.setName("cancel"); // NOI18N
        buttonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelMouseClicked(evt);
            }
        });

        inputPassword.setBackground(null);
        inputPassword.setFont(null);
        inputPassword.setForeground(null);
        inputPassword.setToolTipText("Enter your reddit password");

        jLabel2.setBackground(null);
        jLabel2.setFont(null);
        jLabel2.setForeground(null);
        jLabel2.setText("Username");

        jLabel3.setBackground(null);
        jLabel3.setFont(null);
        jLabel3.setForeground(null);
        jLabel3.setText("Password");

        checkboxRememberLogin.setBackground(null);
        checkboxRememberLogin.setFont(null);
        checkboxRememberLogin.setForeground(null);
        checkboxRememberLogin.setText("Remember Login");
        checkboxRememberLogin.setToolTipText("Save this login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(buttonCancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(checkboxRememberLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(buttonLogin))
                            .addComponent(inputPassword)
                            .addComponent(inputUsername))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonLogin)
                    .addComponent(checkboxRememberLogin))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
	    String username = inputUsername.getText();
	    String password = inputPassword.getText();

	    if (checkboxRememberLogin.isSelected() == true) {
		    saveLogin(username, password);
	    }

	    userLogin(username, password);
	    saveLogin(username, password);
	    RedditClientMain.tabsView.requestFocus();
	    this.dispose();
    }//GEN-LAST:event_buttonLoginMouseClicked

    private void buttonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelMouseClicked
	    JLogger.logMessage(time, app, classname, padding, "User cancelled login");
	    RedditClientMain.tabsView.requestFocus();
	    this.dispose();
    }//GEN-LAST:event_buttonCancelMouseClicked

	public static void main() {

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				RedditAuth dialog = new RedditAuth(new javax.swing.JFrame(), true);
				dialog.setLocationRelativeTo(null);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				checkboxRememberLogin.setSelected(true);
				dialog.setVisible(true);
			}
		});
		JLogger.logMessage(time, app, classname, padding, "Created login prompt");
	}

	public static void userLogin(String username, String password) {

		User user = new User(username, password);

		try {
			user.connect();
		} catch (Exception ex) {
			JLogger.logError(time, app, classname, padding, "Login failed");
			JOptionPane.showMessageDialog(RedditAuth.buttonLogin, "Login failed");
			RedditAuth.main();
		}
		JLogger.logMessage(time, app, classname, padding, "Login successful");
	}

	public static void saveLogin(String username, String password) {
		File configFolder;
		configFolder = new File(System.getProperty("user.home") + "//.config//");

		try {
			if (!configFolder.exists()) {
				boolean status;
				status = configFolder.mkdir();
				if (status) {
					JLogger.logMessage(time, app, classname, padding, "Created ~/.config");
				}
			}
		} catch (Exception ex) {
			JLogger.logError(time, app, classname, padding, "Failed to create ~/.config");
		}

		try {
			FileWriter loginFileStream;
			loginFileStream = new FileWriter(configFolder + "/java-reddit.conf");
			try (BufferedWriter loginFileBuffer = new BufferedWriter(loginFileStream)) {
				loginFileBuffer.write(username);
			}
		} catch (IOException e) {
			JLogger.logError(time, app, classname, padding, "Failed to save login");
			JOptionPane.showMessageDialog(RedditAuth.buttonLogin, "Saving login failed");
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    public static javax.swing.JButton buttonLogin;
    private static javax.swing.JCheckBox checkboxRememberLogin;
    public static javax.swing.JPasswordField inputPassword;
    public static javax.swing.JTextField inputUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
