package restobar.Views;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import restobar.Controllers.ControllerOrder;
import restobar.Controllers.ControllerProduct;
import restobar.Controllers.ControllerStock;
import restobar.Controllers.ControllerTable;
import restobar.Controllers.ControllerWaiter;
import restobar.Models.Category;
import restobar.Models.Item;
import restobar.Models.Order;
import restobar.Models.Product;
import restobar.Models.Table;
import restobar.Persistence.DAOException;

public class Menues extends javax.swing.JFrame {
    private ControllerWaiter waiterCont;
    private ControllerProduct productCont;
    private ControllerStock stockCont;
    private ControllerOrder orderCont;
    private ControllerTable tableCont;
    
    private Table tableSelected;
    private int selectedCategoryID;
    
    public Menues() {
        initComponents();
        this.setExtendedState(6);
        
        this.waiterCont= new ControllerWaiter();
        
        this.productCont=new ControllerProduct();
        this.stockCont=new ControllerStock();
        this.stockCont.setControllerProduct(productCont);
        
        this.orderCont=new ControllerOrder();
        this.orderCont.setControllerWaiter(waiterCont);
        this.orderCont.setControllerProduct(productCont);
        
        this.tableCont=new ControllerTable();
        this.tableCont.setControllerOrder(orderCont);
        
        this.selectedCategoryID=1;
        listCategories(0);
        listTables();
        pnlCategory.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        pnlOrder = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblTableSelected = new javax.swing.JLabel();
        btnCloseOrder = new javax.swing.JButton();
        lblOrderTotal = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnAddOneProductToOrder = new javax.swing.JButton();
        btnSubProductToOrder = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        lblOrderWaiter = new javax.swing.JLabel();
        lblOrderCutlery = new javax.swing.JLabel();
        pnlCategory = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cmbCategories = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnAddProduct = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTables = new javax.swing.JList<>();
        jMenuBar4 = new javax.swing.JMenuBar();
        mnTable = new javax.swing.JMenu();
        mnItemTableAdd = new javax.swing.JMenuItem();
        mnItemTableEdit = new javax.swing.JMenuItem();
        mnItemTableHistory = new javax.swing.JMenuItem();
        mnProduct = new javax.swing.JMenu();
        mnItemProductAdd = new javax.swing.JMenuItem();
        mnItemProductEdit = new javax.swing.JMenuItem();
        mnItemProductList = new javax.swing.JMenuItem();
        mnWaiter = new javax.swing.JMenu();
        mnItemWaiterAdd = new javax.swing.JMenuItem();
        mnItemWaiterEdit = new javax.swing.JMenuItem();
        mnItemWaiterList = new javax.swing.JMenuItem();
        mnStock = new javax.swing.JMenu();
        mnItemStockList = new javax.swing.JMenuItem();
        mnCategory = new javax.swing.JMenu();
        mnItemCategoryAdd = new javax.swing.JMenuItem();
        mnItemCategoryEdit = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenuItem7.setText("jMenuItem7");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tito´s Restobar | Romero, Suizer");
        setAlwaysOnTop(true);
        setResizable(false);

        pnlOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlOrder.setToolTipText("");
        pnlOrder.setAutoscrolls(true);

        lblTableSelected.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnCloseOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCloseOrder.setText("Cerrar Mesa");
        btnCloseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseOrderActionPerformed(evt);
            }
        });

        lblOrderTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderTotal.setText("Total =");

        btnAddOneProductToOrder.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnAddOneProductToOrder.setText("+");
        btnAddOneProductToOrder.setBorderPainted(false);
        btnAddOneProductToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOneProductToOrderActionPerformed(evt);
            }
        });

        btnSubProductToOrder.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnSubProductToOrder.setText("-");
        btnSubProductToOrder.setBorderPainted(false);
        btnSubProductToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubProductToOrderActionPerformed(evt);
            }
        });

        btnUp.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnUp.setText("↑");
        btnUp.setBorderPainted(false);
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnDown.setText("↓");
        btnDown.setBorderPainted(false);
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddOneProductToOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnSubProductToOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddOneProductToOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubProductToOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod.", "Cant", "Descripcion", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblOrder);
        tblOrder.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
        }

        lblOrderWaiter.setText("Mozo:");

        lblOrderCutlery.setText("Cubiertos:");

        javax.swing.GroupLayout pnlOrderLayout = new javax.swing.GroupLayout(pnlOrder);
        pnlOrder.setLayout(pnlOrderLayout);
        pnlOrderLayout.setHorizontalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrderLayout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addContainerGap())
                    .addGroup(pnlOrderLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderLayout.createSequentialGroup()
                        .addComponent(lblTableSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCloseOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderLayout.createSequentialGroup()
                                .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(pnlOrderLayout.createSequentialGroup()
                        .addComponent(lblOrderWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOrderCutlery, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        pnlOrderLayout.setVerticalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTableSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrderLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderWaiter)
                    .addComponent(lblOrderCutlery))
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCloseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Categorias:");

        cmbCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesActionPerformed(evt);
            }
        });

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProducts);

        btnAddProduct.setText("Añadir");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCategoryLayout = new javax.swing.GroupLayout(pnlCategory);
        pnlCategory.setLayout(pnlCategoryLayout);
        pnlCategoryLayout.setHorizontalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGroup(pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(pnlCategoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlCategoryLayout.createSequentialGroup()
                                .addGroup(pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddProduct)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlCategoryLayout.setVerticalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddProduct)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        lstTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstTables);

        mnTable.setText("Mesas");

        mnItemTableAdd.setText("Añadir mesa");
        mnItemTableAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemTableAddActionPerformed(evt);
            }
        });
        mnTable.add(mnItemTableAdd);

        mnItemTableEdit.setText("Eliminar/Modificar mesa");
        mnItemTableEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemTableEditActionPerformed(evt);
            }
        });
        mnTable.add(mnItemTableEdit);

        mnItemTableHistory.setText("Historial de pedidos");
        mnItemTableHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemTableHistoryActionPerformed(evt);
            }
        });
        mnTable.add(mnItemTableHistory);

        jMenuBar4.add(mnTable);

        mnProduct.setText("Productos");

        mnItemProductAdd.setText("Añadir producto");
        mnItemProductAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProductAddActionPerformed(evt);
            }
        });
        mnProduct.add(mnItemProductAdd);

        mnItemProductEdit.setText("Eliminar/Modificar producto");
        mnItemProductEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProductEditActionPerformed(evt);
            }
        });
        mnProduct.add(mnItemProductEdit);

        mnItemProductList.setText("Listado de productos");
        mnItemProductList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProductListActionPerformed(evt);
            }
        });
        mnProduct.add(mnItemProductList);

        jMenuBar4.add(mnProduct);

        mnWaiter.setText("Mozos");

        mnItemWaiterAdd.setText("Añadir mozo");
        mnItemWaiterAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemWaiterAddActionPerformed(evt);
            }
        });
        mnWaiter.add(mnItemWaiterAdd);

        mnItemWaiterEdit.setText("Eliminar/Modificar mozo");
        mnItemWaiterEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemWaiterEditActionPerformed(evt);
            }
        });
        mnWaiter.add(mnItemWaiterEdit);

        mnItemWaiterList.setText("Listado de mozos");
        mnItemWaiterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemWaiterListActionPerformed(evt);
            }
        });
        mnWaiter.add(mnItemWaiterList);

        jMenuBar4.add(mnWaiter);

        mnStock.setText("Stock");

        mnItemStockList.setText("Lista");
        mnItemStockList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemStockListActionPerformed(evt);
            }
        });
        mnStock.add(mnItemStockList);

        jMenuBar4.add(mnStock);

        mnCategory.setText("Categorias");

        mnItemCategoryAdd.setText("Añadir categoria");
        mnItemCategoryAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemCategoryAddActionPerformed(evt);
            }
        });
        mnCategory.add(mnItemCategoryAdd);

        mnItemCategoryEdit.setText("Eliminar/Modificar categoria");
        mnItemCategoryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemCategoryEditActionPerformed(evt);
            }
        });
        mnCategory.add(mnItemCategoryEdit);

        jMenuBar4.add(mnCategory);

        setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseOrderActionPerformed
        CloseOrder newPayView = new CloseOrder(tableCont,tableSelected.getId());
        newPayView.setVisible(true);
    }//GEN-LAST:event_btnCloseOrderActionPerformed

    private void btnAddOneProductToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOneProductToOrderActionPerformed
        try {
            orderCont.changeTotalProductFromItem(1, tableSelected.getOrder().getItem(tblOrder.getSelectedRow()));
            displayOrderFromTable();
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddOneProductToOrderActionPerformed

    private void mnItemTableEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemTableEditActionPerformed
        EditTable win = new EditTable(tableCont,this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemTableEditActionPerformed

    private void mnItemWaiterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemWaiterAddActionPerformed
        AddWaiter win=new AddWaiter(waiterCont);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemWaiterAddActionPerformed

    private void mnItemProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProductAddActionPerformed
        AddProduct win=new AddProduct(stockCont,this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemProductAddActionPerformed

    private void mnItemTableAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemTableAddActionPerformed
        AddTable win = new AddTable(tableCont,this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemTableAddActionPerformed

    private void mnItemTableHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemTableHistoryActionPerformed
        HistoryTable win=new HistoryTable(tableCont);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemTableHistoryActionPerformed

    private void cmbCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesActionPerformed
        this.selectedCategoryID=cmbCategories.getItemAt(cmbCategories.getSelectedIndex()).getId();//Getting the idCategory for display specific products
        listProductsByCategorySelected();
    }//GEN-LAST:event_cmbCategoriesActionPerformed

    private void mnItemCategoryAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemCategoryAddActionPerformed
        AddCategory win = new AddCategory(this.productCont.getControllerCategory(),this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemCategoryAddActionPerformed

    private void mnItemWaiterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemWaiterListActionPerformed
        try {
            ListWaiter win=new ListWaiter();
            win.setVisible(true);
            win.listAllWaiters(waiterCont.listAll());
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnItemWaiterListActionPerformed

    private void mnItemProductListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProductListActionPerformed
        ListProduct l=new ListProduct(productCont);
        l.setVisible(true);
    }//GEN-LAST:event_mnItemProductListActionPerformed

    private void mnItemCategoryEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemCategoryEditActionPerformed
        EditCategory win = new EditCategory(this.productCont,this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemCategoryEditActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        try {
            int selectedProduct=Integer.valueOf(tblProducts.getValueAt(tblProducts.getSelectedRow(), 0).toString());
            Item item=new Item(productCont.getProductById(selectedProduct),0,1);
            orderCont.addItemToOrder(item,tableSelected.getOrder());
            displayOrderFromTable();
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddProductActionPerformed
    
    private void mnItemStockListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemStockListActionPerformed
        ListStock ls = new ListStock(stockCont);
        ls.setVisible(true);
    }//GEN-LAST:event_mnItemStockListActionPerformed

    private void btnSubProductToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubProductToOrderActionPerformed
        try {
            orderCont.changeTotalProductFromItem(-1, tableSelected.getOrder().getItem(tblOrder.getSelectedRow()));
            if(tableSelected.getOrder().getItem(tblOrder.getSelectedRow()).getTotalProduct()<=0)
                tableSelected.getOrder().removeItem(tblOrder.getSelectedRow());
            displayOrderFromTable();
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubProductToOrderActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        if(tblOrder.getSelectedRow()-1>=0)
            tblOrder.setRowSelectionInterval(tblOrder.getSelectedRow()-1, tblOrder.getSelectedRow()-1);
        else
            tblOrder.setRowSelectionInterval(tblOrder.getRowCount()-1,tblOrder.getRowCount()-1);
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        if(tblOrder.getSelectedRow()+1<tblOrder.getRowCount())
            tblOrder.setRowSelectionInterval(tblOrder.getSelectedRow()+1, tblOrder.getSelectedRow()+1);
        else
            tblOrder.setRowSelectionInterval(0,0);
    }//GEN-LAST:event_btnDownActionPerformed

    private void lstTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTablesMouseClicked
        try {
            tableSelected=tableCont.getTableById(lstTables.getSelectedValue().getId());
            if(tableSelected.getOrder().getWaiter().getId()!=1)
                displayOrderFromTable();
            else{
                OpenOrder sw = new OpenOrder(tableCont,tableSelected.getId(),this);
                sw.setVisible(true);
            }
            //Display panel of category when a table is selected
            listProductsByCategorySelected();
            pnlCategory.setVisible(true);
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lstTablesMouseClicked

    private void mnItemWaiterEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemWaiterEditActionPerformed
        EditWaiter win=new EditWaiter(orderCont);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemWaiterEditActionPerformed

    private void mnItemProductEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProductEditActionPerformed
        EditProduct win=new EditProduct(stockCont,orderCont,this);
        win.setVisible(true);
    }//GEN-LAST:event_mnItemProductEditActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menues().setVisible(true);
            }
        });
    }
    public void displayOrderFromTable()
    {
        try {
            lblTableSelected.setText("Pedido="+lstTables.getSelectedValue());
            Order o=tableSelected.getOrder();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Cantidad");
            model.addColumn("Importe");
            tblOrder.setModel(model);
            String [] datos = new String[4];
            for(int i=0;i<o.getItems().size();i++)
            {
                Product p=productCont.getProductById(o.getItem(i).getProduct().getId());
                datos[0]=tableSelected.getOrder().getItem(i).getProduct().getId()+"";
                datos[1]=p.getName();
                datos[2]=tableSelected.getOrder().getItem(i).getTotalProduct()+"";
                datos[3]=tableSelected.getOrder().getItem(i).calculateTotalPrice()+"";
                model.addRow(datos);
            }
            //Metodo precio total en tiempo real
            this.lblOrderTotal.setText("Total = "+tableSelected.getOrder().calculatePrice(0));
            this.lblOrderCutlery.setText("Cubiertos: "+tableSelected.getOrder().getCutlery());
            this.lblOrderWaiter.setText("Mozo: "+waiterCont.getWaiterById(tableSelected.getOrder().getWaiter().getId()));
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JComboBox getCmbCategories(){return this.cmbCategories;}
    //BASIC UPDATES
    public void listCategories(int indexStart){
        try {
            int temp=selectedCategoryID;
            DefaultComboBoxModel model=new DefaultComboBoxModel();
            cmbCategories.setModel(model);
            List<Category> c=this.productCont.getControllerCategory().listAll();
            for (int i = 0; i < c.size();i++){
                cmbCategories.addItem(c.get(i));
            }
            
            System.out.println("CATEGORIAS = "+cmbCategories.getItemCount());
            if(indexStart<cmbCategories.getItemCount())
                cmbCategories.setSelectedIndex(indexStart);
            else
                cmbCategories.setSelectedIndex(0);
            
            selectedCategoryID=temp;
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listProductsByCategorySelected()
    {
        try {
            List<Product> p=this.productCont.getProductsFromCategory(selectedCategoryID);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Descripcion");
            model.addColumn("Importe");
            tblProducts.setModel(model);
            String [] datos = new String[3];
            for(int i=0;i<p.size();i++)
            {
                datos[0]=p.get(i).getId()+"";
                datos[1]=p.get(i).getName();
                datos[2]=p.get(i).getPrice().getValue()+"";
                model.addRow(datos);
            }
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listTables()
    {
        try {
            List<Table> t=this.tableCont.listAll();
            DefaultListModel model = new DefaultListModel();
            lstTables.setModel(model);
            for(int i=1;i<t.size();i++)
            {
                model.addElement(t.get(i));
            }
        } catch (DAOException ex) {
            Logger.getLogger(Menues.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public String toString()
    {
        //This method it's like a generic update function
        listCategories(cmbCategories.getSelectedIndex());
        listProductsByCategorySelected();
        listTables();
        if(tableSelected!=null)
            displayOrderFromTable();
        return "UPDATED";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOneProductToOrder;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCloseOrder;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnSubProductToOrder;
    private javax.swing.JButton btnUp;
    private javax.swing.JComboBox<Category> cmbCategories;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblOrderCutlery;
    private javax.swing.JLabel lblOrderTotal;
    private javax.swing.JLabel lblOrderWaiter;
    private javax.swing.JLabel lblTableSelected;
    private javax.swing.JList<Table> lstTables;
    private javax.swing.JMenu mnCategory;
    private javax.swing.JMenuItem mnItemCategoryAdd;
    private javax.swing.JMenuItem mnItemCategoryEdit;
    private javax.swing.JMenuItem mnItemProductAdd;
    private javax.swing.JMenuItem mnItemProductEdit;
    private javax.swing.JMenuItem mnItemProductList;
    private javax.swing.JMenuItem mnItemStockList;
    private javax.swing.JMenuItem mnItemTableAdd;
    private javax.swing.JMenuItem mnItemTableEdit;
    private javax.swing.JMenuItem mnItemTableHistory;
    private javax.swing.JMenuItem mnItemWaiterAdd;
    private javax.swing.JMenuItem mnItemWaiterEdit;
    private javax.swing.JMenuItem mnItemWaiterList;
    private javax.swing.JMenu mnProduct;
    private javax.swing.JMenu mnStock;
    private javax.swing.JMenu mnTable;
    private javax.swing.JMenu mnWaiter;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlOrder;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblProducts;
    // End of variables declaration//GEN-END:variables
}
