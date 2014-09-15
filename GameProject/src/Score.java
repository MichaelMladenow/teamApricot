import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;
//EXCUSE MY SPAGHETTY CODE, XAXATIX PLS DON'T HATE ME :D
public class Score implements ActionListener {
	
	JFrame score;
	
	public void actionPerformed(ActionEvent e) {
		
		//A TreeMap taking scores so they can be readily sorted.
		TreeMap <String, String> namesAndScores = new TreeMap <String, String>();
		// A file reader reads the file of scores on every initiation.
		FileReader f = null;
		 try {
			 f = new FileReader("src/scoreFile.txt");
		 }
		 catch (FileNotFoundException e1) {
		 		 e1.printStackTrace();
		 }
		 
		 BufferedReader br =new BufferedReader(f);
		 String s;
		 // And adds them to the TreeMap
		 try {
		 while((s=br.readLine())!=null){
			 String[] temp = s.split(" ");
			 namesAndScores.put(temp[1], temp[0]);
		 }
		 }catch (IOException e1) {
			 e1.printStackTrace();
	}
		
		score = new JFrame();
		score.setVisible(true);
		score.setLayout(new FlowLayout());
		score.setAlwaysOnTop(true);
		score.setSize(425,300);
		score.setTitle("Score Board");
		
		JPanel pan = new JPanel();
		JTextArea area = new JTextArea();
		area.setEditable(false);
		
		for (Map.Entry<String, String> entry : namesAndScores.entrySet()) {
			area.append(String.format("%-40s > %40s%n" , entry.getValue(), entry.getKey()));
		}
		
		pan.add(area);
		score.add(pan); 
		
	}

}
