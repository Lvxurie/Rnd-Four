import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StockTableModel extends AbstractTableModel {
    private Collection<Computer> computers;
    private Collection<Computer> allComputers;
    private String currentType;
    private String currentCategory;
    private final String[] columnNames = {"ID", "Category", "Type", "Brand", "CPU Family", "Price"};
    public StockTableModel(Collection<Computer> data){
        allComputers = data;
        computers = new ArrayList<>(allComputers);
        currentCategory = "---Show All---";
        currentType = "---Show All---";
    }
    //update data
    public void updateData(){
        ArrayList<Computer> updatedData = new ArrayList<>();
        for(Computer c : allComputers){
            if((c.getType().equals(currentType) || currentType.equals("---Show All---")) && (c.getCategory().equals(currentCategory) || currentCategory.equals("---Show All---"))){
                updatedData.add(c);
            }
        }
        computers = updatedData;
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
            case 1: return temp.getCategory();
            case 2: return temp.getType();
            case 3: return temp.getBrand();
            case 4: return temp.getCpuFamily();
            case 5: return temp.getPrice();
            default: return null;
        }
    }
public void updateType(String currentType){
        this.currentType = currentType;
        updateData();
}
public void updateCategory(String currentCategory){
        this.currentCategory = currentCategory;
        updateData();
}
public Computer activeSelection(int index){
        Computer[] activeList = computers.toArray(computers.toArray(new Computer[0]));
        return activeList[index];
}
public boolean checkDuplicateID(String id){
        for(Computer c: computers){
            if(c.getId().equals(id)){
                return true;
            }
        }
        return false;
}
public void updateMasterList(Collection<Computer> newList){
        allComputers = newList;
}
}
