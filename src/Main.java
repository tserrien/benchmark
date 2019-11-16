import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

//TODO implement logger instead of printing to cl
public class Main {

    public static void main(String[] args) {
        Path path;
        String row;

        try{
            path = Paths.get(args[0]).toAbsolutePath();
        }catch(Exception e){
            path = Paths.get("tester.csv");
            e.printStackTrace(System.out);
        }

        String pathSt = path.toString();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathSt));
            while ((row = csvReader.readLine()) != null) {
                String[] line = row.split(";");
                for (int i = 0; i < line.length; i++) {
                    System.out.print(line[i] + " ");
                }
                System.out.println();
                // do something with the data
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
