import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
/**
 * Created by Nik on 22.03.2015.
 */
public class Sudoku {
    Player player = new Player(0,0);
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    private int [][] sudokuField = new int[9][9];   //Само игровое поле
    private int [][] sudokuFieldSolve = new int [9][9]; //Поле, в котором будет лежать ответ

    public void testField(int [][] mySudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mySudoku[i][j] = 0;
            }
        }
        mySudoku[0][2]=6;
        mySudoku[1][0]=8;mySudoku[1][1]=7;mySudoku[1][4]=1;mySudoku[1][8]=6;
        mySudoku[2][3]=5;mySudoku[2][4]=4;mySudoku[2][8]=9;
        mySudoku[3][0]=6;mySudoku[3][4]=8;mySudoku[3][5]=1;mySudoku[3][6]=3;mySudoku[3][8]=4;
        mySudoku[4][3]=3;mySudoku[4][7]=5;
        mySudoku[5][5]=7;
        mySudoku[7][1]=9;mySudoku[7][3]=4;mySudoku[7][8]=8;
        mySudoku[8][2]=5;mySudoku[8][4]=6;mySudoku[8][6]=1;
    }   //Тестовое поле судоки. Проверял, работает ли алгоритм решения.
    public void sudokuFieldCreate(){
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = 0; j<sudokuField[0].length; j++){
                if(i == 0 & j != 0){
                    sudokuField[i][j] = sudokuField[i][j-1] + 1;
                }
                else{
                    sudokuField[0][0] = 1;
                }
                if(i == 1 | i == 2){
                    sudokuField[i][j] = sudokuField[i-1][j] + 3;
                    sudokuField[i][j] = checkValue(i,j);
                }
                if(i == 3 | i == 4 | i == 5 | i == 6 | i == 7 | i == 8){
                    sudokuField[i][j] = sudokuField[i-3][j] + 1;
                    sudokuField[i][j] = checkValue(i,j);
                }
            }
        }
    }   //Создание базового поля судоку.

    public int checkValue(int i, int j){
        if(sudokuField[i][j] > 9 ){
            sudokuField[i][j] = (sudokuField[i][j] % 10) + 1;
        }
        return sudokuField[i][j];
    }   //Проверка значений в клетках(Чтобы не превышало 9)

    public void watchField(){
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = 0; j<sudokuField[0].length; j++){
                System.out.print(sudokuField[i][j] + "  ");
            }
            System.out.println();
        }
    }       //Вывод текущего игрового поля

    public void changeFieldTransposing(){
        int k = 0;
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = k; j<sudokuField[0].length; j++){
                int temp = sudokuField[i][j];
                sudokuField[i][j] = sudokuField[j][i];
                sudokuField[j][i] = temp;
            }
            k++;
        }
    }   //Изменение поля путем транспонирования
    public void changeFieldSwapRows(){
        int numberRowOne = random.nextInt(9);
        int numberRowTwo = 0;
        if(numberRowOne == 0 | numberRowOne == 3 | numberRowOne == 6){
            numberRowTwo = numberRowOne + randomWithoutNull();
        }
        if(numberRowOne == 1 | numberRowOne == 4 | numberRowOne == 7){
            int temp = random.nextInt(2);
            if(temp == 0){
                numberRowTwo = numberRowOne -1;
            }
            else {
                numberRowTwo = numberRowOne + 1;
            }
        }
        if (numberRowOne == 2 | numberRowOne == 5 | numberRowOne == 8){
            numberRowTwo = numberRowOne - randomWithoutNull();
        }
        for(int j = 0; j<sudokuField.length; j++){
            int temp = sudokuField[numberRowOne][j];
            sudokuField[numberRowOne][j] = sudokuField[numberRowTwo][j];
            sudokuField[numberRowTwo][j] = temp;
        }
    }   //Изменение поля путем перемешивания двух строк
    public void changeFieldSwapColums(){
        int numberRowOne = random.nextInt(9);
        int numberRowTwo = 0;
        if(numberRowOne == 0 | numberRowOne == 3 | numberRowOne == 6){
            numberRowTwo = numberRowOne + randomWithoutNull();
        }
        if(numberRowOne == 1 | numberRowOne == 4 | numberRowOne == 7){
            int temp = random.nextInt(2);
            if(temp == 0){
                numberRowTwo = numberRowOne -1;
            }
            else {
                numberRowTwo = numberRowOne + 1;
            }
        }
        if (numberRowOne == 2 | numberRowOne == 5 | numberRowOne == 8){
            numberRowTwo = numberRowOne - randomWithoutNull();
        }
        for(int i = 0; i<sudokuField.length; i++){
            int temp = sudokuField[i][numberRowOne];
            sudokuField[i][numberRowOne] = sudokuField[i][numberRowTwo];
            sudokuField[i][numberRowTwo] = temp;
        }
    }   //Изменение поля путем перемешивания двух столбцов
    public void changeFieldSwapRowsArea(){
        int numberAreaOne = random.nextInt(3);
        int  numberAreaTwo = 0;
        if(numberAreaOne == 0){
            numberAreaTwo = randomWithoutNull();
        }
        if(numberAreaOne == 1){
            int temp = random.nextInt(2);
            if(temp == 0){
                numberAreaTwo = numberAreaOne -1;
            }
            else {
                numberAreaTwo = numberAreaOne + 1;
            }
        }
        if(numberAreaOne == 2){
            numberAreaTwo = numberAreaOne - randomWithoutNull();
        }
        for(int j = 0; j<sudokuField.length; j++){
            int tempRow1 = sudokuField[checkValueArea(numberAreaOne)][j];
            int tempRow2 = sudokuField[checkValueArea(numberAreaOne)+1][j];
            int tempRow3 = sudokuField[checkValueArea(numberAreaOne)+2][j];
            sudokuField[checkValueArea(numberAreaOne)][j] = sudokuField[checkValueArea(numberAreaTwo)][j];
            sudokuField[checkValueArea(numberAreaOne)+1][j] = sudokuField[checkValueArea(numberAreaTwo)+1][j];
            sudokuField[checkValueArea(numberAreaOne)+2][j] = sudokuField[checkValueArea(numberAreaTwo)+2][j];
            sudokuField[checkValueArea(numberAreaTwo)][j] = tempRow1;
            sudokuField[checkValueArea(numberAreaTwo)+1][j] = tempRow2;
            sudokuField[checkValueArea(numberAreaTwo)+2][j] = tempRow3;
        }
    }   //Изменение поля путем перестановки малых квадратов в строках
    public void changeFieldSwapColumsArea(){
        int numberAreaOne = random.nextInt(3);
        int  numberAreaTwo = 0;
        if(numberAreaOne == 0){
            numberAreaTwo = randomWithoutNull();
        }
        if(numberAreaOne == 1){
            int temp = random.nextInt(2);
            if(temp == 0){
                numberAreaTwo = numberAreaOne -1;
            }
            else {
                numberAreaTwo = numberAreaOne + 1;
            }
        }
        if(numberAreaOne == 2){
            numberAreaTwo = numberAreaOne - randomWithoutNull();
        }
        for(int i = 0; i<sudokuField.length; i++){
            int tempRow1 = sudokuField[i][checkValueArea(numberAreaOne)];
            int tempRow2 = sudokuField[i][checkValueArea(numberAreaOne)+1];
            int tempRow3 = sudokuField[i][checkValueArea(numberAreaOne)+2];
            sudokuField[i][checkValueArea(numberAreaOne)] = sudokuField[i][checkValueArea(numberAreaTwo)];
            sudokuField[i][checkValueArea(numberAreaOne)+1] = sudokuField[i][checkValueArea(numberAreaTwo)+1];
            sudokuField[i][checkValueArea(numberAreaOne)+2] = sudokuField[i][checkValueArea(numberAreaTwo)+2];
            sudokuField[i][checkValueArea(numberAreaTwo)] = tempRow1;
            sudokuField[i][checkValueArea(numberAreaTwo)+1] = tempRow2;
            sudokuField[i][checkValueArea(numberAreaTwo)+2] = tempRow3;
        }
    }   //Изменение поля путем перестановки мылых квадратов в столбцах
    public void changeField(){
        int n = random.nextInt(5);
        switch (n) {
            case 0:
                changeFieldSwapRows();
                break;
            case 1:
                changeFieldSwapColums();
                break;
            case 2:
                changeFieldSwapRowsArea();
                break;
            case 3:
                changeFieldSwapColumsArea();
                break;
            case 4:
                changeFieldTransposing();
        }
    }   //Изменение поля одним из методов выше.

    public int randomWithoutNull(){
        int number = random.nextInt(3);
        if(number == 0){
            return randomWithoutNull();
        }
        else {
            return number;
        }
    }   //Генерирование чисел без 0
    public int checkValueArea(int number){
        switch (number) {
            case (0):
                number += 0;
                break;
            case (1):
                number += 2;
                break;
            case (2):
                number += 4;
                break;
        }
        return number;
    }   //Метод, с помощью которого мы получаем координаты клетки, когда изменяем поле по малым квадратам
    public int definitionSmallSquare(int number){
        switch (number){
            case (0):
                number = 0;
                break;
            case (1):
                number = 0;
                break;
            case (2):
                number = 0;
                break;
            case (3):
                number = 3;
                break;
            case (4):
                number = 3;
                break;
            case (5):
                number = 3;
                break;
            case (6):
                number = 6;
                break;
            case (7):
                number = 6;
                break;
            case (8):
                number = 6;
                break;
        }
        return number;
    }   //Определение по координатам в каком малом квадрате мы находимся

    public void Game(){
        int [][] sudokuTemp = new int [9][9];
        sudokuFieldCreate();
        int k = 50;
        while(k!=0){
            changeField();
            k--;
        }
        copuSodokuField(sudokuField, sudokuFieldSolve);
        showTwoDimensionalArray(sudokuFieldSolve);
        System.out.println("Выбирите уровень сложности судоку: \n" +
                "1. Easy (35 - 30 клеток на поле) \n" +
                "2. Medium (30 - 25 клеток на поле) \n" +
                "3. Hard (25 - 20 кдеток на поле");
        levelOfDifficulty(scanner.nextInt());
        copuSodokuField(sudokuField, sudokuTemp);
        System.out.println();
        while (statusGame() == false){
            System.out.println("Цифра на клетке: " + sudokuField[player.getY()][player.getX()]);
            System.out.println("X: " + (player.getX() + 1) + "\n" +
                    "Y: " + (player.getY() + 1));
            watchField();
            if(sudokuTemp[player.getY()][player.getX()] == 0){
                if(changeFieldInGame(sudokuField, sudokuTemp, player.getX(), player.getY()) == true){
                    watchField();
                }
            }
            else {
                movePlayer();
            }
        }
        System.out.println("Поздравляю, Вы решили судоку!");
    }


    public void levelOfDifficulty(int levelOfDifficulty){
        int numberOfCellRemove = 0;
        switch (levelOfDifficulty){
            case 1:
                while (numberOfCellRemove<= 30){
                    numberOfCellRemove = random.nextInt(36);
                }
                deleteCell(81 - numberOfCellRemove);
                break;
            case 2:
                while (numberOfCellRemove<= 25){
                    numberOfCellRemove = random.nextInt(31);
                }
                deleteCell(81 - numberOfCellRemove);
                break;
            case 3:
                while (numberOfCellRemove<= 20){
                    numberOfCellRemove = random.nextInt(26);
                }
                deleteCell(81 - numberOfCellRemove);
                break;
        }
    }

    public int [][] tempDataMass(int tempDate [][]){
        tempDate[0][0] = 1;
        for(int i = 0; i<tempDate.length; i++) {
            for (int j = 0; j < tempDate[0].length; j++) {
                if (i == 0) {
                    if (j != 0) {
                        tempDate[i][j] = tempDate[i][j - 1] + 1;
                    }
                } else {
                    tempDate[i][j] = 0;
                }
            }
        }
        return tempDate;
    }   //Заполняет массив особым образом
    public int [] searchCandidates(int iRandom, int jRandom, int [][] field) {
        int[][] tempData = new int[4][9];         //1 - поле, содержащее возможные значения клетки
        tempData[1][0] = 1;                         //2 - поле, содержащее элементы, которых нет в рассматриваемой строке
        tempData[2][0] = 1;                         //3 - поле, содержащее элементы, которых нет в рассматриваемом столбце
        tempData[3][0] = 1;                         //4 - поле, содержащее элементы, которых нет в рассматриваемом малом квадрате
        for (int i = 0; i < tempData.length; i++) {
            for (int j = 0; j < tempData[0].length; j++) {
                if (i == 0) {
                    tempData[i][j] = 0;
                }
                else {
                    if (j>0) {
                        tempData[i][j] = tempData[i][j - 1] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < sudokuField.length; i++) {
            for (int j = 0; j < sudokuField[0].length; j++) {
                if (tempData[1][i] == field[iRandom][j]) {
                    tempData[1][i] = 0;
                }
                if (tempData[2][i] == field[j][jRandom]) {
                    tempData[2][i] = 0;
                }
            }
        }
        for (int k = 0; k < sudokuField.length; k++) {
            for (int i = definitionSmallSquare(iRandom); i < definitionSmallSquare(iRandom) + 3; i++) {
                for (int j = definitionSmallSquare(jRandom); j < definitionSmallSquare(jRandom) + 3; j++) {
                    if (tempData[3][k] == field[i][j]) {
                        tempData[3][k] = 0;
                    }
                }
            }
        }
        for(int i = 0; i<tempData[0].length; i++){
            if(tempData[1][i] == tempData[2][i] & tempData[2][i] == tempData[3][i]){
                tempData[0][i] = tempData[1][i];
            }
        }
        int [] tempMass = new int[tempData[0].length];
        for(int i = 0; i<tempData[0].length; i++){
            tempMass[i] = tempData[0][i];
        }
        return tempMass;
    }   //Поиск кандидатов в ячейку
    public void searchSingleValue(int [][] field){
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = 0; j<sudokuField[0].length; j++){
                if(field[i][j] == 0){
                    int tempValue = 0;
                    int kek = 0;
                    for(int k = 0; k<sudokuField.length; k++){
                        if(searchCandidates(i,j,field)[k] != 0){
                            kek = searchCandidates(i,j,field)[k];
                            tempValue++;
                        }

                    }
                    if(tempValue == 1){
                        field[i][j] = kek;
                    }
                }
            }
        }
    }   //Заполнение ячеек, где возможен единственный кандидат
    public void searchUniqueValuesInSmallSquares(int k, int h, int [][] tempData, int [][] field){
        for(int i = k; i<k+3; i++){
            for(int j = h; j<h+3; j++) {
                if (field[i][j] == 0) {
                    for (int a = 0; a < sudokuField.length; a++) {
                        for (int z = 0; z < sudokuField[0].length; z++) {
                            if (tempData[0][a] == searchCandidates(i, j,field)[z]) {
                                tempData[1][a]++;
                                tempData[2][a] = i;
                                tempData[3][a] = j;
                            }
                        }
                    }
                }
            }
        }
        for (int b = 0; b < tempData[0].length; b++) {
            if (tempData[1][b] == 1) {
                field[tempData[2][b]][tempData[3][b]] = tempData[0][b];
            }
        }
        tempDataMass(tempData);
    }   //Поиск уникального значения в малых квадратах
    public void searchUniqueValue(int [][] field){
        int tempData [][] = new int[4][9];
        //1 - поле для сравнения
        //2 - поле, в котором будут храниться встретившиеся элементы
        //3 - поле, в котором будет сохранена позиция элемента
        //4 - поле, в котором будет сохранена позиция элемента(будет использована при поиске по малым квадратам)
        tempDataMass(tempData);
        //по строкам
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = 0; j<sudokuField[0].length; j++){
                if(field[i][j] == 0){
                    for(int a = 0; a<sudokuField.length; a++) {
                        for (int z = 0; z < sudokuField[0].length; z++) {
                            if(tempData[0][a] == searchCandidates(i,j,field)[z]){
                                tempData[1][a]++;
                                tempData[2][a] = j;
                            }
                        }
                    }
                }
            }
            for(int b = 0; b<tempData[0].length; b++){
                if(tempData[1][b] == 1){
                    field[i][tempData[2][b]] = tempData[0][b];
                }
            }
            tempDataMass(tempData);
        }
        //по столбцам
        for(int i = 0; i<sudokuField.length; i++){
            for(int j = 0; j<sudokuField[0].length; j++){
                if(field[j][i] == 0){
                    for(int a = 0; a<sudokuField.length; a++) {
                        for (int z = 0; z < sudokuField[0].length; z++) {
                            if(tempData[0][a] == searchCandidates(j,i,field)[z]){
                                tempData[1][a]++;
                                tempData[2][a] = j;
                            }
                        }
                    }
                }
            }
            for(int b = 0; b<tempData[0].length; b++){
                if(tempData[1][b] == 1){
                    field[tempData[2][b]][i] = tempData[0][b];
                }
            }
            tempDataMass(tempData);
        }
        //по малым квадратам
        for(int i =0; i<sudokuField.length;i+=3){
            for (int j = 0; j<sudokuField[0].length; j+=3){
                searchUniqueValuesInSmallSquares(i, j, tempData, field);
            }
        }
    }
    //Поиск уникального значения. Уникальные - это те значения,
    //которые встречаются в контейнерах возможных значений строки или колонки или блока единожды.


    public int solve(int [][] field){
        int sum = 0;
        int tempSumm = 0;
        while (sum != 405) {
            searchSingleValue(field);
            searchUniqueValue(field);
            for(int i = 0; i<sudokuField.length; i++){
                for(int j = 0; j<sudokuField[0].length; j++){
                    sum += field[i][j];
                }
            }
            if(tempSumm != sum){
                tempSumm = sum;
                sum = 0;
            }
            else {
                break;
            }
        }
        return sum;
    }   //Алгоритм, решающий судоку, у которой только единственное решение
    public void deleteCell(int n) {
        int iterator = 0;
        int sudokuFieldTemp[][] = new int[9][9];
        while (iterator != n) {
            if (iterator > 55){
                int tempArray [][] = new int[2][81-iterator];
                int a = 0;
                for(int i = 0; i<sudokuField.length; i++) {
                    for (int j = 0; j < sudokuField[0].length; j++) {
                        if(sudokuField[i][j] != 0){
                            tempArray[0][a] = i;
                            tempArray[1][a] = j;
                            a++;
                        }
                    }
                }
                a = 0;
                while (a != tempArray[0].length) {
                    sudokuFieldTemp[tempArray[0][a]][tempArray[1][a]] = 0;
                    if (solve(sudokuFieldTemp) == 405) {
                        sudokuField[tempArray[0][a]][tempArray[1][a]] = 0;
                        copuSodokuField(sudokuField, sudokuFieldTemp);
                        iterator++;
                        a++;
                    } else {
                        copuSodokuField(sudokuField, sudokuFieldTemp);
                        a++;
                    }
                }
                break;
            }
            else {
                copuSodokuField(sudokuField, sudokuFieldTemp);
                int i = random.nextInt(9);
                int j = random.nextInt(9);
                if (sudokuField[i][j] != 0) {
                    sudokuFieldTemp[i][j] = 0;
                    if (solve(sudokuFieldTemp) == 405) {
                        sudokuField[i][j] = 0;
                        copuSodokuField(sudokuField, sudokuFieldTemp);
                        iterator++;
                    } else {
                        copuSodokuField(sudokuField, sudokuFieldTemp);
                    }
                }
            }
        }
    }   //Удаление клеток таким образом, чтобы финальная судоку имела единственное решение
    public void copuSodokuField(int [][] firstField, int [][] secondField){
        for(int a = 0; a<9; a++){
            for(int b = 0; b<9; b++){
                secondField[a][b] = firstField[a][b];
            }
        }
    }   //Перенос значений из одного массива в другой

    public void showTwoDimensionalArray(int [][] mas){
        for(int i = 0; i<mas.length; i++){
            for(int j = 0; j<mas[0].length; j++) {
                System.out.print(mas[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public void showDimensionalArray(int [] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }

    public void movePlayer() {
        String move = scanner.next();
        if (move.equals("w") || move.equals("ц")) {
            if (player.getY() > 0) {
                player.moveUp();
            }
        } else if (move.equals("s") || move.equals("ц")){
            if (player.getY() < 8){
                player.moveDown();
            }
        } else if (move.equals("a") || move.equals("ф")){
            if(player.getX() > 0){
                player.moveLeft();
            }
        } else if (move.equals("d") || move.equals("в")){
            if(player.getX() < 8){
                player.moveRight();
            }
        }
    }   //Движение курсора по полю матрицы
    public void movePlayer(String move) {
        //String move = scanner.next();
        if (move.equals("w") || move.equals("ц")) {
            if (player.getY() > 0) {
                player.moveUp();
            }
        } else if (move.equals("s") || move.equals("ц")){
            if (player.getY() < 8){
                player.moveDown();
            }
        } else if (move.equals("a") || move.equals("ф")){
            if(player.getX() > 0){
                player.moveLeft();
            }
        } else if (move.equals("d") || move.equals("в")){
            if(player.getX() < 8){
                player.moveRight();
            }
        }
    }

    public boolean changeFieldInGame(int [][] sudokuField,int [][] sudokuTemp, int x, int y){
        String chose = scanner.next();
        boolean status = false;
        if(chose.equals("f") || chose.equals("а")) {
            //if (sudokuTemp[y][x] == 0) {
                System.out.println("Вы на находитесь на клетке с координатами X: " + (x + 1) + " Y: " + (y + 1) + " \n" +
                        "Хотите изменить значение клетки, на которой Вы находитесь? \n" +
                        "1. Да \n" +
                        "2. Нет");
                int answer = scanner.nextInt();
                switch (answer) {
                    case (1):
                        System.out.println("Введите ваше число: ");
                        sudokuField[y][x] = inputValue(scanner.nextInt(), x, y);
                        status = true;
                        break;
                    case (2):
                        break;
               // }
            }
        }
        else {
            movePlayer(chose);
        }
        return status;
    }   //Метод меняющий значение клеток во время игры

    public int inputValue(int value, int x, int y){
        if(value > 0 & value < 10){
            System.out.println("Вы поставили число " + value + ". Его координаты по X: " + (x+1) + " и " + "Y: " + (y+1));
            return value;
        }
        else {
            System.out.println("В судоку должны стоять числа, от 1 до 9. \n" +
                    "Введите число заного.");
            value = scanner.nextInt();
            inputValue(value, x,y);
        }
        return value;
    }   //Проверка введенного числа(от 1 до 9)

    public boolean statusGame(){
        boolean status = true;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(sudokuField[i][j] == sudokuFieldSolve[i][j]) {
                }
                else {
                    status = false;
                }
            }
        }
        return status;
    }   //Проверяет закончилась игра или нет, т.е. совпадает ли Ваша решенная судоку с ответом. Ответ может быть только один
}
