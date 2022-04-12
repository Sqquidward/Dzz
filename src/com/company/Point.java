package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Point{
    private int x;

    public int getY() {
        return y;
    }

    private int y;

    public int getX() {
        return x;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Solution do_smt = new Solution();
        System.out.println("Максимальное X: "+do_smt.X_Max()+"\n");
        System.out.println("Растояние от точки, до начала координат.");
        do_smt.Rast();
        System.out.println("\nСортировка по расстоянию до начала координат.");

        //Да, последняя функция получилась максимально убого
        for(int i = 0; i<do_smt.new_Potok().size(); i++){
            System.out.println("X-"+do_smt.new_Potok().get(i).getX()+"   Y-"+do_smt.new_Potok().get(i).getY());
        }
    }


}

class Solution{
    public List<Point> X_Y(){
        List<Point> List_xy = new ArrayList<>();
        //Добавляем координаты x и y
        List_xy.add(new Point(1, 3));
        List_xy.add(new Point(5, 2));
        List_xy.add(new Point(9, 7));
        List_xy.add(new Point(6, 1));
        List_xy.add(new Point(5, 8));
        List_xy.add(new Point(2, 7));

        return List_xy;

    }
    public int X_Max(){
        return X_Y().stream().max(comparing(Point::getX)).get().getX();
    }

    public void Rast(){
        X_Y().stream()
                .map(h->Math.sqrt(Math.pow(h.getX(), 2)+Math.pow(h.getY(), 2)))
                .forEach(System.out::println);
    }



    public List<T> new_Potok(){
        List<T> List_xy = Arrays.asList(
                new T(4, 9, (int) Math.sqrt(Math.pow(4, 2)+Math.pow(9, 2))),
                new T(5, 8, (int) Math.sqrt(Math.pow(5, 2)+Math.pow(8, 2))),
                new T(7, 6, (int) Math.sqrt(Math.pow(7, 2)+Math.pow(6, 2))),
                new T(8, 7, (int) Math.sqrt(Math.pow(8, 2)+Math.pow(7, 2))),
                new T(9, 5, (int) Math.sqrt(Math.pow(9, 2)+Math.pow(5, 2))));
        //Создает новый поток, расттояних которых до начала координат больше 5
        //Создать массив только с (x, y) и отсортирвоать его по расстоянию у меня не получилось и я добавил еще путь до начала координат
        //Да, это не совсем по заданию, но я еще постараюсь подумать, как это сделать с помощью steam api


        return List_xy.stream().sorted(Comparator.comparingInt(T::getWay).reversed()).collect(Collectors.toList());

    }}

class T{
    public int x;
    public  int y;
    public int way;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWay() {
        return way;
    }

    public T(int x, int y, int way) {
        this.x = x;
        this.y = y;
        this.way = way;
    }}
