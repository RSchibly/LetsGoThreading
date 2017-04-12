package LetsGoThreading;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewer {

	private JFrame frame;
	private ActionListener m_actionListener;
	private Sensor[] m_sensors;

	/**
	 * Create the application.
	 */
	public Viewer() {
		m_sensors = new Sensor[8];
		for(int i = 0; i < m_sensors.length; i++) {
			m_sensors[i] = new Sensor("Sensor " + (i+1));
			m_sensors[i].start();
		}
		
		m_actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(event.getActionCommand().startsWith("Sensor")) {
					String[] cmdSplit = event.getActionCommand().split(" ");
					if(cmdSplit.length != 2) {
						System.out.println("Parse Error: " + event.getActionCommand());
						return;
					}
					int sensorNum = Integer.parseInt(cmdSplit[1]);
					m_sensors[sensorNum-1].interrupt();
					if(sensorNum == 8) {
						for(int i = 0; i < 8; i++) {
							m_sensors[i].terminate();
							m_sensors[i].interrupt();
							try {
								m_sensors[i].join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.exit(0);
					}
				}
			}
		};
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][][]", "[][][][][][][][]"));
		
		JButton btnSensor1 = new JButton("Sensor 1");
		btnSensor1.addActionListener(m_actionListener);
		btnSensor1.setActionCommand(btnSensor1.getText());
		frame.getContentPane().add(btnSensor1, "cell 1 0");
		
		JButton btnSensor2 = new JButton("Sensor 2");
		btnSensor2.addActionListener(m_actionListener);
		btnSensor2.setActionCommand(btnSensor2.getText());
		frame.getContentPane().add(btnSensor2, "cell 1 1");
		
		JButton btnSensor3 = new JButton("Sensor 3");
		btnSensor3.addActionListener(m_actionListener);
		btnSensor3.setActionCommand(btnSensor3.getText());
		frame.getContentPane().add(btnSensor3, "cell 1 2");
		
		JButton btnSensor4 = new JButton("Sensor 4");
		btnSensor4.addActionListener(m_actionListener);
		btnSensor4.setActionCommand(btnSensor4.getText());
		frame.getContentPane().add(btnSensor4, "cell 1 3");
		
		JButton btnSensor5 = new JButton("Sensor 5");
		btnSensor5.addActionListener(m_actionListener);
		btnSensor5.setActionCommand(btnSensor5.getText());
		frame.getContentPane().add(btnSensor5, "cell 1 4");
		
		JButton btnSensor6 = new JButton("Sensor 6");
		btnSensor6.addActionListener(m_actionListener);
		btnSensor6.setActionCommand(btnSensor6.getText());
		frame.getContentPane().add(btnSensor6, "cell 1 5");
		
		JButton btnSensor7 = new JButton("Sensor 7");
		btnSensor7.addActionListener(m_actionListener);
		btnSensor7.setActionCommand(btnSensor7.getText());
		frame.getContentPane().add(btnSensor7, "cell 1 6");
		
		JButton btnSensor8 = new JButton("Sensor 8");
		btnSensor8.addActionListener(m_actionListener);
		btnSensor8.setActionCommand(btnSensor8.getText());
		frame.getContentPane().add(btnSensor8, "cell 1 7");
	}

}
