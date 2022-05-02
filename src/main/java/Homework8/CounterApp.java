package Homework8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CounterApp extends JFrame {
    private int value;



    //camelCaseText
    //snake_case_text
    //kebab-case-text

    public CounterApp(int initialValue) {
        this.value = initialValue;
        setBounds(500, 500, 700, 150);
        setTitle("Simple counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Создадим шрифт
        Font font = new Font("Arial", Font.BOLD, 50);
        setLayout(new GridLayout(1,5));
        //Уменьшение значения
        JButton decrement = new JButton("-1");
        decrement.setFont(font);
        add(decrement, BorderLayout.WEST);
        //Уменьшение значения  на 10
        JButton decrement10 = new JButton("-10");
        decrement10.setFont(font);
        add(decrement10);
        //Создадим сам счетчик
        JLabel counterValue = new JLabel(String.valueOf(this.value));
        counterValue.setFont(font);
        counterValue.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValue);
        //Увеличение значения
        JButton increment = new JButton("+1");
        increment.setFont(font);
        add(increment);
        //Увеличение значения
        JButton increment10 = new JButton("+10");
        increment10.setFont(font);
        add(increment10);

        //Добавляем слушателей
        decrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                counterValue.setText(String.valueOf(value));

            }
        });
        decrement10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = value - 10;
                counterValue.setText(String.valueOf(value));
            }
        });
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                counterValue.setText(String.valueOf(value));
            }
        });
        increment10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = value + 10;
                counterValue.setText(String.valueOf(value));
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp(0);
    }
}