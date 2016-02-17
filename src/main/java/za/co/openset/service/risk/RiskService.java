package za.co.openset.service.risk;

import za.co.openset.dao.risk.*;
import za.co.openset.model.risk.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/28.
 *
 */

@Stateless
public class RiskService {

    @Inject
    private RiskCategoryRepo riskCategoryRepo;

    @Inject
    private RiskControlEffectivenessRepo riskControlEffectivenessRepo;

    @Inject
    private RiskImpactRepo riskImpactRepo;

    @Inject
    private RiskLikelihoodRepo riskLikelihoodRepo;

    @Inject
    private RiskObjectiveRepo riskObjectiveRepo;

    @Inject
    private RiskSubCategoryRepo riskSubCategoryRepo;

    // functions RiskObjective
    public RiskObjective update(RiskObjective po) throws Exception {
        return riskObjectiveRepo.update(po);
    }

    public RiskObjective getRiskObjectiveById(Long id) throws Exception {
        return riskObjectiveRepo.findById(id);
    }

    public List<RiskObjective> getAllRiskObjectives() throws Exception {
        return riskObjectiveRepo.findAll();
    }

    // functions RiskLikelihood
    public RiskLikelihood update(RiskLikelihood po) throws Exception {
        return riskLikelihoodRepo.update(po);
    }

    public RiskLikelihood getRiskLikelihoodById(Long id) throws Exception {
        return riskLikelihoodRepo.findById(id);
    }

    public List<RiskLikelihood> getAllRiskLikelihoods() throws Exception {
        return riskLikelihoodRepo.findAll();
    }

    // functions RiskControlEffectiveness
    public RiskControlEffectiveness update(RiskControlEffectiveness po) throws Exception {
        return riskControlEffectivenessRepo.update(po);
    }

    public RiskControlEffectiveness getRiskControlEffectivenessById(Long id) throws Exception {
        return riskControlEffectivenessRepo.findById(id);
    }

    public List<RiskControlEffectiveness> getAllRiskControlEffectiveness() throws Exception {
        return riskControlEffectivenessRepo.findAll();
    }

    // functions RiskSubCategory
    public RiskSubCategory update(RiskSubCategory po) throws Exception {
        return riskSubCategoryRepo.update(po);
    }

    public RiskSubCategory getRiskSubCategoryById(Long id) throws Exception {
        return riskSubCategoryRepo.findById(id);
    }

    public List<RiskSubCategory> getAllRiskSubCategories() throws Exception {
        return riskSubCategoryRepo.findAll();
    }

    // functions RiskCategory
    public RiskCategory update(RiskCategory po) throws Exception {
        return riskCategoryRepo.update(po);
    }

    public RiskCategory getRiskCategoryRepoById(Long id) throws Exception {
        return riskCategoryRepo.findById(id);
    }

    public List<RiskCategory> getAllRiskCategories() throws Exception {
        return riskCategoryRepo.findAll();
    }

    // functions RiskImpact
    public RiskImpact update(RiskImpact po) throws Exception {
        return riskImpactRepo.update(po);
    }

    public RiskImpact getRiskImpactById(Long id) throws Exception {
        return riskImpactRepo.findById(id);
    }

    public List<RiskImpact> getAllRiskImpacts() throws Exception {
        return riskImpactRepo.findAll();
    }

    public RiskImpact create(RiskImpact po) throws Exception {
        return riskImpactRepo.update(po);
    }

    /**
     * Invoking the function. has to be public to be visible to the external classes.
     *
     * @param key
     * @param <T>
     * @return
     */
     /* public <T> T fetchValue(String key) {
        try {
            Method method = functionMap.get(key);
            return (T)method.invoke(this);
        } catch (IllegalArgumentException e) {
            throw new ServiceException(e);
        } catch (IllegalAccessException e) {
            throw new ServiceException(e);
        } catch (InvocationTargetException e) {
            throw new ServiceException(e);
        }
     } */
}
