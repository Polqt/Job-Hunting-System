import Dashboard.Dashboard;
import RegistrationForm.RegistrationForm;
import User.User;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;

public class Job {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Janpol Hidalgo\\Downloads\\346153812_1167150957299429_6589387488065726014_n.jpg");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        int choice = JOptionPane.showOptionDialog(null, "Are you a tech graduate looking for a job?", "Job Search",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, resizedIcon, null, null);

        if (choice == JOptionPane.YES_OPTION) {
            RegistrationForm registrationForm = new RegistrationForm();
            registrationForm.setVisible(true);

            while (registrationForm.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            User user = registrationForm.getUser();
            Dashboard dashboard = new Dashboard(user);
            dashboard.setVisible(true);
        } else {

        }
    }
}