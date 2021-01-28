package com.esisa.java.reflexion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.esisa.java.reflexion.annotations.Textfield;


public class Form extends JPanel{
	private int labelWidth =100;
	private JPanel container;
	private String title="";
	public Form(Object x) {
		// TODO Auto-generated constructor stub
		com.esisa.java.reflexion.annotations.Form f=	x.getClass().getDeclaredAnnotation( com.esisa.java.reflexion.annotations.Form.class);
		if (f!= null) {
			title=f.title();
			labelWidth=f.labelWidth();
		}
		else
		{
			title=x.getClass().getSimpleName();

		}
		setLayout(new FlowLayout(FlowLayout.LEFT));
		container=new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		if(!title.contains(":")) title=" " + title + " : ";
		Border border=BorderFactory.createEtchedBorder();
		container.setBorder(BorderFactory.createTitledBorder(border,title));

		createFields(x);

	}
	private void createFields(Object x) {
		Field f[]=	x.getClass().getDeclaredFields();

		for (int i = 0; i < f.length; i++) {
			Textfield field =f[i].getAnnotation(Textfield.class);

			if(field !=null) {
				JTextField txt=	add(field.label(),field.size());
				Object value=getValue(x, f[i]);
			if ( value!= null)	txt.setText(""+ value);
			}
		}
	}
	public Object getValue(Object x,Field f) {
		try {
			f.setAccessible(true);
			Object value = f.get(x);
			f.setAccessible(false);
			return value;
		} catch (Exception e) {
			return null;
		}

	}
	public JTextField add(String label,int size) {
		JPanel t1 =new JPanel(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) title=" " + title + " : ";
		JLabel l1= new JLabel(label);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
		t1.add(l1);
		JTextField txt=new JTextField(size);
		t1.add(txt);
		container.add(t1);
		return txt;

	}

}
