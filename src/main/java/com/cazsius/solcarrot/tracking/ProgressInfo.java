package com.cazsius.solcarrot.tracking;

import com.cazsius.solcarrot.SOLCarrotConfig;

/**
 * contains all relevant variables for current progress
 */
public final class ProgressInfo {
    /**
     * the number of unique foods eaten
     */
    public final int foodsEaten;
    private final int queueNutrition;
    private final int addedHearts;
    private final int queueVariation;

    ProgressInfo(FoodList foodList) {
        foodsEaten = (int) foodList.getEatenFoods().stream()
                .filter(food -> SOLCarrotConfig.shouldCount(food.item))
                .count();
        queueNutrition = foodList.getQueueNutritionValue();
        addedHearts = queueNutrition / SOLCarrotConfig.queueNutritionPerHeart();
        queueVariation = foodList.getQueueNutritionVariation();
    }

    public int getAddedHearts() {
        return addedHearts;
    }

    public boolean hasReachedMax() {
        return addedHearts >= SOLCarrotConfig.getMaxAddedHeartsFromFood();
    }

    public int getQueueNutrition() {
        return queueNutrition;
    }

    public int getQueueVariation() {
        return queueVariation;
    }

    /** the next milestone to reach, or a negative value if the maximum has been reached */


    /** the number of foods remaining until the next milestone, or a negative value if the maximum has been reached */


    /** the number of milestones achieved, doubling as the index of the next milestone */

}
