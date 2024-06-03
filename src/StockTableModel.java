import javax.swing.table.AbstractTableModel;
import java.util.Collection;

public class StockTableModel extends AbstractTableModel {
    private Collection<Computer> computers;
    private final String[] columnNames = {"ID", "Category", "Type", "Brand", "CPU Family", "Price"};
    public StockTableModel(Collection<Computer> data){
        computers = data;
    }
    //update data
    public void updateData(Collection<Computer> data){
        computers = data;
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return computers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Computer[] computer = computers.toArray(new Computer[0]);
        Computer temp = computer[rowIndex];
        switch (columnIndex){
            case 0: return temp.getId();
            case 1: return temp.getCatagory();
            case 2: return temp.getType();
            case 3: return temp.getBrand();
            case 4: return temp.getCpuFamily();
            case 5: return temp.getPrice();
            default: return null;
        }
    }

}
