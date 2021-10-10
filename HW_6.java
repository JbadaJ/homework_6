package P3;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class HW_6 {


	public static void main(String args[]) {
	
		
		//origin //
		Scanner sc = new Scanner(System.in);

		while(true) {
			int a= Student.menu();

			if(a==1) {
				Student.inputData();
			}
			else if(a==2) {
				Student.show();
			}
			else if(a==3) {
				Student.update();
			}
			else if(a==4) {
				Student.delete();
			}
			else if(a==5) {
				break;
			}
			else if(a==6) {
				Student.write();
			}
			else if(a==7) {
				Student.read();
			}
		}
		
		sc.close();
		}
	}
