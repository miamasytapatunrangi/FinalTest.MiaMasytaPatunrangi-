/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Rusaut.ia.zz;
import java.sql.SQLException;
import Rusaut.ia.Pasien;
import java.util.List;
/**
 *
 * @author ASUS
 */
public interface PasienInterface {
    public Pasien create(Pasien psn) throws SQLException;
    public void update(Pasien p)throws SQLException;
    public void delete(String id_pasien)throws SQLException;
    public List retriveData()throws SQLException;
    
}
