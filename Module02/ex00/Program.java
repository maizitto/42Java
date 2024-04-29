import java.util.*;
import java.io.*;

public class Program {


	public static void main(String[] args) {

		Map<String, String> csv = new HashMap<>();

		try (Scanner scanner = new Scanner(new File("Signatures.txt"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				if (parts[1].startsWith(" ")) {
					parts[1] = parts[1].substring(1);
				}
				csv.put(parts[0], parts[1]);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt"))) {
			try (Scanner scanner = new Scanner(System.in)) {
				String filePath = "";
				while (true){
					System.out.print("Enter the file path: ");
					filePath = scanner.nextLine();
					if (filePath.equals("42")) {
						break;
					}
					String fileSignature = readSignature(filePath);
					for (Map.Entry<String, String> entry : csv.entrySet()) {
						if (fileSignature.startsWith(entry.getValue())) {
							String fileType = entry.getKey();
							writer.println("File type: " + fileType + " - Signature: " + entry.getValue());
							System.out.println("PROCESSED");
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readSignature(String filePath) {
		String fileSignature = "";
		try (FileInputStream file = new FileInputStream(filePath)) {
			byte[] bytes = new byte[8];
			file.read(bytes, 0, 8);
			for (byte b : bytes) {
				fileSignature += String.format("%02X", b);
				fileSignature += " ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSignature;
	}
}
