import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

//TODO implement logger instead of printing to cl
public class Main {

    private static boolean debug = false;

    public static void main(String[] args) {
        Path path;
        String row;

        try{
            path = Paths.get(args[0]).toAbsolutePath();
        }catch(Exception e){
            path = Paths.get("tester.csv");
            //e.printStackTrace(System.out);
        }

        String pathSt = path.toString();

        int lineCounter = 0;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathSt));
            while ((row = csvReader.readLine()) != null) {
                String[] line = row.split(";");
                if(debug)
                for (int i = 0; i < line.length; i++) {
                    System.out.print(line[i] + " ");
                }
                System.out.println();
                if (lineCounter > 0){
                    Launcher launcher = new Launcher(line);
                    launcher.run();
                }
                lineCounter++;
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}