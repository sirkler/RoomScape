package roomscape.es.roomscape.presentacion.escape_room;

import roomscape.es.roomscape.negocio.escape_room.TEscapeRoom;
import roomscape.es.roomscape.presentacion.Eventos;
import roomscape.es.roomscape.presentacion.command.escape_room.TableModelListarEscapeRoom;
import roomscape.es.roomscape.presentacion.controller.Context;
import roomscape.es.roomscape.presentacion.controller.Controller;
import roomscape.es.roomscape.presentacion.vistas.Vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarEscapeRoomView extends javax.swing.JFrame implements Vista {

    private JFrame last;

    private javax.swing.JButton buttonScapeRooms;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonReservas;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonList;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelBottom;
    private TableModelListarEscapeRoom tableModel;
    private JTable table;
    private JScrollPane tableScroll;

    public ListarEscapeRoomView() {
        initComponents();
        setSize(744, 454);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Images\\IconoApp_1.png");
        setIconImage(icon);
        setResizable(false);
        setLocationRelativeTo(null);
        last = null;
        setVisible(true);
    }

    private void initComponents() {

        panelLeft = new javax.swing.JPanel();
        buttonScapeRooms = new javax.swing.JButton();
        buttonReservas = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        panelBottom = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonList = new javax.swing.JButton();
        tableModel = new TableModelListarEscapeRoom();
        table = new JTable(tableModel);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(true);
        tableScroll = new JScrollPane(table);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RoomScape");

        panelLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonScapeRooms.setBackground(new java.awt.Color(0, 0, 0));
        buttonScapeRooms.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonScapeRooms.setForeground(new java.awt.Color(255, 255, 255));
        buttonScapeRooms.setText("> Escape Rooms");
        buttonScapeRooms.setBorder(null);
        buttonScapeRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Context c = new Context(null, Eventos.AbrirEscapeRoomView);
                Controller control = Controller.getInstance();
                control.action(c);
                dispose();
            }
        });

        buttonReservas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonReservas.setText("Reservas");
        buttonReservas.setBorder(null);
        buttonReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TODO
            }
        });

        buttonClose.setBackground(new java.awt.Color(0, 0, 0));
        buttonClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setText("Cerrar");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonScapeRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonClose)
                                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonScapeRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonClose)
                                .addContainerGap())
        );

        panelRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBottom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        buttonBack.setBackground(new java.awt.Color(153, 153, 153));
        buttonBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonBack.setForeground(new java.awt.Color(255, 255, 255));
        buttonBack.setText("Atrás");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TODO
            }
        });


        buttonCancel.setBackground(new java.awt.Color(0, 0, 0));
        buttonCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Context c = new Context(null, Eventos.AbrirEscapeRoomView);
                Controller control = Controller.getInstance();
                control.action(c);
                dispose();
            }
        });


        buttonList.setBackground(new java.awt.Color(0, 0, 0));
        buttonList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonList.setForeground(new java.awt.Color(255, 255, 255));
        buttonList.setText("Registrar");
        buttonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TODO
                ArrayList<TEscapeRoom> scapeRoomList = new ArrayList<TEscapeRoom>();
                Context c = new Context(scapeRoomList, Eventos.ListarEscapeRoomOK);
                Controller.getInstance().action(c);

                tableModel.update(scapeRoomList);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(113, Short.MAX_VALUE)
                                .addComponent(buttonCancel)
                                .addGap(79, 79, 79)
                                .addComponent(buttonBack)
                                .addGap(18, 18, 18)
                                .addComponent(buttonList)
                                .addGap(123, 123, 123))
        );

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonCancel)
                                        .addComponent(buttonBack)
                                        .addComponent(buttonList))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panelRight);
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public JFrame getLast() {
        return last;
    }

    public void setLast(JFrame last) {
        this.last = last;
    }

    @Override
    public void update(Context context) {
        // TODO
    }
}
