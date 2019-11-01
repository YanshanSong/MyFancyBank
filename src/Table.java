import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Table {
    private JTable table;
    private String[] title;
    private Object[][] data;
    DefaultTableModel model;

    public Table(String[] title, String[][] data) {
        this.title = title;
        this.data = data;
    }

    public JScrollPane generateTable() {
        model = new DefaultTableModel(data, title);
		table = new JTable(model);
		table.setGridColor(Color.BLACK);

		table.setEnabled(false);

		// must do: bind JTable to JScrollPane
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setViewportView(table);
		return jscrollpane;
    }

    public void setTableValue(String value, int i, int j) {
        table.setValueAt(value, i, j);
    }

    public void addRowData(String[] rowData) {
        model.addRow(rowData);
    }

    public void setColumnWidth(int index, int width) {
        TableColumn column = table.getColumnModel().getColumn(index);
        column.setPreferredWidth(width);
    }
}
