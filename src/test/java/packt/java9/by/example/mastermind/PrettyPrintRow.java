package packt.java9.by.example.mastermind;

public class PrettyPrintRow {

    public static String pprint(Row row){
        String string = "";
        for( int i = 0 ; i < row.nrColumns() ; i++){
            string += row.position(i);
        }
        string += " ";
        string += row.matchedPositions();
        string += "/";
        string += row.matchedColors();
        return string;
    }

}
