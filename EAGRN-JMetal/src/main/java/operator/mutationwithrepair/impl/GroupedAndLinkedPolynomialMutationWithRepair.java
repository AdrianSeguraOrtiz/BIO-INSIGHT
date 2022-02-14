package operator.mutationwithrepair.impl;

import operator.repairer.WeightRepairer;
import org.uma.jmetal.operator.mutation.impl.GroupedAndLinkedPolynomialMutation;
import org.uma.jmetal.solution.doublesolution.DoubleSolution;
import org.uma.jmetal.util.errorchecking.JMetalException;
import org.uma.jmetal.util.grouping.CollectionGrouping;

import java.util.List;

public class GroupedAndLinkedPolynomialMutationWithRepair extends GroupedAndLinkedPolynomialMutation {
    private WeightRepairer repairer;

    public GroupedAndLinkedPolynomialMutationWithRepair(double distributionIndex, CollectionGrouping<List<Double>> variableGrouping, WeightRepairer repairer) {
        super(distributionIndex, variableGrouping);
        this.repairer = repairer;
    }

    @Override
    public DoubleSolution execute(DoubleSolution solution) throws JMetalException {
        DoubleSolution mutated_sol = super.execute(solution);
        repairer.repairSolution(mutated_sol);
        return mutated_sol;
    }
}
