import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	Vector<String> listNama = new Vector <>();
	Vector<String> listGender = new Vector <>();
	Vector<String> listJabatan = new Vector <>();
	Vector<String> listId = new Vector <>();
	Vector<Integer> listGaji = new Vector <>();
	

	public Main() {
		mainMenu();
	}
	
	public void mainMenu() {
		int choose = 0;
		
		do {
			System.out.println("PT Musang Menu");
			System.out.println("1. Insert Data");
			System.out.println("2. View Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.print(">> ");
			choose = scInt();
			
			switch (choose) {
			case 1:
				insert();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;

			}
						
		} while (choose != 4);
	}
	
	
	public void insert() {
		String nama, gender, jabatan, id;
		int gaji = 0;
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = sc.nextLine();
			
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = sc.nextLine();
			
		} while (!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
			
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
		} else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
		} else if (jabatan.equals("Admin")) {
			gaji = 4000000;
		}
		
		char huruf1 = (char) ('A' + rd.nextInt(26));
		char huruf2 = (char) ('A' + rd.nextInt(26));
		int angka1 = rd.nextInt(10);
		int angka2 = rd.nextInt(10);
		int angka3 = rd.nextInt(10);
		id = "" + huruf1 + huruf2 + "-" + angka1 + angka2 + angka3;		
			
		listNama.add(nama);
		listGender.add(gender);
		listJabatan.add(jabatan);
		listId.add(id);
		listGaji.add(gaji);
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + id);
		
		System.out.println("ENTER to return");
		sc.nextLine();
		
	}
	
	public void view() {
		ascending();
		
		System.out.println("|----|---------------|-------------------|---------------|-------------|-----------------|");
		System.out.println("| No | Kode Karyawan |   Nama Karyawan   | Jenis Kelamin |   Jabatan   |  Gaji Karyawan  |");
		System.out.println("|----|---------------|-------------------|---------------|-------------|-----------------|");
		for (int i = 0; i < listNama.size(); i++) {
			System.out.printf("| %-3d| %-14s| %-18s| %-14s| %-12s| %-16d|\n", (i+1), listId.get(i), listNama.get(i), listGender.get(i), listJabatan.get(i), listGaji.get(i));
		}
		System.out.println("|----|---------------|-------------------|---------------|-------------|-----------------|");
	}
	
	public void update() {
		int no, idx, gaji = 0;
		String nama, gender, jabatan;
		view();
		
		do {
			System.out.print("Input nomor urutan karyawan yang ingin diupdate: " );
			no = scInt();
			
		} while (no < 1 || no > listNama.size());
		
		idx = no - 1;
		
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = sc.nextLine();
			
			if (nama.equals("0")) {
				break;
			}
			
			listNama.set(idx, nama);
			
		} while (nama.length() < 3 || nama.equals("0"));
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = sc.nextLine();
			
			if (gender.equals("0")) {
				break;
			} 
			
			listGender.set(idx, gender);
			
		} while (!(gender.equals("Laki-laki") || gender.equals("Perempuan")) || gender.equals("0"));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
			
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
			} else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			} else if (jabatan.equals("Admin")) {
				gaji = 4000000;
			}
			
			if (jabatan.equals("0")) {
				break;
			}
			
			listJabatan.set(idx, jabatan);
			listGaji.set(idx, gaji);
			
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")) || jabatan.equals("0"));
		
		System.out.println("Berhasil mengupdate karyawan dengan id " + listId.get(idx));
		System.out.println("ENTER to return");
		sc.nextLine();
		
	}
	
	public void delete() {
		int no, idx;
		view();
		
		do {
			System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
			no = scInt();
			
		} while (no < 1 || no > listNama.size());
		
		idx = no - 1;
		
		System.out.println("Karyawan dengan kode " + listId.get(idx) + " berhasil dihapus");
		
		listNama.remove(idx);
		listGender.remove(idx);
		listJabatan.remove(idx);
		listId.remove(idx);
		listGaji.remove(idx);
		
		
		System.out.println("ENTER to return");
		sc.nextLine();
		mainMenu();
		
		
	}
	
	public void ascending () {
	for(int i = 0;i < listNama.size();i++) {
		for(int j = 0;j < listNama.size()-1;j++) {
			if(listNama.get(j).compareTo(listNama.get(j+1)) > 0) {

				String temp = listNama.get(j);
				listNama.set(j, listNama.get(j+1));
				listNama.set(j+1,temp);

			}
		 }
	  }
	}
	
	public 	int scInt() {
		int input;
		try {
			input = sc.nextInt();
		} catch (Exception e) {
			input = Integer.MIN_VALUE;
		}
		sc.nextLine();
		return input;
	}

	public static void main(String[] args) {
		new Main();

	}

}
