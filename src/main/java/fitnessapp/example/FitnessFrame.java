package fitnessapp.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class FitnessFrame extends JFrame {
    private DayService dayService;
    private DefaultListModel<Day> swingDayList;
    private DefaultListModel<Training> swingTrainingList;
    private JList<Day> dayList;
    private JList<Training> trainingList;
    private ActionListener actionListener;

    public FitnessFrame() {
        dayService = new DayService(new DayRepository());
//        trainingService = new TrainingService();
        initializeUI();
        refreshData();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Простой трекер тренировок");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Основная панель с разделителем
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(400);

        // Левая панель - дни тренировок
        JPanel leftPanel = createDaysPanel();
        // Правая панель - тренировки
        JPanel rightPanel = createTrainingsPanel();

        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);

        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel createDaysPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Дни тренировок"));

        // Модель и список дней
        swingDayList = new DefaultListModel<>();
        dayList = new JList<>(swingDayList);
        dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Панель кнопок для дней
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addDayBtn = new JButton("Добавить день");
        JButton deleteDayBtn = new JButton("Удалить день");

        addDayBtn.addActionListener(e -> addDay());


//        deleteDayBtn.addActionListener(e -> deleteDay());

        buttonPanel.add(addDayBtn);
        buttonPanel.add(deleteDayBtn);

        panel.add(new JScrollPane(dayList), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTrainingsPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Тренировки"));

        // Модель и список тренировок
        swingTrainingList = new DefaultListModel<>();
        trainingList = new JList<>(swingTrainingList);

        // Панель кнопок для тренировок
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addTrainingBtn = new JButton("Создать тренировку");
        JButton addToDayBtn = new JButton("Добавить к дню");

        addTrainingBtn.addActionListener(e -> createTraining());
        actionListener = e -> addTrainingToSelectedDay();
        addToDayBtn.addActionListener(actionListener);

        buttonPanel.add(addTrainingBtn);
        buttonPanel.add(addToDayBtn);

        panel.add(new JScrollPane(trainingList), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void addDay() {
        JTextField dateField = new JTextField(10);
        JTextField descField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Дата (ГГГГ-ММ-ДД):"));
        panel.add(dateField);
        panel.add(new JLabel("Описание:"));
        panel.add(descField);      // todo remove

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Новый день тренировки", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                LocalDate date = LocalDate.parse(dateField.getText());
                Day newDay = new Day(date, new ArrayList<>());
                dayService.addDay(newDay);
                refreshData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ошибка в формате даты!");
            }
        }
    }

//    private void deleteDay() {
//        Day selected = dayList.getSelectedValue();
//        if (selected != null) {
//            int confirm = JOptionPane.showConfirmDialog(this,
//                    "Удалить выбранный день?", "Подтверждение", JOptionPane.YES_NO_OPTION);
//            if (confirm == JOptionPane.YES_OPTION) {
//                trainingService.removeDay(selected.getDate());
//                refreshData();
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Выберите день для удаления");
//        }
//    }

    private void createTraining() {
        JTextField nameField = new JTextField(15);
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{
                "Кардио", "Силовая", "Йога", "Плавание"
        });
        JSpinner durationSpinner = new JSpinner(new SpinnerNumberModel(30, 5, 180, 5));

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Название:"));
        panel.add(nameField);
        panel.add(new JLabel("Тип:"));
        panel.add(typeCombo);
        panel.add(new JLabel("Длительность (мин):"));
        panel.add(durationSpinner);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Новая тренировка", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Training training = new Training(
                    nameField.getText(),
                    (String) typeCombo.getSelectedItem(),
                    (Integer) durationSpinner.getValue()
            );
            trainingService.addTraining(training);
            refreshData();
        }
    }

    private void addTrainingToSelectedDay() {
        Day selectedDay = dayList.getSelectedValue();
        Training selectedTraining = trainingList.getSelectedValue();

        if (selectedDay == null || selectedTraining == null) {
            JOptionPane.showMessageDialog(this,
                    "Выберите день и тренировку!");
            return;
        }

//        trainingService.addTrainingToDay(selectedDay.getDate(), selectedTraining);
//        JOptionPane.showMessageDialog(this,
//                "Тренировка '" + selectedTraining.getName() +
//                        "' добавлена к " + selectedDay.getDate());
//        refreshData();
    }

    private void refreshData() {
        swingDayList.clear();
        dayService.getAllDays().forEach(swingDayList::addElement);

        swingTrainingList.clear();
//        trainingService.getAllTrainings().forEach(trainingListModel::addElement);
    }
}
