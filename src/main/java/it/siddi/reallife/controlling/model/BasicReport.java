package it.siddi.reallife.controlling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import java.util.List;

public class BasicReport {

    public Float food_tot = new Float(0.0);
    public Float leisure_tot = new Float(0.0);
    public Float state_tot = new Float(0.0);
    public Float clothing_tot = new Float(0.0);
    public Float notNegotiable_tot = new Float(0.0);
    public Float hygiene_tot = new Float(0.0);
    public Float income_tot = new Float(0.0);
    public Float surviving_amount = new Float(0.0);
    public Float total_amount = new Float(0.0);
    public Float margin_amount = new Float(0.0);
    @JsonIgnore
    private List<Movement> food;
    @JsonIgnore
    private List<Movement> state;
    @JsonIgnore
    private List<Movement> income;
    @JsonIgnore
    private List<Movement> leisure;
    @JsonIgnore
    private List<Movement> clothing;
    @JsonIgnore
    private List<Movement> notNegotiable;
    @JsonIgnore
    private List<Movement> hygiene;
    public BasicReport(){
        food = Lists.newArrayList();
        state = Lists.newArrayList();
        income = Lists.newArrayList();
        leisure = Lists.newArrayList();
        clothing = Lists.newArrayList();
        notNegotiable = Lists.newArrayList();
        hygiene = Lists.newArrayList();
    }

    public Float getFood_tot() {
        return food_tot;
    }

    public Float getLeisure_tot() {
        return leisure_tot;
    }

    public void addMovement(Movement movement){
        switch (movement.getType()){
            case FOOD:
                food.add(movement);
                break;
            case STATE:
                state.add(movement);
                break;
            case INCOME:
                income.add(movement);
                break;
            case LEISURE:
                leisure.add(movement);
                break;
            case CLOTHING:
                clothing.add(movement);
                break;
            case NOT_NEGOTIABLE:
                notNegotiable.add(movement);
                break;
            case HYGIENE:
                hygiene.add(movement);
            default:
                throw new IllegalArgumentException(movement.getType() + " not supported");
        }

    }

    public void produceReport(){
        for (Movement entry: food) {
            food_tot = food_tot+ entry.getAmount();
        }
        for (Movement entry: income) {
            income_tot = income_tot+ entry.getAmount();
        }
        for (Movement entry: hygiene) {
            hygiene_tot = hygiene_tot+ entry.getAmount();
        }
        for (Movement entry: clothing) {
            clothing_tot = clothing_tot+ entry.getAmount();
        }
        for (Movement entry: notNegotiable) {
            notNegotiable_tot = notNegotiable_tot+ entry.getAmount();
        }
        for (Movement entry: state) {
            state_tot = state_tot+ entry.getAmount();
        }
        for (Movement entry: leisure) {
            leisure_tot = leisure_tot+ entry.getAmount();
        }

        surviving_amount = food_tot + hygiene_tot + notNegotiable_tot;
        total_amount = surviving_amount + clothing_tot + leisure_tot;
        margin_amount = (income_tot + state_tot) - total_amount;
    }


    public Float getState_tot() {
        return state_tot;
    }

    public Float getClothing_tot() {
        return clothing_tot;
    }

    public Float getNotNegotiable_tot() {
        return notNegotiable_tot;
    }

    public Float getHygiene_tot() {
        return hygiene_tot;
    }

    public Float getIncome_tot() {
        return income_tot;
    }

    public Float getSurviving_amount() {
        return surviving_amount;
    }

    public Float getTotal_amount() {
        return total_amount;
    }

    public Float getMargin_amount() {
        return margin_amount;
    }
}
