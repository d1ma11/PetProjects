package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDigitButton extends Button implements ActionListener {

    MyCalculator cl;

    MyDigitButton(int x, int y, int width, int height, String cap, MyCalculator clc) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);
    }

    static boolean isLnString(String s, char ch) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ch)
                return true;
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String tempText = ((MyDigitButton) event.getSource()).getLabel();
        if (tempText.equals(".")) {
            if (cl.setClear) {
                cl.displayLabel.setText("0.");
                cl.setClear = false;
            } else if (!isLnString(cl.displayLabel.getText(), '.')) {
                cl.displayLabel.setText(cl.displayLabel.getText() + ".");
            }
            return;
        }

        int index = 0;
        try {
            index = Integer.parseInt(tempText);
        } catch (NumberFormatException exception) {
            return;
        }

        if (index == 0 && cl.displayLabel.getText().equals("0")) {
            return;
        }

        if (cl.setClear) {
            cl.displayLabel.setText("" + index);
            cl.setClear = false;
        } else {
            cl.displayLabel.setText(cl.displayLabel.getText() + index);
        }
    }
}
