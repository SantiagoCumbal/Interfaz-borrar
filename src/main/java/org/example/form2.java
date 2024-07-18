package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form2 {
    public JPanel MainPanel;
    private JTextField cedulaT;
    private JTextField B2T;
    private JTextField B1T;
    private JButton actualizarButton;
    private JLabel mensaje;
    String url = "jdbc:mysql://localhost:3306/EstudiantesA24";
    String usser = "root";
    String pass = "123456";
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt2=null;
    Connection connection =null;

    public form2() {
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection = DriverManager.getConnection(url,usser,pass);
                    System.out.println("Conexion establecida");
                    String sql1="Update estudiantesA set b1 = ? where cedula = ?";
                    String sql2="Update estudiantesA set b2 = ? where cedula = ?";
                    pstmt1=connection.prepareStatement(sql1);
                    pstmt2=connection.prepareStatement(sql2);
                    pstmt1.setInt(1,Integer.parseInt(B1T.getText()));
                    pstmt1.setString(2,cedulaT.getText());
                    pstmt2.setInt(1,Integer.parseInt(B2T.getText()));
                    pstmt2.setString(2,cedulaT.getText());
                    pstmt1.executeUpdate();
                    pstmt2.executeUpdate();
                    if(cedulaT.getText() in)
                    mensaje.setText("Datos actualizados");


                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                } finally {
                    try{
                        if(pstmt1!=null){
                            pstmt1.close();
                        }
                        if(pstmt2!=null){
                            pstmt2.close();
                        }
                        if (connection!=null){
                            connection.close();
                        }
                    }catch (SQLException e1){
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });
    }
}
