package Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.ArrayList;

public class View extends JFrame implements MouseListener, ActionListener {
    final private Model model; //связь с моделью
    final private List<JLabel> cells; //массив игровых клеток
    View(String title, Model model){
        //общие параметры окна
        super(title); //передаём заголовок в класс-родитель
        this.model = model; //создаём привязку игры к полю
        setSize(520, 620); //устанавливаем размеры окна
        setLocation(700, 350); //позиция окна
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanel board = new JPanel(); //панель игрового поля
        board.setLocation(2, 2); //позиция поля
        board.setSize(498, 498); //размер поля
        board.setLayout(new GridLayout(3, 3)); //создание сетки поля
        cells = new ArrayList<>(); //инициализируем массив игровых клеток
        for (int i = 0; i < 9; i++){
            JLabel board_cell = new JLabel(); //инициализируем новую клетку
            board_cell.setName(Integer.toString(i)); //задаём имя клетки
            board_cell.setFont(new Font("Verdana", Font.PLAIN, 100)); //стили текста клетки
            board_cell.setHorizontalAlignment(JLabel.CENTER); //центрирование текста внутри клетки
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1); //рамка клетки
            board_cell.setBorder(border); //установка рамки для клетки
            board_cell.addMouseListener(this); //слушатель кликов мыши по клетке
            cells.add(board_cell); //добавляем клетку в список клеток
            board.add(board_cell); //добавляем клетку на игровое поле
        }

        JPanel button = new JPanel(); //инициализируем панель для кнопки "Новая игра"
        button.setSize(200, 100); //размеры панели
        button.setLayout(null);
        JButton new_game = new JButton("Новая игра!"); //инициализируем кнопку
        new_game.setLocation(175, 520); //начальная позиция кнопки
        new_game.setSize(150, 40); //размеры кнопки
        new_game.addActionListener(this); //слушатель кликов по кнопке
        button.add(new_game); //добавляем кнопку в свою панель

        add(board);  //добавляем игровое поле в главное окно
        add(button); //добавляем кнопку в главное окно
        setVisible(true); //отображение окна
    }

    @Override
    public void mouseClicked(MouseEvent e) { //фиксируем нажатие на поле
        if (model.get_isGaming()){ //проверка игры на продолжение
            JLabel label = (JLabel) e.getSource(); //вытаскиваем объект нужного поля
            int cell_id = Integer.parseInt(label.getName());
            if (model.checkCell(cell_id)){
                label.setText( (model.getFlag() == 1) ? "x" : "o"); //задаём полю текст
                model.makeMove(cell_id); //записываем ход в модель
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JLabel cell : cells){
            cell.setText("");
        }
        model.newGame();
    }
}
