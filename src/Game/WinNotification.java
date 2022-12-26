package Game;

import javax.swing.*;

public class WinNotification extends JFrame { //окно уведомления победы
    WinNotification(String title, String win){
        super(title);
        setSize(400, 200); //устанавливаем размеры окна
        setLocation(800, 600 ); //начальная позиция окна
        JLabel text = new JLabel(); //поле текста уведомления
        text.setSize(200, 100); //размер поля
        if (win.equals("Ничья!")){
            text.setText(win); //текст поля
        }
        else{
            text.setText("Победили: " + win); //текст поля
        }
        //выравнивание поля по центру окна
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        //инициализация окна
        add(text);
        setVisible(true);
    }
}
