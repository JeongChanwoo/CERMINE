package pl.edu.icm.yadda.analysis.zone.classification.features;

import pl.edu.icm.yadda.analysis.hmm.features.FeatureCalculator;
import pl.edu.icm.yadda.analysis.textr.model.BxChunk;
import pl.edu.icm.yadda.analysis.textr.model.BxLine;
import pl.edu.icm.yadda.analysis.textr.model.BxPage;
import pl.edu.icm.yadda.analysis.textr.model.BxWord;
import pl.edu.icm.yadda.analysis.textr.model.BxZone;

/**
 *
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class LowercaseCountFeature implements FeatureCalculator<BxZone, BxPage> {

    private static String featureName = "LowercaseCount";

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
        int count = 0;
        for (BxLine line : zone.getLines()) {
            for (BxWord word : line.getWords()) {
                for (BxChunk chunk : word.getChunks()) {
                    char[] arr = chunk.getText().toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        if (Character.isLowerCase(arr[i])) {
                            count++;
                        }
                    }
                }
            }
        }
        return (double) count;   
    }
}
