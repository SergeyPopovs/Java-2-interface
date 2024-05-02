package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//наследуем класс JDialog для создания диалогового окна
public class AsteroidDialog extends JDialog {
    JTextField name;
    JTextField period;
    JTextField length;
    JButton apply;
    JButton cancel;
    private static AsteroidDialog asteroidDialog;
    com.company.comet comet;
    String cometName;
    double cometPeriod;
    double cometTail;

//создание конструктора класса для построения диалогового окна и помещения класса comet
    public AsteroidDialog(Frame parent, com.company.comet comet) {
//наследование конструктора супер класса Dialog
        super(parent, "Интересный космос", false);
        this.comet = comet;
//создание панели и цвета фона
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBackground(Color.YELLOW);
//создание текстовых полей и надписей к ним
        JLabel namep = new JLabel("Имя кометы");
        name = new JTextField(12);
        name.setText(comet.getName());
        namep.setLabelFor(name);

        JLabel periodp = new JLabel("Период вращения");
        period = new JTextField(12);
        period.setText(String.valueOf(comet.getP()));
        periodp.setLabelFor(period);

        JLabel lengthp = new JLabel("Длина хвоста");
        length = new JTextField(12);
        length.setText(String.valueOf(comet.getTaillength()));
        lengthp.setLabelFor(length);
//создание кнопок
        apply = new JButton("ok");
        apply.setPreferredSize(new Dimension(90, 25));

        cancel = new JButton("отмена");
        cancel.setPreferredSize(new Dimension(90, 25));
//добавление элементов на панель
        panel.add(namep);
        panel.add(name);
        panel.add(periodp);
        panel.add(period);
        panel.add(lengthp);
        panel.add(length);
        panel.add(apply);
        panel.add(cancel);
//расположение элементов
        SpringLayout layout = (SpringLayout) panel.getLayout();
        layout.putConstraint(SpringLayout.WEST , namep, 40,
                SpringLayout.WEST , panel);
        layout.putConstraint(SpringLayout.NORTH, namep, 25,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST , name, 40,
                SpringLayout.WEST , panel);
        layout.putConstraint(SpringLayout.NORTH, name, 50,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, periodp, 180,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, periodp, 25,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, period, 180,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, period, 50,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lengthp, 320,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lengthp, 25,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, length, 320,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, length, 50,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, apply, 150,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, apply, 77,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, cancel, 300,
                SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, cancel, 77,
                SpringLayout.NORTH, panel);
//добавление панели на фрейм
        add(panel);
//добавление лисенеров и экшенеров на кнопку
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comet.setName(name.getText());
                comet.setP(Double.parseDouble(period.getText()));
                comet.setTaillength(Double.parseDouble(length.getText()));
                dispose();
             }
        });
//добавление лисенеров и экшенеров на кнопку
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setSize(500,240);
        setModal(true);
        setVisible(true);
        setLocationRelativeTo(parent);
    }
//метод для редактирования объекта comet
    public static void editObject(Frame parent, com.company.comet comet) {
        //AsteroidDialog dialog = new AsteroidDialog(parent,comet );
        //dialog.setVisible(true);
        if (asteroidDialog == null) {
            asteroidDialog = new AsteroidDialog(parent,comet);
        } else {
            asteroidDialog.updateFields(comet);
        }
        asteroidDialog.setVisible(true);
    }

    // Метод для обновления значений полей
    public void updateFields(com.company.comet comet) {
        name.setText(comet.getName());
        period.setText(String.valueOf(comet.getP()));
        length.setText(String.valueOf(comet.getTaillength()));
    }
}

