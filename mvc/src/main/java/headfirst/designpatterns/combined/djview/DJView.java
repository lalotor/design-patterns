package headfirst.designpatterns.combined.djview;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
  private BeatModelInterface model;
  private ControllerInterface controller;
  private JFrame viewFrame;
  private JPanel viewPanel;
  private BeatBar beatBar;
  private JLabel bpmOutputLabel;
  private JFrame controlFrame;
  private JPanel controlPanel;
  private JLabel bpmLabel;
  private JTextField bpmTextField;
  private JButton setBPMButton;
  private JButton increaseBPMButton;
  private JButton decreaseBPMButton;
  private JMenuBar menuBar;
  private JMenu menu;
  private JMenuItem startMenuItem;
  private JMenuItem stopMenuItem;

  public DJView(BeatModelInterface model, ControllerInterface controller) {
    this.model = model;
    this.controller = controller;
    model.registerObserver((BeatObserver) this);
    model.registerObserver((BPMObserver) this); 
  }

  public void createView() {
    viewPanel = new JPanel(new GridLayout(1, 2));
    viewFrame = new JFrame("view");
    viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    viewFrame.setSize(100, 80);
    bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
    beatBar = new BeatBar();
    beatBar.setValue(0);

    JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
    bpmPanel.add(beatBar);
    bpmPanel.add(bpmOutputLabel);

    viewPanel.add(bpmPanel);
    viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
    viewFrame.pack();
    viewFrame.setVisible(true);
  }

  public void createControls() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    controlFrame = new JFrame("Control");
    controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    controlFrame.setSize(100, 80);

    controlPanel = new JPanel(new GridLayout(1, 2));

    menuBar = new JMenuBar();
    menu = new JMenu("DJ Control");

    startMenuItem = new JMenuItem("Start");
    menu.add(startMenuItem);
    startMenuItem.addActionListener(e -> controller.start());

    stopMenuItem = new JMenuItem("Stop");
    menu.add(stopMenuItem);
    stopMenuItem.addActionListener(e -> controller.stop());

    JMenuItem exitMenuItem = new JMenuItem("Quit");
    menu.add(exitMenuItem);
    exitMenuItem.addActionListener(e -> System.exit(0));

    menuBar.add(menu);
    controlFrame.setJMenuBar(menuBar);

    bpmTextField = new JTextField(2);
    bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
    setBPMButton = new JButton("Set");
    setBPMButton.setSize(new Dimension(10, 40));
    increaseBPMButton = new JButton(">>");
    decreaseBPMButton = new JButton("<<");
    setBPMButton.addActionListener(this);
    increaseBPMButton.addActionListener(this);
    decreaseBPMButton.addActionListener(this);

    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
    buttonPanel.add(decreaseBPMButton);
    buttonPanel.add(increaseBPMButton);
    
    JPanel enterPanel = new JPanel(new GridLayout(1, 2));
    enterPanel.add(bpmLabel);
    enterPanel.add(bpmTextField);

    JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
    insideControlPanel.add(enterPanel);
    insideControlPanel.add(setBPMButton);
    insideControlPanel.add(buttonPanel);
    controlPanel.add(insideControlPanel);

    bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    
    controlFrame.getRootPane().setDefaultButton(setBPMButton);
    controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
    controlFrame.pack();
    controlFrame.setVisible(true);
  }

  @Override
  public void updateBPM() {
    if (bpmOutputLabel == null) {
      return;
    }

    int bpm = model.getBPM();
    if (bpm == 0) {
      bpmOutputLabel.setText("offline");
    } else {
      bpmOutputLabel.setText("Current BPM: " + model.getBPM());
    }
  }

  @Override
  public void updateBeat() {
    if (beatBar == null) {
      return;
    }

    beatBar.setValue(100);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == setBPMButton) {
      int bpm = 90;
      String bpmText = bpmTextField.getText();
      if (bpmText == null || bpmText.contentEquals("")) {
        bpm = 90;
      } else {
        bpm = Integer.parseInt(bpmTextField.getText());
      }
      controller.setBPM(bpm);
    } else if (e.getSource() == increaseBPMButton) {
      controller.increaseBPM();
    } else if (e.getSource() == decreaseBPMButton) {
      controller.decreaseBPM();
    }
  }
  
  public void enableStopMenuItem() {
    stopMenuItem.setEnabled(true);
  }

  public void disableStopMenuItem() {
    stopMenuItem.setEnabled(false);
  }

  public void enableStartMenuItem() {
    startMenuItem.setEnabled(true);
  }

  public void disableStartMenuItem() {
    startMenuItem.setEnabled(false);
  }

}
