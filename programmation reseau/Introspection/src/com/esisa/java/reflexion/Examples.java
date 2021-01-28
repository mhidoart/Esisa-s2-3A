package com.esisa.java.reflexion;

import java.io.ObjectStreamConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import com.esisa.java.reflexion.model.Document;
import com.esisa.java.reflexion.model.Produit;

public class Examples {

	public Examples() {
		// TODO Auto-generated constructor stub
		exp07();
	}
	void exp01() {
		Document doc= new Document("543-6556-321", "programmation web avec java-script", 654, 10);
		serFieldValue(doc,"isbn","555-666-111");
		reflexion(doc);
	}
	void exp02() {

		//  Document.class.getDeclaredMethods();  ou :
		Class<?>cls =Document.class;
		Method m[] = cls.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(" - "+m[i].getName()+"()");
		}
		Document doc= new Document("543-6556-321", "programmation web avec java-script", 654, 10);
		try {
			m[1].invoke(doc);
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());
		}
	}
	void exp03() {
		Document doc= new Document("543-6556-321", "programmation web avec java-script", 654, 10);
		invoke(doc, "print");
	}
	void exp04()
	{
		Document doc= new Document("543-6556-321", "programmation web avec java-script", 654, 10);
		try {
			Method m=	doc.getClass().getDeclaredMethod("print",String.class,int.class);
			m.invoke(doc,"hsna .py ",11);
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());
		}
	}
	void exp05()
	{
		Document doc=(Document)newInstance(Document.class);
		doc.print();
		try {
			Method m=	doc.getClass().getDeclaredMethod("print",String.class,int.class);
			m.invoke(doc,"hsna .py ",11);
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());
		}
	}
	Object newInstance(Class<?> cls) {
		try {
			return cls.getConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());
			return null;
		}
	}
	void exp06() {
		try {
			String name="com.esisa.java.reflexion.model.Document";
			Class<?> cls=Class.forName(name);
			Object x=cls.getConstructor(String.class,String.class,double.class,int.class).newInstance("543-6556-321", "xi languages", 654, 10);
			System.out.println(x);
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());

		}
	}
	void exp07() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Form form =new Form(new Document("543-132-1324" ," Introspection en java",2000,10));
		//	Form form =new Form(new Produit());
		f.setContentPane(form);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);

	}
	void exp08() {
		Document doc=new Document("543-132-1324" ," Introspection en java",2000,10);
		HtmlFormGenerator gen=new HtmlFormGenerator(doc);
		gen.generate("resourcess/nv.html");
	}
	void invoke(Object x, String method) {
		try {
			Method m=	x.getClass().getDeclaredMethod(method);
			m.invoke(x);
		} catch (Exception e) {
			System.out.println("erreur : " +e.getMessage());
		}
	}
	void serFieldValue(Object x, String fieldname, Object value) {
		Class<?> cls = x.getClass();
		try {
			Field f =cls.getDeclaredField(fieldname);
			boolean a =f.isAccessible();
			f.setAccessible(true);
			f.set(x, value);
			f.setAccessible(a);
			System.out.println(f.get(x));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur : " +e.getMessage());
		}
	}

	void reflexion(Document x) {
		Class<?> cls = x.getClass();
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());

		Field f[] = cls.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			Object value=0;
			try {
				f[i].setAccessible(true);
				value = f[i].get(x);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("erreur : " +e.getMessage());
			}
			System.out.println(" - " +f[i].getName() + " = " + value);
		}
	}
	public static void main(String[] args) {
		new Examples();
	}

}
