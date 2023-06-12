/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import Data.DatabaseAcc;
import Model.SinhVien;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

// @by Truong Viet Tran-0333999726
public class QLSV extends javax.swing.JFrame {

    /**
     * Creates new form QLSV
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    SinhVien sinhVien;

    public QLSV() {
        initComponents();
        showTable();
    }
    String ImagePast = null;

    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    public boolean CheckInput() {
        if (txtMaSv.getText() == null || txtHoTen.getText() == null || txtEmail.getText() == null
                || checkNam.getText() == null || checkNu.getText() == null || txtDiaChi.getText() == null) {
            return false;
        } else {
            try {
                Integer.parseInt(txtSDT.getText());
                return true;
            } catch (Exception E) {
                return false;
            }
        }
    }

    // @by Truong Viet Tran-0333999726
    //đưa dữ liệu từ sever về để hiễn thị lên table
    public ArrayList<SinhVien> getSinhVienList() {
        ArrayList<SinhVien> sinhViens = new ArrayList<SinhVien>();
        con = DatabaseAcc.getDatabaseAcc();
        String query = "SELECT * FROM SinhVien";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sinhVien = new SinhVien(rs.getInt("id"), rs.getString("MaSV"), rs.getString("HoTen"),
                        rs.getString("Email"), Integer.parseInt(rs.getString("SDT")), rs.getString("GioTinh"), rs.getString("DiaChi"), rs.getBytes("HinhAnh"));
                sinhViens.add(sinhVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhViens;
    }

    //hiễn thị lên table
    public void showTable() {
        ArrayList<SinhVien> list = getSinhVienList();
        DefaultTableModel model = (DefaultTableModel) tbhienthi.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaSV();
            row[1] = list.get(i).getHoTen();
            row[2] = list.get(i).getEmail();
            row[3] = formatPhoneNumber(list.get(i).getSDT());
            row[4] = list.get(i).getGiotinh();
            row[5] = list.get(i).getDiaChi();
            row[6] = list.get(i).getHinhanh();
            model.addRow(row);
        }
    }

    public String formatPhoneNumber(int phoneNumber) {
        String formattedNumber = String.valueOf(phoneNumber);
        if (formattedNumber.length() < 10) {
            formattedNumber = "+84" + formattedNumber;
        }
        return formattedNumber;
    }

    public void ShowItem(int index) {
        txtMaSv.setText(getSinhVienList().get(index).getMaSV());
        txtHoTen.setText(getSinhVienList().get(index).getHoTen());
        txtEmail.setText(getSinhVienList().get(index).getEmail());
        txtSDT.setText(Integer.toString(getSinhVienList().get(index).getSDT()));
        if (tbhienthi.getValueAt(index, 4).equals("Nam")) {
            checkNam.setSelected(true);
        } else {
            checkNu.setSelected(true);
        }
        txtDiaChi.setText(getSinhVienList().get(index).getDiaChi());
        lbimage.setIcon(ResizeImage(null, getSinhVienList().get(index).getHinhanh()));
    }

    public void Clean() {
        txtMaSv.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        checkNam.setSelected(false);
        checkNu.setSelected(false);
        txtDiaChi.setText("");
        lbimage.setIcon(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @by Truong Viet Tran-0333999726
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkNam = new javax.swing.JRadioButton();
        checkNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbhienthi = new javax.swing.JTable();
        bntIcon = new javax.swing.JButton();
        bntSave = new javax.swing.JButton();
        bntdetele = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbimage = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        nhapmsv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Hồ Sơ Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã SV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Họ Tên:");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Email:");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Giới Tính:");

        checkNam.setText("Nam");
        checkNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNamActionPerformed(evt);
            }
        });

        checkNu.setText("Nu");
        checkNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        tbhienthi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình Ảnh"
            }
        ));
        tbhienthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhienthiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbhienthi);

        bntIcon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_add.png"))); // NOI18N
        bntIcon.setText("New");
        bntIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIconActionPerformed(evt);
            }
        });

        bntSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_save.png"))); // NOI18N
        bntSave.setText("Save");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntdetele.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntdetele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_delete.png"))); // NOI18N
        bntdetele.setText("Delete");
        bntdetele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntdeteleActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbimage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbimageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbimage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 102, 0));
        search.setText("search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        nhapmsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapmsvActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("TÌM KIẾM THEO MÃ SINH VIÊN :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel10.setText("(số điện thoại phải bắt buộc là 10 chữ số , định dạng mã vùng là +84)");

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("@by:Nhom12 -VietTruong-ThanhThao-VanQuan-PhuongNga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(30, 30, 30)
                                .addComponent(nhapmsv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(118, 118, 118)
                                        .addComponent(checkNam)
                                        .addGap(94, 94, 94)
                                        .addComponent(checkNu))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(97, 97, 97)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(88, 88, 88)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jLabel10)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntdetele, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(283, 283, 283))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(bntIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkNam)
                            .addComponent(checkNu)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(bntdetele, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhapmsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbimageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbimageMouseClicked
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbimage.setIcon(ResizeImage(path, null));
            ImagePast = path;
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình ảnh");
        }
    }//GEN-LAST:event_lbimageMouseClicked

    private void bntIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIconActionPerformed
        // TODO add your handling code here:
        this.Clean();

    }//GEN-LAST:event_bntIconActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (CheckInput() && txtMaSv.getText() != null && txtSDT.getText().length() == 10) {
            String maSV = txtMaSv.getText();
            con = DatabaseAcc.getDatabaseAcc();

            try {
                // Kiểm tra sự tồn tại của Mã Sinh Viên
                pst = con.prepareStatement("SELECT * FROM SinhVien WHERE MaSV = ?");
                pst.setString(1, maSV);
                ResultSet rs = pst.executeQuery();

                if (rs.next() && !maSV.equals(txtMaSv.getText())) {
                    // Mã Sinh Viên đã tồn tại, hiển thị thông báo
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại, không thể cập nhật !");
                } else {
                    // Mã Sinh Viên không tồn tại hoặc cập nhật cùng mã Sinh Viên, tiến hành cập nhật dữ liệu
                    String UpString = null;
                    pst = null;
                    if (ImagePast == null) {
                        UpString = "UPDATE SinhVien SET HoTen = ?, Email = ?, SDT = ?, GioTinh = ?, DiaChi = ? WHERE MaSV = ?";
                        pst = con.prepareStatement(UpString);
                        pst.setString(1, txtHoTen.getText());
                        pst.setString(2, txtEmail.getText());
                        pst.setInt(3, Integer.parseInt(txtSDT.getText()));
                        if (checkNam.isSelected()) {
                            pst.setString(4, checkNam.getText());
                        }
                        if (checkNu.isSelected()) {
                            pst.setString(4, checkNu.getText());
                        }
                        pst.setString(5, txtDiaChi.getText());
                        pst.setString(6, maSV);
                    } else {
                        InputStream img = new FileInputStream(new File(ImagePast));
                        UpString = "UPDATE SinhVien SET HoTen = ?, Email = ?, SDT = ?, GioTinh = ?, DiaChi = ?, HinhAnh = ? WHERE MaSV = ?";
                        pst = con.prepareStatement(UpString);
                        pst.setString(1, txtHoTen.getText());
                        pst.setString(2, txtEmail.getText());
                        pst.setInt(3, Integer.parseInt(txtSDT.getText()));
                        if (checkNam.isSelected()) {
                            pst.setString(4, checkNam.getText());
                        }
                        if (checkNu.isSelected()) {
                            pst.setString(4, checkNu.getText());
                        }
                        pst.setString(5, txtDiaChi.getText());
                        pst.setBlob(6, img);
                        pst.setString(7, maSV);
                    }

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    this.Clean();
                    showTable(); // Thực hiện làm mới bảng dữ liệu sau khi cập nhật thành công
                }

                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
        }


    }//GEN-LAST:event_jButton1ActionPerformed
// @by Truong Viet Tran-0333999726
    private void bntdeteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntdeteleActionPerformed
        try {
            // Establish a database connection
            con = DatabaseAcc.getDatabaseAcc();

            // Prompt the user to enter the value of "MaSV" to be checked and deleted
            String xoa = JOptionPane.showInputDialog(this, "Nhập Mã NV cần xóa");

            // Prepare a SQL statement to select a record from the "SinhVien" table based on the "MaSV" column
            pst = con.prepareStatement("SELECT * FROM SinhVien WHERE MaSV = ?");
            pst.setString(1, xoa);

            // Execute the select query
            ResultSet rs = pst.executeQuery();

            // Check if the student ID exists
            if (rs.next()) {
                // Display a confirmation message dialog
                int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    // Prepare a SQL statement to delete the record from the "SinhVien" table
                    pst = con.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?");
                    pst.setString(1, xoa);

                    // Execute the delete operation
                    int deleteResult = pst.executeUpdate();
                    if (deleteResult > 0) {
                        // Display a success message dialog
                        JOptionPane.showMessageDialog(this, "Xóa thành công");

                        // Call the Clean() method (not shown) to reset any form fields or variables
                        this.Clean();

                        // Call the showTable() method (not shown) to refresh the displayed table data
                        showTable();
                    } else {
                        // Display a failure message dialog
                        JOptionPane.showMessageDialog(this, "Xóa không thành công");
                    }
                }
            } else {
                // Display a message dialog indicating that the student ID does not exist
                JOptionPane.showMessageDialog(this, "Mã SV không tồn tại");
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions that occur during the delete operation
            Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
        }


    }//GEN-LAST:event_bntdeteleActionPerformed
// @by Truong Viet Tran-0333999726
    private void tbhienthiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhienthiMouseClicked
        // TODO add your handling code here:
        int index = tbhienthi.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_tbhienthiMouseClicked

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        if (CheckInput() && ImagePast != null && txtSDT.getText().length() == 10) {
            try {
                con = DatabaseAcc.getDatabaseAcc();

                // Kiểm tra sự tồn tại của Mã Sinh Viên
                pst = con.prepareStatement("SELECT * FROM SinhVien WHERE MaSV = ?");
                pst.setString(1, txtMaSv.getText());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    // Mã Sinh Viên đã tồn tại, hiển thị thông báo
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại, không thể thêm sinh viên mới !");
                } else {
                    // Mã Sinh Viên chưa tồn tại, tiến hành chèn dữ liệu
                    pst = con.prepareStatement("INSERT INTO SinhVien(MaSV, HoTen, Email, SDT, GioTinh, DiaChi, HinhAnh) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
                    pst.setString(1, txtMaSv.getText());
                    pst.setString(2, txtHoTen.getText());
                    pst.setString(3, txtEmail.getText());
                    pst.setInt(4, Integer.parseInt(txtSDT.getText()));

                    // Lấy giới tính từ nút radio được chọn
                    String gioiTinh = "";
                    if (checkNam.isSelected()) {
                        gioiTinh = checkNam.getText();
                        checkNu.setSelected(false); // Tắt nút radio "Nữ" nếu nút radio "Nam" được chọn
                    } else if (checkNu.isSelected()) {
                        gioiTinh = checkNu.getText();
                        checkNam.setSelected(false); // Tắt nút radio "Nam" nếu nút radio "Nữ" được chọn
                    }

                    pst.setString(5, gioiTinh);
                    pst.setString(6, txtDiaChi.getText());
                    InputStream img = new FileInputStream(new File(ImagePast));
                    pst.setBlob(7, img);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    showTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm không thành công, Bạn vui lòng điền đầy đủ thông tin !");
        }
    }//GEN-LAST:event_bntSaveActionPerformed
// @by Truong Viet Tran-0333999726
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String maSV = nhapmsv.getText();
        if (maSV != null) {
            findStudentByMaSV(maSV);
        } else {
            JOptionPane.showMessageDialog(this, "Ô tìm kiếm không được khởi tạo.");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNamActionPerformed

    private void checkNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNuActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void nhapmsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapmsvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapmsvActionPerformed
    private void findStudentByMaSV(String maSV) {
        try {
            con = DatabaseAcc.getDatabaseAcc();
            pst = con.prepareStatement("SELECT * FROM SinhVien WHERE MaSV = ?");
            pst.setString(1, maSV);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Sinh viên được tìm thấy
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                String SDT = rs.getString("SDT");
                String diachi = rs.getString("DiaChi");
                String gioitinh = rs.getString("GioTinh");
                byte[] imageData = rs.getBytes("HinhAnh");

                // Hiển thị ảnh sinh viên
                if (imageData != null && imageData.length > 0) {
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(image);
                    JOptionPane.showMessageDialog(this, "", "Sinh viên cần tìm :", JOptionPane.INFORMATION_MESSAGE, scaledIcon);
                } else {
                    JOptionPane.showMessageDialog(this, "Không có ảnh sinh viên.");
                }// Hiển thị thông tin sinh viên
                JOptionPane.showMessageDialog(this, "Thông tin chi tiết :\nMã SV: " + maSV + "\nGioiTinh: " + gioitinh + "\nHọ tên: " + hoTen + "\nEmail: " + email + "\nSo Dien Thoai:+84" + SDT + "\nDia Chi :" + diachi);
            } else {
                // Sinh viên không tồn tại trong cơ sở dữ liệu
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có mã: " + maSV);
            }

            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }// @by Truong Viet Tran-0333999726

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIcon;
    private javax.swing.JButton bntSave;
    private javax.swing.JButton bntdetele;
    private javax.swing.JRadioButton checkNam;
    private javax.swing.JRadioButton checkNu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbimage;
    private javax.swing.JTextField nhapmsv;
    private javax.swing.JButton search;
    private javax.swing.JTable tbhienthi;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
// @by Truong Viet Tran-0333999726
