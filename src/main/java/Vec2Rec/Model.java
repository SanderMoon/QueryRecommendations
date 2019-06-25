package Vec2Rec;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;

import java.util.Collection;
import java.util.Scanner;

/**
 * @Authors:    Sander Moonemans (Radboud University) &
 *              Thom Theunissen (Avans university of applied sciences)
 *
 *
 */

public class Model {



    public static void main(String[] args) {

        FrameController controller = new FrameController();
        controller.showMainFrame();
        Word2Vec w2vModel = WordVectorSerializer.readWord2VecModel("C:\\Users\\Sander\\Downloads\\w2v_model.bin");
        Scanner scan = new Scanner(System.in);
        String inputWord = "";

        while(true){
            String input = controller.getWord();
            if(!inputWord.equals(input)){
                Collection<String> results = w2vModel.wordsNearest(input, 15);
                controller.showResults(results);
                inputWord = input;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
