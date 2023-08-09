public class Average_notes {
    public static void main(String[] args) throws Exception {
/*
        float score_1, score_2, score_3;

            score_1 = 10.0f;
            score_2 = 8.5f;
            score_3 = 6.3f; 
 */
        double score_1, score_2, score_3;        

        score_1 = 10.0;
        score_2 = 8.5;
        score_3 = 6.3;

        double media;

        media = (score_1 + score_2 + score_3)/3;

        System.out.format("Media = %.3f", media);
    }
}
