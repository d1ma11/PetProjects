package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySpecialButton extends Button implements ActionListener {
    MyCalculator cl;

    MySpecialButton(int x, int y, int width, int height, String cap, MyCalculator clc) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);
    }

    static String backSapce(String s) {
        String Res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            Res += s.charAt(i);
        }
        return Res;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String opText = ((MySpecialButton) event.getSource()).getLabel();
        //checking for button "backspace"
        if (opText.equals("Backspc")) {
            String tempText = backSapce(cl.displayLabel.getText());
            if (tempText.equals("")) {
                cl.displayLabel.setText("0");
            } else {
                cl.displayLabel.setText(tempText);
            }
        }

        //checking for "C" button i.e. Reset
        if (opText.equals("C")) {
            cl.number = 0.0;
            cl.op = ' ';
            cl.memValue = 0.0;
            cl.memLabel.setText(" ");
        }
        cl.displayLabel.setText("0");
        cl.setClear = true;
    }
}
