package pl.edu.icm.yadda.analysis.zone.classification.features;

import pl.edu.icm.yadda.analysis.hmm.features.FeatureCalculator;
import pl.edu.icm.yadda.analysis.textr.model.BxLine;
import pl.edu.icm.yadda.analysis.textr.model.BxPage;
import pl.edu.icm.yadda.analysis.textr.model.BxZone;

/**
 *
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class LineXWidthPositionDiffFeature implements FeatureCalculator<BxZone, BxPage> {

    private static String featureName = "LineXWidthPositionDiff";

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @Override
    public double calculateFeatureValue(BxZone zone, BxPage page) {
        double min = zone.getBounds().getX() + zone.getBounds().getWidth();
        double max = zone.getBounds().getX();
        for (BxLine line : zone.getLines()) {
            if (line.getBounds().getX()+line.getBounds().getWidth() < min) {
                min = line.getBounds().getX()+line.getBounds().getWidth();
            }
            if (line.getBounds().getX()+line.getBounds().getWidth() > max) {
                max = line.getBounds().getX()+line.getBounds().getWidth();
            }
        }
        return max - min;
    }

}
