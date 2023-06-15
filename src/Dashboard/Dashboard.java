package Dashboard;

import User.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard extends JFrame {
    public JLabel welcomeLabel;
    public JTable jobTable;
    public JTextField searchField;
    public JButton searchButton;
    public JButton applyButton;
    public JButton cancelButton;
    public JButton bookmarkButton;
    public JList<String> searchHistoryList;
    public DefaultListModel<String> searchHistoryModel;
    public JList<String> bookmarkList;
    public DefaultListModel<String> bookmarkModel;
    public HashMap<String, Integer> jobApplications;

    public Dashboard(User user) {
        setTitle("Dashboard");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcomeLabel = new JLabel("Welcome, " + user.getFullName() + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        String[] columnNames = {"Job Title", "Company", "Location", "Salary", "Applicants"};
        Object[][] data = {
                {"Software Engineer", "Google", "Mountain View, CA", "$120,000 - $200,000"},
                {"Data Analyst", "Facebook", "Menlo Park, CA", "$80,000 - $120,000"},
                {"Product Manager", "Amazon", "Seattle, WA", "$100,000 - $150,000"},
                {"Web Developer", "Microsoft", "Redmond, WA", "$80,000 - $120,000"},
                {"Database Administrator", "Oracle", "Redwood City, CA", "$90,000 - $130,000"},
                {"Network Administrator", "Cisco", "San Jose, CA", "$80,000 - $120,000"},
                {"Cybersecurity Analyst", "IBM", "Armonk, NY", "$100,000 - $150,000"},
                {"Artificial Intelligence Engineer", "Intel", "Santa Clara, CA", "$120,000 - $200,000"},
                {"Software Developer", "Accenture", "Manila, Philippines", "PHP 50,000 - PHP 100,000"},
                {"Data Scientist", "IBM", "Makati, Philippines", "PHP 80,000 - PHP 150,000"},
                {"Web Designer", "TaskUs", "Cavite, Philippines", "PHP 30,000 - PHP 50,000"},
                {"Network Engineer", "Converge ICT", "Pasig, Philippines", "PHP 60,000 - PHP 100,000"},
                {"Mobile App Developer", "Globe Telecom", "Taguig, Philippines", "PHP 80,000 - PHP 120,000"},
                {"Cloud Architect", "Amazon Web Services", "Singapore", "SGD 120,000 - SGD 200,000"},
                {"Full Stack Developer", "Grab", "Singapore", "SGD 80,000 - SGD 120,000"},
                {"DevOps Engineer", "DBS Bank", "Singapore", "SGD 100,000 - SGD 150,000"},
                {"Data Engineer", "Sea Group", "Singapore", "SGD 90,000 - SGD 130,000"},
                {"Cybersecurity Consultant", "PwC", "Hong Kong", "HKD 500,000 - HKD 800,000"},
                {"Blockchain Developer", "Crypto.com", "Hong Kong", "HKD 600,000 - HKD 1,000,000"},
                {"AI Researcher", "SenseTime", "Hong Kong", "HKD 800,000 - HKD 1,500,000"},
                {"Cloud Solutions Architect", "Alibaba Cloud", "Hong Kong", "HKD 700,000 - HKD 1,200,000"},
                {"Software Engineer", "Tencent", "Shenzhen, China", "CNY 300,000 - CNY 500,000"},
                {"Data Analyst", "Baidu", "Beijing, China", "CNY 200,000 - CNY 400,000"},
                {"Web Developer", "Alibaba Group", "Hangzhou, China", "CNY 200,000 - CNY 400,000"},
                {"Database Administrator", "Huawei", "Shenzhen, China", "CNY 250,000 - CNY 450,000"},
                {"Network Administrator", "China Mobile", "Beijing, China", "CNY 150,000 - CNY 300,000"},
                {"Cybersecurity Analyst", "360 Security", "Beijing, China", "CNY 300,000 - CNY 500,000"},
                {"Artificial Intelligence Engineer", "Baidu", "Beijing, China", "CNY 400,000 - CNY 800,000"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jobTable = new JTable(model);
        JScrollPane jobScrollPane = new JScrollPane(jobTable);
        JPanel jobPanel = new JPanel(new BorderLayout());
        jobPanel.setBorder(BorderFactory.createTitledBorder("Available Jobs"));
        jobPanel.add(jobScrollPane, BorderLayout.CENTER);

        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase();
                ArrayList<Integer> matchingRows = new ArrayList<>();
                for (int i = 0; i < jobTable.getRowCount(); i++) {
                    String jobTitle = jobTable.getValueAt(i, 0).toString().toLowerCase();
                    if (jobTitle.contains(searchText)) {
                        matchingRows.add(i);
                    }
                }
                if (matchingRows.size() > 0) {
                    int[] rows = new int[matchingRows.size()];
                    for (int i = 0; i < matchingRows.size(); i++) {
                        rows[i] = matchingRows.get(i);
                    }
                    jobTable.setRowSelectionInterval(rows[0], rows[rows.length - 1]);
                    addToSearchHistory(searchText);
                } else {
                    JOptionPane.showMessageDialog(Dashboard.this, "No matching jobs found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder("Job Search"));
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        searchHistoryModel = new DefaultListModel<>();
        searchHistoryList = new JList<>(searchHistoryModel);
        JScrollPane searchHistoryScrollPane = new JScrollPane(searchHistoryList);
        JPanel searchHistoryPanel = new JPanel(new BorderLayout());
        searchHistoryPanel.setBorder(BorderFactory.createTitledBorder("Search History"));
        searchHistoryPanel.add(searchHistoryScrollPane, BorderLayout.CENTER);

        applyButton = new JButton("Apply");
        cancelButton = new JButton("Cancel");
        bookmarkButton = new JButton("Bookmark");
        bookmarkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jobTable.getSelectedRow();
                if (selectedRow != -1) {
                    String jobTitle = jobTable.getValueAt(selectedRow, 0).toString();
                    addToBookmark(jobTitle);
                } else {
                    JOptionPane.showMessageDialog(Dashboard.this, "Please select a job to bookmark.", "Bookmark", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jobTable.getSelectedRow();
                if (selectedRow != -1) {
                    String jobTitle = jobTable.getValueAt(selectedRow, 0).toString();
                    int applicationCount = jobApplications.getOrDefault(jobTitle, 0);
                    if (applicationCount > 0) {
                        applicationCount--;
                        jobApplications.put(jobTitle, applicationCount);
                        updateJobTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(Dashboard.this, "Please select a job to cancel the application.", "Cancel Application", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(applyButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(bookmarkButton);
        jobPanel.add(buttonPanel, BorderLayout.SOUTH);

        bookmarkModel = new DefaultListModel<>();
        bookmarkList = new JList<>(bookmarkModel);
        JScrollPane bookmarkScrollPane = new JScrollPane(bookmarkList);
        JPanel bookmarkPanel = new JPanel(new BorderLayout());
        bookmarkPanel.setBorder(BorderFactory.createTitledBorder("Bookmarks"));
        bookmarkPanel.add(bookmarkScrollPane, BorderLayout.CENTER);

        JPanel recommendedJobsPanel = new JPanel(new GridLayout(1, 2));
        recommendedJobsPanel.setBorder(BorderFactory.createTitledBorder("DASHBOARD"));
        recommendedJobsPanel.add(searchHistoryPanel);
        recommendedJobsPanel.add(bookmarkPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(jobPanel, BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(recommendedJobsPanel, BorderLayout.WEST);
        add(mainPanel);

        jobApplications = new HashMap<>();

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jobTable.getSelectedRow();
                if (selectedRow != -1) {
                    String jobTitle = jobTable.getValueAt(selectedRow, 0).toString();
                    int applicationCount = jobApplications.getOrDefault(jobTitle, 0);
                    applicationCount++;
                    jobApplications.put(jobTitle, applicationCount);
                    updateJobTable();
                } else {
                    JOptionPane.showMessageDialog(Dashboard.this, "Please select a job to apply.", "Apply", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    private void addToSearchHistory(String searchText) {
        if (!searchHistoryModel.contains(searchText)) {
            searchHistoryModel.addElement(searchText);
        }
    }

    private void addToBookmark(String jobTitle) {
        if (!bookmarkModel.contains(jobTitle)) {
            bookmarkModel.addElement(jobTitle);
        }
    }

    private void updateJobTable() {
        for (int row = 0; row < jobTable.getRowCount(); row++) {
            String jobTitle = jobTable.getValueAt(row, 0).toString();
            int applicationCount = jobApplications.getOrDefault(jobTitle, 0);
            jobTable.setValueAt(applicationCount, row, 4);
        }
    }
}