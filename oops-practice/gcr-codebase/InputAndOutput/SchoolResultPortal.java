// 1. A school result portal reads student names and marks from a text file, computes averages, and writes a formatted report card to a new file. Handle FileNotFoundException gracefully. Extend: append new results without overwriting old ones. 

package InputAndOutput;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SchoolResultPortal {

	public static void main(String[] args) {
		String inputFile = args.length > 0 ? args[0] : "student_results.txt";
		String reportFile = "report_card.txt";

		List<String> reports = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.##");
		int studentCount = 0;
		double classTotal = 0.0;

		try (Scanner scanner = new Scanner(new File(inputFile))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) continue;

				// Accept either comma-separated or whitespace-separated values: "Name,90,85,78" or "Name 90 85 78"
				String[] parts = line.split("\\s*,\\s*|\\s+");
				String name = parts[0];
				List<Integer> marks = new ArrayList<>();
				for (int i = 1; i < parts.length; i++) {
					try {
						marks.add(Integer.parseInt(parts[i]));
					} catch (NumberFormatException ex) {
						// ignore invalid marks
					}
				}

				if (marks.isEmpty()) continue;

				double sum = 0;
				for (int m : marks) sum += m;
				double avg = sum / marks.size();
				classTotal += avg;
				studentCount++;

				StringBuilder sb = new StringBuilder();
				sb.append(String.format("Student: %s%n", name));
				sb.append("Marks: ");
				for (int i = 0; i < marks.size(); i++) {
					sb.append(marks.get(i));
					if (i < marks.size() - 1) sb.append(", ");
				}
				sb.append(System.lineSeparator());
				sb.append("Average: ").append(df.format(avg)).append(System.lineSeparator());
				sb.append("------------------------------").append(System.lineSeparator());

				reports.add(sb.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found: " + inputFile);
			System.out.println("Please ensure the input file exists in the working directory or pass its path as an argument.");
			return;
		}

		if (reports.isEmpty()) {
			System.out.println("No student data found in " + inputFile);
			return;
		}

		// Append results to report file (do not overwrite existing content)
		try (FileWriter fw = new FileWriter(reportFile, true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			out.println("Report generated: " + LocalDateTime.now().format(dtf));
			out.println();
			for (String r : reports) out.print(r);
			double classAvg = classTotal / studentCount;
			out.println("Class average: " + df.format(classAvg));
			out.println("=======================================");
			out.println();

			System.out.println("Report appended to " + reportFile);

		} catch (IOException e) {
			System.out.println("Error writing report: " + e.getMessage());
		}
	}

}
