package packt.java9.by.example.mastermind;


import org.junit.Assert;
import org.junit.Test;
import packt.java9.by.example.mastermind.lettered.LetteredColorManager;

public class GameTest {

    @Test
    public void testSimpleGame(){
        final int nrColors = 6;
        ColorManager manager = new LetteredColorManager(nrColors);
        final int nrColumns = 4;
        Table table = new Table(nrColumns,manager);
        Color[] secret = new Color[nrColumns];
        int count = 0;
        Color color = manager.firstColor();
        while( count < nrColors - nrColumns ){
            color = manager.nextColor(color);
            count ++;
        }
        for( int i = 0; i < nrColumns ; i ++ ){
            secret[i] = color;
            color = manager.nextColor(color);
        }
        System.out.println(PrettyPrintRow.pprint(new Row(secret)));
        System.out.println();
        Game game = new Game(table,secret);

        Guesser guesser = new GeneralGuesser(table);
        while( ! game.isFinished()) {
            Row guess = guesser.guess();
            if( guess == Row.none){
                Assert.fail();
            }
            game.newGuess(guess);
            System.out.println(PrettyPrintRow.pprint(guess));
        }
    }

}
