package Game;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Integer> process_game; //массив состояния клеток, где 0 - пусто, 1 - X, 2 - 0
    private int flag_move; //флаг "Очерёдность хода" 1 - X, 2 - O
    private boolean isGaming; //флаг "Игра продолжается"
    Model() {
        process_game = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            process_game.add(0);
        }
        flag_move = 1;
        isGaming = true;
    }
    public void makeMove(int cell) { //запись хода в массив состояний
        process_game.set(cell, flag_move); //перевод клетки в состояние
        flag_move = (flag_move == 1) ? 2 : 1; //смена очереди
        if (checkWin() == 1){
            WinNotification notification = new WinNotification("Уведомление!", "x"); //уведомление о победе X
            isGaming = false; //остановка работы с полем
        }
        else if (checkWin() == 2){
            WinNotification notification = new WinNotification("Уведомление!", "0"); //уведомление о победе O
            isGaming = false; //остановка работы с полем
        }
    }

    public int checkWin(){ // проверка победы
        if (process_game.get(4) != 0 && (process_game.get(1).equals(process_game.get(4)) && //проверка линий,
                                         process_game.get(4).equals(process_game.get(7)) || //проходящих центр
                                         process_game.get(0).equals(process_game.get(4)) &&
                                         process_game.get(4).equals(process_game.get(8)) ||
                                         process_game.get(3).equals(process_game.get(4)) &&
                                         process_game.get(4).equals(process_game.get(5)) ||
                                         process_game.get(2).equals(process_game.get(4)) &&
                                         process_game.get(4).equals(process_game.get(6))

        )) {
            return process_game.get(4);
        }
        else if (process_game.get(0) != 0 && (process_game.get(0).equals(process_game.get(1)) && //проверка линий,
                                              process_game.get(1).equals(process_game.get(2)) || //проходящих левый
                                              process_game.get(0).equals(process_game.get(3)) && //верхний угол
                                              process_game.get(3).equals(process_game.get(6))
        )){
            return process_game.get(0);
        }
        else if (process_game.get(8) != 0 && (process_game.get(6).equals(process_game.get(7)) && //проверка линий,
                                              process_game.get(7).equals(process_game.get(8)) || //проходящих правый
                                              process_game.get(2).equals(process_game.get(5)) && //нижний угол
                                              process_game.get(5).equals(process_game.get(8))
        )){
            return process_game.get(8);
        }
        else {
            return 0; //победы ни одной из сторон не найдено
        }
    }
    void newGame() { //новая игра, обнуление полей и возврат флагов к исходному состоянию
        for (int i = 0; i < 9; i++) {
            process_game.set(i, 0);
        }
        flag_move = 1;
        isGaming = true;
    }
    public int getFlag(){
        return flag_move;
    }
    public boolean get_isGaming(){
        return isGaming;
    }

}
