import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList extends JFrame {

    // Componentes da interface
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

    // Construtor da classe TodoList
    public ToDoList() {
        // Configurações iniciais da janela
        super("To-Do List App");// Título da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação quando a janela é fechada
        this.setSize(550, 300);// Posição e tamanho da janela

        // Inicialização da Janela Principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicialização das listas de tarefas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicialização de campos de texto, botões e uma lista de seleção
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
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // Configuração dos eventos (Listeners)

        // Listener para o botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        // Listener para "Adicionar" pela tecla "Enter"
        taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });
        // Listener para o botão "Excluir"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        // Listener para "Excluir" pela tecla "Delete"
        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteTask();
                }
            }
        });
        // Listener para o botão "Concluir"
        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskDone();
            }
        });
        // Listener para o botão "Limpar concluidas"
        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCompletedTasks();
            }
        });
        // Listener para a lista de seleção (filtrar tarefas)
        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTasks();
            }
        });
        // Listener para concluir tarefa com 2 cliques do mouse
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    markTaskDoneDoubleClick();
                }
            }
        });
    }

    // Adiciona uma tarefa
    private void addTask() {
        try {
            String taskDescription = taskInputField.getText().trim();
            if (taskDescription.isEmpty()) {
                throw new Exception("Por favor, insira uma descrição para a tarefa.");
            }

            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao adicionar tarefa", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Exclui uma tarefa
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = { "NÃO", "SIM" }; // som ou nao para excluir tarefa
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

    // Marca uma tarefa como concluída
    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    // Marca uma tarefa como concluída (duplo clique)
    private void markTaskDoneDoubleClick() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    // Filtra as tarefas de acordo com o ComboBox
    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                String taskDescription = task.getDescription();

                if (!task.isDone() && filter.equals("Ativas")) {
                    taskDescription += " (Ativas)";
                } else if (task.isDone() && filter.equals("Concluídas")) {
                    taskDescription += " (Concluídas)";
                }

                listModel.addElement(taskDescription);
            }
        }
    }
    // Limpa as tarefas concluídas
    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        // gera mensagem de confirmação para excluir tarefas concluidas
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
                updateTaskList();
            }
        }
    }

    // Atualiza a lista de tarefas na interface gráfica
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            String taskDescription = task.getDescription() + (task.isDone() ? " (Concluída)" : "");
            if (!task.isDone()) {
                taskDescription += " (Ativa)";
            }
            listModel.addElement(taskDescription);
        }
    }

    public void run() {
        this.setVisible(true);
    }

}
