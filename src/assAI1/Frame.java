package assAI1;
import java.util.*;
import org.jpl7.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class Frame extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	JLabel l1;
	 public Frame() {
		 this.setTitle("Metro Station");
		 this.setSize(500,150);
		 l1=new JLabel("welcome to Metro Station guide");
		 b1= new JButton("Full path");
		 b2= new JButton("Attached to station");
		 b3= new JButton("Cost");
		 
		 this.add(l1);
		 this.add(b1);
		 this.add(b2);
		 this.add(b3);
		 
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 this.setResizable(false);
		 this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		 
	 }
	 
	 @Override
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==b1) {
				
				JFrame f1=new JFrame();
				JTextField in1,in2,in3;
				JButton ok = new JButton("ok");
				
				
				f1.setTitle("show path");
				f1.setSize(500,300);
				JLabel l= new JLabel("from a src to dest :");
				in1 = new JTextField("source",10);
				in2 = new JTextField("destination",10);
				JLabel n= new JLabel("limit number :");
				JLabel t= new JLabel("to");
				JLabel A= new JLabel("answer..");
				in3 = new JTextField(4);
				f1.add(l);
				f1.add(in1);
				f1.add(t);
				f1.add(in2);
				f1.add(n);
				f1.add(in3);
				f1.add(ok);
				f1.add(A);
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f1.setVisible(true);
				f1.setResizable(false);
				f1.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
				ok.addActionListener( new ActionListener(){ 
					  public void actionPerformed( ActionEvent a ){
						  
						   Variable Z = new Variable("Z");
						   Term t1 = Util.textToTerm(in1.getText());
						   Term t2 = Util.textToTerm(in2.getText());
						   Term t3 = Util.textToTerm(in3.getText());
						    Query q2 = new Query("path",new Term[] {t1,t2,t3,Z});
						    String S = Util.toString((Map<String, Term>) q2.oneSolution().get("Z"));
						    A.setText(S);
					  }
					});
				
				
			}else if(a.getSource()==b2) {
				
				JFrame f2=new JFrame();
				JTextField inp1;
				JButton get;
				f2.setTitle("number of stations");
				f2.setSize(600,200);
				JLabel ln= new JLabel("number of stations directly connected to a given station");
				inp1 = new JTextField("enter name of station",20);
				get= new JButton("enter");
				JLabel B= new JLabel("answer..");
				f2.add(ln);
				f2.add(inp1);
				f2.add(get);
				f2.add(B);
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setVisible(true);
				f2.setResizable(false);
				f2.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
				get.addActionListener( new ActionListener(){ 
					  public void actionPerformed( ActionEvent a ){
						 
						    Query q3 = new Query("nstations",new Term[] {new Atom(inp1.getText()),new Atom("N")});
						    int I = Util.listToLength(q3.oneSolution().get("N"));
						    String b = String.valueOf(I);
						    B.setText(b);
						   
					  }
					});
				
			}
             else if(a.getSource()==b3) {
            	 
            	 JTextField src,des;
 				JButton result = new JButton("enter");
            	JFrame f3=new JFrame();
 				f3.setTitle("get the cost");
 				f3.setSize(500,200);
 				JLabel lc= new JLabel("the cost of moving from one station to another");
 				src = new JTextField("source",10);
				des = new JTextField("destination",10);
				JLabel C= new JLabel("answer..");
 				f3.add(lc);
 				f3.add(src);
 				f3.add(des);
 				f3.add(result);
 				f3.add(C);
 				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 				f3.setVisible(true);
 				f3.setResizable(false);
 				f3.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
 				result.addActionListener( new ActionListener(){ 
					  public void actionPerformed( ActionEvent a ){
						 
						    Query q4 = new Query("cost",new Term[] {new Atom(src.getText()),new Atom(des.getText()),new Atom("N")});
						    String c=String.valueOf(q4.oneSolution().get("N"));
						    C.setText(c);
					  }
					});
			}
         
		}
	 
	 
	 public static void main(String[]rgs) {
		 JPL.init();
		 String s1 = "consult('C:\\Users\\user\\eclipse-workspace\\assAI1/metroStation')";
	        Query q1 = new Query(s1);
	        System.out.println(s1+" "+(q1.hasSolution()?"success":"failed"));
		
		 Frame f =new Frame();
	 }
	
	

}
