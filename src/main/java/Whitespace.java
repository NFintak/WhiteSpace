import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Whitespace {

    public static void main(String[] args) throws IOException {
        Whitespace wspc = new Whitespace();


        wspc.fileChecker("testdata1.txt");
        //wspc.countBoth("testdata2.txt");
        //wspc.countBoth("testdata3.txt");


        // for each file "testdata{1,2,3}.txt
        // read in all the text and
        // send it to countBoth

        wspc.countBoth("a b c d e"); // should print 4, 5

    }

    private void countBoth(String testdata) {
        int whitespaces = 0;
        int non_whitespaces = 0;
        for (int i = 0; i < testdata.length(); i++) {
            if (testdata.charAt(i) == ' ') {
                whitespaces++;
            } else {
                non_whitespaces++;
            }
        }
        System.out.println(whitespaces + ", " + non_whitespaces);

        // count the number of whitespace chars and non-whitespace chars.
        // need to use a FOR loop.
        // print the results simply on a line #whitespaces, #ofnonwhitespacechars for each file.

    }

    private void fileChecker(String fileHere) {
        try {
            Files newFile = new Files(fileHere);
            Scanner scanner = new Scanner(newFile); //double check that this is the right start place
            while (scanner.hasNextLine()) {
                //String sentence = scanner.nextLine();
                countBoth(newFile); //switched sentence to newFile
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        }
    }


    // what you CANNOT do is use `Character.isWhitespace()`
    // you have to "write your own" by checking the char against what you think is whitespace
    // you should also USE a FOR loop to step thru each char in the String.
//    private void cannotDoThis(String input) {
//        long wspc = input.chars()
//                .mapToObj(a -> (char) a)
//                .filter(c -> Character.isWhitespace(c)).count();
//        long nwpsc = input.chars()
//                .mapToObj(a -> (char) a)
//                .filter(c -> !Character.isWhitespace(new Character(c))).count();
//
//        System.out.printf("%d, %d\n", wspc, nwpsc);
//    }
}
