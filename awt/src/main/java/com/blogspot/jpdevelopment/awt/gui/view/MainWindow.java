package com.blogspot.jpdevelopment.awt.gui.view;

import com.blogspot.jpdevelopment.awt.AwtConfig;
import com.blogspot.jpdevelopment.awt.gui.control.UpdateNewsController;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsEvent;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends Frame {

    private final TextArea textArea;
    private final Button button;

    ApplicationContext context = new AnnotationConfigApplicationContext(AwtConfig.class);

    public MainWindow() {
        this.textArea = setupTextArea();
        this.button = setupNewsButton();

        setupCloseWindowEvent();
        setupFrame(this.textArea, this.button);
    }

    private TextArea setupTextArea() {
        TextArea textArea = new TextArea();
        textArea.setBounds(25, 50, 450, 675);
        return textArea;
    }

    private Button setupNewsButton() {
        UpdateNewsController updateNewsController = this.context.getBean(UpdateNewsController.class);

        Button b = new Button("Update news");
        b.setBounds(25, 750, 100, 25);
        b.addActionListener(e -> {
            System.out.println("Button has been clicked");
            UpdateNewsResult updateNewsResult = updateNewsController.updateNews(new UpdateNewsEvent());
            this.textArea.append(updateNewsResult.prettyPrint());
        });
        return b;
    }

    private void setupCloseWindowEvent() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void setupFrame(Component... components) {
        for (Component component : components) {
            add(component);
        }
        setSize(500, 800);
        setBackground(new Color(195, 195, 195));
        setLayout(null); //no layout manager
        setVisible(true);
    }
}
