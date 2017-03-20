
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class SwingValidator
{
    public boolean isPresent(JTextComponent c, String title)
    {
        if (c.getText().length() == 0)
        {
            showMessage(c, title + " is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isIntegerWithinRange(JTextComponent c, String title, int min, int max)
    {
        try
        {
            int i = Integer.parseInt(c.getText());
        		if (i < min)
        		{
        		 	showMessage(c, title + " must be an integer greater than " + min);
        		 	c.requestFocusInWindow();
        		 	return false;
        		}
        		else if (i > max)
        		{
        			showMessage(c, title + " must be an integer less than " + max);
        		 	c.requestFocusInWindow();
        		 	return false;
        		}
        		else
        			return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be an integer.");
            c.requestFocusInWindow();
            return false;
        }
    }


    public boolean isDouble(JTextComponent c, String title)
    {
        try
        {
            double d = Double.parseDouble(c.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            showMessage(c, title + " must be a valid number.");
            c.requestFocusInWindow();
            return false;
        }
    }

    private void showMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public void showPositiveMessage(JTextComponent c, String message)
    {
            JOptionPane.showMessageDialog(c, message, "Success",
                JOptionPane.DEFAULT_OPTION);
    }

}
