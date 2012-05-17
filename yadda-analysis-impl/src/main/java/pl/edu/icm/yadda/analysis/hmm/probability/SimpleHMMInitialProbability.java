package pl.edu.icm.yadda.analysis.hmm.probability;

import pl.edu.icm.yadda.analysis.hmm.training.HMMTrainingElement;
import pl.edu.icm.yadda.analysis.textr.tools.ProbabilityDistribution;

/**
 * Simple Hidden Markov Model initial probability implementation.
 *
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class SimpleHMMInitialProbability<S> implements HMMInitialProbability<S> {

    private ProbabilityDistribution<S> probability;

    private double zeroProbabilityValue;

    public SimpleHMMInitialProbability(HMMTrainingElement<S,?>[] trainingElements) {
        this(trainingElements, 0.0);
    }

    public SimpleHMMInitialProbability(HMMTrainingElement<S,?>[] trainingElements, double zeroProbabilityValue) {
        this.zeroProbabilityValue = zeroProbabilityValue;
        probability = new ProbabilityDistribution<S>();
        for (HMMTrainingElement<S,?> element : trainingElements) {
            if (element.isFirst()) {
                probability.addEvent(element.getLabel());
            }
        }
    }

    @Override
    public double getProbability(S label) {
        return (probability.getProbability(label) == 0) ? zeroProbabilityValue : probability.getProbability(label);
    }

}
