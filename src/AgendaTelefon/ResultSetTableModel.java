/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaTelefon;

/**
 *
 * @author Razvan
 */


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author instructor
 */
public class ResultSetTableModel extends AbstractTableModel{
    private ResultSet r;

    public ResultSetTableModel(ResultSet r) {
        this.r = r;
    }
    
    @Override
    public int getRowCount() {
        try {
            r.last();
            return r.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            //        return 3;
            ResultSetMetaData meta = r.getMetaData();
            return meta.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            r.absolute(rowIndex+1);
            return r.getString(columnIndex+1);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            ResultSetMetaData meta = r.getMetaData();
            return meta.getColumnName(column+1);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }
    public void setValueAt(Object v, int row, int col){
        //ResultSet r  = get(row);
    }
    
}

