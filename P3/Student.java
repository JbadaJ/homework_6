package P3;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//1//

public class Student implements Comparable<Student>{
	int no;
	String name;
	int age;
	
	static List<Student> al=new ArrayList<Student>();
	static List<String> b=new ArrayList<String>();
	static List<Student> bl=new ArrayList<Student>();
	
	public Student(int no, String name, int age) {
		setName(name);
		setNo(no);
		setAge(age);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	@Override
	public String toString() {
		return "Student [no="+no+", name="+name+", age="+age+"]";
	
	}
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
	public void start() {
		
	}
	public static void inputData(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("num:");
		int no =0;
		no=sc.nextInt();
		sc.nextLine();
		
		System.out.println("name:");
		String name = sc.nextLine();
		
		System.out.println("age:");
		int age = sc.nextInt();
		sc.nextLine();
		
		Student s1 = new Student(no,name,age);
		al.add(s1);

		
	}
	public static void show() {
		for (int i=0; i<al.size();i++) {
			System.out.println(i+1+": "+al.get(i).toString());
		}
	}
	public static int menu() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.create data");
		System.out.println("2.show data");
		System.out.println("3.updata data");
		System.out.println("4.delete data");
		System.out.println("5.exit program");
		System.out.println("6 save data");
		System.out.println("7.load data");
		System.out.println("choose number");
		
		int a=0;
		a=sc.nextInt();
		
		return a;
		}
	public static void update() {
		Scanner sc = new Scanner(System.in);
		int update_num=choose_number();
		
		System.out.println("num:");
		int no = sc.nextInt();
		sc.nextLine();
		
		System.out.println("name:");
		String name = sc.nextLine();
		
		System.out.println("age:");
		int age = sc.nextInt();
		sc.nextLine();
		
		Student s1 = new Student(no,name,age);
		al.set(update_num-1,s1);
	}
	public static int choose_number() {
		Scanner sc= new Scanner(System.in);
		show();
		System.out.println("Choose number");
		int a=sc.nextInt();
		return a;
		
	}
	public static void delete() {
	
		int delete_num=choose_number();
		al.remove(delete_num-1);
	}
	public static void write() {
		try {
			Writer w = new FileWriter("data_Save.txt");
			
			for(int i=0;i<al.size();i++) {
				Student p= al.get(i);
				Student sa=al.get(i);
				String to_no=Integer.toString(sa.no);
				String to_name=sa.name;
				String to_age=Integer.toString(sa.age);
			
				w.write(to_no);
				w.write(",");
				w.write(to_name);
				w.write(",");
				w.write(to_age);
				w.write(",");
					
			}
			w.write(".,");
			w.close();
			System.out.println("학생 정보 저장!!!");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void read() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("data_Save.txt"));
			String s;
			int count=0;
			String t_no;
			String t_name;
			String t_age;
			while ((s = in.readLine()) != null) {
				while(true) {
					
					String[] split = new String[50];
					split = s.split(",");
					if(split[count].equals(".")) {
						break;
					}
					t_no=split[count];
					split = s.split(",");
					
					t_name=split[count+1];
					split = s.split(",");
					
					t_age=split[count+2];
					int tt_no = Integer.parseInt(t_no);
					int tt_age = Integer.parseInt(t_age);
					
					Student t = new Student(tt_no,t_name,tt_age);
					
					al.add(t);
					
					count=count+3;	
				}
				
				
			}
				 
			in.close();
			
			System.out.println("\n 학생 정보 가져오기 완료!!!");
		} catch (FileNotFoundException q) {
			q.printStackTrace();
		} catch(IOException a) {
			a.printStackTrace();
		}
	}
	
	
}