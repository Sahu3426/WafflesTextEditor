
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;
import com.ozten.font.JFontChooser;
import com.sun.org.apache.bcel.internal.classfile.LineNumber;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;


public class WafflesGui extends javax.swing.JFrame {
    String fileName;
    Clipboard clipboard=getToolkit().getSystemClipboard();
    UndoManager editManager=new UndoManager();
    boolean isSaved=false;
    boolean firstTime=true;
    public WafflesGui() {
        initComponents();
        
        try{
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
           editManager.addEdit(e.getEdit());
            }
        });
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary("/dictionary/"));

        SpellChecker.registerDictionaries(getClass().getResource("/dictionary/"), "en");
        SpellChecker.register(textArea1);

        SpellCheckerOptions sco=new SpellCheckerOptions();
        sco.setCaseSensitive(true);
        sco.setSuggestionsLimitMenu(20);

        JPopupMenu popup = SpellChecker.createCheckerPopup(sco);
        textArea1.setComponentPopupMenu(popup);
        
        
    }
    
    
    class myHighLighter extends DefaultHighlighter.DefaultHighlightPainter{
    public myHighLighter(Color color){
        super(color);
    }
    }
    
    DefaultHighlighter.DefaultHighlightPainter highLighter =new myHighLighter(Color.yellow);
    
    
    public void removeHighlight(JTextComponent textComponent){
        Highlighter removeHighlighter=textComponent.getHighlighter();
        Highlighter.Highlight[] remove=removeHighlighter.getHighlights();
        
        
        for(int i=0;i<remove.length;i++){
            if(remove[i].getPainter() instanceof myHighLighter){
            removeHighlighter.removeHighlight(remove[i]);
        }
            
        }
    }
    public void searchTextArea(JTextComponent textComponent,String textString){
        removeHighlight(textComponent);
        try{
            Highlighter highlight=textComponent.getHighlighter();
            Document doc=textComponent.getDocument();
            String text=doc.getText(0,doc.getLength());
            
            int pos=0;
            while((pos=text.toUpperCase().indexOf(textString.toUpperCase(),pos))>=0){
                highlight.addHighlight(pos, pos+textString.length(),highLighter);
                pos+=textString.length();
                
            }
            
        }
        catch(Exception e){}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        newfileicon = new javax.swing.JButton();
        openicon = new javax.swing.JButton();
        saveicon = new javax.swing.JButton();
        color = new javax.swing.JButton();
        text = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        redo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        printicon = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newButton = new javax.swing.JMenuItem();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAsFile = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cutText = new javax.swing.JMenuItem();
        copyText = new javax.swing.JMenuItem();
        pasteText = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        font = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fontColor = new javax.swing.JMenuItem();
        padColor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        acryl = new javax.swing.JRadioButtonMenuItem();
        aero = new javax.swing.JRadioButtonMenuItem();
        aluminium = new javax.swing.JRadioButtonMenuItem();
        bernstein = new javax.swing.JRadioButtonMenuItem();
        fast = new javax.swing.JRadioButtonMenuItem();
        hifi = new javax.swing.JRadioButtonMenuItem();
        mcwin = new javax.swing.JRadioButtonMenuItem();
        mint = new javax.swing.JRadioButtonMenuItem();
        noire = new javax.swing.JRadioButtonMenuItem();
        smart = new javax.swing.JRadioButtonMenuItem();
        luna = new javax.swing.JRadioButtonMenuItem();
        texture = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Waffles Text Editor");
        setBackground(java.awt.SystemColor.textHighlight);
        setMinimumSize(new java.awt.Dimension(720, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setWrapStyleWord(true);
        textArea1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textArea1CaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(textArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        searchField.setToolTipText("");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search2.png"))); // NOI18N
        searchButton.setToolTipText("Search Button");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        newfileicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new_file.png"))); // NOI18N
        newfileicon.setToolTipText("New");
        newfileicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newfileiconActionPerformed(evt);
            }
        });

        openicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Folder Open.png"))); // NOI18N
        openicon.setToolTipText("Open File");
        openicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openiconActionPerformed(evt);
            }
        });

        saveicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saveAs.png"))); // NOI18N
        saveicon.setToolTipText("Save");
        saveicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveiconActionPerformed(evt);
            }
        });

        color.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color.png"))); // NOI18N
        color.setToolTipText("Color Chooser");
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });

        text.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/text.png"))); // NOI18N
        text.setToolTipText("Font Chooser");
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });

        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        remove.setToolTipText("Remove Highlight");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        undo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ABHISHEK\\Documents\\NetBeansProjects\\Waffles\\icons\\undo.png")); // NOI18N
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        jLabel1.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(newfileicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveicon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addGap(4, 4, 4)
                .addComponent(remove))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(undo))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton)
                    .addComponent(text)
                    .addComponent(color)
                    .addComponent(newfileicon)
                    .addComponent(openicon)
                    .addComponent(saveicon)
                    .addComponent(remove)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo.png"))); // NOI18N
        redo.setToolTipText("redo");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cut.png"))); // NOI18N
        jButton1.setToolTipText("cut");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/copy.png"))); // NOI18N
        jButton2.setToolTipText("copy");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard_paste.png"))); // NOI18N
        jButton3.setToolTipText("paste");

        printicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer.png"))); // NOI18N
        printicon.setToolTipText("print");
        printicon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printiconActionPerformed(evt);
            }
        });

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        undoButton.setToolTipText("undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        jMenu1.setBackground(new java.awt.Color(0, 150, 136));
        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        newButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new_file.png"))); // NOI18N
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        jMenu1.add(newButton);

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/newFile.png"))); // NOI18N
        newFile.setText("New File");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        jMenu1.add(newFile);

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Folder Open.png"))); // NOI18N
        openFile.setText("Open File");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saveAs.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        saveAsFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy-save-icon--23.png"))); // NOI18N
        saveAsFile.setText("Save As");
        saveAsFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsFile);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        cutText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cut.png"))); // NOI18N
        cutText.setText("Cut");
        cutText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutTextActionPerformed(evt);
            }
        });
        jMenu2.add(cutText);

        copyText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/copy.png"))); // NOI18N
        copyText.setText("Copy");
        copyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTextActionPerformed(evt);
            }
        });
        jMenu2.add(copyText);

        pasteText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard_paste.png"))); // NOI18N
        pasteText.setText("Paste");
        pasteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteTextActionPerformed(evt);
            }
        });
        jMenu2.add(pasteText);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Format");

        font.setText("Font");
        font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontActionPerformed(evt);
            }
        });
        jMenu3.add(font);
        jMenu3.add(jSeparator1);

        fontColor.setText("Font Color");
        fontColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontColorActionPerformed(evt);
            }
        });
        jMenu3.add(fontColor);

        padColor.setText("Pad Color");
        padColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padColorActionPerformed(evt);
            }
        });
        jMenu3.add(padColor);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Skin");

        buttonGroup1.add(acryl);
        acryl.setSelected(true);
        acryl.setText("Acryl");
        acryl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acrylActionPerformed(evt);
            }
        });
        jMenu4.add(acryl);

        buttonGroup1.add(aero);
        aero.setText("Aero");
        aero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aeroActionPerformed(evt);
            }
        });
        jMenu4.add(aero);

        buttonGroup1.add(aluminium);
        aluminium.setText("Aluminium");
        aluminium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aluminiumActionPerformed(evt);
            }
        });
        jMenu4.add(aluminium);

        buttonGroup1.add(bernstein);
        bernstein.setText("Bernstein");
        bernstein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bernsteinActionPerformed(evt);
            }
        });
        jMenu4.add(bernstein);

        buttonGroup1.add(fast);
        fast.setText("Fast");
        fast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastActionPerformed(evt);
            }
        });
        jMenu4.add(fast);

        buttonGroup1.add(hifi);
        hifi.setText("HiFi");
        hifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hifiActionPerformed(evt);
            }
        });
        jMenu4.add(hifi);

        buttonGroup1.add(mcwin);
        mcwin.setText("McWin");
        mcwin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcwinActionPerformed(evt);
            }
        });
        jMenu4.add(mcwin);

        buttonGroup1.add(mint);
        mint.setText("Mint");
        mint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mintActionPerformed(evt);
            }
        });
        jMenu4.add(mint);

        buttonGroup1.add(noire);
        noire.setText("Noire");
        noire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noireActionPerformed(evt);
            }
        });
        jMenu4.add(noire);

        buttonGroup1.add(smart);
        smart.setText("Smart");
        smart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smartActionPerformed(evt);
            }
        });
        jMenu4.add(smart);

        buttonGroup1.add(luna);
        luna.setText("Luna");
        luna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunaActionPerformed(evt);
            }
        });
        jMenu4.add(luna);

        buttonGroup1.add(texture);
        texture.setText("Texture");
        texture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textureActionPerformed(evt);
            }
        });
        jMenu4.add(texture);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3)
                        .addComponent(printicon))
                    .addComponent(redo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(undoButton)))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(undoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printicon)
                        .addGap(0, 317, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
        isSaved=false;
        textArea1.setText("");
        if(fileName!=null)
        setTitle("Waffles Text Editor : "+fileName);
        else
        setTitle("Waffles Text Editor : Untitled");
            
    }//GEN-LAST:event_newButtonActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        FileDialog fileDialog=new FileDialog(WafflesGui.this,"Open File",FileDialog.LOAD);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile()!=null){
            fileName=fileDialog.getDirectory()+fileDialog.getFile();
            setTitle("Waffles Text Editor : "+fileName);
        }
        
        try{
            BufferedReader reader=new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder=new StringBuilder();
            
            
            String line=null;
            
            while((line=reader.readLine())!=null){
                stringBuilder.append(line+"\n");
                textArea1.setText(stringBuilder.toString());
            }
            reader.close();
            
        }
        catch(IOException e){
            System.out.println("File Not Found");
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveAsFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsFileActionPerformed
        // TODO add your handling code here:
        FileDialog fileDialog=new FileDialog(WafflesGui.this,"Save File",FileDialog.SAVE);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile()!=null){
            fileName=fileDialog.getDirectory()+fileDialog.getFile();
            setTitle("Waffles Text Editor: "+fileName);
        }
        
        try{
            FileWriter fileWriter=new FileWriter(fileName);
            fileWriter.write(textArea1.getText());
            setTitle("Waffles Text Editor: "+fileName);
            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("File Not Found");
        }
    }//GEN-LAST:event_saveAsFileActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void cutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutTextActionPerformed
        // TODO add your handling code here:
        String cutString=textArea1.getSelectedText();
        StringSelection cutSelection=new StringSelection(cutString);
        clipboard.setContents(cutSelection, cutSelection);
       textArea1.replaceRange("",textArea1.getSelectionStart(),textArea1.getSelectionEnd());
        
    }//GEN-LAST:event_cutTextActionPerformed

    private void copyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTextActionPerformed
        // TODO add your handling code here:
        String copyText=textArea1.getSelectedText();
        StringSelection copySelection=new StringSelection(copyText);
        clipboard.setContents(copySelection, copySelection);
    }//GEN-LAST:event_copyTextActionPerformed

    private void pasteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteTextActionPerformed
        // TODO add your handling code here:
        try{
            Transferable pasteText=clipboard.getContents(WafflesGui.this);
            String selected=(String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea1.replaceRange(selected,textArea1.getSelectionStart(), textArea1.getSelectionEnd());
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }//GEN-LAST:event_pasteTextActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        if(searchField.getText().length()>0 && textArea1.getText().length()>=0)
        searchTextArea(textArea1,searchField.getText());

    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void printiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printiconActionPerformed
        // TODO add your handling code here:
        try{
            boolean complete=textArea1.print();
            if(complete){
                JOptionPane.showMessageDialog(null, "Done Printing","Information",JOptionPane.INFORMATION_MESSAGE);
            }
//            else{
//                JOptionPane.showMessageDialog(null,"Printing !","Printer",JOptionPane.ERROR_MESSAGE);
//            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_printiconActionPerformed

    private void fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontActionPerformed
        // TODO add your handling code here:
        JFontChooser fontChooser=new JFontChooser();
        JOptionPane.showMessageDialog(null,fontChooser,"Choose Font :",JOptionPane.PLAIN_MESSAGE);
        
        textArea1.setFont(fontChooser.getFont());
        textArea1.setFont(fontChooser.getPreviewFont());
    }//GEN-LAST:event_fontActionPerformed

    private void newfileiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newfileiconActionPerformed
        // TODO add your handling code here:
        newButtonActionPerformed(evt);
    }//GEN-LAST:event_newfileiconActionPerformed

    private void openiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openiconActionPerformed
        // TODO add your handling code here:
        openFileActionPerformed(evt);
    }//GEN-LAST:event_openiconActionPerformed

    private void saveiconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveiconActionPerformed
        // TODO add your handling code here:
        saveActionPerformed(evt);
    }//GEN-LAST:event_saveiconActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        // TODO add your handling code here:
        if(editManager.canUndo()) editManager.undo();
    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        // TODO add your handling code here:
        if(editManager.canRedo()) editManager.redo();
    }//GEN-LAST:event_redoActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        Color colorChooser;
        colorChooser= JColorChooser.showDialog(null,"Pick A Color.", Color.BLACK);
        if(colorChooser==null)
            colorChooser=Color.BLACK;
        
        textArea1.setForeground(colorChooser);
    }//GEN-LAST:event_colorActionPerformed

    private void fontColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontColorActionPerformed
        // TODO add your handling code here:
        colorActionPerformed(evt);
    }//GEN-LAST:event_fontColorActionPerformed

    private void padColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padColorActionPerformed
        // TODO add your handling code here:
        Color colorChooser;
        colorChooser= JColorChooser.showDialog(null,"Pick A Color.", Color.BLACK);
        if(colorChooser==null)
            colorChooser=Color.BLACK;
        
        textArea1.setBackground(colorChooser);
    }//GEN-LAST:event_padColorActionPerformed

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        // TODO add your handling code here:
        fontActionPerformed(evt);
    }//GEN-LAST:event_textActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        removeHighlight(textArea1);
    }//GEN-LAST:event_removeActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        // TODO add your handling code here:
         if(editManager.canUndo()) editManager.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if(isSaved==false && fileName!=null )
        try{
            FileWriter writer=new FileWriter(fileName);
            textArea1.write(writer);
            writer.close();
            isSaved=true;
        }
        catch(IOException e){
            
        }
        else{
            saveAsFileActionPerformed(evt);
            isSaved=true;
        }
    }//GEN-LAST:event_saveActionPerformed

    private void textArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textArea1CaretUpdate
        // TODO add your handling code here:
        isSaved=false;
    }//GEN-LAST:event_textArea1CaretUpdate

    private void acrylActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acrylActionPerformed
        // TODO add your handling code here:
                try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_acrylActionPerformed

    private void aeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aeroActionPerformed
        // TODO add your handling code here:
              try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_aeroActionPerformed

    private void aluminiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aluminiumActionPerformed
        // TODO add your handling code here:
             try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_aluminiumActionPerformed

    private void bernsteinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bernsteinActionPerformed
        // TODO add your handling code here:
             try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bernsteinActionPerformed

    private void fastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastActionPerformed
        // TODO add your handling code here:
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_fastActionPerformed

    private void hifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hifiActionPerformed
        // TODO add your handling code here:
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_hifiActionPerformed

    private void mcwinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcwinActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_mcwinActionPerformed

    private void mintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mintActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_mintActionPerformed

    private void noireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noireActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_noireActionPerformed

    private void smartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smartActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_smartActionPerformed

    private void lunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunaActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_lunaActionPerformed

    private void textureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textureActionPerformed
        // TODO add your handling code here:
        try{
           UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_textureActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        // TODO add your handling code here:
        saveAsFileActionPerformed(evt);
        newButtonActionPerformed(evt);
    }//GEN-LAST:event_newFileActionPerformed

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
            java.util.logging.Logger.getLogger(WafflesGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WafflesGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WafflesGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WafflesGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WafflesGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem acryl;
    private javax.swing.JRadioButtonMenuItem aero;
    private javax.swing.JRadioButtonMenuItem aluminium;
    private javax.swing.JRadioButtonMenuItem bernstein;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton color;
    private javax.swing.JMenuItem copyText;
    private javax.swing.JMenuItem cutText;
    private javax.swing.JMenuItem exit;
    private javax.swing.JRadioButtonMenuItem fast;
    private javax.swing.JMenuItem font;
    private javax.swing.JMenuItem fontColor;
    private javax.swing.JRadioButtonMenuItem hifi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JRadioButtonMenuItem luna;
    private javax.swing.JRadioButtonMenuItem mcwin;
    private javax.swing.JRadioButtonMenuItem mint;
    private javax.swing.JMenuItem newButton;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JButton newfileicon;
    private javax.swing.JRadioButtonMenuItem noire;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JButton openicon;
    private javax.swing.JMenuItem padColor;
    private javax.swing.JMenuItem pasteText;
    private javax.swing.JButton printicon;
    private javax.swing.JButton redo;
    private javax.swing.JButton remove;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAsFile;
    private javax.swing.JButton saveicon;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JRadioButtonMenuItem smart;
    private javax.swing.JButton text;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JRadioButtonMenuItem texture;
    private javax.swing.JButton undo;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
