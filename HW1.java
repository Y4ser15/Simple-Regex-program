import java.nio.file.*;;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HW1 {

    //Method to Read the file and convert it to string
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("C:\\Users\\ysyss\\Desktop\\regextest.txt");
        String regex_ing = ("[a-zA-Z]+ing[s\\s\\W]");
        String regex_lines = ("\\r\\n|\\n|\\r");
        String regex_500 = ("[1-9]\\d{3,}|[6-9]\\d{2}|5[1-9]\\d|50[1-9]");
        String regex_aA = "[\\s\\W][aA] [\\w]+";


        //ending with "ing"
        Pattern pattern = Pattern.compile(regex_ing);
        Matcher matcher = pattern.matcher(data);
        int count_ing = 0;
        while (matcher.find()) {
            count_ing++;
        }

        //counting lines
        pattern = Pattern.compile(regex_lines);
        matcher = pattern.matcher(data);
        int count_line = 1;
        while (matcher.find()) {
            count_line++;
        }

        //finding numbers greater than 500
        pattern = Pattern.compile(regex_500);
        matcher = pattern.matcher(data);
        String greater_500[] = new String[2000];
        int count_500 = 0;
        while (matcher.find()) {
            greater_500[count_500++] = matcher.group();
        }


        //finding all words that are preceded by a or A. e.g. a car, A girl
        pattern = Pattern.compile(regex_aA);
        matcher = pattern.matcher(data);
        String aA[] = new String[2000];
        int count_aA = 0;
        while (matcher.find()) {
            aA[count_aA++] = matcher.group();
        }

        //print "ing" regex
        if(count_ing > 0) System.out.println("The number of words that are ended by \"ing\": " + count_ing);
        else System.out.println("No words ended by \"ing\"");

        //print lines regex
        if(count_line > 0) System.out.println("The number of lines: " + count_line);
        else System.out.println("No Lines");

        //print 500 regex
        if(count_500 > 0){
            System.out.print("The numbers that are greater than 500: ");
            for (int i = 0; i < count_500; i++){
                System.out.print(greater_500[i] +" ");
            }
            System.out.println();
        }
        else System.out.println("There are no numbers are greater than 500");

        //print aA regex
        if(count_aA > 0){
            System.out.print("The words that are preceded by a or A: ");
            for (int i = 0; i < count_aA; i++){
                System.out.print(aA[i] + " ");
            }
        }
        else System.out.println("No words preceded by a or A");

    }
}
