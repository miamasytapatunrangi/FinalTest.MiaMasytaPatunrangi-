/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rusaut.ia.zz;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Rusaut.ia.Pasien;
import Rusaut.Koneksi;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class PasienRsia implements PasienInterface{
    @Override
    public Pasien create(Pasien psn) throws SQLException {
        PreparedStatement st = Koneksi.getKoneksi().prepareStatement("insert into pasien values (?,?,?,?)");
        st.setString(1, psn.getId_pasien());
        st.setString(2, psn.getNama());
        st.setString(3, psn.getUsia());
        st.setString(4, psn.getAlamat());
        st.executeUpdate();

        return psn;
    }
    
    @Override
    public void update(Pasien psn) throws SQLException {
        PreparedStatement st = Koneksi.getKoneksi().prepareStatement("update pasien set nama=?, usia=?, alamat=? where id_pasien=?");
        st.setString(1, psn.getNama());
        st.setString(2, psn.getUsia());
        st.setString(3, psn.getAlamat());
        st.setString(4, psn.getId_pasien());
        st.executeUpdate();

    }
    
    @Override
    public void delete(String id_pasien) throws SQLException {
        PreparedStatement st = Koneksi.getKoneksi().prepareStatement("delete from pasien where id_pasien=?");
        st.setString(1, id_pasien);
        st.executeUpdate();
   
    }

    @Override
    public List retriveData() throws SQLException {
        Statement st = Koneksi.getKoneksi().createStatement();
        ResultSet rs = st.executeQuery("select * from pasien");
        List list = new ArrayList();
        while (rs.next()){
                Pasien psn = new Pasien();
                psn.setId_pasien(rs.getString("id_pasien"));
                psn.setNama(rs.getString("nama"));
                psn.setUsia(rs.getString("usia"));
                psn.setAlamat(rs.getString("alamat"));
                list.add(psn);
        }
        return list;
    }
}
