package RegistrationForm;

import Dashboard.Dashboard;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    private JPanel personalBackgroundPanel;
    public JLabel personalBackgroundLabel;
    public JLabel fullNameLabel;
    private JTextField fullNameField;
    public JLabel contactNoLabel;
    private JTextField contactNoField;
    public JLabel addressLabel;
    private JTextField addressField;
    public JLabel dateOfBirthLabel;
    private JTextField dateOfBirthField;
    public JButton nextButton;
    public JButton quitButton;

    private JPanel educationalBackgroundPanel;
    public JLabel educationalBackgroundLabel;
    public JLabel degreeLabel;
    public JTextField degreeField;
    public JLabel institutionLabel;
    public JTextField institutionField;
    public JLabel majorLabel;
    public JTextField majorField;
    public JLabel graduationYearLabel;
    public JTextField graduationYearField;
    public JButton backButton;
    public JButton nextButton2;
    public JButton quitButton2;

    private JPanel workExperiencePanel;
    public JLabel workExperienceLabel;
    public JLabel jobTitleLabel;
    public JTextField jobTitleField;
    public JLabel companyNameLabel;
    public JTextField companyNameField;
    public JLabel durationLabel;
    public JTextField durationField;
    public JLabel responsibilitiesLabel;
    public JTextField responsibilitiesField;
    public JLabel achievementsLabel;
    public JTextField achievementsField;
    public JLabel referencesLabel;
    public JTextField referencesField;
    public JButton backButton2;
    public JButton nextButton3;
    public JButton quitButton3;

    private JPanel technicalSkillsPanel;
    public JLabel technicalSkillsLabel;
    public JLabel programmingLanguagesLabel;
    public JTextField programmingLanguagesField;
    public JLabel developmentToolsLabel;
    public JTextField developmentToolsField;
    public JLabel databasesLabel;
    public JTextField databasesField;
    public JLabel webDevelopmentLabel;
    public JTextField webDevelopmentField;
    public JLabel operatingSystemsLabel;
    public JTextField operatingSystemsField;
    public JButton backButton3;
    public JButton submitButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        createPersonalBackgroundPanel();
        createEducationalBackgroundPanel();
        createWorkExperiencePanel();
        createTechnicalSkillsPanel();

        cardPanel.add(personalBackgroundPanel, "personalBackground");
        cardPanel.add(educationalBackgroundPanel, "educationalBackground");
        cardPanel.add(workExperiencePanel, "workExperience");
        cardPanel.add(technicalSkillsPanel, "technicalSkills");

        add(cardPanel);

        setVisible(true);
    }

    private void createPersonalBackgroundPanel() {
        personalBackgroundPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        personalBackgroundLabel = new JLabel("PERSONAL BACKGROUND");
        personalBackgroundLabel.setFont(new Font("Aileron", Font.BOLD, 20));
        personalBackgroundLabel.setHorizontalAlignment(JLabel.CENTER);
        personalBackgroundPanel.add(personalBackgroundLabel, BorderLayout.NORTH);

        fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField();
        dateOfBirthLabel = new JLabel("Date of Birth:");
        dateOfBirthField = new JTextField();
        addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        contactNoLabel = new JLabel("Contact Number:");
        contactNoField = new JTextField();
        formPanel.add(fullNameLabel);
        formPanel.add(fullNameField);
        formPanel.add(dateOfBirthLabel);
        formPanel.add(dateOfBirthField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(contactNoLabel);
        formPanel.add(contactNoField);
        personalBackgroundPanel.add(formPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validatePersonalBackground()) {
                    cardLayout.show(cardPanel, "educationalBackground");
                } else {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Please fill in all the fields.");
                }
            }
        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(nextButton);
        buttonPanel.add(quitButton);
        personalBackgroundPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createEducationalBackgroundPanel() {
        educationalBackgroundPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        educationalBackgroundLabel = new JLabel("EDUCATIONAL BACKGROUND");
        educationalBackgroundLabel.setFont(new Font("Aileron", Font.BOLD, 20));
        educationalBackgroundLabel.setHorizontalAlignment(JLabel.CENTER);
        educationalBackgroundPanel.add(educationalBackgroundLabel, BorderLayout.NORTH);

        degreeLabel = new JLabel("Degree(s) Earned:");
        degreeField = new JTextField();
        institutionLabel = new JLabel("Name of Institution(s):");
        institutionField = new JTextField();
        majorLabel = new JLabel("Major(s) or Field(s) of Study:");
        majorField = new JTextField();
        graduationYearLabel = new JLabel("Graduation Year(s):");
        graduationYearField = new JTextField();

        formPanel.add(degreeLabel);
        formPanel.add(degreeField);
        formPanel.add(institutionLabel);
        formPanel.add(institutionField);
        formPanel.add(majorLabel);
        formPanel.add(majorField);
        formPanel.add(graduationYearLabel);
        formPanel.add(graduationYearField);

        educationalBackgroundPanel.add(formPanel, BorderLayout.CENTER);

        nextButton2 = new JButton("Next");
        nextButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateEducationalBackground()) {
                    cardLayout.show(cardPanel, "workExperience");
                } else {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Please fill in all the fields.");
                }
            }
        });

        backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "personalBackground"));

        quitButton2 = new JButton("Quit");
        quitButton2.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(nextButton2);
        buttonPanel.add(backButton);
        buttonPanel.add(quitButton2);
        educationalBackgroundPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createWorkExperiencePanel() {
        workExperiencePanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        workExperienceLabel = new JLabel("WORK EXPERIENCE");
        workExperienceLabel.setFont(new Font("Aileron", Font.BOLD, 20));
        workExperienceLabel.setHorizontalAlignment(JLabel.CENTER);
        workExperiencePanel.add(workExperienceLabel, BorderLayout.NORTH);

        jobTitleLabel = new JLabel("Job Title:");
        jobTitleField = new JTextField();
        companyNameLabel = new JLabel("Company Name:");
        companyNameField = new JTextField();
        durationLabel = new JLabel("Duration:");
        durationField = new JTextField();
        responsibilitiesLabel = new JLabel("Responsibilities:");
        responsibilitiesField = new JTextField();
        achievementsLabel = new JLabel("Achievements:");
        achievementsField = new JTextField();
        referencesLabel = new JLabel("References:");
        referencesField = new JTextField();

        formPanel.add(jobTitleLabel);
        formPanel.add(jobTitleField);
        formPanel.add(companyNameLabel);
        formPanel.add(companyNameField);
        formPanel.add(durationLabel);
        formPanel.add(durationField);
        formPanel.add(responsibilitiesLabel);
        formPanel.add(responsibilitiesField);
        formPanel.add(achievementsLabel);
        formPanel.add(achievementsField);
        formPanel.add(referencesLabel);
        formPanel.add(referencesField);

        workExperiencePanel.add(formPanel, BorderLayout.CENTER);

        nextButton3 = new JButton("Next");
        nextButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateWorkExperience()) {
                    cardLayout.show(cardPanel, "technicalSkills");
                } else {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Please fill in all the fields.");
                }
            }
        });

        backButton2 = new JButton("Back");
        backButton2.addActionListener(e -> cardLayout.show(cardPanel, "educationalBackground"));

        quitButton3 = new JButton("Quit");
        quitButton3.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(nextButton3);
        buttonPanel.add(backButton2);
        buttonPanel.add(quitButton3);
        workExperiencePanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createTechnicalSkillsPanel() {
        technicalSkillsPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        technicalSkillsLabel = new JLabel("TECHNICAL SKILLS");
        technicalSkillsLabel.setFont(new Font("Aileron", Font.BOLD, 20));
        technicalSkillsLabel.setHorizontalAlignment(JLabel.CENTER);
        technicalSkillsPanel.add(technicalSkillsLabel, BorderLayout.NORTH);

        programmingLanguagesLabel = new JLabel("Programming Languages:");
        programmingLanguagesField = new JTextField();
        developmentToolsLabel = new JLabel("Development Tools:");
        developmentToolsField = new JTextField();
        databasesLabel = new JLabel("Databases:");
        databasesField = new JTextField();
        webDevelopmentLabel = new JLabel("Web Development:");
        webDevelopmentField = new JTextField();
        operatingSystemsLabel = new JLabel("Operating Systems:");
        operatingSystemsField = new JTextField();

        formPanel.add(programmingLanguagesLabel);
        formPanel.add(programmingLanguagesField);
        formPanel.add(developmentToolsLabel);
        formPanel.add(developmentToolsField);
        formPanel.add(databasesLabel);
        formPanel.add(databasesField);
        formPanel.add(webDevelopmentLabel);
        formPanel.add(webDevelopmentField);
        formPanel.add(operatingSystemsLabel);
        formPanel.add(operatingSystemsField);

        technicalSkillsPanel.add(formPanel, BorderLayout.CENTER);




        backButton3 = new JButton("Back");
        backButton3.addActionListener(e -> cardLayout.show(cardPanel, "workExperience"));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateTechnicalSkills()) {
                    User user = new User(
                            fullNameField.getText(),
                            contactNoField.getText(),
                            addressField.getText(),
                            dateOfBirthField.getText(),
                            degreeField.getText(),
                            institutionField.getText(),
                            majorField.getText(),
                            graduationYearField.getText(),
                            jobTitleField.getText(),
                            companyNameField.getText(),
                            durationField.getText(),
                            responsibilitiesField.getText(),
                            achievementsField.getText(),
                            referencesField.getText(),
                            programmingLanguagesField.getText(),
                            developmentToolsField.getText(),
                            databasesField.getText(),
                            webDevelopmentField.getText(),
                            operatingSystemsField.getText()
                    );

                    Dashboard dashboard = new Dashboard(user);
                    dashboard.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Please fill in all the fields.");
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(submitButton);
        buttonPanel.add(backButton3);
        technicalSkillsPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private boolean validatePersonalBackground() {
        return !fullNameField.getText().isEmpty() &&
                !contactNoField.getText().isEmpty() &&
                !addressField.getText().isEmpty() &&
                !dateOfBirthField.getText().isEmpty();
    }

    private boolean validateEducationalBackground() {
        return !degreeField.getText().isEmpty() &&
                !institutionField.getText().isEmpty() &&
                !majorField.getText().isEmpty() &&
                !graduationYearField.getText().isEmpty();
    }

    private boolean validateWorkExperience() {
        return !jobTitleField.getText().isEmpty() &&
                !companyNameField.getText().isEmpty() &&
                !durationField.getText().isEmpty() &&
                !responsibilitiesField.getText().isEmpty() &&
                !achievementsField.getText().isEmpty() &&
                !referencesField.getText().isEmpty();
    }

    private boolean validateTechnicalSkills() {
        return !programmingLanguagesField.getText().isEmpty() &&
                !developmentToolsField.getText().isEmpty() &&
                !databasesField.getText().isEmpty() &&
                !webDevelopmentField.getText().isEmpty() &&
                !operatingSystemsField.getText().isEmpty();
    }

    public User getUser() {
        return null;
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}