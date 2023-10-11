import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList extends JFrame {

    // Declaração de componentes da interface
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> activeTaskList; // Lista de tarefas a concluir
    private DefaultListModel<String> activeListModel;
    private JList<String> completedTaskList; // Lista de tarefas concluídas
    private DefaultListModel<String> completedListModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public ToDoList() {
        // Configurações gerais da janela
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 300);

        // Inicialização de componentes e listas
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        activeListModel = new DefaultListModel<>(); // Modelo para tarefas a concluir
        completedListModel = new DefaultListModel<>(); // Modelo para tarefas concluídas
        activeTaskList = new JList<>(activeListModel);
        completedTaskList = new JList<>(completedListModel);

        // Configuração dos elementos da interface
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        // Configuração do painel de entrada de tarefas
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adição dos componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel taskListsPanel = new JPanel(new BorderLayout());
        taskListsPanel.add(new JScrollPane(activeTaskList), BorderLayout.WEST);
        taskListsPanel.add(new JScrollPane(completedTaskList), BorderLayout.EAST);
        mainPanel.add(taskListsPanel, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        // Adicionando escutador de cliques duplos na lista de tarefas a concluir
        activeTaskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    markTaskDone(); // Marca a tarefa como concluída
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskEnter(); // Adiciona funcionalidade de pressionar Enter para adicionar tarefa
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
    }

    // Método para marcar uma tarefa como concluída
    private void markTaskDone() {
        int selectedIndex = activeTaskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskLists();
        }
    }
    
    // Método para adicionar funcionalidade de pressionar Enter para adicionar tarefa
    private void addTaskEnter() {
        taskInputField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });
    }

    // Método para adicionar uma nova tarefa
    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskLists();
            taskInputField.setText("");
        }
    }

    // Método para excluir uma tarefa
    private void deleteTask() {
        int selectedIndex = activeTaskList.getSelectedIndex();
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
                updateTaskLists();
            }
        }
    }

    // Método para filtrar tarefas com base no ComboBox
    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        activeListModel.clear();
        completedListModel.clear();

        for (Task task : tasks) {
            String taskDescription = task.getDescription() + (task.isDone() ? " (Concluída)" : "");
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                if (task.isDone()) {
                    completedListModel.addElement(taskDescription);
                } else {
                    activeListModel.addElement(taskDescription);
                }
            }
        }
    }

    // Método para limpar tarefas concluídas
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
                    new Object[] { "NÃO", "SIM" },
                    "NÃO");

            if (acao == 1) {
                tasks.removeAll(completedTasks);
                updateTaskLists();
            }
        }
    }

    // Método para atualizar as listas de tarefas
    private void updateTaskLists() {
        activeListModel.clear();
        completedListModel.clear();
    
        for (Task task : tasks) {
            String taskDescription = task.getDescription() + (task.isDone() ? " (Concluída)" : "");
            if (task.isDone()) {
                completedListModel.addElement(taskDescription);
            } else {
                activeListModel.addElement(taskDescription);
            }
        }
    }
    

    public void run() {
        this.setVisible(true);
    }

    // Classe Task
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
