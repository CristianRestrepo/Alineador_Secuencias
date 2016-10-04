package Lógica;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRender
  extends DefaultTableCellRenderer
{
  String[][] alineamiento;
  int rows = 0;
  
  public MiRender(String[][] alineamiento, int rows)
  {
    this.alineamiento = alineamiento;
    this.rows = rows;
  }
  
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if ((table.getValueAt(row, column) != null) && (!table.getValueAt(row, column).equals(" "))) {
      if (this.alineamiento[row][column].equals("-"))
      {
        setForeground(Color.RED);
      }
      else if ((row != 0) && (this.alineamiento[(row - 1)][column].equals("-")))
      {
        setForeground(Color.RED);
      }
      else if ((row != this.rows - 1) && (this.alineamiento[(row + 1)][column].equals("-")))
      {
        setForeground(Color.RED);
      }
      else if ((row != 0) && (this.alineamiento[(row - 1)][column].equals(this.alineamiento[row][column])))
      {
        setForeground(Color.GREEN);
      }
      else if ((row != this.rows - 1) && (this.alineamiento[(row + 1)][column].equals(this.alineamiento[row][column])))
      {
        setForeground(Color.GREEN);
      }
      else
      {
        setForeground(Color.YELLOW);
      }
    }
    return this;
  }
}
