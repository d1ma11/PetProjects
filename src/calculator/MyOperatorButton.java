package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyOperatorButton extends Button implements ActionListener {
    MyCalculator cl;

    MyOperatorButton(int x, int y, int width, int height, String cap, MyCalculator clc) {
        super(cap);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String opText = ((MyOperatorButton) event.getSource()).getLabel();
        cl.setClear = true;
        double temp = Double.parseDouble(cl.displayLabel.getText());

        if (opText.equals("1/x")) {
            try {
                double tempd = 1 / temp;
                cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
            } catch (ArithmeticException exception) {
                cl.displayLabel.setText("Divide by 0.");
            }
            return;
        }

        if (opText.equals("√")) {
            try {
                double tempd = Math.sqrt(temp);
                cl.displayLabel.setText((MyCalculator.getFormattedText(tempd)));
            } catch (ArithmeticException exception) {
                cl.displayLabel.setText("Divide by 0.");
            }
            return;
        }
        if (!opText.equals("=")) {
            cl.number = temp;
            cl.op = opText.charAt(0);
            return;
        }

        switch (cl.op) {
            case '+' -> temp += cl.number;
            case '-' -> temp = cl.number - temp;
            case '*' -> temp *= cl.number;
            case '%' -> {
                try {
                    temp = cl.number % temp;
                } catch (ArithmeticException exception) {
                    cl.displayLabel.setText("Divide by 0.");
                }
            }
            case '/' -> {
                try {
                    temp = cl.number / temp;
                } catch (ArithmeticException exception) {
                    cl.displayLabel.setText("Divide by 0.");
                }
            }
        }
        cl.displayLabel.setText(MyCalculator.getFormattedText(temp));
    }
}
