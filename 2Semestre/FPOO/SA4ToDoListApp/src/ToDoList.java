import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList extends JFrame {

    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public ToDoList() {
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskEnter();
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });

        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCompletedTasks();
            }
        });

        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    markTaskDoneDoubleClick();
                }
            }
        });
    }

    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void addTaskEnter() {
        taskInputField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = { "NÃO", "SIM" };
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja Excluir?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (acao == 1) {
                tasks.remove(selectedIndex);
                updateTaskList();
            }
        }
    }

    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void markTaskDoneDoubleClick() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }

        if (!completedTasks.isEmpty()) {
            int acao = JOptionPane.showOptionDialog(
                    null,
                    "Tem Certeza que deseja Excluir essa Tarefa Concluída?",
                    "Confirmação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new Object[]{"NÃO", "SIM"},
                    "NÃO");

            if (acao == 1) {
                tasks.removeAll(completedTasks);
                updateTaskList();
            }
        }
    }

    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    public void run() {
        this.setVisible(true);
    }

    private class Task {
        private String description;
        private boolean done;

        public Task(String description) {
            this.description = description;
            this.done = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        todoList.run();
    }
}
